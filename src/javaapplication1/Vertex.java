/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.List;

/**
 *
 * @author paulo
 */
public class Vertex {
    public String space; //can be FREE, WALL or TARGET
    int linePos, columnPos;
    
    List<Edge> edges;
    
    Vertex sw;    //SOUTHWEST
    Vertex w;     //WEST
    Vertex nw;    //NORTHWEST
    Vertex n;     //NORTH
    Vertex ne;    //NORTHEAST
    Vertex e;     //EAST
    Vertex se;    //SOUTHEAST
    Vertex s;     //SOUTH

    public Vertex(String space) {
        if(space.equals(".") || space.equals(">")){
            //this.space = "FREE";
            this.space = ".";
        }
        else if(space.equals("*")){
            this.space = "WALL";
            //this.space = "*";
        }
        else if(space.equalsIgnoreCase("X")){
            this.space = "TARG";
            //this.space = "X";
        }
    }
    
    public Vertex(String space, int linePos, int columnPos){
        if(space.equals(".") || space.equals(">")){
            //this.space = "FREE";
            this.space = ".";
        }
        else if(space.equals("*")){
            this.space = "WALL";
            //this.space = "*";
        }
        else if(space.equalsIgnoreCase("X")){
            this.space = "TARG";
            //this.space = "X";
        }
    }
}