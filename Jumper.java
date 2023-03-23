/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
 * A <code>Jumper</code> jumps two grid squares at a time, hopping over actors. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class Jumper extends Bug
{
    private int steps;
    private int sideLength;
    private int x;
    private int c;
    private int heading;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public Jumper()
    {
		heading = 0;
		x = getLocation().getRow();
		c = getLocation().getCol();
		setColor(Color.BLUE);
    }

    /**
     * Moves to the next location.
     */
    public void act(){
		System.out.println(x+" "+c);
		moveIt();
		if(getLocation().getCol()==c&&getLocation().getRow()==x){
			turn();
			heading += 45;
			if(heading>360)
				heading = 45;
		}
    }
    public void moveIt(){
		if(heading==0){
			moveTo(new Location(x-2, c));
			x-=2;
		}
		else if(heading==45){
			moveTo(new Location(x-2, c+2));
			x-=2;
			c+=2;
		}
		else if(heading==90){
			moveTo(new Location(x, c+2));
			c+=2;
		}
		else if(heading==135){
			moveTo(new Location(x+2, c+2));
			x+=2;
			c+=2;
		}
		else if(heading==180){
			moveTo(new Location(x+2, c));
			x+=2;
		}
		else if(heading==225){
			moveTo(new Location(x+2, c-2));
			x+=2;
			c-=2;
		}
		else if(heading==270){
			moveTo(new Location(x, c-2));
			c-=2;
		}
		else if(heading==315){
			moveTo(new Location(x-2, c-2));
			x-=2;
			c-=2;
		}
		else if(heading==360){
			moveTo(new Location(x-2, c));
			x-=2;
		}
	}
}
