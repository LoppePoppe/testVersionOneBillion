package com.test2.testversiononebillion;

public class Player {

        private int playerNumber;
        private String name;

        public Player (String name, int playerNumber){
            this.playerNumber = (playerNumber+1);
            this.name = name;
        }

        public int getPlayerNumber(){
            return playerNumber;
        }

        public String getName(){
            return name;
        }

        @Override
        public String toString() {
            return String.format("%d. %s", playerNumber, name);
        }
    }
