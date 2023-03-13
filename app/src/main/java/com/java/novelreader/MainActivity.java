package com.java.novelreader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnSeeAllBooks, btnCurrentlyReading, btnAlreadyRead, btnWishList, btnFavorite, btnAbout;
    private TextView tvDeveloped;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Method for initializing all buttons
         */
        initButton();

        //Method for initializing long click on developed by text
        lclickDev();

        //Method for onClick on See All Books
        btnSeeAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSAB = new Intent(MainActivity.this, All_Books.class);
                startActivity(intentSAB);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Book_Activity.class);
                startActivity(intent);
            }
        });




    }

    private void seeAllBooks() {


    }





    //Method of initializing Buttons
    private void initButton() {
        btnSeeAllBooks = findViewById(R.id.btnSeeAllBooks);
        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead);
        btnWishList = findViewById(R.id.btnWishList);
        btnFavorite = findViewById(R.id.btnFavorite);
        btnAbout = findViewById(R.id.btnAbout);

        tvDeveloped = findViewById(R.id.tvDeveloped);
    }

    //Method of on Long Click Text View
    private void lclickDev() {
        tvDeveloped.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "\"I LOVE YOU VERY MUCH BDS\"", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}