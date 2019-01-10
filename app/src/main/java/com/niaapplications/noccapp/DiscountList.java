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

public class DiscountList extends ArrayAdapter<Discount>{
    private Activity context;
    List<Discount> discount;

    public DiscountList(Activity context, List<Discount> discount) {
        super(context, R.layout.listlayout, discount);
        this.context = context;
        this.discount = discount;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.listlayout, null, true);
        final Discount discObj = discount.get(position);

        String url = discObj.getBusinessPhoto();
        ImageView imageView = (ImageView) listViewItem.findViewById(R.id.image);
        Button button = (Button) listViewItem.findViewById(R.id.button);

        Glide.with(context).load(url).into(imageView);
        button.setText(discObj.getName() + System.getProperty("line.separator") + discObj.getDescription());

// For when DB is updated, just uncomment
//   button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Uri uri = Uri.parse(discObj.getWebURL());
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                context.startActivity(intent);
//            }
//        });
        return listViewItem;



    }

}