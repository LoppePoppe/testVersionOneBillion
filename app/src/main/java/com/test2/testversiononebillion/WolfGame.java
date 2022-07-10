package com.test2.testversiononebillion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class WolfGame extends AppCompatActivity {

    private ArrayList<Player> players = new ArrayList<>();
    private TextView mTee1;
    private TextView mTee2;
    private TextView mTee3;
    private TextView mTee4;
    private TextView mHoleNr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wolf_game);

        Intent intent = getIntent();
        String p1 = intent.getStringExtra("mP1");
        String p2 = intent.getStringExtra("mP2");
        String p3 = intent.getStringExtra("mP3");
        String p4 = intent.getStringExtra("mP4");
        int nrOfHoles = intent.getIntExtra("numberOfHoles", 1);
        addPlayer(p1, p2, p3, p4);

        mTee1 = (TextView) findViewById(R.id.firstTee);
        mTee2 = (TextView) findViewById(R.id.secondTee);
        mTee3 = (TextView) findViewById(R.id.thirdTee);
        mTee4 = (TextView) findViewById(R.id.fourthTee);

        String nameP1 = p1;

        mTee1.setText(nameP1);
        mTee2.setText(players.get(1).getName());
        mTee3.setText(players.get(2).getName());
        mTee4.setText(players.get(3).getName());


        //gameLoop(nrOfHoles);
        //Byt till sista skärmen som visar final score




    }
    private void gameLoop(int numberOfHoles){
        mHoleNr = (TextView) findViewById(R.id.holeNumber);
        int currentHole = 1;

        do {
            mHoleNr.setText("Hål " + currentHole);
            //Vänta på input om lag
            //Vänta på input om vinst
            //Dela ut poäng
            //Justera scoreboard
            //Justera tee-ordning
            //currentHole++
        } while (currentHole <= numberOfHoles);

    }

    private void addPlayer(String p1, String p2, String p3, String p4){

        Player player1 = new Player(p1, players.size());
        Player player2 = new Player(p2, players.size());
        Player player3 = new Player(p3, players.size());
        Player player4 = new Player(p4, players.size());

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);


    }



}