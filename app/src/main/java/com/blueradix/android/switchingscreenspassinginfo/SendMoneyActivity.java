package com.blueradix.android.switchingscreenspassinginfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class SendMoneyActivity extends AppCompatActivity {

    private TextInputEditText sendMoneyReceiverNameTextInputEditText;
    TextInputEditText sendMoneyAmountTextInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);

        sendMoneyReceiverNameTextInputEditText = findViewById(R.id.sendMoneyReceiverNameTextInputEditText);
        sendMoneyAmountTextInputEditText = findViewById(R.id.sendMoneyAmountTextInputEditText);

        Button sendMoneyCancelButton = findViewById(R.id.sendMoneyCancelButton);
        Button sendMoneySendButton = findViewById(R.id.sendMoneySendButton);

        sendMoneyCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });

        sendMoneySendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMoney();
            }
        });


    }

    private void cancel() {
        Intent goBackToMainMenuIntent = new Intent();
        setResult(RESULT_OK, goBackToMainMenuIntent);

        finish();
    }

    private void sendMoney() {
        Intent goBackToMainMenuIntent = new Intent();
        goBackToMainMenuIntent.putExtra("recipient", sendMoneyReceiverNameTextInputEditText.getText().toString());
        goBackToMainMenuIntent.putExtra("amount", sendMoneyAmountTextInputEditText.getText().toString());
        goBackToMainMenuIntent.putExtra("viewed", true);
        setResult(RESULT_OK, goBackToMainMenuIntent);

        finish();
    }
}