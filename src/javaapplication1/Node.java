/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.BorderLayout;
import static java.lang.Math.sqrt;
import static javaapplication1.JavaApplication1.environmentFromText;

/**
 *
 * @author paulo
 */
public class Node {

	boolean visitado;
	//Direção: 0 (norte), 1 (nordeste), 2 (leste), 3 (sudeste)
	//Direção: 4 (sul), 5 (sudoeste), 6 (oeste), 7 (noroeste)
	public int posX, posY, dir;

	public Node sent_antiHorNode, sent_horNode, frenteNode;
	
	//Cost to go to adjacent Nodes
	//It is an Array of 8 objects, one for each direction
	public MovementCostForNode[] movementCostForNodes;
	
	//Heuristic cost to destination - simple pythagoras
	private Double heuristicCost;

	public Node(int posX, int posY, int dir) {
		this.posX = posX;
		this.posY = posY;
		this.dir = dir;
		visitado = false;
		movementCostForNodes = new MovementCostForNode[8];
	}

	@Override
	public String toString() {
		return "Node{ " + "posX = " + posX + ", posY = " + posY + ", dir = " + dir + '}';
	}
	
	public void calculateHeuristicCost(int endi, int endj){
		heuristicCost = sqrt((Double.valueOf(((posX - endi)^2) + ((posY - endj)^2))));
	}
	
