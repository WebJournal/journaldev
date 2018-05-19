package com.journaldev.efficientsearch;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements CuisineSearchAdapter.ItemListener {

    Toolbar toolbar;
    private ImageView image_search_back;
    private RelativeLayout view_search;
    private EditText edit_text_search;
    private CardView card_search;
    private View line_divider, toolbar_shadow;
    RecyclerView recyclerView;
    ListView listView;
    String text = "";
    List<Model> modelsList, filterModels;
    List<Model> cuisinesModels;

    ListViewAdapter listViewAdapter;
    CuisineSearchAdapter cuisineSearchAdapter;
    ShowSearchView showSearchView;

    boolean editTextChangedFromClick = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        showSearchView = new ShowSearchView();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_main);
        image_search_back = (ImageView) findViewById(R.id.image_search_back);
        view_search = (RelativeLayout) findViewById(R.id.view_search);
        edit_text_search = (EditText) findViewById(R.id.edit_text_search);
        card_search = (CardView) findViewById(R.id.card_search);
        line_divider = findViewById(R.id.line_divider);
        toolbar_shadow = findViewById(R.id.toolbar_shadow);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listView = (ListView) findViewById(R.id.listView);

        TextView no_results = (TextView) findViewById(R.id.txtNoResultsFound);
        listView.setEmptyView(no_results);
        populateRestaurantsAndCuisines();


        image_search_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "";

                showSearchView.handleToolBar(MainActivity.this, card_search, toolbar, view_search, recyclerView, edit_text_search, line_divider);
                toolbar_shadow.setVisibility(View.VISIBLE);
                listViewAdapter = new ListViewAdapter(modelsList);

                listView.setAdapter(listViewAdapter);
            }
        });

        edit_text_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                text = s.toString();

                if (editTextChangedFromClick) {
                    editTextChangedFromClick = false;

                    if (recyclerView.getVisibility() == View.VISIBLE)
                        recyclerView.setVisibility(View.GONE);

                } else {

                    if (recyclerView.getVisibility() != View.VISIBLE)
                        recyclerView.setVisibility(View.VISIBLE);

                    if (s.toString().length() > 0) {
                        performFiltering(filterModels);
                    } else {
                        CuisineSearchAdapter cuisineSearchAdapter = new CuisineSearchAdapter(cuisinesModels, modelsList, MainActivity.this, MainActivity.this, text);
                        cuisineSearchAdapter.notifyDataSetChanged();
                        recyclerView.setAdapter(cuisineSearchAdapter);

                        listViewAdapter = new ListViewAdapter(modelsList);
                        listView.setAdapter(listViewAdapter);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edit_text_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // Your piece of code on keyboard search click
                    recyclerView.setVisibility(View.GONE);
                    ((InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view_search.getWindowToken(), 0);

                    listViewAdapter.getFilter().filter(v.getText().toString());

                    return true;
                }
                return false;
            }
        });


        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItem = item.getItemId();
                switch (menuItem) {
                    case R.id.action_search:
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        cuisineSearchAdapter = new CuisineSearchAdapter(cuisinesModels, filterModels, MainActivity.this, MainActivity.this, text);
                        recyclerView.setAdapter(cuisineSearchAdapter);
                        showSearchView.handleToolBar(MainActivity.this, card_search, toolbar, view_search, recyclerView, edit_text_search, line_divider);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });


    }

    private void populateRestaurantsAndCuisines() {
        modelsList = new ArrayList<>();
        cuisinesModels = new ArrayList<>();

        List<String> cuisinesList = new ArrayList<>();

        for (int i = 0; i < 7; i++)
            cuisinesList.add("Cafes");
        for (int i = 0; i < 4; i++)
            cuisinesList.add("Burgers");
        for (int i = 0; i < 4; i++)
            cuisinesList.add("Bars");

        modelsList.add(new Model("1", "McDonalds", new ArrayList<>(Arrays.asList("Cafes", "Burgers")), false, -1));
        modelsList.add(new Model("2", "KFC", new ArrayList<>(Arrays.asList("Cafes", "Burgers")), false, -1));
        modelsList.add(new Model("3", "Burger King", new ArrayList<>(Arrays.asList("Cafes", "Burgers")), false, -1));
        modelsList.add(new Model("4", "Subway", new ArrayList<>(Arrays.asList("Burgers")), false, -1));
        modelsList.add(new Model("5", "Cafe Coffee Day", new ArrayList<>(Arrays.asList("Cafes")), false, -1));
        modelsList.add(new Model("6", "Costa", new ArrayList<>(Arrays.asList("Cafes")), false, -1));
        modelsList.add(new Model("7", "Coffee Beans", new ArrayList<>(Arrays.asList("Cafes")), false, -1));
        modelsList.add(new Model("8", "Starbucks", new ArrayList<>(Arrays.asList("Cafes")), false, -1));
        modelsList.add(new Model("9", "Blues", new ArrayList<>(Arrays.asList("Bars")), false, -1));
        modelsList.add(new Model("10", "Hard Rock Cafe", new ArrayList<>(Arrays.asList("Bars", "Cafe")), false, -1));
        modelsList.add(new Model("11", "The Backyard Underground", new ArrayList<>(Arrays.asList("Bars")), false, -1));
        modelsList.add(new Model("12", "Downtown", new ArrayList<>(Arrays.asList("Bars")), false, -1));

        Map<String, Integer> cuisineMap = new HashMap<>();
        for (String cuisine : cuisinesList) {
            Integer n = cuisineMap.get(cuisine);
            n = (n == null) ? 1 : ++n;
            cuisineMap.put(cuisine, n);

        }

        for (Map.Entry<String, Integer> entry : cuisineMap.entrySet()) {
            Model model = new Model("", entry.getKey(), null, true, entry.getValue());
            modelsList.add(model);
            cuisinesModels.add(model);
        }

        filterModels = new ArrayList<>(modelsList);


        initialiseAdapters();

    }

    private void initialiseAdapters() {
        listViewAdapter = new ListViewAdapter(filterModels);
        listView.setAdapter(listViewAdapter);
    }

    @Override
    public void onItemClick(Model model) {

        editTextChangedFromClick = true;

        if (model.isCuisine) {
            edit_text_search.setText(model.name);
            listViewAdapter.getFilter().filter(model.name);

        } else {

            edit_text_search.setText(model.name);
            showSearchView.handleToolBar(MainActivity.this, card_search, toolbar, view_search, recyclerView, edit_text_search, line_divider);
            Toast.makeText(getApplicationContext(), model.name + " was selected.", Toast.LENGTH_LONG).show();
        }


    }

    public void performFiltering(List<Model> filteredSuggestions) {

        filteredSuggestions.clear();
        for (Model model : modelsList) {
            if (model.name.toLowerCase().contains(text.toLowerCase())) {
                filteredSuggestions.add(model);
            }
        }

        CuisineSearchAdapter cuisineSearchAdapter = new CuisineSearchAdapter(cuisinesModels, filteredSuggestions, MainActivity.this, MainActivity.this, text);
        cuisineSearchAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(cuisineSearchAdapter);

    }
}
