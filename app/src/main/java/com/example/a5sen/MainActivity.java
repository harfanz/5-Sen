package com.example.a5sen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a5sen.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


private boolean isLoggedIn =false;
//TextView textGreeting;

private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ActivityMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;});


//        setContentView(R.layout.activity_main);
binding= ActivityMainBinding.inflate(getLayoutInflater());
View view= binding.getRoot();
setContentView(view);

        Intent mainIntent = getIntent();
        String username = mainIntent.getStringExtra("USERNAME");
        isLoggedIn = mainIntent.getBooleanExtra("IS_LOGGED_IN", false);

        if(!isLoggedIn){
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        }

//       textGreeting = binding.textGreeting;//(TextView) findViewById(R.id.textGreeting);
//       textGreeting.setText("Hello, " + username);

       binding.textGreeting.setText("Hello" + username);



    }
}