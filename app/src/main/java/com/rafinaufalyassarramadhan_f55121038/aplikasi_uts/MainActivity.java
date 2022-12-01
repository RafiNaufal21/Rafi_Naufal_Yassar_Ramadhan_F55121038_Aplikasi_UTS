package com.rafinaufalyassarramadhan_f55121038.aplikasi_uts;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] datadescription;
    private TypedArray dataPhoto;
    private HeroAdapter adapter;
    private ArrayList<Hero> heroes;
    private String[] dataName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new HeroAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);
        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int Position, long id) {
               if (Position == 0){
                    startActivity(new Intent(MainActivity.this, museum.class));
                }
               else if( Position == 1 ){
                   startActivity(new Intent(MainActivity.this, tamannasional.class));
                }
                else if( Position == 2 ){
                    startActivity(new Intent(MainActivity.this, souraja.class));
                }
               else if( Position == 3 ){
                   startActivity(new Intent(MainActivity.this, cagaralammorowalli.class));
               }
               else if( Position == 4 ){
                   startActivity(new Intent(MainActivity.this, tuguperdamaian.class));
               }
               else if( Position == 5 ){
                   startActivity(new Intent(MainActivity.this, danauposo.class));
               }
               else if( Position == 6 ){
                   startActivity(new Intent(MainActivity.this, danautambing.class));
               }
               else if( Position == 7 ){
                   startActivity(new Intent(MainActivity.this, pulautogean.class));
               }
            }
        });
    }
    private void prepare() {
        dataName =
                getResources().getStringArray(R.array.data_name);
        datadescription =
                getResources().getStringArray(R.array.data_description);
        dataPhoto =
                getResources().obtainTypedArray(R.array.data_photo);
    }
    private void addItem() {
        heroes = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Hero hero = new Hero ();
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setDescription(datadescription[i]);
            heroes.add(hero);
        }
        adapter.setHeroes(heroes);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setQueryHint("Search Wisata..");
        return true;
    }
}
