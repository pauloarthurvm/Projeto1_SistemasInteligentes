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

    boolean[][] matrixBoolean;
    public static ArrayList<Node> nodeList;

    public EnvironmentFromTextNode() throws FileNotFoundException, IOException {
        //String txtLine;
	int lines, columns;
	
        //Abre arquivo de texto
        File file = new File("Env.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        //Lê primeira linha do arquivo - numero de linhas
        lines = Integer.parseInt(br.readLine());
        System.out.println("Lines: " + lines);

        //Lê segunda linha do arquivo - numero de colunas
        columns = Integer.parseInt(br.readLine());
        System.out.println("Columns: " + columns);
	
	//Cria matriz booleana para identificar espaço livre e List de Nodes
	matrixBoolean = new boolean[lines][columns];
	nodeList = new ArrayList<>();
	
        //Percorre linhas do arquivo de texto
        String lineFromTxt;
        for (int i = 0; i < 10; i++) {
            lineFromTxt = br.readLine();    //Lê uma linha inteira
            System.out.println(lineFromTxt);

            //Cria cada Node da matriz, lendo cada Char do arquivo
            for (int j = 0; j < 10; j++) {
                System.out.print(String.valueOf(lineFromTxt.charAt(j)));
                if(!String.valueOf(lineFromTxt.charAt(j)).equals("*")){	//Caso a posição não seja uma parede
		    for(int k = 0; k < 8; k++){
			matrixBoolean[i][j] = true;
			nodeList.add(new Node(i, j, k));
		    }
		} 
		else{	//Caso a posição seja uma parede
		    matrixBoolean[i][j] = false;
		}
            }
            System.out.println();
        }
        
        br.close(); //Fecha arquivo de texto
    }
    
    
    
    
    public void printEnvironment(){
	int count = 0;  //Contador para percorrer lista de Node
	
        for(int i = 0; i < matrixBoolean.length; i++){	//Percorre linhas da matriz
            for(int j = 0; j < matrixBoolean[i].length; j++){	//Percorre colunas
		System.out.println("Line = " + (i+1) + "    Column = " + (j + 1));
		if(matrixBoolean[i][j] != false){	//Caso a posição não seja uma parede
		    for(int k = 0; k < 8; k++){	    //Imprime todos os Nodes daquela posição
			Node auxNode = nodeList.get(count);
			System.out.print("X: " + (auxNode.posX + 1) + " " + "Y: " + (auxNode.posY + 1) + " Dir: " + auxNode.dir + " ---- ");
			count++;
		    }
		    System.out.println("");
		} else{
		    System.out.println("PAREDE");
		}
            }
            System.out.println();
        }
    }
}