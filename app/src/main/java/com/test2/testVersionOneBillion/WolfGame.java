package com.test2.testVersionOneBillion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
public class WolfGame extends AppCompatActivity {

    private ArrayList<Player> playersOrder = new ArrayList<>();
    private ArrayList<Player> scoreBoard = new ArrayList<>(playersOrder);
    //private ArrayList <Player> playerOrder = new ArrayList<>();
    private TextView mHoleNr;
    private Button mWolfWin;
    private Button mChallengerWin;
    private Button mTie;
    int currentHole = 1;

    // Va som händer när layoten laddas
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

        setTeeOrder();
        updateScoreboard();


        // Knapp för om WOLF vinner
        mWolfWin = (Button) findViewById(R.id.buttonWinWolf);
        mWolfWin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View buttonWolfWin){
                // Dela ut poäng
                givePoints();
                // Uppdatera scoreboard
                updateScoreboard();
                    // mPosX.setText(getName.ScoreBoard.(X)
                // Kolla om det är slut
                checkHole(currentHole, nrOfHoles);
                // Justera Tee-ordning
                setTeeOrder();
            }});

        // Knapp för om OTHER laget vinner
        mChallengerWin = (Button) findViewById(R.id.tie);
        mChallengerWin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View buttonChallengerWin){
                scoreBoard.get(1).setScore(1);
                currentHole++;
                mHoleNr.setText("Hål " + (Integer.toString(currentHole)));
            }});

        // Knapp om det blir LIKA
        mTie = (Button) findViewById(R.id.buttonChallenger);
        mTie.setOnClickListener(new View.OnClickListener(){
            public void onClick(View buttonTie){
                Toast.makeText(WolfGame.this, "Player #: " + playersOrder.get(0).getPlayerNumber() + "Name: " + playersOrder.get(0).getName() + " Score: " + playersOrder.get(0).getScore(), Toast.LENGTH_SHORT).show();
                currentHole++;
                mHoleNr.setText("Hål " + (Integer.toString(currentHole)));
            }});
         };

    private void addPlayer(String p1, String p2, String p3, String p4){
        Player player1 = new Player(p1, playersOrder.size());
        playersOrder.add(player1);
        Player player2 = new Player(p2, playersOrder.size());
        playersOrder.add(player2);
        Player player3 = new Player(p3, playersOrder.size());
        playersOrder.add(player3);
        Player player4 = new Player(p4, playersOrder.size());
        playersOrder.add(player4);
    }

    private void setTeeOrder(){
        TextView mTee1 = (TextView) findViewById(R.id.firstTee);
        TextView mTee2 = (TextView) findViewById(R.id.secondTee);
        TextView mTee3 = (TextView) findViewById(R.id.thirdTee);
        TextView mTee4 = (TextView) findViewById(R.id.fourthTee);

        if (currentHole <= 1){
            // Blandar listan om det är hål 1
            Collections.shuffle(playersOrder);
        }else {
            Collections.rotate(playersOrder, -1);
        }
            mTee1.setText(playersOrder.get(0).getName());
            mTee2.setText(playersOrder.get(1).getName());
            mTee3.setText(playersOrder.get(2).getName());
            mTee4.setText(playersOrder.get(3).getName());
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
        scoreBoard.get(0).setScore(pointsToGive);
    }

    private void updateScoreboard(){

            //scoreBoard = players;
            TextView mPos1 = (TextView) findViewById(R.id.firstPlaceName);
            TextView mPos2 = (TextView) findViewById(R.id.secondPlaceName);
            TextView mPos3 = (TextView) findViewById(R.id.thirdPlaceName);
            TextView mPos4 = (TextView) findViewById(R.id.fourthPlaceName);
            //sortScoreboard();
            mPos1.setText(scoreBoard.get(0).getName());
            mPos2.setText(scoreBoard.get(1).getName());
            mPos3.setText(scoreBoard.get(2).getName());
            mPos4.setText(scoreBoard.get(3).getName());



    }

    private void sortScoreboard() { // insertionSort

        for (int i = 0; i < scoreBoard.size(); i++) { // vanlg foor-loop
            Player key = scoreBoard.get(i); // Värdet som ska jämföras
            int j = i - 1; // sätter j till postionen innan i

            // så länge j är större än 0 och key är mindre än j
            while (j >= 0 && key.getScore() <= scoreBoard.get(j).getScore()) {

                // kolla om svanslängden är lika
                if (key.getScore() == scoreBoard.get(j).getScore()) {

                    if (key.getName().compareTo(scoreBoard.get(j).getName()) < 0) { // jämför score
                        scoreBoard.set(j + 1, scoreBoard.get(j)); // sätt platsen efter index j till värdet från index j
                        j--; // gå ett steg åt vänster sen tillbaka till while()
                    } else {
                        break; // hanterar oändlig loop
                    }

                } else { // om score inte är lika
                    scoreBoard.set(j + 1, scoreBoard.get(j)); // Flytta värdet i j ett steg fram
                    j--; // återställ j
                }
            }
            scoreBoard.set(j + 1, key); // sätt värdet från key på platsen efter j
        }

    }







}