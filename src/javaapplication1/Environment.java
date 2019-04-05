/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.EnumSet;
import static javaapplication1.JavaApplication1.input;

/**
 *
 * @author paulo
 */
public class Environment {
    

    private final int matrice[][];
    private final String spaceMatrice[][];

    public Environment(int lines, int columns) {
        matrice = new int[lines][columns];
        spaceMatrice = new String[lines][columns];
        if (spaceMatrice[0][0] == null){
            System.out.println("null matrice");
        }
        printEnvironment();
        insertWalls();
        printEnvironment();
        insertPlayer();
        printEnvironment();
    }
    
    public void printEnvironment() {
        System.out.print(" ");
        for (int i = 0; i < matrice[0].length; i++) {   //Print the column number
            System.out.print("  " + i + "  ");
        }
        System.out.println("");
        System.out.print(" ");
        for (int i = 0; i < matrice[0].length; i++) {   //Print superior limit
            System.out.print("+---+");
        }
        for (int i = 0; i < matrice.length; i++) {
            System.out.println("");
            System.out.print(i);    //Print the line number
            for (int j = 0; j < matrice[i].length; j++) {   //Put the space - free or wall
                if(spaceMatrice[i][j] == "WALL"){
                    System.out.print("|XXX|");
                }else if(spaceMatrice[i][j] == "PLAYER"){
                    System.out.print("  N  ");
                }else{
                    System.out.print("|   |");
                }
            }
            System.out.println();

            if (i != (matrice.length - 1)) {
            System.out.print(" ");
                for (int j = 0; j < (matrice[i].length); j++) { //Print limit between limit
                    System.out.print("|---|");
                }
            }
        }
        System.out.print(" ");
        for (int j = 0; j < matrice[0].length; j++) {   //Print bottom limit
            System.out.print("+---+");
        }
        System.out.println();
    }

    private void insertWalls() {
        System.out.println("Insert the walls:");
        System.out.println("\tPut LINE and COLUMN of the wall");
        System.out.println("\tTo finish, insert 'f'");
        System.out.println("");
        String addMore = "";
        while(!addMore.contains("n")){
            System.out.print("Line: ");
            int lineWall = input.nextInt();
            System.out.print("Column: ");
            int columnWall = input.nextInt();
            spaceMatrice[lineWall][columnWall] = "WALL";
            System.out.print("Add more? [y/n] ");
            addMore = input.next();
            System.out.println("addMore: " + addMore);
        }
    }

    private void insertPlayer() {
        System.out.println("Insert player position:");
        System.out.print("\tLine: ");
        int playerLine = input.nextInt();
        System.out.print("\tColumn: ");
        int playerColumn = input.nextInt();
        spaceMatrice[playerLine][playerColumn] = "PLAYER";
    }

}
