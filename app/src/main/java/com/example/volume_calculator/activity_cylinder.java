package com.example.volume_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_cylinder extends AppCompatActivity {

    TextView result,title;
    EditText cylinder_radi,cylinder_height;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cylinder);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cylinder_radi = findViewById(R.id.cylinder_edit_txt);
        result = findViewById(R.id.textView_vol);
        title = findViewById(R.id.textView_cylinder);
        button =findViewById(R.id.button);
        cylinder_height = findViewById(R.id.editText_height);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String radius = cylinder_radi.getText().toString();
                String height = cylinder_height.getText().toString();

                int r = Integer.parseInt(radius);
                int h = Integer.parseInt(height);

                double vol = 3.12159*r*r*h;
                result.setText("Vol = "+vol+"m^3");

            }
        });

    }
}