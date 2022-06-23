package com.test2.testversiononebillion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button mTestKnapp;
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

    mTestKnapp = (Button) findViewById(R.id.buttonStart);
        mTestKnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vad händer när man klickar på knappen?
                String players = mNumbPlayers.getText().toString();
                String holes = mNumbHoles.getText().toString();
                Boolean wolfOn = mSwitchWolf.isChecked();
                Boolean creditOn = mSwitchCredit.isChecked();

                // Hur man skriver en pop up
                Toast.makeText(MainActivity.this, "Du klickade på knappen och skickade med " + players + " " + holes, Toast.LENGTH_SHORT).show();

                // Byt till ny sida
                Intent intent = new Intent(MainActivity.this, registerPlayers.class);
                intent.putExtra("players", players);
                intent.putExtra("holes", holes);
                intent.putExtra("wolfOn", wolfOn);
                intent.putExtra("creditOn", creditOn);
                startActivity(intent);


            }
        });
    }




}