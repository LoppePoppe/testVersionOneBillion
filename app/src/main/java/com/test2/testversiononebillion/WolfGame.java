package com.test2.testversiononebillion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WolfGame extends AppCompatActivity {

    private ArrayList<Player> players = new ArrayList<>();
    private TextView mTee1;
    private TextView mTee2;
    private TextView mTee3;
    private TextView mTee4;
    private TextView mHoleNr;
    private Button mWolfWin;
    private Button mChallengerWin;
    private Button mTie;
    int currentHole = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wolf_game);

        Intent registeredPlayers = getIntent();
        String p1 = registeredPlayers.getStringExtra("p1");
        String p2 = registeredPlayers.getStringExtra("p2");
        String p3 = registeredPlayers.getStringExtra("p3");
        String p4 = registeredPlayers.getStringExtra("p4");
        int nrOfHoles = registeredPlayers.getIntExtra("numberOfHoles", 5);

        addPlayer(p1, p2, p3, p4);
        Toast.makeText(WolfGame.this, "WolfGame " + p1 + p2 + p3 + p4 + nrOfHoles, Toast.LENGTH_SHORT).show();

        mHoleNr = (TextView) findViewById(R.id.holeNumber);

        mHoleNr.setText("Hål " + (Integer.toString(currentHole)));

        mTee1 = (TextView) findViewById(R.id.firstTee);
        mTee2 = (TextView) findViewById(R.id.secondTee);
        mTee3 = (TextView) findViewById(R.id.thirdTee);
        mTee4 = (TextView) findViewById(R.id.fourthTee);

        mTee1.setText("" + p1);
        mTee2.setText("" + p2);
        mTee3.setText("" + p3);
        mTee4.setText("" + p4);

        // Knapp för om Wolf vinner
        mWolfWin = (Button) findViewById(R.id.buttonWinWolf);
        mWolfWin.setOnClickListener(new View.OnClickListener(){

            public void onClick(View buttonWolfWin){
                // Dela ut poäng
                // Uppdatera scoreboard
                // Justera teeordning

                if (currentHole < nrOfHoles){
                    currentHole++;
                    mHoleNr.setText("Hål " + (Integer.toString(currentHole)));
                }else{Toast.makeText(WolfGame.this, "Nu är det slut", Toast.LENGTH_SHORT).show();}
        }});

        // Knapp för om Other laget vinner
        mChallengerWin = (Button) findViewById(R.id.tie);
        mChallengerWin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View buttonChallengerWin){
                currentHole++;
                mHoleNr.setText("Hål " + (Integer.toString(currentHole)));
            }});

        // Knapp om det blir lika
        mTie = (Button) findViewById(R.id.buttonChallenger);
        mTie.setOnClickListener(new View.OnClickListener(){
            public void onClick(View buttonTie){
                currentHole++;
                mHoleNr.setText("Hål " + (Integer.toString(currentHole)));
            }});
         };

    private void addPlayer(String p1, String p2, String p3, String p4){
        Player player1 = new Player(p1, players.size());
        players.add(player1);
        Player player2 = new Player(p2, players.size());
        players.add(player2);
        Player player3 = new Player(p3, players.size());
        players.add(player3);
        Player player4 = new Player(p4, players.size());
        players.add(player4);
    }




}