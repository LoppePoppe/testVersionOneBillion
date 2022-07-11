package com.test2.testversiononebillion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mStartKnapp;
    private EditText mNumbPlayers;
    private EditText mNumbHoles;
    private Switch mSwitchWolf;
    private Switch mSwitchCredit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumbPlayers = (EditText) findViewById(R.id.numbPlayers);
        mNumbHoles = (EditText) findViewById(R.id.editTextNumber);
        mSwitchWolf = (Switch) findViewById(R.id.switchWolf);
        mSwitchCredit = (Switch) findViewById(R.id.switchCredit);


    mStartKnapp = (Button) findViewById(R.id.buttonStart); // Koppla variabeln till knappen (tror jag)
    mStartKnapp.setOnClickListener(new View.OnClickListener() { // Säg åt knappen att lyssna efter att någon trycker?

            @Override
            public void onClick(View v) {
                // Vad händer när man klickar på knappen?
                String players = mNumbPlayers.getText().toString();
                String numberOfHoles = mNumbHoles.getText().toString();
                Boolean wolfOn = mSwitchWolf.isChecked();
                Boolean creditOn = mSwitchCredit.isChecked();

                // Hur man skriver en pop up
                // Toast.makeText(MainActivity.this, "Du klickade på knappen och skickade med " + players + " " + holes, Toast.LENGTH_SHORT).show();

                // Byt till ny sida
                Intent intent = new Intent(MainActivity.this, registerPlayers.class);
                intent.putExtra("players", players);
                intent.putExtra("holes", numberOfHoles);
                intent.putExtra("wolfOn", wolfOn);
                intent.putExtra("creditOn", creditOn);
                startActivity(intent);


            }
        });
    }




}