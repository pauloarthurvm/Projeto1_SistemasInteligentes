/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author paulo
 */
public class JavaApplication1 {

	/**
	 * @param args the command line arguments
	 */
	static Scanner input;
	private static EnvironmentFromTextNode environmentFromText;
	private static Graph graph;

	public static void main(String[] args) throws IOException {
        // TODO code application logic here

		//Create the environment from the text file
		environmentFromText = new EnvironmentFromTextNode();

		//Show the map from environment
		//environmentFromText.printEnvironment();
		//environmentFromText.printNodeList();


        //Cria grafo com o ArrayList de Nodes e a matriz booleana, inserindo os ponteiros de cada Node --- frente, horário e anti-horário
		graph = new Graph(environmentFromText.matrixBoolean, environmentFromText.nodeList);
		System.out.println("");
		
		environmentFromText.printNodeList();
	}

}
