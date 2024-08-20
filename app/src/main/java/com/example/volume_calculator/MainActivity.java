package com.example.volume_calculator;


import android.content.Intent;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<My_Shape> shapeArrayList;
    MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        gridView = findViewById(R.id.gridView);
        shapeArrayList = new ArrayList<>();

        My_Shape s1 = new My_Shape(R.drawable.sphere,"sphere");
        My_Shape s2 = new My_Shape(R.drawable.cylinder,"Cylinder");
        My_Shape s3 = new My_Shape(R.drawable.cube,"Cube");
        My_Shape s4 = new My_Shape(R.drawable.prism,"Prism");

        shapeArrayList.add(s1);
        shapeArrayList.add(s2);
        shapeArrayList.add(s3);
        shapeArrayList.add(s4);

        adapter = new MyCustomAdapter(shapeArrayList,getApplicationContext());
        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long l) {
                My_Shape
                selectedShape = shapeArrayList.get(i);
                String shapeName = selectedShape.getShapeName();

                Class activityClass;
                if (shapeName.equals("sphere")) {
                    activityClass = activity_Sphere.class;
                } else if (shapeName.equals("Cylinder")) {
                    activityClass = activity_cylinder.class;
                } else {
                    // Handle other shapes or invalid selection
                    return;
                }

                Intent intent = new Intent(getApplicationContext(), activityClass);
                startActivity(intent);
            }
        });


    }
}