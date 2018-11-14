package com.example.johan.friendsr;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friend> {
    private ArrayList<Friend> friends;
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

//        Make sure you can scroll through list of friends in main page
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }
        Friend currentFriend = friends.get(position);
        String friend_name = currentFriend.getName();
        ((TextView) convertView.findViewById(R.id.FriendName)).setText(friend_name);
        ((ImageView) convertView.findViewById(R.id.FriendPicture)).setImageResource(currentFriend.getDrawableId());
        return convertView;
    }


    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }
}
