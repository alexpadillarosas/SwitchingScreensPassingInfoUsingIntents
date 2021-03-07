package com.blueradix.android.switchingscreenspassinginfo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Intent activityThatCalled = getIntent();

        String username = activityThatCalled.getExtras().getString("username", "Unknown");
        TextView userTextView = findViewById(R.id.userTextView);
        userTextView.setText(username);

        Button viewTransactionsButton = findViewById(R.id.viewTransactionsButton);
        viewTransactionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToTransactionsActivityIntent = new Intent(MenuActivity.this, ViewTransactionsActivity.class);
                //pass the username to display it in the View Transactions Activity
                goToTransactionsActivityIntent.putExtra("username", username);
                //startActivityForResult : we will wait for a result to be returned in the method onActivityResult
                //if you don't wait for any response then use: startActivity instead
                startActivityForResult(goToTransactionsActivityIntent, Constants.VIEW_TRANSACTIONS_ACTIVITY);
            }
        });

        Button sendMoneyButton = findViewById(R.id.sendMoneyButton);
        sendMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSendMoneyIntent = new Intent(MenuActivity.this, SendMoneyActivity.class);

                startActivityForResult(goToSendMoneyIntent, Constants.SEND_MONEY_ACTIVITY);
            }
        });

        Button viewBalanceButton = findViewById(R.id.viewBalanceButton);
        viewBalanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToViewBalanceIntent = new Intent(MenuActivity.this, ViewBalanceActivity.class);
                goToViewBalanceIntent.putExtra("username", username);
                startActivityForResult(goToViewBalanceIntent, Constants.VIEW_BALANCE_ACTIVITY);

            }
        });

        Button menuActivityLogoutButton = findViewById(R.id.menuActivityLogoutButton);
        menuActivityLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBackToMainActivityIntent = new Intent();
                setResult(RESULT_OK, goBackToMainActivityIntent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Constants.VIEW_TRANSACTIONS_ACTIVITY){
            if(resultCode == RESULT_OK){
                //get the result back
                boolean viewed = data.getBooleanExtra("viewed", false);
                //find the chip
                Chip viewTransactionsChip = findViewById(R.id.viewTransactionsChip);
                //set the chip as checked
                viewTransactionsChip.setChecked(viewed);
            }else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, "maybe you forgot to set the data back, check your child setResult() ", Toast.LENGTH_SHORT).show();
            }
        }else if(requestCode == Constants.SEND_MONEY_ACTIVITY) {
            if(resultCode == RESULT_OK){
                //get the result back
                boolean viewed = data.getBooleanExtra("viewed", false);
                //Do with these 2 values whatever you want:
                String name = data.getStringExtra("recipient");
                String amount = data.getStringExtra("amount");
                //find the chip
                Chip sendMoneyChip = findViewById(R.id.sendMoneyChip);
                //set the chip as checked
                sendMoneyChip.setChecked(viewed);

            }else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, "maybe you forgot to set the data back, check your child setResult() ", Toast.LENGTH_SHORT).show();
            }
        }else if(requestCode == Constants.VIEW_BALANCE_ACTIVITY) {
            if(resultCode == RESULT_OK){
                //get the result back, if the property "viewed" was not previously set, return false
                boolean viewed = data.getBooleanExtra("viewed", false);
                //find the chip
                Chip viewBalanceChip = findViewById(R.id.viewBalanceChip);
                //set the chip as checked
                viewBalanceChip.setChecked(viewed);

            }else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, "maybe you forgot to set the data back, check your child setResult() ", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "wrong request code come back? requestCode: " + requestCode, Toast.LENGTH_SHORT).show();
        }
    }
}