/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import static javaapplication1.JavaApplication1.environmentFromText;

/**
 *
 * @author paulo
 */
public class AStar {
	
	//Starting point
	private int starti, startj, startdir;
	//Ending point
	private int endi, endj;
	//List of nodes
	private ArrayList<Node> nodeList;
	//List of Nodes with movement cost
	private ArrayList<Node> movementCostList;

	public AStar(int starti, int startj, int startdir, int endi, int endj, ArrayList<Node> nodeList) {
		this.starti = starti;
		this.startj = startj;
		this.startdir = startdir;
		this.endi = endi;
		this.endj = endj;
		this.nodeList = nodeList;
	}
	
	public void calculateMovementCostForEachNode(){
		for(int i = 0; i < environmentFromText.nodeList.size(); i ++){
			System.out.println("Calculating moves cost for " + nodeList.get(i).toString());
			environmentFromText.nodeList.get(i).setMovementCost();
		}
	}

	void findBestWay() {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	
	
}
