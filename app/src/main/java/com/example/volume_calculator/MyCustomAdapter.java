package com.example.volume_calculator;

import android.content.Context;
import android.graphics.drawable.shapes.Shape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

//This class will be responsible for creating
//the view for each item and binding data to it
public class MyCustomAdapter extends ArrayAdapter<My_Shape> {
    private ArrayList<My_Shape> shapeArrayList;
    Context context;



    public MyCustomAdapter( ArrayList<My_Shape> shapeArrayList, Context context1) {
        super(context1, R.layout.grid_item_layout,shapeArrayList);
        this.shapeArrayList = shapeArrayList;
        this.context = context1;
    }

    //View Holder: Used to cache references to the views within an item layout
    private static class MyViewHolder{
        TextView shapeName;
        ImageView shapeImage;

    }
    // GetView() : Used to create and return a view for a specific item in grid.
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //1- Get the shape object for the current position
        My_Shape shapes = getItem(position);
        //2- Inflating Layout:
        MyViewHolder myViewHolder;

        if (convertView==null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.grid_item_layout,parent,false);
            myViewHolder.shapeImage = (ImageView) convertView.findViewById(R.id.imageView);
            myViewHolder.shapeName = (TextView) convertView.findViewById(R.id.textView);

            convertView.setTag(myViewHolder);
        }else {

            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        myViewHolder.shapeName.setText(shapes.getShapeName());
        myViewHolder.shapeImage.setImageResource(shapes.getShapeImg());

        return convertView;
    }
}

