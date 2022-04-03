package com.bmcong2k.spinner_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class SpinnerAdapter extends BaseAdapter {

    private int[] imgs = {
        R.drawable.facebook_logo,
        R.drawable.github_logo,
        R.drawable.google_logo
    };
    private Context context;

    public SpinnerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view  = LayoutInflater.from(context)
                .inflate(R.layout.item_image, parent, false);
        ImageView img  = view.findViewById(R.id.image);
        img.setImageResource(imgs[position]);

        return view;
    }
}
