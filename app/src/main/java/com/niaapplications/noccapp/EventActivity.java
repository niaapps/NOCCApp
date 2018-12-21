package com.niaapplications.noccapp;


import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.widget.ListView;
import android.os.Bundle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;
//Discount Activity, responsible for displaying the discounts list.

public class EventActivity extends AppCompatActivity {

    ListView listViewDiscount;
    DatabaseReference ref;
    Event event;
    List<Event> eventList;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_event);
        listViewDiscount = (ListView) findViewById(R.id.listELayout);
        event = new Event();
        eventList = new ArrayList<>();
        ref = FirebaseDatabase.getInstance().getReference("businesses");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                eventList.clear();

                for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {
                    Event eventObj = eventSnapshot.getValue(Event.class);
                    eventList.add(eventObj);

                }
                EventList eventAdapter = new EventList(EventActivity.this, eventList);
                //attaching adapter to the listview
                listViewDiscount.setAdapter(eventAdapter);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }



}
