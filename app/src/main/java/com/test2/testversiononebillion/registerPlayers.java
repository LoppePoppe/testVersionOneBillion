package com.test2.testversiononebillion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class registerPlayers extends AppCompatActivity {


    private TextView mNumbPlayers;
    private Button mPlayButton;
    private EditText mP1;
    private EditText mP2;
    private EditText mP3;
    private EditText mP4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_players);

        mNumbPlayers = (TextView) findViewById(R.id.textUppe);
        mPlayButton = (Button) findViewById(R.id.buttonPlay);
        mP1 = (EditText) findViewById(R.id.p1Name);
        mP2 = (EditText) findViewById(R.id.p2Name);
        mP3 = (EditText) findViewById(R.id.p3Name);
        mP4 = (EditText) findViewById(R.id.p4Name);

        // Hämta värdena som skickades med och ändra texten
        Intent intent = getIntent();
        String noOfPlayers = intent.getStringExtra("players");
        String numberOfHoles = intent.getStringExtra("holes");
        Boolean wolfOn = intent.getBooleanExtra("wolfOn", false);
        Boolean creditOn = intent.getBooleanExtra("creditOn", false);

        // Test för att se om den läser input
        mNumbPlayers.setText("Här är dina värden: " + noOfPlayers + " Players on " + numberOfHoles + " holes, wolf is turned " + isOn(wolfOn) + " and credits is turned " + isOn(creditOn));

        mPlayButton = (Button) findViewById(R.id.buttonPlay);
        mPlayButton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View playButton){

            String player1 = mP1.getText().toString();
            String player2 = mP2.getText().toString();
            String player3 = mP3.getText().toString();
            String player4 = mP4.getText().toString();

            // Test för att se om den läser input
            Toast.makeText(registerPlayers.this, "spelare " + player1 + player2 + player3 + player4, Toast.LENGTH_SHORT).show();

            Intent startWolf = new Intent(registerPlayers.this, WolfGame.class);
            startWolf.putExtra("p1", player1);
            startWolf.putExtra("p2", player2);
            startWolf.putExtra("p3", player3);
            startWolf.putExtra("p4", player4);
            startWolf.putExtra("numberOfHoles", numberOfHoles);
            startActivity(startWolf);}
        });
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