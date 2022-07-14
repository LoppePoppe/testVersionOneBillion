package com.test2.testVersionOneBillion;

public class Player {

        private int playerNumber;
        private String name;
        private int score;

        public Player (String name, int playerNumber){
            this.playerNumber = (playerNumber+1);
            this.name = name;
            this.score = 0;
        }

        public int getPlayerNumber(){
            return playerNumber;
        }

        public String getName(){
            return name;
        }

        public int getScore(){
            return score;
        }

        public void setScore(int scoreToAdd){
            score = this.score + scoreToAdd;
        }

        @Override
        public String toString() {
            return String.format(name + playerNumber + score);
        }
    }
