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
 * A <code>DancingBug</code> dances on the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class DancingBug extends Bug
{
    private int steps;
    private int[] numTurns = { 1, 0, 0, 0, 1, 0, 0, 3, 4, 4, 0, 0, 1, 0, 3, 2, 0, 7, 0, 0, 0, 3, 2, 1};

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public DancingBug()
    {
        steps = 0;
    }
    /**
     * Moves to the next location of the dance.
     */
    public void act()
    {
        move();
        for(int i = 0;i<numTurns[steps];i++)
			turn();
		steps++;
		if(steps>numTurns.length-1)
			steps = 0;
    }
}
