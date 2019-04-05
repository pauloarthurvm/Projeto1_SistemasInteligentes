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

enum Looking{
    N(0), NE(1), E(2), SE(3), S(4), SW(5), W(6), NW(7);
    
    public int lookingValue;

    Looking(int value){
        lookingValue = value;
    }
}

public class Player {
    
    int pos_x, pos_y;
    String look;
    Enum looking;
    
}
