package com.company;

import java.util.ArrayList;
import java.util.*;
/**
 * Created by raz on 3/23/15.
 */



public class Gameboard {


    public class Ship {
        public String name;
        public String acronym;
        public int health;

        public Ship(String name, String acronym, int health){
            this.name = name;
            this.health = health;
            this.acronym = acronym;
        }

    }



    String grid[][];
    ArrayList<Ship> ships;



    public Gameboard(){

        // add ships
        ships = new ArrayList<Ship>();
        ships.add(new Ship("Aircraft Carrier", "A1", 5));
        ships.add(new Ship("Battleship","B2", 4));
        ships.add(new Ship("Sub","S3", 3));
        ships.add(new Ship("Destroyer", "D4", 3));
        ships.add(new Ship("Destroyer", "D5", 3));
        ships.add(new Ship("PT Boat", "P6", 2));
        ships.add(new Ship("PT Boat", "P7", 2));




        grid  = new String[10][10];
        // first initialize game board to be empty
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                grid[i][j] = "o";
            }
        }

        // now add ships to the board
        System.out.println("Adding ships to board");
        Random rand = new Random();
        for (Ship ship: ships){
            addShip(ship.acronym, ship.health, rand);
        }
    }

    public void displayBoard(){
        String[] rows = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        System.out.print("     ");
        for (int i = 0; i < 10; i++){
            System.out.printf("%3s  ", i + 1);
        }
        System.out.println();

        for (int i = 0; i < 10; i++){
            System.out.printf("%3s  ", rows[i]);
            for (int j = 0; j < 10; j++){
                System.out.printf("%3s  ", grid[i][j]);
            }
            System.out.println();
        }

    }

    public void addShip(String name, int size, Random rand) {
        boolean positionGood = false;
        String orientation   = "";
        int column= 0;
        int row = 0;
        while (!positionGood) {
            row = rand.nextInt(10);
            column = rand.nextInt(10);
            orientation = "horizontal";
            if (rand.nextInt(10) < 5) {
                orientation = "vertical";
            }
            positionGood = checkPosition(row, column, orientation, size);
        }
        if (orientation.equals("horizontal")){
            for (int  i =  column; i < column + size; i++){
                grid[row][i] = name;
            }
        }
        else{
            for (int  i =  row; i < row + size; i++){
                grid[i][column] = name;
            }


        }
    }

    public boolean checkPosition(int row, int column, String direction, int size){
        if (direction.equals("vertical")){
            if (row + size < 10){
                for (int i = row; i < row + size; i++){
                    if (!(grid[i][column].equals("o"))){
                        return false;
                    }

                }
                return true;
            }
            else {
                return false;
            }
        }
        else{
            if (column + size < 10){
                for (int i = column; i < column + size; i++){
                    if (!(grid[row][i].equals("o"))) {
                        return false;
                    }
                }
                return true;
            }
            else{
                return false;
            }
        }

    }


    public boolean isWin(){
        // should return true if the person won
        // the game; false otherwise
        return false;
    }

    public void drawPlayerBoard(){

        // This will be based on the displayBoard method above
        // it should hid the location of ships
        // and show misses and hits
    }

    public void move(){
        /* This procedure should process one move of the game.
        1) it should display the board
        2) it should get input from the user (the move) in the form like B5
        3) it should determine if there is a hit or miss (and print out 'HIT' or 'MISS'
        4) it should update the grid
        5) if necessary, it should update the ships arraylist
        6) if a ship has been sunk it should report that

        */

    }

    public void play(){
        // while not a win play the game
    }

}
