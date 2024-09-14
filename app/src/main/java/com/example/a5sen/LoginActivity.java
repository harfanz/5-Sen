package com.example.a5sen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a5sen.databinding.ActivityLoginBinding;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    //TextInputEditText editUsername, editPassword;

    private ActivityLoginBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ActivityMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

binding = ActivityLoginBinding.inflate(getLayoutInflater());
View view= binding.getRoot();
setContentView(view);

       //editUsername = findViewById(R.id.editUsername);
      // editPassword = findViewById(R.id.editPassword);

    }

    public void onButtonLoginClicked(View view) {

        //Explicit Intent
        String username = binding.editUsername.getText().toString();
        String password = binding.editPassword.getText().toString();

        if(password.equals("123")){
            Intent mainIntent = new Intent(this, MainActivity.class);
            mainIntent.putExtra("USERNAME", username);
            mainIntent.putExtra("IS_LOGGED_IN", true);
            startActivity(mainIntent);

        }else {
            Toast.makeText(this, "Kombinasi Username dan Password salah", Toast.LENGTH_SHORT).show();
        }
    }

    public void onForgotPasssword(View view) {
        //Implicit Intent
        Intent callIntent=new Intent();
        callIntent.setAction(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:0895-3605-5776-5"));
        startActivity(callIntent);

//        public void onForgotPasssword(View view) {
//            Implicit Intent
//            Intent callIntent=new Intent();
//      /      callIntent.setAction(Intent.ACTION_SEND);
//            callIntent.setType("text/plain");
//            callIntent.putExtra(Intent.EXTRA_TEXT,"Hallo Saya Lupa Password");
//            if (callIntent.resolveActivity(getPackageManager()) != null) {
//                startActivity(callIntent);
//            }
        callIntent.setData(Uri.parse("tel:0895-3605-5776-5"));
        startActivity(callIntent);
//            else {
//                Toast.makeText(this, "Activity tidak tersedia", Toast.LENGTH_SHORT).show();
//            }
//        }
    }
}