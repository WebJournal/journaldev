package com.journaldev.androiddialogfragment;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MyDialogFragment.DialogListener {

    Button btnEmbedDialogFragment, btnDialogFragment, btnDialogFragmentFullScreen, btnAlertDialogFragment;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textView);
        btnEmbedDialogFragment = findViewById(R.id.btnEmbedDialogFragment);
        btnDialogFragment = findViewById(R.id.btnDialogFragment);
        btnDialogFragmentFullScreen = findViewById(R.id.btnDialogFragmentFullScreen);
        btnAlertDialogFragment = findViewById(R.id.btnAlertDialogFragment);

        btnEmbedDialogFragment.setOnClickListener(this);
        btnDialogFragment.setOnClickListener(this);
        btnDialogFragmentFullScreen.setOnClickListener(this);
        btnAlertDialogFragment.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnEmbedDialogFragment:
                MyDialogFragment dialogFragment = new MyDialogFragment();

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                ft.replace(R.id.frameLayout, dialogFragment);
                ft.commit();
                break;

            case R.id.btnDialogFragment:
                dialogFragment = new MyDialogFragment();

                Bundle bundle = new Bundle();
                bundle.putBoolean("notAlertDialog", true);

                dialogFragment.setArguments(bundle);

                ft = getSupportFragmentManager().beginTransaction();
                Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);


                dialogFragment.show(ft, "dialog");
                break;

            case R.id.btnDialogFragmentFullScreen:
                dialogFragment = new MyDialogFragment();

                bundle = new Bundle();
                bundle.putString("email", "xyz@gmail.com");
                bundle.putBoolean("fullScreen", true);
                bundle.putBoolean("notAlertDialog", true);

                dialogFragment.setArguments(bundle);


                ft = getSupportFragmentManager().beginTransaction();
                prev = getSupportFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);


                dialogFragment.show(ft, "dialog");
                break;

            case R.id.btnAlertDialogFragment:
                dialogFragment = new MyDialogFragment();


                ft = getSupportFragmentManager().beginTransaction();
                prev = getSupportFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);


                dialogFragment.show(ft, "dialog");
                break;
        }
    }

    @Override
    public void onFinishEditDialog(String inputText) {

        if (TextUtils.isEmpty(inputText)) {
            textView.setText("Email was not entered");
        } else
            textView.setText("Email entered: " + inputText);
    }
}
