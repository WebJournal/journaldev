package com.journaldev.androidgooglesmartlock;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.Credentials;
import com.google.android.gms.auth.api.credentials.CredentialsClient;
import com.google.android.gms.auth.api.credentials.CredentialsOptions;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.IdentityProviders;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, ResultCallback<CredentialRequestResult> {

    private GoogleApiClient mGoogleApiClient;
    CredentialsClient mCredentialsApiClient;
    CredentialRequest mCredentialRequest;
    public static final String TAG = "API123";
    private static final int RC_READ = 3;
    private static final int RC_SAVE = 1;
    private static final int RC_HINT = 2;
    boolean isResolving;

    Button btnLogin;
    EditText inEmail, inPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpGoogleApiClient();

        //needed for Android Oreo.
        CredentialsOptions options = new CredentialsOptions.Builder()
                .forceEnableSaveDialog()
                .build();


        mCredentialsApiClient = Credentials.getClient(this, options);
        createCredentialRequest();

        btnLogin = findViewById(R.id.btnLogin);
        inEmail = findViewById(R.id.inEmail);
        inPassword = findViewById(R.id.inPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = inEmail.getText().toString();
                String password = inPassword.getText().toString();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || !Patterns.EMAIL_ADDRESS.matcher(email).matches())
                    showToast("Please enter valid email and password");

                else {

                    Credential credential = new Credential.Builder(email)
                            .setPassword(password)
                            .build();

                    saveCredentials(credential);
                }

            }
        });
    }

    public void setUpGoogleApiClient() {


        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addApi(Auth.CREDENTIALS_API)
                .enableAutoManage(this, this)
                .build();
    }

    public void createCredentialRequest() {
        mCredentialRequest = new CredentialRequest.Builder()
                .setPasswordLoginSupported(true)
                .setAccountTypes(IdentityProviders.GOOGLE)
                .build();
    }

    public void requestCredentials() {
        Auth.CredentialsApi.request(mGoogleApiClient, mCredentialRequest).setResultCallback(this);
    }


    private void onCredentialRetrieved(Credential credential) {
        String accountType = credential.getAccountType();
        if (accountType == null) {
            // Sign the user in with information from the Credential.
            gotoNext();
        } else if (accountType.equals(IdentityProviders.GOOGLE)) {


            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .build();

            GoogleSignInClient signInClient = GoogleSignIn.getClient(this, gso);
            Task<GoogleSignInAccount> task = signInClient.silentSignIn();

            task.addOnCompleteListener(new OnCompleteListener<GoogleSignInAccount>() {
                @Override
                public void onComplete(@NonNull Task<GoogleSignInAccount> task) {
                    if (task.isSuccessful()) {
                        // See "Handle successful credential requests"
                        populateLoginFields(task.getResult().getEmail(), null);
                    } else {
                        showToast("Unable to do a google sign in");
                    }
                }
            });
        }
    }


    public void gotoNext() {
        startActivity(new Intent(this, SecondActivity.class));
        finish();
    }


    public void showToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.d("API123", "onConnected");
        requestCredentials();

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onDestroy() {
        mGoogleApiClient.disconnect();
        super.onDestroy();
    }

    @Override
    public void onResult(@NonNull CredentialRequestResult credentialRequestResult) {

        Status status = credentialRequestResult.getStatus();
        if (status.isSuccess()) {
            onCredentialRetrieved(credentialRequestResult.getCredential());
        } else {
            if (status.getStatusCode() == CommonStatusCodes.RESOLUTION_REQUIRED) {
                try {
                    isResolving = true;
                    status.startResolutionForResult(this, RC_READ);
                } catch (IntentSender.SendIntentException e) {
                    Log.d(TAG, e.toString());
                }
            } else {

                showHintDialog();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "onActivityResult");
        if (requestCode == RC_READ) {
            if (resultCode == RESULT_OK) {
                Credential credential = data.getParcelableExtra(Credential.EXTRA_KEY);
                onCredentialRetrieved(credential);
            } else {
                Log.d(TAG, "Request failed");
            }
            isResolving = false;
        }

        if (requestCode == RC_HINT) {
            if (resultCode == RESULT_OK) {
                Credential credential = data.getParcelableExtra(Credential.EXTRA_KEY);
                populateLoginFields(credential.getId(), "");
            } else {
                showToast("Hint dialog closed");
            }
        }

        if (requestCode == RC_SAVE) {
            if (resultCode == RESULT_OK) {
                Log.d(TAG, "SAVE: OK");
                gotoNext();
                showToast("Credentials saved");
            }
        }


    }

    public void populateLoginFields(String email, String password) {
        if (!TextUtils.isEmpty(email))
            inEmail.setText(email);

        if (!TextUtils.isEmpty(password))
            inPassword.setText(password);
    }

    public void showHintDialog() {
        HintRequest hintRequest = new HintRequest.Builder()
                .setHintPickerConfig(new CredentialPickerConfig.Builder()
                        .setShowCancelButton(true)
                        .build())
                .setEmailAddressIdentifierSupported(true)
                .setAccountTypes(IdentityProviders.GOOGLE, IdentityProviders.FACEBOOK)
                .build();

        PendingIntent intent = mCredentialsApiClient.getHintPickerIntent(hintRequest);
        try {
            startIntentSenderForResult(intent.getIntentSender(), RC_HINT, null, 0, 0, 0);
        } catch (IntentSender.SendIntentException e) {
            Log.e(TAG, "Could not start hint picker Intent", e);
        }
    }

    public void saveCredentials(Credential credential) {


        mCredentialsApiClient.save(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "SAVE: OK");
                    showToast("Credentials saved");
                    return;
                }

                Exception e = task.getException();
                if (e instanceof ResolvableApiException) {
                    // Try to resolve the save request. This will prompt the user if
                    // the credential is new.
                    ResolvableApiException rae = (ResolvableApiException) e;
                    try {
                        rae.startResolutionForResult(MainActivity.this, RC_SAVE);
                    } catch (IntentSender.SendIntentException f) {
                        // Could not resolve the request
                        Log.e(TAG, "Failed to send resolution.", f);
                        showToast("Saved failed");
                    }
                } else {
                    // Request has no resolution
                    showToast("Saved failed");
                }
            }
        });

    }
}
