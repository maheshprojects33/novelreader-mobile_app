package com.java.novelreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Book_Activity extends AppCompatActivity {



    private ImageView ivThumbnail;
    private TextView txtBookTitle, txtBookAuthor, txtPages, tvLongDesc;
    private Button btnCurrentlyReading, btnWantToRead, btnAlreadyRead, btnAddTo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_);


        initView();

        Intent intentExtra = getIntent();
        List_Holder_Class list =intentExtra.getParcelableExtra("Extra");
        int imageRes = list.getIcon();
        String bookTitle = list.getTitle();
        String author = list.getAuthor();
        String shortDesc = list.getShortDescription();
        String longDesc = list.getLongDescription();
        String pgNo = list.getPgNo();

        ImageView icon =findViewById(R.id.ivThumbnail);
        icon.setImageResource(imageRes);
        TextView title = findViewById(R.id.txtBookTitle);
        title.setText(bookTitle);
        TextView writer = findViewById(R.id.txtBookAuthor);
        writer.setText(author);
        TextView page = findViewById(R.id.txtPages);
        page.setText(pgNo);
        TextView longD = findViewById(R.id.tvLongDesc);
        longD.setText(longDesc);










        ivThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Book_Activity.this, PdfView.class );
                startActivity(intent);
            }
        });











    }



    private void initView() {
        ivThumbnail = findViewById(R.id.ivThumbnail);
        txtBookTitle = findViewById(R.id.txtBookTitle);
        txtBookAuthor = findViewById(R.id.txtBookAuthor);
        txtPages = findViewById(R.id.txtPages);
        tvLongDesc = findViewById(R.id.tvLongDesc);

        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnWantToRead = findViewById(R.id.btnWantToRead);
        btnAlreadyRead =findViewById(R.id.btnAlreadyRead);
        btnAddTo = findViewById(R.id.btnAddTo);

    }
}