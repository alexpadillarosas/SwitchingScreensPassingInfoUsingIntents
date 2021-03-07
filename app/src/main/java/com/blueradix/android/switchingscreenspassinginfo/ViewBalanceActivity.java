package com.blueradix.android.switchingscreenspassinginfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewBalanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_balance);

        Button viewBalanceOkButton = findViewById(R.id.viewBalanceOkButton);
        viewBalanceOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }

    private void goBack() {
        Intent goBackToMainMenuIntent = new Intent();
        goBackToMainMenuIntent.putExtra("viewed", true);
        setResult(RESULT_OK, goBackToMainMenuIntent);

        finish();
    }
}