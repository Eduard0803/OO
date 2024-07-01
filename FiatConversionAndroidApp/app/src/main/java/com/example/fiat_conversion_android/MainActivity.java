package com.example.fiat_conversion_android;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText __email, __password;
    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.this.__email = findViewById(R.id.textInputEditText);
                MainActivity.this.__password = findViewById(R.id.textInputEditText2);

                MainActivity.this.email = MainActivity.this.__email.getText().toString();
                MainActivity.this.password = MainActivity.this.__password.getText().toString();


                Log.i("MainActivity", "\n\n\nClicked button\n\n\n");

                Log.i("E-MAIL", "\n\n\n"+ MainActivity.this.email +"\n\n\n");
                Log.i("PASSWORD", "\n\n\n"+ MainActivity.this.password +"\n\n\n");
            }
        });
    }
}
