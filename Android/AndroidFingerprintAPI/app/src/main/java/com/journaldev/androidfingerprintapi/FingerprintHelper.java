package com.journaldev.androidfingerprintapi;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.support.v4.app.ActivityCompat;

public class FingerprintHelper extends FingerprintManager.AuthenticationCallback {


    private Context mContext;
    private FingerprintManager mFingerprintManager;
    private CancellationSignal mCancellationSignal;
    private Callback mCallback;


    public FingerprintHelper(FingerprintManager fingerprintManager, Context context, Callback callback) {
        mContext = context;
        mFingerprintManager = fingerprintManager;
        mCallback = callback;

    }


    public boolean isFingerprintAuthAvailable() {

        return mFingerprintManager.isHardwareDetected()
                && mFingerprintManager.hasEnrolledFingerprints();
    }


    public void startAuthentication(FingerprintManager manager, FingerprintManager.CryptoObject cryptoObject) {

        if (!isFingerprintAuthAvailable())
            return;

        mCancellationSignal = new CancellationSignal();
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        manager.authenticate(cryptoObject, mCancellationSignal, 0, this, null);
    }


    public void stopListening() {
        if (mCancellationSignal != null) {
            mCancellationSignal.cancel();
            mCancellationSignal = null;
        }
    }

    @Override
    public void onAuthenticationError(int errMsgId, CharSequence errString) {
        mCallback.onError(errString.toString());
    }


    @Override
    public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
        mCallback.onHelp(helpString.toString());
    }


    @Override
    public void onAuthenticationFailed() {
        mCallback.onAuthenticated(false);
    }


    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        mCallback.onAuthenticated(true);
    }


    public interface Callback {

        void onAuthenticated(boolean b);

        void onError(String s);

        void onHelp(String s);
    }
}
