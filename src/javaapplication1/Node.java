/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author paulo
 */
public class Node {

	boolean visitado;
	int posX, posY, dir;

	Node sent_antiHorNode, sent_horNode, frenteNode;

	public Node(int posX, int posY, int dir) {
		this.posX = posX;
		this.posY = posY;
		this.dir = dir;
		visitado = false;
	}

	@Override
	public String toString() {
		return "Node{ " + "posX = " + posX + ", posY = " + posY + ", dir = " + dir + '}';
	}
}
