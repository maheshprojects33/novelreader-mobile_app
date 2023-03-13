package com.java.novelreader;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class All_Books extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerLayoutManager;
    private Recycler_Adapter recyclerAdapter;
    private ArrayList<List_Holder_Class> allBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__books);

        createArrayListForBooks();

        recyclerView = findViewById(R.id.recycler_view);

        recyclerLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerLayoutManager);

        recyclerAdapter = new Recycler_Adapter(allBooks, this);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerAdapter.setOnItemClickListener(new Recycler_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intentToBookActivity = new Intent(All_Books.this, Book_Activity.class);
                intentToBookActivity.putExtra("Extra", allBooks.get(position));
                startActivity(intentToBookActivity);
            }
        });


    }

    private void createArrayListForBooks() {
        allBooks = new ArrayList<>();
        allBooks.add(new List_Holder_Class(R.drawable.alchemist_, "R.string.the_alchemist", "Paulo Coelho", "Short Description", getString(R.string.alchemist_desc), "190"));
        allBooks.add(new List_Holder_Class(R.drawable.eleven_minutes_, getString(R.string.Eleven_Minutes), "Paulo Coelho", "Short Description", getString(R.string.ElevenMinutes_desc), "190"));
        allBooks.add(new List_Holder_Class(R.drawable.a_lot_like_love_, getString(R.string.A_Lot_Like_Love), "Sumrit Shahi", "Short Description", getString(R.string.ALotLikeLove_desc), "190"));
        allBooks.add(new List_Holder_Class(R.drawable.its_first_love_, getString(R.string.Its_First_Love), "Sachin Garg", "Short Description", getString(R.string.ItsFirstLove_desc), "190"));
        allBooks.add(new List_Holder_Class(R.drawable.charlie_chaplin_, getString(R.string.My_Autobiography), "Charles Spencer", "Short Description", getString(R.string.MyAutobiography_desc), "190"));
        allBooks.add(new List_Holder_Class(R.drawable.the_battle_of_life_, getString(R.string.The_Battle_of_Life), "Charles Dickens", "Short Description", getString(R.string.TheBattleOfLife_desc), "190"));
        allBooks.add(new List_Holder_Class(R.drawable.your_dreams_are_mine_, getString(R.string.Your_Dreams_Are_Mine_Now), "Ravinder Singh", "Short Description", getString(R.string.YourDreamsAreMineNow_desc), "190"));
        allBooks.add(new List_Holder_Class(R.drawable.mistakes_, getString(R.string.The_Mistakes_of_My_Life), "Chetan Bhagat", "Short Description", getString(R.string.TheMistakesOfMyLife_desc), "190"));

    }
}