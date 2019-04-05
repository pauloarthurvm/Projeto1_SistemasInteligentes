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
    }
    
    public void addPonteiros(){
	
	switch (dir){
	    case 0:	//olhando norte
		if(posX == 0 || posY == 0){
		    
		}
		break;
	    case 1:
		
		break;
	    case 2:
		
		break;
	    case 3:
		
		break;
	    case 4:
		
		break;
	    case 5:
		
		break;
	    case 6:
		
		break;
	    case 7:
		
		break;
	}
    }
}
