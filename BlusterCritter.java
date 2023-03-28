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
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class BlusterCritter extends Critter
{
	private int c;
	public BlusterCritter(){
		c = 5;
	}
	public BlusterCritter(int cval){
		c = cval;
	}
	/**
	 * Returns the value of c
	 * @return c	The value of c
	 */
	public int getCVal(){
		return c;
	}
	
	/**
	 * Gets the number of actors near the BlisterCritter
	 * @return The number of actors within 2 locations of the BlusterCritter
	 */
	public int getNumActors()
    {
		Actor ac = new Actor();
        ArrayList<Actor> actors = new ArrayList<Actor>();
        int rowLoc = getLocation().getRow();
        int colLoc = getLocation().getCol();
        int rowLength = 5;
        int colLength = 5;
        int counter = 0;
        int startloc = 0;
        int startloc0 = 0;
        if(rowLoc==0){
			rowLength-=2;
			startloc = 0;
		}
		else if(rowLoc==getGrid().getNumRows()-1){
			rowLength-=2;
			startloc = rowLoc-2;
		}
		else if(rowLoc==1){
			startloc = 0;
			rowLength-=1;
		}
		else if(rowLoc==getGrid().getNumRows()-2){
			rowLength-=1;
			startloc = rowLoc-2;
		}
		else{
			startloc = rowLoc-2;
		}
		if(colLoc==0){
			colLength-=2;
			startloc0 = 0;
		}
		else if(colLoc==getGrid().getNumCols()-1){
			colLength-=2;
			startloc0 = colLoc-2;
		}
		else if(colLoc==1){
			colLength-=1;
			startloc0 = 0;
		}
		else if(colLoc==getGrid().getNumCols()-2){
			colLength-=1;
			startloc0 = colLoc-2;
		}
		else{
			startloc0 = colLoc-2;
		}
		for(int i = startloc;i<startloc+rowLength;i++){
			for(int a = startloc0;a<startloc0+colLength;a++){
				ac = getGrid().get(new Location(i, a));
				System.out.println(i+" "+a);
				if(ac==null){
				}
				else{
					if(ac instanceof Critter){
						counter++;
						System.out.println(ac.toString());
					}
				}
			}
		}
		counter = counter-1;
		return counter;
    }
    /**
     * Looks for all neighbors within 2 steps of its current location, and
     * increases its brightness if there are more than c actors, and decreases
     * its brightness if there are fewer than c actors
     */
    public void processActors(ArrayList<Actor> actors)
    {
        int numActors = getNumActors();
        if(numActors>=c){
			Color c = getColor();
			int red = (int) (c.getRed() * 0.95);
			int green = (int) (c.getGreen() * 0.95);
			int blue = (int) (c.getBlue() * 0.95);
			setColor(new Color(red, green, blue));
		}
		else{
			Color c = getColor();
			int red = (int) (c.getRed() * 1.05);
			int green = (int) (c.getGreen() * 1.05);
			int blue = (int) (c.getBlue() * 1.05);
			if(red>255)
				red = 255;
			if(blue>255)
				blue = 255;
			if(green>255)
				green = 255;
			setColor(new Color(red, green, blue));
		}
    }

    /**
     * Turns towards the new location as it moves.
     */
    public void makeMove(Location loc)
    {
        if (loc == null)
            removeSelfFromGrid();
        else
            moveTo(loc);   
    }
}
