package com.journaldev.androidviewmodel;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FavouritesAdapter mFavAdapter;
    private FavouritesViewModel mFavViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        FloatingActionButton fab = findViewById(R.id.fab);

        mFavViewModel = ViewModelProviders.of(this).get(FavouritesViewModel.class);

        List<Favourites> favourites = mFavViewModel.getFavs();
        mFavAdapter = new FavouritesAdapter(this, R.layout.list_item_row, favourites);
        listView.setAdapter(mFavAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText inUrl = new EditText(MainActivity.this);
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("New favourite")
                        .setMessage("Add a url link below")
                        .setView(inUrl)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String url = String.valueOf(inUrl.getText());
                                long date = (new Date()).getTime();
                                // VM AND VIEW
                                mFavAdapter.add(mFavViewModel.addFav(url, date));
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();
            }
        });
    }

    public void deleteFav(View view) {
        View parent = (View) view.getParent();
        int position = (int) parent.getTag(R.id.POS);
        Favourites favourites = mFavAdapter.getItem(position);
        // VM
        mFavViewModel.removeFav(favourites.mId);
        // VIEW
        mFavAdapter.remove(favourites);
    }

    public class FavouritesAdapter extends ArrayAdapter<Favourites> {

        private class ViewHolder {
            TextView tvUrl;
            TextView tvDate;
        }

        public FavouritesAdapter(Context context, int layoutResourceId, List<Favourites> todos) {
            super(context, layoutResourceId, todos);
        }

        @Override
        @NonNull
        public View getView(int position, View convertView, ViewGroup parent) {
            Favourites favourites = getItem(position);
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.list_item_row, parent, false);
                viewHolder.tvUrl = convertView.findViewById(R.id.tvUrl);
                viewHolder.tvDate = convertView.findViewById(R.id.tvDate);
                convertView.setTag(R.id.VH, viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag(R.id.VH);

            }

            viewHolder.tvUrl.setText(favourites.mUrl);
            viewHolder.tvDate.setText((new Date(favourites.mDate).toString()));
            convertView.setTag(R.id.POS, position);
            return convertView;
        }

    }
}
