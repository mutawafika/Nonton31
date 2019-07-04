package com.example.hp15_bw068axa10.nonton;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.hp15_bw068axa10.nonton.DetailFilm.EXTRA_JUDUL;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private FilmAdapter adapter;
    private ArrayList<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FilmAdapter(this);
        prepare();
        addItem();

        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {


                Intent intent = new Intent(MainActivity.this, DetailFilm.class);
                intent.putExtra( DetailFilm.EXTRA_JUDUL, films.get(i));
                startActivity(intent);

            }
        });
    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem(){
        films = new ArrayList<>();
        for (int i = 0 ; i < dataName.length; i++){
            Film film = new Film();
            film.setPhoto(dataPhoto.getResourceId(i, -1));
            film.setName(dataName[i]);
            film.setDescription(dataDescription[i]);
            films.add(film);
        }
        adapter.setFilms(films);

    }

}
