package com.example.hp15_bw068axa10.nonton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFilm extends AppCompatActivity {
    public static final String EXTRA_JUDUL = "extra_judul";


    TextView tvName;
    TextView tvDescription;
    ImageView tvPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        tvName = findViewById(R.id.txt_name_receive);
        tvDescription = findViewById(R.id.txt_description_received);
        tvPhoto = findViewById(R.id.img_photo_receive);


        Film film = getIntent().getParcelableExtra(EXTRA_JUDUL);

        String judul = film.getName();
        tvName.setText(judul);

        String desc = film.getDescription();
        tvDescription.setText(desc);

        int foto = film.getPhoto();
        tvPhoto.setImageResource(foto);


    }
}
