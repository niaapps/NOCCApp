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

public class DiscountActivity extends AppCompatActivity {

    ListView listViewDiscount;
    DatabaseReference ref;
    Discount discount;
    List<Discount> discountList;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_discount);
        listViewDiscount = (ListView) findViewById(R.id.listDLayout);
        discount = new Discount();
        discountList = new ArrayList<>();
        ref = FirebaseDatabase.getInstance().getReference("deals");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                discountList.clear();

                for (DataSnapshot discountSnapshot : dataSnapshot.getChildren()) {
                    Discount discountObj = discountSnapshot.getValue(Discount.class);
                    discountList.add(discountObj);

                }
                DiscountList discountAdapter = new DiscountList(DiscountActivity.this, discountList);
                //attaching adapter to the listview
                listViewDiscount.setAdapter(discountAdapter);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}