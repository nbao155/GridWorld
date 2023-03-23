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

/**
 * A <code>ZBug</code> traces out a "Z" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
	private int numActions;
	private boolean stop = false;
	private int numStep = 0;
	
    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        steps = 0;
        sideLength = length;
        turn();
        turn();
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
		if(stop==false){
			if(numActions>3*sideLength-4){
				stop = true;
			}
			else if (steps < sideLength-1 && canMove())
			{
				move();
				steps++;
				numActions++;
			}
			else if(canMove()==false){
				stop = true;
			}
			else if(numStep==0)
			{
				for(int i = 0;i<3;i++)
					turn();
				steps = 0;
				numStep++;
			}
			else if(numStep==1){
				for(int i = 0;i<5;i++)
					turn();
				steps = 0;
			}
			//System.out.println(numActions+" "+numStep);
		}
    }
}
