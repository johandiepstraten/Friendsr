package com.example.johan.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Printer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    Initiate List of friends
    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Make class objects
        friends.add(new Friend("Sanne", "Ik ben messed up", getResources().getIdentifier("sanne2",
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
        friends.add(new Friend("Vrouw Sam", "Wereldreiziger met een zachte g", getResources().getIdentifier("vrouwsam",
                "drawable", getPackageName())));
        friends.add(new Friend("Ya'gel", "Kom naar Krit", getResources().getIdentifier("yagel",
                "drawable", getPackageName())));

//        Connecting the adapter to the gridview and the list.
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView gridview = findViewById(R.id.gridview);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new GridItemClickListener());
    }
//    Notice when Item is clicked on
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//            Log what friend is clicked on
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);
            Log.d("friends", "checkClicked: " + String.valueOf(clickedFriend.getName()));

//            Link to friend profile
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}
