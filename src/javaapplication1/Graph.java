/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.*;

/**
 *
 * @author paulo
 */
public class Graph {

	Graph(boolean[][] matrixBoolean, ArrayList<Node> nodeList) {

		int count = 0;	//Marcar qual Node está sendo verificando

		for (int i = 0; i < matrixBoolean.length; i++) {	//Percorre linhas da matriz
			for (int j = 0; j < matrixBoolean[i].length; j++) {	//Percorre colunas
				if (matrixBoolean[i][j] != false) {	//Caso a posição não seja uma parede
					System.out.println("\tADICIONANDO PONTEIROS PARA NODES DE [" + i + "][" + j + "]");
					for (int k = 0; k < 8; k++) {	    //Adiciona ponteiros para todos Nodes naquela posição
						addPointersToNode(nodeList, count);
						count++;
					}
				} else {
					System.out.println("NODE DE [" + i + "][" + j + "] É PAREDE");
				}
				System.out.println();
			}
		}

	}

	private void addPointersToNode(ArrayList<Node> nodeList, int count) {	//Esse método recebe um Node e adiciona em seus ponteiros outros Nodes
		Node auxNode = nodeList.get(count);
		int checkPointExist;
		System.out.println("Adicionando ponteiros ao " + auxNode.toString());
		switch (auxNode.dir) {
			case 0:		//Caso norte
				checkPointExist = searchInNodeList(nodeList, auxNode.posX - 1, auxNode.posY, 0);	//Verifica se tem para onde apontar
				if (checkPointExist != -1) {	//Verificar se não está na primeira linha da matriz e se tem para onde apontar
					auxNode.frenteNode = nodeList.get(checkPointExist);
					System.out.println("	frenteNode aponta para " + auxNode.frenteNode.toString());
				} else {
					auxNode.frenteNode = null;
					System.out.println("	Não foi adicionado frenteNode");
				}
				auxNode.sent_antiHorNode = nodeList.get(searchInNodeList(nodeList, auxNode.posX, auxNode.posY, 7));
				System.out.println("	sent_antiHorNode aponta para " + auxNode.sent_antiHorNode.toString());
				auxNode.sent_horNode = nodeList.get(searchInNodeList(nodeList, auxNode.posX, auxNode.posY, 1));
				System.out.println("	sent_horNode aponta para " + auxNode.sent_horNode.toString());
				break;
			case 1:		//Caso Nordeste
				checkPointExist = searchInNodeList(nodeList, auxNode.posX - 1, auxNode.posY + 1, 1);	//Verifica se tem para onde apontar
				if (checkPointExist != -1) {	//Verificar se não está na primeira linha da matriz 
					auxNode.frenteNode = nodeList.get(checkPointExist);
					System.out.println("	frenteNode aponta para " + auxNode.frenteNode.toString());
				} else {
					auxNode.frenteNode = null;
					System.out.println("	Não foi adicionado frenteNode");
				}
				auxNode.sent_antiHorNode = nodeList.get(searchInNodeList(nodeList, auxNode.posX, auxNode.posY, 0));
				System.out.println("	sent_antiHorNode aponta para " + auxNode.sent_antiHorNode.toString());
				auxNode.sent_horNode = nodeList.get(searchInNodeList(nodeList, auxNode.posX, auxNode.posY, 2));
				System.out.println("	sent_horNode aponta para " + auxNode.sent_horNode.toString());
				break;
			case 2:		//Caso Leste
				checkPointExist = searchInNodeList(nodeList, auxNode.posX, auxNode.posY + 1, 2); 	//Verifica se tem para onde apontar, e recebe index de qual apontar
				if (checkPointExist != -1) {	//Verificar se não está na primeira linha da matriz
					auxNode.frenteNode = nodeList.get(checkPointExist);
					System.out.println("	frenteNode aponta para " + auxNode.frenteNode.toString());
				} else {
					auxNode.frenteNode = null;
					System.out.println("	Não foi adicionado frenteNode");
				}
				auxNode.sent_antiHorNode = nodeList.get(searchInNodeList(nodeList, auxNode.posX, auxNode.posY, 1));
				System.out.println("	sent_antiHorNode aponta para " + auxNode.sent_antiHorNode.toString());
				auxNode.sent_horNode = nodeList.get(searchInNodeList(nodeList, auxNode.posX, auxNode.posY, 3));
				System.out.println("	sent_horNode aponta para " + auxNode.sent_horNode.toString());
				break;
			case 3:		//Caso Sudeste
				checkPointExist = searchInNodeList(nodeList, auxNode.posX + 1, auxNode.posY + 1, 3); 	//Verifica se tem para onde apontar, e recebe index de qual apontar
				if (checkPointExist != -1) {	//Verificar se não está na primeira linha da matriz
					auxNode.frenteNode = nodeList.get(checkPointExist);
					System.out.println("	frenteNode aponta para " + auxNode.frenteNode.toString());
				} else {
					auxNode.frenteNode = null;
					System.out.println("	Não foi adicionado frenteNode");
				}
				auxNode.sent_antiHorNode = nodeList.get(searchInNodeList(nodeList, auxNode.posX, auxNode.posY, 2));
				System.out.println("	sent_antiHorNode aponta para " + auxNode.sent_antiHorNode.toString());
				auxNode.sent_horNode = nodeList.get(searchInNodeList(nodeList, auxNode.posX, auxNode.posY, 4));
				System.out.println("	sent_horNode aponta para " + auxNode.sent_horNode.toString());
				break;
			case 4:		//Caso Sul
				checkPointExist = searchInNodeList(nodeList, auxNode.posX + 1, auxNode.posY, 4); 	//Verifica se tem para onde apontar, e recebe index de qual apontar
				if (checkPointExist != -1) {	//Verificar se não está na primeira linha da matriz
					auxNode.frenteNode = nodeList.get(checkPointExist);
					System.out.println("	frenteNode aponta para " + auxNode.frenteNode.toString());
				} else {
					auxNode.frenteNode = null;
					System.out.println("	Não foi adicionado frenteNode");
				}
				auxNode.sent_antiHorNode = nodeList.get(searchInNodeList(nodeList, auxNode.posX, auxNode.posY, 3));
				System.out.println("	sent_antiHorNode aponta para " + auxNode.sent_antiHorNode.toString());
				auxNode.sent_horNode = nodeList.get(searchInNodeList(nodeList, auxNode.posX, auxNode.posY, 5));
				System.out.println("	sent_horNode aponta para " + auxNode.sent_horNode.toString());
				break;
			case 5:		//Caso Sudoeste
				checkPointExist = searchInNodeList(nodeList, auxNode.posX + 1, auxNode.posY - 1, 5); 	//Verifica se tem para onde apontar, e recebe index de qual apontar
				if (checkPointExist != -1) {	//Verificar se não está na primeira linha da matriz
					auxNode.frenteNode = nodeList.get(checkPointExist);
					System.out.println("	frenteNode aponta para " + auxNode.frenteNode.toString());
				} else {
					auxNode.frenteNode = null;
					System.out.println("	Não foi adicionado frenteNode");
				}
				auxNode.sent_antiHorNode = nodeList.get(searchInNodeList(nodeList, auxNode.posX, auxNode.posY, 4));
				System.out.println("	sent_antiHorNode aponta para " + auxNode.sent_antiHorNode.toString());
				auxNode.sent_horNode = nodeList.get(searchInNodeList(nodeList, auxNode.posX, auxNode.posY, 6));
				System.out.println("	sent_horNode aponta para " + auxNode.sent_horNode.toString());
				break;
			case 6:		//Caso Oeste
				checkPointExist = searchInNodeList(nodeList, auxNode.posX, auxNode.posY - 1, 6); 	//Verifica se tem para onde apontar, e recebe index de qual apontar
				if (checkPointExist != -1) {	//Verificar se não está na primeira linha da matriz
					auxNode.frenteNode = nodeList.get(checkPointExist);
					System.out.println("	frenteNode aponta para " + auxNode.frenteNode.toString());
				} else {
					auxNode.frenteNode = null;
					System.out.println("	Não foi adicionado frenteNode");
				}
				auxNode.sent_antiHorNode = nodeList.get(searchInNodeList(nodeList, auxNode.posX, auxNode.posY, 5));
				System.out.println("	sent_antiHorNode aponta para " + auxNode.sent_antiHorNode.toString());
				auxNode.sent_horNode = nodeList.get(searchInNodeList(nodeList, auxNode.posX, auxNode.posY, 7));
				System.out.println("	sent_horNode aponta para " + auxNode.sent_horNode.toString());
				break;
			case 7:		//Caso Noroeste
				checkPointExist = searchInNodeList(nodeList, auxNode.posX - 1, auxNode.posY - 1, 7); 	//Verifica se tem para onde apontar
				if (checkPointExist != -1) {	//Verificar se não está na primeira linha da matriz
					auxNode.frenteNode = nodeList.get(checkPointExist);
					System.out.println("	frenteNode aponta para " + auxNode.frenteNode.toString());
				} else {
					auxNode.frenteNode = null;
					System.out.println("	Não foi adicionado frenteNode");
				}
				auxNode.sent_antiHorNode = nodeList.get(searchInNodeList(nodeList, auxNode.posX, auxNode.posY, 6));
				System.out.println("	sent_antiHorNode aponta para " + auxNode.sent_antiHorNode.toString());
				auxNode.sent_horNode = nodeList.get(searchInNodeList(nodeList, auxNode.posX, auxNode.posY, 0));
				System.out.println("	sent_horNode aponta para " + auxNode.sent_horNode.toString());
				break;
			default:
				System.out.println("Error");
		}
	}

	//Verifica se existe um Node específico com Posição X e Y, e direção específica
	//Se SIM, retorna index do Node ---- Se NÃO, retorna -1
	public int searchInNodeList(ArrayList<Node> nodeList, int line, int column, int dir) {
		for (int i = 0; i < nodeList.size(); i++) {
			if (nodeList.get(i).posX == line && nodeList.get(i).posY == column && nodeList.get(i).dir == dir) {
				return i;
			}
		}
		return -1;
	}

}
