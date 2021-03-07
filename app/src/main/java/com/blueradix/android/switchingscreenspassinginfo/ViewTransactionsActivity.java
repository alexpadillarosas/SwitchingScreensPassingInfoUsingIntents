package com.blueradix.android.switchingscreenspassinginfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewTransactionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_transactions);

        //get the username passed in the intent
        Intent intent = getIntent();
        String username = intent.getExtras().getString("username", "Unknown");
        //set the username in the UI
        TextView usernameTextView = findViewById(R.id.viewTransactionsNameTextView);
        usernameTextView.setText(username);

        Button viewTransactionGoBackButton = findViewById(R.id.viewTransactionGoBackButton);
        viewTransactionGoBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goBack();
            }
        });



    }

    private void goBack() {
        Intent goBackToMainMenuIntent = new Intent();
        //pass a parameter I've called it "viewed" to check the chip in the GUI
        goBackToMainMenuIntent.putExtra("viewed", true);
        setResult(RESULT_OK, goBackToMainMenuIntent);

        finish();
    }
}