	public void setMovementCost(){
		System.out.println("Setting movement cost for " + toString());
		if(dir == 0){
			
			//Andar para node à 0
			//Verificar se tem node
			if(posX != 0 && environmentFromText.matrixBoolean[posX-1][posY] == true){
				movementCostForNodes[0] = new MovementCostForNode();
				movementCostForNodes[0].nodesInPath.add(frenteNode);
				movementCostForNodes[0].totalCost = 1;
			} else{
				movementCostForNodes[0] = null;
			}	//OK
			
			//Andar para node à 1
			//Verificar se tem node
			if((posX != 0 || posY != environmentFromText.matrixBoolean[0].length) && environmentFromText.matrixBoolean[posX-1][posY+1] == true){
				movementCostForNodes[1] = new MovementCostForNode();
				movementCostForNodes[1].nodesInPath.add(sent_horNode);
				movementCostForNodes[1].nodesInPath.add(frenteNode);
				movementCostForNodes[1].totalCost = 2;
			} else{
				movementCostForNodes[1] = null;
			}
			
			//Andar para node à 2
			//Verificar se tem node
			if(posY != environmentFromText.matrixBoolean[0].length && environmentFromText.matrixBoolean[posX][posY+1] == true){
				movementCostForNodes[2] = new MovementCostForNode();
				movementCostForNodes[2].nodesInPath.add(sent_horNode);
				movementCostForNodes[2].nodesInPath.add(sent_horNode);
				movementCostForNodes[2].nodesInPath.add(frenteNode);
				movementCostForNodes[2].totalCost = 3;
			} else{
				movementCostForNodes[2] = null;
			}
			
			//Andar para node à 3
			//Verificar se tem node
			if((posY != environmentFromText.matrixBoolean[0].length || posX != environmentFromText.matrixBoolean.length) && environmentFromText.matrixBoolean[posX+1][posY+1] == true){
				movementCostForNodes[3] = new MovementCostForNode();
				movementCostForNodes[3].nodesInPath.add(sent_horNode);
				movementCostForNodes[3].nodesInPath.add(sent_horNode);
				movementCostForNodes[3].nodesInPath.add(sent_horNode);
				movementCostForNodes[3].nodesInPath.add(frenteNode);
				movementCostForNodes[3].totalCost = 4;
			} else{
				movementCostForNodes[3] = null;
			}
			
			//Andar para node à 4
			//Verificar se tem node
			if(posX != environmentFromText.matrixBoolean.length && environmentFromText.matrixBoolean[posX+1][posY+1] == true){
				movementCostForNodes[4] = new MovementCostForNode();
				movementCostForNodes[4].nodesInPath.add(sent_horNode);
				movementCostForNodes[4].nodesInPath.add(sent_horNode);
				movementCostForNodes[4].nodesInPath.add(sent_horNode);
				movementCostForNodes[4].nodesInPath.add(sent_horNode);
				movementCostForNodes[4].nodesInPath.add(frenteNode);
				movementCostForNodes[4].totalCost = 5;
			} else{
				movementCostForNodes[4] = null;
			}
			
			//Andar para node à 5
			//Verificar se tem node
			if((posY != 0 || posX != environmentFromText.matrixBoolean.length) && environmentFromText.matrixBoolean[posX+1][posY-1] == true){
				movementCostForNodes[5] = new MovementCostForNode();
				movementCostForNodes[5].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[5].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[5].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[5].nodesInPath.add(frenteNode);
				movementCostForNodes[5].totalCost = 4;
			} else{
				movementCostForNodes[5] = null;
			}
			
			//Andar para node à 6
			//Verificar se tem node
			if(posY != 0 && environmentFromText.matrixBoolean[posX][posY-1] == true){
				movementCostForNodes[6] = new MovementCostForNode();
				movementCostForNodes[6].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[6].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[6].nodesInPath.add(frenteNode);
				movementCostForNodes[6].totalCost = 3;
			} else{
				movementCostForNodes[6] = null;
			}
			
			//Andar para node à 7
			//Verificar se tem node
			if((posY != 0 || posX != 0) && environmentFromText.matrixBoolean[posX-1][posY-1] == true){
				movementCostForNodes[7] = new MovementCostForNode();
				movementCostForNodes[7].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[7].nodesInPath.add(frenteNode);
				movementCostForNodes[7].totalCost = 3;
			} else{
				movementCostForNodes[7] = null;
			}
			
		} else if(dir == 1){
			
			//Andar para node à 0
			//Verificar se tem node
			if(posX != 0 && environmentFromText.matrixBoolean[posX-1][posY] == true){
				movementCostForNodes[0] = new MovementCostForNode();
				movementCostForNodes[0].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[0].nodesInPath.add(frenteNode);
				movementCostForNodes[0].totalCost = 2;
			} else{
				movementCostForNodes[0] = null;
			}
			
			//Andar para node à 1
			//Verificar se tem node
			if((posX != 0 || posY != environmentFromText.matrixBoolean[0].length) && environmentFromText.matrixBoolean[posX-1][posY+1] == true){
				movementCostForNodes[1] = new MovementCostForNode();
				movementCostForNodes[1].nodesInPath.add(frenteNode);
				movementCostForNodes[1].totalCost = 1;
			} else{
				movementCostForNodes[1] = null;
			}
			
			//Andar para node à 2
			//Verificar se tem node
			if(posY != environmentFromText.matrixBoolean[0].length && environmentFromText.matrixBoolean[posX][posY+1] == true){
				movementCostForNodes[2] = new MovementCostForNode();
				movementCostForNodes[2].nodesInPath.add(sent_horNode);
				movementCostForNodes[2].nodesInPath.add(frenteNode);
				movementCostForNodes[2].totalCost = 2;
			} else{
				movementCostForNodes[2] = null;
			}
			
			//Andar para node à 3
			//Verificar se tem node
			if((posY != environmentFromText.matrixBoolean[0].length || posX != environmentFromText.matrixBoolean.length) && environmentFromText.matrixBoolean[posX+1][posY+1] == true){
				movementCostForNodes[3] = new MovementCostForNode();
				movementCostForNodes[3].nodesInPath.add(sent_horNode);
				movementCostForNodes[3].nodesInPath.add(sent_horNode);
				movementCostForNodes[3].nodesInPath.add(frenteNode);
				movementCostForNodes[3].totalCost = 3;
			} else{
				movementCostForNodes[3] = null;
			}
			
			//Andar para node à 4
			//Verificar se tem node
			if(posX != environmentFromText.matrixBoolean.length && environmentFromText.matrixBoolean[posX+1][posY+1] == true){
				movementCostForNodes[4] = new MovementCostForNode();
				movementCostForNodes[4].nodesInPath.add(sent_horNode);
				movementCostForNodes[4].nodesInPath.add(sent_horNode);
				movementCostForNodes[4].nodesInPath.add(sent_horNode);
				movementCostForNodes[4].nodesInPath.add(frenteNode);
				movementCostForNodes[4].totalCost = 4;
			} else{
				movementCostForNodes[4] = null;
			}
			
			//Andar para node à 5
			//Verificar se tem node
			if((posY != 0 || posX != environmentFromText.matrixBoolean.length) && environmentFromText.matrixBoolean[posX+1][posY-1] == true){
				movementCostForNodes[5] = new MovementCostForNode();
				movementCostForNodes[5].nodesInPath.add(sent_horNode);
				movementCostForNodes[5].nodesInPath.add(sent_horNode);
				movementCostForNodes[5].nodesInPath.add(sent_horNode);
				movementCostForNodes[5].nodesInPath.add(sent_horNode);
				movementCostForNodes[5].nodesInPath.add(frenteNode);
				movementCostForNodes[5].totalCost = 5;
			} else{
				movementCostForNodes[5] = null;
			}
			
			//Andar para node à 6
			//Verificar se tem node
			if(posY != 0 && environmentFromText.matrixBoolean[posX][posY-1] == true){
				movementCostForNodes[6] = new MovementCostForNode();
				movementCostForNodes[6].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[6].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[6].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[6].nodesInPath.add(frenteNode);
				movementCostForNodes[6].totalCost = 4;
			} else{
				movementCostForNodes[6] = null;
			}
			
			//Andar para node à 7
			//Verificar se tem node
			if((posY != 0 || posX != 0) && environmentFromText.matrixBoolean[posX-1][posY-1] == true){
				movementCostForNodes[7] = new MovementCostForNode();
				movementCostForNodes[7].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[7].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[7].nodesInPath.add(frenteNode);
				movementCostForNodes[7].totalCost = 3;
			} else{
				movementCostForNodes[7] = null;
			}
						
		} else if(dir == 2){
			
			//Andar para node à 0
			//Verificar se tem node
			if(posX != 0 && environmentFromText.matrixBoolean[posX-1][posY] == true){
				movementCostForNodes[0] = new MovementCostForNode();
				movementCostForNodes[0].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[0].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[0].nodesInPath.add(frenteNode);
				movementCostForNodes[0].totalCost = 3;
			} else{
				movementCostForNodes[0] = null;
			}
			
			//Andar para node à 1
			//Verificar se tem node
			if((posX != 0 || posY != environmentFromText.matrixBoolean[0].length) && environmentFromText.matrixBoolean[posX-1][posY+1] == true){
				movementCostForNodes[1] = new MovementCostForNode();
				movementCostForNodes[1].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[1].nodesInPath.add(frenteNode);
				movementCostForNodes[1].totalCost = 2;
			} else{
				movementCostForNodes[1] = null;
			}
			
			//Andar para node à 2
			//Verificar se tem node
			if(posY != environmentFromText.matrixBoolean[0].length && environmentFromText.matrixBoolean[posX][posY+1] == true){
				movementCostForNodes[2] = new MovementCostForNode();
				movementCostForNodes[2].nodesInPath.add(frenteNode);
				movementCostForNodes[2].totalCost = 1;
			} else{
				movementCostForNodes[2] = null;
			}
			
			//Andar para node à 3
			//Verificar se tem node
			if((posY != environmentFromText.matrixBoolean[0].length || posX != environmentFromText.matrixBoolean.length) && environmentFromText.matrixBoolean[posX+1][posY+1] == true){
				movementCostForNodes[3] = new MovementCostForNode();
				movementCostForNodes[3].nodesInPath.add(sent_horNode);
				movementCostForNodes[3].nodesInPath.add(frenteNode);
				movementCostForNodes[3].totalCost = 2;
			} else{
				movementCostForNodes[3] = null;
			}
			
			//Andar para node à 4
			//Verificar se tem node
			if(posX != environmentFromText.matrixBoolean.length && environmentFromText.matrixBoolean[posX+1][posY+1] == true){
				movementCostForNodes[4] = new MovementCostForNode();
				movementCostForNodes[4].nodesInPath.add(sent_horNode);
				movementCostForNodes[4].nodesInPath.add(sent_horNode);
				movementCostForNodes[4].nodesInPath.add(frenteNode);
				movementCostForNodes[4].totalCost = 3;
			} else{
				movementCostForNodes[4] = null;
			}
			
			//Andar para node à 5
			//Verificar se tem node
			if((posY != 0 || posX != environmentFromText.matrixBoolean.length) && environmentFromText.matrixBoolean[posX+1][posY-1] == true){
				movementCostForNodes[5] = new MovementCostForNode();
				movementCostForNodes[5].nodesInPath.add(sent_horNode);
				movementCostForNodes[5].nodesInPath.add(sent_horNode);
				movementCostForNodes[5].nodesInPath.add(sent_horNode);
				movementCostForNodes[5].nodesInPath.add(frenteNode);
				movementCostForNodes[5].totalCost = 4;
			} else{
				movementCostForNodes[5] = null;
			}
			
			//Andar para node à 6
			//Verificar se tem node
			if(posY != 0 && environmentFromText.matrixBoolean[posX][posY-1] == true){
				movementCostForNodes[6] = new MovementCostForNode();
				movementCostForNodes[6].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[6].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[6].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[6].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[6].nodesInPath.add(frenteNode);
				movementCostForNodes[6].totalCost = 5;
			} else{
				movementCostForNodes[6] = null;
			}
			
			//Andar para node à 7
			//Verificar se tem node
			if((posY != 0 || posX != 0) && environmentFromText.matrixBoolean[posX-1][posY-1] == true){
				movementCostForNodes[7] = new MovementCostForNode();
				movementCostForNodes[7].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[7].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[7].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[7].nodesInPath.add(frenteNode);
				movementCostForNodes[7].totalCost = 4;
			} else{
				movementCostForNodes[7] = null;
			}
			
		} else if(dir == 3){
			
			//Andar para node à 0
			//Verificar se tem node
			if(posX != 0 && environmentFromText.matrixBoolean[posX-1][posY] == true){
				movementCostForNodes[0] = new MovementCostForNode();
				movementCostForNodes[0].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[0].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[0].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[0].nodesInPath.add(frenteNode);
				movementCostForNodes[0].totalCost = 4;
			} else{
				movementCostForNodes[0] = null;
			}
			
			//Andar para node à 1
			//Verificar se tem node
			if((posX != 0 || posY != environmentFromText.matrixBoolean[0].length) && environmentFromText.matrixBoolean[posX-1][posY+1] == true){
				movementCostForNodes[1] = new MovementCostForNode();
				movementCostForNodes[1].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[1].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[1].nodesInPath.add(frenteNode);
				movementCostForNodes[1].totalCost = 3;
			} else{
				movementCostForNodes[1] = null;
			}
			
			//Andar para node à 2
			//Verificar se tem node
			if(posY != environmentFromText.matrixBoolean[0].length && environmentFromText.matrixBoolean[posX][posY+1] == true){
				movementCostForNodes[2] = new MovementCostForNode();
				movementCostForNodes[2].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[2].nodesInPath.add(frenteNode);
				movementCostForNodes[2].totalCost = 2;
			} else{
				movementCostForNodes[2] = null;
			}
			
			//Andar para node à 3
			//Verificar se tem node
			if((posY != environmentFromText.matrixBoolean[0].length || posX != environmentFromText.matrixBoolean.length) && environmentFromText.matrixBoolean[posX+1][posY+1] == true){
				movementCostForNodes[3] = new MovementCostForNode();
				movementCostForNodes[3].nodesInPath.add(frenteNode);
				movementCostForNodes[3].totalCost = 1;
			} else{
				movementCostForNodes[3] = null;
			}
			
			//Andar para node à 4
			//Verificar se tem node
			if(posX != environmentFromText.matrixBoolean.length && environmentFromText.matrixBoolean[posX+1][posY+1] == true){
				movementCostForNodes[4] = new MovementCostForNode();
				movementCostForNodes[4].nodesInPath.add(sent_horNode);
				movementCostForNodes[4].nodesInPath.add(frenteNode);
				movementCostForNodes[4].totalCost = 2;
			} else{
				movementCostForNodes[4] = null;
			}
			
			//Andar para node à 5
			//Verificar se tem node
			if((posY != 0 || posX != environmentFromText.matrixBoolean.length) && environmentFromText.matrixBoolean[posX+1][posY-1] == true){
				movementCostForNodes[5] = new MovementCostForNode();
				movementCostForNodes[5].nodesInPath.add(sent_horNode);
				movementCostForNodes[5].nodesInPath.add(sent_horNode);
				movementCostForNodes[5].nodesInPath.add(frenteNode);
				movementCostForNodes[5].totalCost = 3;
			} else{
				movementCostForNodes[5] = null;
			}
			
			//Andar para node à 6
			//Verificar se tem node
			if(posY != 0 && environmentFromText.matrixBoolean[posX][posY-1] == true){
				movementCostForNodes[6] = new MovementCostForNode();
				movementCostForNodes[6].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[6].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[6].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[6].nodesInPath.add(frenteNode);
				movementCostForNodes[6].totalCost = 4;
			} else{
				movementCostForNodes[6] = null;
			}
			
			//Andar para node à 7
			//Verificar se tem node
			if((posY != 0 || posX != 0) && environmentFromText.matrixBoolean[posX-1][posY-1] == true){
				movementCostForNodes[7] = new MovementCostForNode();
				movementCostForNodes[7].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[7].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[7].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[7].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[7].nodesInPath.add(frenteNode);
				movementCostForNodes[7].totalCost = 5;
			} else{
				movementCostForNodes[7] = null;
			}
			
		} else if(dir == 4){
			
			//Andar para node à 0
			//Verificar se tem node
			if(posX != 0 && environmentFromText.matrixBoolean[posX-1][posY] == true){
				movementCostForNodes[0] = new MovementCostForNode();
				movementCostForNodes[0].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[0].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[0].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[0].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[0].nodesInPath.add(frenteNode);
				movementCostForNodes[0].totalCost = 5;
			} else{
				movementCostForNodes[0] = null;
			}
			
			//Andar para node à 1
			//Verificar se tem node
			if((posX != 0 || posY != environmentFromText.matrixBoolean[0].length) && environmentFromText.matrixBoolean[posX-1][posY+1] == true){
				movementCostForNodes[1] = new MovementCostForNode();
				movementCostForNodes[1].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[1].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[1].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[1].nodesInPath.add(frenteNode);
				movementCostForNodes[1].totalCost = 4;
			} else{
				movementCostForNodes[1] = null;
			}
			
			//Andar para node à 2
			//Verificar se tem node
			if(posY != environmentFromText.matrixBoolean[0].length && environmentFromText.matrixBoolean[posX][posY+1] == true){
				movementCostForNodes[2] = new MovementCostForNode();
				movementCostForNodes[2].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[2].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[2].nodesInPath.add(frenteNode);
				movementCostForNodes[2].totalCost = 3;
			} else{
				movementCostForNodes[2] = null;
			}
			
			//Andar para node à 3
			//Verificar se tem node
			if((posY != environmentFromText.matrixBoolean[0].length || posX != environmentFromText.matrixBoolean.length) && environmentFromText.matrixBoolean[posX+1][posY+1] == true){
				movementCostForNodes[3] = new MovementCostForNode();
				movementCostForNodes[3].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[3].nodesInPath.add(frenteNode);
				movementCostForNodes[3].totalCost = 2;
			} else{
				movementCostForNodes[3] = null;
			}
			
			//Andar para node à 4
			//Verificar se tem node
			if(posX != environmentFromText.matrixBoolean.length && environmentFromText.matrixBoolean[posX+1][posY+1] == true){
				movementCostForNodes[4] = new MovementCostForNode();
				movementCostForNodes[4].nodesInPath.add(frenteNode);
				movementCostForNodes[4].totalCost = 1;
			} else{
				movementCostForNodes[4] = null;
			}
			
			//Andar para node à 5
			//Verificar se tem node
			if((posY != 0 || posX != environmentFromText.matrixBoolean.length) && environmentFromText.matrixBoolean[posX+1][posY-1] == true){
				movementCostForNodes[5] = new MovementCostForNode();
				movementCostForNodes[5].nodesInPath.add(sent_horNode);
				movementCostForNodes[5].nodesInPath.add(frenteNode);
				movementCostForNodes[5].totalCost = 2;
			} else{
				movementCostForNodes[5] = null;
			}
			
			//Andar para node à 6
			//Verificar se tem node
			if(posY != 0 && environmentFromText.matrixBoolean[posX][posY-1] == true){
				movementCostForNodes[6] = new MovementCostForNode();
				movementCostForNodes[6].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[6].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[6].nodesInPath.add(frenteNode);
				movementCostForNodes[6].totalCost = 3;
			} else{
				movementCostForNodes[6] = null;
			}
			
			//Andar para node à 7
			//Verificar se tem node
			if((posY != 0 || posX != 0) && environmentFromText.matrixBoolean[posX-1][posY-1] == true){
				movementCostForNodes[7] = new MovementCostForNode();
				movementCostForNodes[7].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[7].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[7].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[7].nodesInPath.add(frenteNode);
				movementCostForNodes[7].totalCost = 4;
			} else{
				movementCostForNodes[7] = null;
			}
			
		} else if(dir == 5){
			
			//Andar para node à 0
			//Verificar se tem node
			if(posX != 0 && environmentFromText.matrixBoolean[posX-1][posY] == true){
				movementCostForNodes[0] = new MovementCostForNode();
				movementCostForNodes[0].nodesInPath.add(sent_horNode);
				movementCostForNodes[0].nodesInPath.add(sent_horNode);
				movementCostForNodes[0].nodesInPath.add(sent_horNode);
				movementCostForNodes[0].nodesInPath.add(frenteNode);
				movementCostForNodes[0].totalCost = 4;
			} else{
				movementCostForNodes[0] = null;
			}
			
			//Andar para node à 1
			//Verificar se tem node
			if((posX != 0 || posY != environmentFromText.matrixBoolean[0].length) && environmentFromText.matrixBoolean[posX-1][posY+1] == true){
				movementCostForNodes[1] = new MovementCostForNode();
				movementCostForNodes[1].nodesInPath.add(sent_horNode);
				movementCostForNodes[1].nodesInPath.add(sent_horNode);
				movementCostForNodes[1].nodesInPath.add(sent_horNode);
				movementCostForNodes[1].nodesInPath.add(sent_horNode);
				movementCostForNodes[1].nodesInPath.add(frenteNode);
				movementCostForNodes[1].totalCost = 5;
			} else{
				movementCostForNodes[1] = null;
			}
			
			//Andar para node à 2
			//Verificar se tem node
			if(posY != environmentFromText.matrixBoolean[0].length && environmentFromText.matrixBoolean[posX][posY+1] == true){
				movementCostForNodes[2] = new MovementCostForNode();
				movementCostForNodes[2].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[2].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[2].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[2].nodesInPath.add(frenteNode);
				movementCostForNodes[2].totalCost = 4;
			} else{
				movementCostForNodes[2] = null;
			}
			
			//Andar para node à 3
			//Verificar se tem node
			if((posY != environmentFromText.matrixBoolean[0].length || posX != environmentFromText.matrixBoolean.length) && environmentFromText.matrixBoolean[posX+1][posY+1] == true){
				movementCostForNodes[3] = new MovementCostForNode();
				movementCostForNodes[3].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[3].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[3].nodesInPath.add(frenteNode);
				movementCostForNodes[3].totalCost = 3;
			} else{
				movementCostForNodes[3] = null;
			}
			
			//Andar para node à 4
			//Verificar se tem node
			if(posX != environmentFromText.matrixBoolean.length && environmentFromText.matrixBoolean[posX+1][posY+1] == true){
				movementCostForNodes[4] = new MovementCostForNode();
				movementCostForNodes[4].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[4].nodesInPath.add(frenteNode);
				movementCostForNodes[4].totalCost = 2;
			} else{
				movementCostForNodes[4] = null;
			}
			
			//Andar para node à 5
			//Verificar se tem node
			if((posY != 0 || posX != environmentFromText.matrixBoolean.length) && environmentFromText.matrixBoolean[posX+1][posY-1] == true){
				movementCostForNodes[5] = new MovementCostForNode();
				movementCostForNodes[5].nodesInPath.add(frenteNode);
				movementCostForNodes[5].totalCost = 1;
			} else{
				movementCostForNodes[5] = null;
			}
			
			//Andar para node à 6
			//Verificar se tem node
			if(posY != 0 && environmentFromText.matrixBoolean[posX][posY-1] == true){
				movementCostForNodes[6] = new MovementCostForNode();
				movementCostForNodes[6].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[6].nodesInPath.add(frenteNode);
				movementCostForNodes[6].totalCost = 2;
			} else{
				movementCostForNodes[6] = null;
			}
			
			//Andar para node à 7
			//Verificar se tem node
			if((posY != 0 || posX != 0) && environmentFromText.matrixBoolean[posX-1][posY-1] == true){
				movementCostForNodes[7] = new MovementCostForNode();
				movementCostForNodes[7].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[7].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[7].nodesInPath.add(frenteNode);
				movementCostForNodes[7].totalCost = 3;
			} else{
				movementCostForNodes[7] = null;
			}
			
		} else if(dir == 6){
			
			//Andar para node à 0
			//Verificar se tem node
			if(posX != 0 && environmentFromText.matrixBoolean[posX-1][posY] == true){
				movementCostForNodes[0] = new MovementCostForNode();
				movementCostForNodes[0].nodesInPath.add(sent_horNode);
				movementCostForNodes[0].nodesInPath.add(sent_horNode);
				movementCostForNodes[0].nodesInPath.add(frenteNode);
				movementCostForNodes[0].totalCost = 3;
			} else{
				movementCostForNodes[0] = null;
			}
			
			//Andar para node à 1
			//Verificar se tem node
			if((posX != 0 || posY != environmentFromText.matrixBoolean[0].length) && environmentFromText.matrixBoolean[posX-1][posY+1] == true){
				movementCostForNodes[1] = new MovementCostForNode();
				movementCostForNodes[1].nodesInPath.add(sent_horNode);
				movementCostForNodes[1].nodesInPath.add(sent_horNode);
				movementCostForNodes[1].nodesInPath.add(sent_horNode);
				movementCostForNodes[1].nodesInPath.add(frenteNode);
				movementCostForNodes[1].totalCost = 4;
			} else{
				movementCostForNodes[1] = null;
			}
			
			//Andar para node à 2
			//Verificar se tem node
			if(posY != environmentFromText.matrixBoolean[0].length && environmentFromText.matrixBoolean[posX][posY+1] == true){
				movementCostForNodes[2] = new MovementCostForNode();
				movementCostForNodes[2].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[2].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[2].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[2].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[2].nodesInPath.add(frenteNode);
				movementCostForNodes[2].totalCost = 5;
			} else{
				movementCostForNodes[2] = null;
			}
			
			//Andar para node à 3
			//Verificar se tem node
			if((posY != environmentFromText.matrixBoolean[0].length || posX != environmentFromText.matrixBoolean.length) && environmentFromText.matrixBoolean[posX+1][posY+1] == true){
				movementCostForNodes[3] = new MovementCostForNode();
				movementCostForNodes[3].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[3].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[3].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[3].nodesInPath.add(frenteNode);
				movementCostForNodes[3].totalCost = 4;
			} else{
				movementCostForNodes[3] = null;
			}
			
			//Andar para node à 4
			//Verificar se tem node
			if(posX != environmentFromText.matrixBoolean.length && environmentFromText.matrixBoolean[posX+1][posY+1] == true){
				movementCostForNodes[4] = new MovementCostForNode();
				movementCostForNodes[4].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[4].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[4].nodesInPath.add(frenteNode);
				movementCostForNodes[4].totalCost = 3;
			} else{
				movementCostForNodes[4] = null;
			}
			
			//Andar para node à 5
			//Verificar se tem node
			if((posY != 0 || posX != environmentFromText.matrixBoolean.length) && environmentFromText.matrixBoolean[posX+1][posY-1] == true){
				movementCostForNodes[5] = new MovementCostForNode();
				movementCostForNodes[5].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[5].nodesInPath.add(frenteNode);
				movementCostForNodes[5].totalCost = 2;
			} else{
				movementCostForNodes[5] = null;
			}
			
			//Andar para node à 6
			//Verificar se tem node
			if(posY != 0 && environmentFromText.matrixBoolean[posX][posY-1] == true){
				movementCostForNodes[6] = new MovementCostForNode();
				movementCostForNodes[6].nodesInPath.add(frenteNode);
				movementCostForNodes[6].totalCost = 1;
			} else{
				movementCostForNodes[6] = null;
			}
			
			//Andar para node à 7
			//Verificar se tem node
			if((posY != 0 || posX != 0) && environmentFromText.matrixBoolean[posX-1][posY-1] == true){
				movementCostForNodes[7] = new MovementCostForNode();
				movementCostForNodes[7].nodesInPath.add(sent_horNode);
				movementCostForNodes[7].nodesInPath.add(frenteNode);
				movementCostForNodes[7].totalCost = 2;
			} else{
				movementCostForNodes[7] = null;
			}
			
		} else if(dir == 7){
			
			//Andar para node à 0
			//Verificar se tem node
			if(posX != 0 && environmentFromText.matrixBoolean[posX-1][posY] == true){
				movementCostForNodes[0] = new MovementCostForNode();
				movementCostForNodes[0].nodesInPath.add(sent_horNode);
				movementCostForNodes[0].nodesInPath.add(frenteNode);
				movementCostForNodes[0].totalCost = 2;
			} else{
				movementCostForNodes[0] = null;
			}
			
			//Andar para node à 1
			//Verificar se tem node
			if((posX != 0 || posY != environmentFromText.matrixBoolean[0].length) && environmentFromText.matrixBoolean[posX-1][posY+1] == true){
				movementCostForNodes[1] = new MovementCostForNode();
				movementCostForNodes[1].nodesInPath.add(sent_horNode);
				movementCostForNodes[1].nodesInPath.add(sent_horNode);
				movementCostForNodes[1].nodesInPath.add(frenteNode);
				movementCostForNodes[1].totalCost = 3;
			} else{
				movementCostForNodes[1] = null;
			}
			
			//Andar para node à 2
			//Verificar se tem node
			if(posY != environmentFromText.matrixBoolean[0].length && environmentFromText.matrixBoolean[posX][posY+1] == true){
				movementCostForNodes[2] = new MovementCostForNode();
				movementCostForNodes[2].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[2].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[2].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[2].nodesInPath.add(frenteNode);
				movementCostForNodes[2].totalCost = 4;
			} else{
				movementCostForNodes[2] = null;
			}
			
			//Andar para node à 3
			//Verificar se tem node
			if((posY != environmentFromText.matrixBoolean[0].length || posX != environmentFromText.matrixBoolean.length) && environmentFromText.matrixBoolean[posX+1][posY+1] == true){
				movementCostForNodes[3] = new MovementCostForNode();
				movementCostForNodes[3].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[3].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[3].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[3].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[3].nodesInPath.add(frenteNode);
				movementCostForNodes[3].totalCost = 5;
			} else{
				movementCostForNodes[3] = null;
			}
			
			//Andar para node à 4
			//Verificar se tem node
			if(posX != environmentFromText.matrixBoolean.length && environmentFromText.matrixBoolean[posX+1][posY+1] == true){
				movementCostForNodes[4] = new MovementCostForNode();
				movementCostForNodes[4].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[4].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[4].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[4].nodesInPath.add(frenteNode);
				movementCostForNodes[4].totalCost = 4;
			} else{
				movementCostForNodes[4] = null;
			}
			
			//Andar para node à 5
			//Verificar se tem node
			if((posY != 0 || posX != environmentFromText.matrixBoolean.length) && environmentFromText.matrixBoolean[posX+1][posY-1] == true){
				movementCostForNodes[5] = new MovementCostForNode();
				movementCostForNodes[5].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[5].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[5].nodesInPath.add(frenteNode);
				movementCostForNodes[5].totalCost = 3;
			} else{
				movementCostForNodes[5] = null;
			}
			
			//Andar para node à 6
			//Verificar se tem node
			if(posY != 0 && environmentFromText.matrixBoolean[posX][posY-1] == true){
				movementCostForNodes[6] = new MovementCostForNode();
				movementCostForNodes[6].nodesInPath.add(sent_antiHorNode);
				movementCostForNodes[6].nodesInPath.add(frenteNode);
				movementCostForNodes[6].totalCost = 2;
			} else{
				movementCostForNodes[6] = null;
			}
			
			//Andar para node à 7
			//Verificar se tem node
			if((posY != 0 || posX != 0) && environmentFromText.matrixBoolean[posX-1][posY-1] == true){
				movementCostForNodes[7] = new MovementCostForNode();
				movementCostForNodes[7].nodesInPath.add(frenteNode);
				movementCostForNodes[7].totalCost = 1;
			} else{
				movementCostForNodes[7] = null;
			}
			
		} else{
			System.out.println("FODEU");
		}
	}
	
}
