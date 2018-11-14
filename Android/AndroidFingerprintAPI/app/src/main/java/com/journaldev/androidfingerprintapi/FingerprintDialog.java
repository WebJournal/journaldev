package com.journaldev.androidfingerprintapi;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import android.security.keystore.KeyProperties;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class FingerprintDialog extends DialogFragment
        implements FingerprintHelper.Callback {

    Button mCancelButton;
    public static final String DEFAULT_KEY_NAME = "default_key";
    FingerprintManager mFingerprintManager;

    private FingerprintManager.CryptoObject mCryptoObject;
    private FingerprintHelper mFingerprintHelper;

    KeyStore mKeyStore = null;
    KeyGenerator mKeyGenerator = null;
    KeyguardManager mKeyguardManager;

    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Material_Light_Dialog);

        try {
            mKeyStore = KeyStore.getInstance("AndroidKeyStore");

        } catch (KeyStoreException e) {
            e.printStackTrace();
        }

        try {
            mKeyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

        Cipher defaultCipher;
        try {
            defaultCipher = Cipher.getInstance(KeyProperties.KEY_ALGORITHM_AES + "/"
                    + KeyProperties.BLOCK_MODE_CBC + "/"
                    + KeyProperties.ENCRYPTION_PADDING_PKCS7);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException("Failed to get an instance of Cipher", e);
        }

        mKeyguardManager = getContext().getSystemService(KeyguardManager.class);
        mFingerprintManager = getContext().getSystemService(FingerprintManager.class);

        mFingerprintHelper = new FingerprintHelper(mFingerprintManager, getContext(), this);

        if (!mKeyguardManager.isKeyguardSecure()) {
            Toast.makeText(getContext(),
                    "Lock screen not set up.\n"
                            + "Go to 'Settings -> Security -> Fingerprint' to set up a fingerprint",
                    Toast.LENGTH_LONG).show();
            return;
        }

        createKey(DEFAULT_KEY_NAME);

        if (initCipher(defaultCipher, DEFAULT_KEY_NAME)) {
            mCryptoObject = new FingerprintManager.CryptoObject(defaultCipher);
        }
    }

    private boolean initCipher(Cipher cipher, String keyName) {
        try {
            mKeyStore.load(null);
            SecretKey key = (SecretKey) mKeyStore.getKey(keyName, null);
            cipher.init(Cipher.ENCRYPT_MODE, key);


            return true;
        } catch (KeyPermanentlyInvalidatedException e) {
            Toast.makeText(mContext, "Keys are invalidated after created. Retry the purchase\n"
                            + e.getMessage(),
                    Toast.LENGTH_LONG).show();

            return false;
        } catch (KeyStoreException | CertificateException | UnrecoverableKeyException | IOException
                | NoSuchAlgorithmException | InvalidKeyException e) {
            Toast.makeText(mContext, "Failed to init cipher", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_fingerprint, container, false);
        mCancelButton = v.findViewById(R.id.btnCancel);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (mCryptoObject != null) {
            mFingerprintHelper.startAuthentication(mFingerprintManager, mCryptoObject);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mFingerprintHelper.stopListening();
    }

    public void setContext(Context context) {
        mContext = context;
    }


    public void createKey(String keyName) {
        // The enrolling flow for fingerprint. This is where you ask the user to set up fingerprint
        // for your flow. Use of keys is necessary if you need to know if the set of
        // enrolled fingerprints has changed.
        try {
            mKeyStore.load(null);
            // Set the alias of the entry in Android KeyStore where the key will appear
            // and the constrains (purposes) in the constructor of the Builder

            KeyGenParameterSpec.Builder builder = new KeyGenParameterSpec.Builder(keyName,
                    KeyProperties.PURPOSE_ENCRYPT |
                            KeyProperties.PURPOSE_DECRYPT)
                    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                    // Require the user to authenticate with a fingerprint to authorize every use
                    // of the key
                    .setUserAuthenticationRequired(true)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7);

            mKeyGenerator.init(builder.build());
            mKeyGenerator.generateKey();
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException
                | CertificateException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onAuthenticated(boolean b) {
        if (b) {
            Toast.makeText(mContext.getApplicationContext(), "Auth success", Toast.LENGTH_LONG).show();
            dismiss();
        } else
            Toast.makeText(mContext.getApplicationContext(), "Auth failed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String s) {
        Toast.makeText(mContext.getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onHelp(String s) {
        Toast.makeText(mContext.getApplicationContext(), "Auth help message:" + s, Toast.LENGTH_LONG).show();
    }
}

