package com.example.johan.friendsr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Printer;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        friends.add(new Friend("Sanne", "Ik ben ook messed up", getResources().getIdentifier("sanne2",
                "drawable", getPackageName())));
        friends.add(new Friend("Annemijn", "Wikipediawedstrijd?", getResources().getIdentifier("annemijn",
                "drawable", getPackageName())));
        friends.add(new Friend("Man Sam", "Waar is Daantje?", getResources().getIdentifier("mansam",
                "drawable", getPackageName())));
        friends.add(new Friend("Jan", "Ik mediteer 10 uur per dag", getResources().getIdentifier("jan",
                "drawable", getPackageName())));
        friends.add(new Friend("Mendel", "Ik kan niet", getResources().getIdentifier("mendel",
                "drawable", getPackageName())));
        friends.add(new Friend("Rebecca", "De wereld is een regenboog en de pot met goud staat in een steegje naast de Amstel54", getResources().getIdentifier("rebecca",
                "drawable", getPackageName())));
        friends.add(new Friend("Steven", "Ik ben beter geworden in opruimen door Edinburgh", getResources().getIdentifier("steven",
                "drawable", getPackageName())));
        friends.add(new Friend("Vrouw Sam", "Wereldreiziger met een zachter g", getResources().getIdentifier("vrouwsam",
                "drawable", getPackageName())));
        friends.add(new Friend("Ya'gel", "Kom naar Krit", getResources().getIdentifier("yagel",
                "drawable", getPackageName())));

        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView testgridview = findViewById(R.id.gridview);

        testgridview.setAdapter(adapter);
    }
}
