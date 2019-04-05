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
    private Map<Vertex, List<Edge>> adjVertices;
    
    
    
    void addVertex(Vertex vertex) {
	adjVertices.put(new Vertex(vertex.space), new ArrayList<>());
    }
}
