package com.test2.testVersionOneBillion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
public class WolfGame extends AppCompatActivity {

    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Player> scoreBoard = new ArrayList<>();
    private TextView mHoleNr;
    private Button mWolfWin;
    private Button mChallengerWin;
    private Button mTie;
    int currentHole = 1;



    // Va som händer när sidan layoten laddas
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wolf_game);

        // Hämta data från tidigare layout
        Intent registeredPlayers = getIntent();
        String p1 = registeredPlayers.getStringExtra("p1");
        String p2 = registeredPlayers.getStringExtra("p2");
        String p3 = registeredPlayers.getStringExtra("p3");
        String p4 = registeredPlayers.getStringExtra("p4");
        int nrOfHoles = registeredPlayers.getIntExtra("numberOfHoles", 18);


        // Lägg till spelarna
        addPlayer(p1, p2, p3, p4);

        // Test för att se om den läser input
        //Toast.makeText(WolfGame.this, "Player #: " + players.get(0).getPlayerNumber() + "Name: " + players.get(0).getName() + " Score: " + players.get(0).getScore(), Toast.LENGTH_SHORT).show();

        // Sätt hålnummer
        mHoleNr = (TextView) findViewById(R.id.holeNumber);
        mHoleNr.setText("Hål " + (Integer.toString(currentHole)));

        // Visa tee ordning HÄR ÄR PROBLEMET JUST NU
        setTeeOrder();


        // Knapp för om WOLF vinner
        mWolfWin = (Button) findViewById(R.id.buttonWinWolf);
        mWolfWin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View buttonWolfWin){
                // Dela ut poäng
                givePoints();

                // Uppdatera scoreboard
                    // mPosX.setText(getName.ScoreBoard.(X)

                // Justera teeordning
                    // mTeeX.setText(getName.teeOrder.(0)

                // Kolla om det är slut
                checkHole(currentHole, nrOfHoles);
            }});

        // Knapp för om OTHER laget vinner
        mChallengerWin = (Button) findViewById(R.id.tie);
        mChallengerWin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View buttonChallengerWin){
                currentHole++;
                mHoleNr.setText("Hål " + (Integer.toString(currentHole)));
            }});

        // Knapp om det blir LIKA
        mTie = (Button) findViewById(R.id.buttonChallenger);
        mTie.setOnClickListener(new View.OnClickListener(){
            public void onClick(View buttonTie){
                Toast.makeText(WolfGame.this, "Player #: " + players.get(0).getPlayerNumber() + "Name: " + players.get(0).getName() + " Score: " + players.get(0).getScore(), Toast.LENGTH_SHORT).show();
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

    private void setTeeOrder(){
        TextView mTee1 = (TextView) findViewById(R.id.firstTee);
        TextView mTee2 = (TextView) findViewById(R.id.secondTee);
        TextView mTee3 = (TextView) findViewById(R.id.thirdTee);
        TextView mTee4 = (TextView) findViewById(R.id.fourthTee);

        if (currentHole <= 1){
            //randomiseTeeOrder();

            ArrayList <Integer> numbers = new ArrayList<>();
            Random random = new Random();

            for (int i = 0; i<= players.size(); i++){numbers.add(i);}

            int p1 = random.nextInt(4);
            for (Integer number:numbers){if (p1 == numbers.get(number)) {numbers.remove(number);}}
            int p2 = random.nextInt(3);
            for (Integer number:numbers){if (p2 == numbers.get(number)) {numbers.remove(number);}}
            int p3 = random.nextInt(2);
            for (Integer number:numbers){if (p3 == numbers.get(number)) {numbers.remove(number);}}
            int p4 = random.nextInt(1);
            for (Integer number:numbers){if (p4 == numbers.get(number)) {numbers.remove(number);}}

            mTee1.setText(players.get(p1).getName());
            mTee2.setText(players.get(p2).getName());
            mTee3.setText(players.get(p3).getName());
            mTee4.setText(players.get(p4).getName());
        }else {
            mTee1.setText(players.get(0).getName());
            mTee2.setText(players.get(1).getName());
            mTee3.setText(players.get(2).getName());
            mTee4.setText(players.get(3).getName());
        }
    }

    private void randomiseTeeOrder(){
        ArrayList <Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i<= players.size(); i++){numbers.add(i);}

        int p1 = random.nextInt(4);
        numbers.remove(p1);
        int p2 = random.nextInt(3);
        numbers.remove(p2);
        int p3 = random.nextInt(2);
        numbers.remove(p3);
        int p4 = random.nextInt(1);
        numbers.remove(p4);


    }

    private void checkHole(int current, int totalHoles){
        //Toast.makeText(WolfGame.this, currentHole + totalHoles, Toast.LENGTH_SHORT).show();
        if (current < totalHoles){
            currentHole++;
            mHoleNr.setText("Hål " + (Integer.toString(currentHole)));
        }else {
            // Vad händer när spelet är slut?
            Intent finalScore = new Intent(WolfGame.this, EndScreen.class);
            startActivity(finalScore);
        }
    }

    private void givePoints(){
        int pointsToGive = 1;
        players.get(0).setScore(pointsToGive);
    }





}