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
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>KingCrab</code> looks at a limited set of neighbors when it eats and moves
 * and pushes them away. If the processed actor cannot move, it removes itself from the
 * grid.
 * <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class KingCrab extends CrabCritter
{
    public KingCrab()
    {
        setColor(Color.RED);
    }

    /**
     * Processes the actors and moves them away
     * @param actors	The ArrayList of actors to process
     */
    public void processActors(ArrayList<Actor> actors){
		int arow = 0;
		int acol = 0;
		int origrow = 0;
		int origcol = 0;
		for (Actor a : actors)
        {
			arow = a.getLocation().getRow();
			acol = a.getLocation().getCol();
			origrow = arow;
			origcol = acol;
            if(arow<getLocation().getRow()){
				if(arow>0){
					arow--;
				}
			}
			else if(arow>getLocation().getRow()){
				if(arow<getGrid().getNumRows()-1){
					arow++;
				}
			}
			else if(arow==getLocation().getRow()){
				
			}
			if(acol<getLocation().getCol()){
				if(acol>0){
					acol--;
				}
			}
			else if(acol>getLocation().getCol()){
				if(arow<getGrid().getNumCols()-1)
					acol++;
			}
			else if(acol==getLocation().getCol()){
				
			}
			a.moveTo(new Location(arow, acol));
			if(arow==origrow&&acol==origcol){
				a.removeSelfFromGrid();
			}
        }
	}
}
