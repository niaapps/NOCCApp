package com.niaapplications.noccapp;

import android.app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import java.util.List;

//DiscountList Activity, responsible loading the discounts into the discount list.

public class EventList extends ArrayAdapter<Event>{
    private Activity context;
    List<Event> event;

    public EventList(Activity context, List<Event> event) {
        super(context, R.layout.listlayout, event);
        this.context = context;
        this.event = event;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.listlayout, null, true);
        final Event eventObj = event.get(position);
        Button button = (Button) listViewItem.findViewById(R.id.button);
        String url = eventObj.getPictureURL();
        ImageView imageView = (ImageView) listViewItem.findViewById(R.id.image);


        Glide.with(context).load(url).into(imageView);
        button.setText(eventObj.getName() + System.getProperty("line.separator") + eventObj.getDescription());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(eventObj.getWebURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }
        });

        return listViewItem;
    }


}