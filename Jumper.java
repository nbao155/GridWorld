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
import info.gridworld.grid.AbstractGrid;
import java.awt.Color;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;

/**
 * A <code>Jumper</code> jumps two grid squares at a time, hopping over actors. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class Jumper extends Bug
{
    private int steps;
    private int sideLength;
    private int row;
    private int col;
    private int origRow;
    private int origCol;
    private int newRow;
    private int newCol;
    private int heading;
    private boolean hasMoved = false;
    private boolean firstTime = true;
    private int counter = 0;
    private int numMovesNoTurn = 0;
    boolean canMove = true;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public Jumper()
    {
		heading = 0;
		setColor(Color.BLUE);
    }

    /**
     * Moves to the next location.
     */
    public void act(){
		Blossom bl = new Blossom();
		if(firstTime==true){
			row = getLocation().getRow();
			col = getLocation().getCol();
			firstTime = false;
		}	
		if(counter<16){
			origRow = row;
			origCol = col;
			//System.out.println(row+" "+c);
			moveIt();
			if(hasMoved==false){
				counter++;
				turn();
				heading += 45;
				if(heading>360)
					heading = 45;
				numMovesNoTurn = 0;
			}
			else{
				//System.out.println("blossom: " + origRow + ":" + origCol);
				bl.putSelfInGrid(getGrid(), new Location(origRow, origCol));
				hasMoved = false;
				counter = 0;
				numMovesNoTurn++;
			}
			if(numMovesNoTurn>25){
				numMovesNoTurn = 0;
				heading += 45;
				if(heading>360)
					heading = 45;
			}
		}
		else{
			removeSelfFromGrid();
		}
		//System.out.println(canMove+" "+hasMoved+" "+heading+"\n\n");
    }
    /**
     * Moves the bug after finding the valid locations it can move
     */
    public void moveIt(){
		//System.out.println(row+" L "+col);
		Location lc = new Location(row, col);
		ArrayList<Location> locations;
		locations = getGrid().getOccupiedLocations();
		lc = changeLoc(lc);
		//System.out.println(lc.getRow()+" C "+lc.getCol());
		for(int i = 0;i<locations.size();i++){
			if(lc.getRow()==locations.get(i).getRow()&&lc.getCol()==locations.get(i).getCol()&&!(getGrid().get(lc) instanceof Blossom)){
				canMove = false;
				lc = changeBackLoc(lc);
				//System.out.println(lc.getRow()+" D "+lc.getCol());
			}
			//System.out.println(locations.get(i).getRow()+" "+locations.get(i).getCol());
			//System.out.println(lc.getRow()+" a "+lc.getCol());
			//System.out.println(canMove);
		}
		//System.out.println(canMove);
		if(canMove == false){
			canMove = true;
			//System.out.println("Z");
		}
		else{
			newCol = lc.getCol();
			newRow = lc.getRow();
			//System.out.println(newRow+" "+newCol);
			try{
				moveTo(new Location(newRow, newCol));
				//System.out.println(row+" A "+col);
				if(row==newRow&&col==newCol)
					hasMoved = false;
				else
					hasMoved = true;
				row = row+(newRow-row);
				col = col+(newCol-col);
			}
			catch(IllegalArgumentException e){
				hasMoved = false;
				//System.out.println("B");
				//row = row-(newRow-row);
				//col = col-(newCol-col);
			}
			lc = null;
			newCol = 0;
			newRow = 0;
		}
	}
	
	/**
	 * Changes the next Location the Jumper will move to
	 * @return 		Which location the bug will move to next
	 */
	public Location changeLoc(Location lc){
		if(heading==0){
			lc = new Location(row-2, col);
			//hasMoved = true;
		}
		else if(heading==45){
			lc = new Location(row-2, col+2);
			//hasMoved = true;
		}
		else if(heading==90){
			lc = new Location(row, col+2);
			//hasMoved = true;
		}
		else if(heading==135){
			lc = new Location(row+2, col+2);
			//hasMoved = true;
		}
		else if(heading==180){
			lc = new Location(row+2, col);
			//hasMoved = true;
		}
		else if(heading==225){
			lc = new Location(row+2, col-2);
			//hasMoved = true;
		}
		else if(heading==270){
			lc = new Location(row, col-2);
			//hasMoved = true;
		}
		else if(heading==315){
			lc = new Location(row-2, col-2);
			//hasMoved = true;
		}
		else if(heading==360){
			lc = new Location(row-2, col);
			//hasMoved = true;
		}
		return lc;
	}
	public Location changeBackLoc(Location lc){
		lc = new Location(row, col);
		return lc;
	}
}
