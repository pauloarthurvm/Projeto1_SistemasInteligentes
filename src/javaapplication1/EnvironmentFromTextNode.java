/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author paulo
 */
public class EnvironmentFromTextNode {

    String txtLine;
    int lines, columns;
    Node[][] matriceNode;

    public EnvironmentFromTextNode() throws FileNotFoundException, IOException {
        
        //Open text file
        File file = new File("Env.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        //Read file's first line - lines
        lines = Integer.parseInt(br.readLine());
        System.out.println("Lines: " + lines);

        //Read file's second line - columns
        columns = Integer.parseInt(br.readLine());
        System.out.println("Columns: " + columns);

        //Create the matrice of nodes
        matriceNode = new Node[lines][columns];

        //Read rest of lines of the file
        String lineFromTxt;
        for (int i = 0; i < 10; i++) {
            lineFromTxt = br.readLine();
            System.out.println(lineFromTxt);

            //Create each node of the matrice, reading each char of the line
            for (int j = 0; j < 10; j++) {
                System.out.print(String.valueOf(lineFromTxt.charAt(j)));
                //matriceNode[i][j] = new Node(String.valueOf(lineFromTxt.charAt(j)));
                if(String.valueOf(lineFromTxt.charAt(j)).equals(".")){
		    for(int k = 0; k < 8; k++){
			matriceNode[i][j] = new Node(i, j, k);
		    }
		} 
		else{
		    matriceNode[i][j] = null;
		}
            }
            System.out.println();
        }
        
        br.close();
    }
 
    public void printEnvironment(){
        for(int i = 0; i < matriceNode.length; i++){
            for(int j = 0; j < matriceNode[i].length; j++){
		if(matriceNode[i][j] != null){
		    for(int k = 0; k < 8; k++){
			if(matriceNode[i][j] != null)
			System.out.print(matriceNode[i][j].posX + " " + matriceNode[i][j].posY + "   dir: " + matriceNode[i][j].dir + " ");
		    }
		    System.out.println("");
		}
            }
            System.out.println();
        }
    }
}