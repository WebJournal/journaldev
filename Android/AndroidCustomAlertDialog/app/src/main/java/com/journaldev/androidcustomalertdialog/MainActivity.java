package com.journaldev.androidcustomalertdialog;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpleAlert(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Simple Alert");
        builder.setMessage("We have a message");
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),
                                "OK was clicked",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),
                        android.R.string.no, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    public void withItems(View view) {

        final String[] items = {"Apple", "Banana", "Orange", "Grapes"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("List of Items")

                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), items[which] + " is clicked", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.setPositiveButton("OK", null);
        builder.setNegativeButton("CANCEL", null);
        builder.setNeutralButton("NEUTRAL", null);
        builder.setPositiveButtonIcon(getResources().getDrawable(android.R.drawable.ic_menu_call, getTheme()));
        builder.setIcon(getResources().getDrawable(R.drawable.jd, getTheme()));

        AlertDialog alertDialog = builder.create();

        alertDialog.show();

        Button button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        button.setBackgroundColor(Color.BLACK);
        button.setPadding(0, 0, 20, 0);
        button.setTextColor(Color.WHITE);
    }

    public void withMultiChoiceItems(View view) {
        final String[] items = {"Apple", "Banana", "Orange", "Grapes"};
        final ArrayList<Integer> selectedList = new ArrayList<>();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("This is list choice dialog box");
        builder.setMultiChoiceItems(items, null,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            selectedList.add(which);
                        } else if (selectedList.contains(which)) {
                            selectedList.remove(Integer.valueOf(which));
                        }
                    }
                });

        builder.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ArrayList<String> selectedStrings = new ArrayList<>();

                for (int j = 0; j < selectedList.size(); j++) {
                    selectedStrings.add(items[selectedList.get(j)]);
                }

                Toast.makeText(getApplicationContext(), "Items selected are: " + Arrays.toString(selectedStrings.toArray()), Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();

    }

    public void withEditText(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("With Edit Text");

        final EditText input = new EditText(MainActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        builder.setView(input);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Text entered is " + input.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void withImageView(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.alert_dialog_with_imageview, null);
        builder.setPositiveButton("OK", null);
        builder.setView(dialogLayout);
        builder.show();
    }

    public void withSeekBar(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("With SeekBar");
        final SeekBar seekBar = new SeekBar(MainActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        seekBar.setLayoutParams(lp);
        builder.setView(seekBar);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Progress is " + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();

    }

    public void withRatingBar(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        builder.setTitle("With RatingBar");
        View dialogLayout = inflater.inflate(R.layout.alert_dialog_with_ratingbar, null);
        final RatingBar ratingBar = dialogLayout.findViewById(R.id.ratingBar);
        builder.setView(dialogLayout);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Rating is " + ratingBar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
}
