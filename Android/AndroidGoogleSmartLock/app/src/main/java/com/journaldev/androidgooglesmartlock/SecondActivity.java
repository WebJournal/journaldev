package com.journaldev.androidgooglesmartlock;

import android.content.Intent;
import android.content.IntentSender;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.Credentials;
import com.google.android.gms.auth.api.credentials.CredentialsClient;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, ResultCallback<CredentialRequestResult> {


    Button btnSignOut, btnSignOutDisableAuto, btnDelete;
    private GoogleApiClient mGoogleApiClient;
    CredentialsClient mCredentialsApiClient;
    CredentialRequest mCredentialRequest;
    public static final String TAG = "API123";
    private static final int RC_REQUEST = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setUpGoogleApiClient();
        mCredentialsApiClient = Credentials.getClient(this);


        btnSignOut = findViewById(R.id.btnSignOut);
        btnSignOutDisableAuto = findViewById(R.id.btnSignOutDisableAutoSign);
        btnDelete = findViewById(R.id.btnDeleteAccount);

        btnSignOut.setOnClickListener(this);
        btnSignOutDisableAuto.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSignOut:
                signOut(false);
                break;
            case R.id.btnSignOutDisableAutoSign:
                signOut(true);
                break;
            case R.id.btnDeleteAccount:
                requestCredentials();

                break;
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onResult(@NonNull CredentialRequestResult credentialRequestResult) {

        Status status = credentialRequestResult.getStatus();
        if (status.isSuccess()) {
            onCredentialSuccess(credentialRequestResult.getCredential());
        } else {
            if (status.hasResolution()) {
                try {
                    status.startResolutionForResult(this, RC_REQUEST);
                } catch (IntentSender.SendIntentException e) {
                    Log.d(TAG, e.toString());
                }
            } else {
                showToast("Request Failed");
            }
        }
    }

    public void setUpGoogleApiClient() {

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addApi(Auth.CREDENTIALS_API)
                .enableAutoManage(this, this)
                .build();
    }


    private void requestCredentials() {
        mCredentialRequest = new CredentialRequest.Builder()
                .setPasswordLoginSupported(true)
                .build();

        Auth.CredentialsApi.request(mGoogleApiClient, mCredentialRequest).setResultCallback(this);
    }


    @Override
    protected void onDestroy() {
        mGoogleApiClient.disconnect();
        super.onDestroy();
    }

    private void onCredentialSuccess(Credential credential) {

        Auth.CredentialsApi.delete(mGoogleApiClient, credential).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                if (status.isSuccess()) {
                    signOut(false);
                } else {
                    showToast("Account Deletion Failed");
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_REQUEST) {
            if (resultCode == RESULT_OK) {
                showToast("Deleted");
                Credential credential = data.getParcelableExtra(Credential.EXTRA_KEY);
                onCredentialSuccess(credential);
            } else {
                Log.d(TAG, "Request failed");
            }
        }
    }

    public void showToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

    private void signOut(boolean disableAutoSignIn) {

        if (disableAutoSignIn)
            Auth.CredentialsApi.disableAutoSignIn(mGoogleApiClient);

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }


}
