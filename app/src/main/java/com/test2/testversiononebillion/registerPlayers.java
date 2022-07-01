package com.test2.testversiononebillion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class registerPlayers extends AppCompatActivity {

private TextView mNumbPlayers;
private Button mPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_players);

        mNumbPlayers = (TextView) findViewById(R.id.textUppe);
        mPlayButton = (Button) findViewById(R.id.buttonPlay);

        // Hämta värdena som skickades med och ändra texten
        Intent intent = getIntent();
        String players = intent.getStringExtra("players");
        String holes = intent.getStringExtra("holes");
        Boolean wolfOn = intent.getBooleanExtra("wolfOn", false);
        Boolean creditOn = intent.getBooleanExtra("creditOn", false);

        mNumbPlayers.setText("Här är dina värden: " + players + " Players on " + holes + " holes, wolf is turned " + isOn(wolfOn) + " and credits is turned " + isOn(creditOn));
    }

    private String isOn(Boolean wolfOn) {
        String booleanValue;

        if (wolfOn){
            booleanValue = "on";
            return booleanValue;
        } else {
            booleanValue = "off";
            return booleanValue;
        }
    }


}