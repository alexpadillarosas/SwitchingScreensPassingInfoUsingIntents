package com.blueradix.android.switchingscreenspassinginfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMenuIntent = new Intent( MainActivity.this, MenuActivity.class);

                TextInputLayout usernameTextInputLayout = findViewById(R.id.usernameTextInputLayout);
                String username = usernameTextInputLayout.getEditText().getText().toString();

                goToMenuIntent.putExtra("username", username);
                //We won't wait for any response value when the user return to this Activity
                startActivity(goToMenuIntent);
            }
        });

    }
}