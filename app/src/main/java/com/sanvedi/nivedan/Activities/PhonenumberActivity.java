package com.sanvedi.nivedan.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.sanvedi.nivedan.databinding.ActivityPhonenumberBinding;

public class PhonenumberActivity extends AppCompatActivity {

    ActivityPhonenumberBinding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhonenumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null){
            Intent intent = new Intent(PhonenumberActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

        getSupportActionBar().hide();
        binding.phoneBox.requestFocus();    //input box open k liye


        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhonenumberActivity.this,OtpActivity.class);
                intent.putExtra("phoneNumber",binding.phoneBox.getText().toString());

                startActivity(intent);
            }
        });



    }
}