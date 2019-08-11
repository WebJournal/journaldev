package com.journaldev.androidmaterialcomponentdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnDialog;
    Button btnMaterialDialog;
    Button btnDialogStyled;
    Button btnCutShapedDialog;
    Button btnRoundShapedDialog;
    Button btnFontDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDialog = findViewById(R.id.btnDialog);
        btnMaterialDialog = findViewById(R.id.btnMaterialDialog);
        btnDialogStyled = findViewById(R.id.btnDialogStyled);
        btnCutShapedDialog = findViewById(R.id.btnCutShapedDialog);
        btnRoundShapedDialog = findViewById(R.id.btnRoundShapedDialog);
        btnFontDialog = findViewById(R.id.btnFontDialog);

        btnDialog.setOnClickListener(this);
        btnMaterialDialog.setOnClickListener(this);
        btnDialogStyled.setOnClickListener(this);
        btnCutShapedDialog.setOnClickListener(this);
        btnRoundShapedDialog.setOnClickListener(this);
        btnFontDialog.setOnClickListener(this);

    }


    private void createDialog(int customStyle)
    {

        new MaterialAlertDialogBuilder(MainActivity.this, customStyle)
                .setTitle("Title")
                .setMessage("Your message goes here. Keep it short but clear.")
                .setPositiveButton("GOT IT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNeutralButton("LATER", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnDialog:


                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Title")
                        .setMessage("Your message goes here. Keep it short but clear.")
                        .setPositiveButton("GOT IT", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();
                break;
            case R.id.btnMaterialDialog:

                new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Title")
                        .setMessage("Your message goes here. Keep it short but clear.")
                        .setPositiveButton("GOT IT", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                        .show();
                break;

            case R.id.btnDialogStyled:
                createDialog(R.style.AlertDialogTheme);
                break;

            case R.id.btnCutShapedDialog:
                createDialog(R.style.CutShapeTheme);
                break;

            case R.id.btnRoundShapedDialog:
                createDialog(R.style.RoundShapeTheme);
                break;

            case R.id.btnFontDialog:
                createDialog(R.style.CustomFont);
                break;
        }

    }
}
