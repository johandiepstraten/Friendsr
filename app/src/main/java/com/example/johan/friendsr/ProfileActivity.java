package com.example.johan.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

//    Make sure the current friend is reachable in both onCreate and RatingBarListener
    Friend friend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

//        linked from the clicked on friend in the main page
        Intent intent = getIntent();
        friend = (Friend) intent.getSerializableExtra("clicked_friend");

//        set profile to show info of current friend
        ((TextView) findViewById(R.id.Name)).setText(friend.getName());
        ((TextView) findViewById(R.id.Bio)).setText(friend.getBio());
        ((ImageView) findViewById(R.id.Profile)).setImageResource(friend.getDrawableId());

//        get possible previous rating of friend
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        Float aStoredFloat = prefs.getFloat(friend.getName(), 0);
        RatingBar rate = (findViewById(R.id.ratingBar));
        if (aStoredFloat != 0) {
            rate.setRating(aStoredFloat);
        }
        else {
            rate.setRating(0);
        }

//         initiate RatingBarListener when ratingbar is clicked on
        rate.setOnRatingBarChangeListener(new RatingBarListener());
    }
    private class RatingBarListener implements RatingBar.OnRatingBarChangeListener  {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            Log.d("friends", "ratingbarClicked");

//            save rating
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putFloat(friend.getName(), ((RatingBar) findViewById(R.id.ratingBar)).getRating());
            editor.apply();
        }
    }
}
