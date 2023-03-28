/**
 * A Critter that moves the same way as a CrabCritter, unless a location
 * two spaces to the right or left and its intervening location are empty.
 * In that case, the QuickCrab moves to one of those spaces.
 */
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class QuickCrab extends CrabCritter{
	private int rightOrLeft = 0;
	/**
	 * Makes the QuickCrab move to a new location
	 * @param loc	The current location of the crab
	 */
	public void makeMove(Location loc)
    {
		boolean canMove = canMoveIt();
		if(canMove){
			if(rightOrLeft==1){
				moveTo(new Location(getLocation().getRow(), getLocation().getCol()-2));
			}
			else{
				moveTo(new Location(getLocation().getRow(), getLocation().getCol()+2));
			}	
		}
		else{
			if (loc.equals(getLocation()))
			{
				double r = Math.random();
				int angle;
				if (r < 0.5)
					angle = Location.LEFT;
				else
					angle = Location.RIGHT;
				setDirection(getDirection() + angle);
			}
			else
				super.makeMove(loc);
		}
    }
    
    /**
     * Checks if the crab can move and if so which direction it should move
     * @return true if the crab can move, false if it can't
     */
    public boolean canMoveIt(){
		int row = getLocation().getRow();
		int col = getLocation().getCol();
		int whichLoc = 0;
		boolean canMove = false;
		if(col>1&&col<getGrid().getNumCols()-2){
			if(getGrid().get(new Location(row, col-2))==null&&getGrid().get(new Location(row, col-1))==null){
				whichLoc = 3;
			}
			if(getGrid().get(new Location(row, col+2))==null&&getGrid().get(new Location(row, col+1))==null){
				whichLoc++;
			}
		}
		else if(col<1){
			if(getGrid().get(new Location(row, col+1))==null&&getGrid().get(new Location(row, col+2))==null){
				whichLoc = 5;
			}
		}
		else if(col>getGrid().getNumCols()-2){
			if(getGrid().get(new Location(row, col-1))==null&&getGrid().get(new Location(row, col-2))==null){
				whichLoc = 2;
			}
		}
		else{
		
		}
		if(whichLoc==4){
			rightOrLeft = (int)(Math.random()+2);
			canMove = true;
		}
		else if(whichLoc==3||whichLoc==2){
			rightOrLeft = 1;
			canMove = true;
		}
		else if(whichLoc==1||whichLoc==5){
			rightOrLeft = 2;
			canMove = true;
		}
		else{
			
		}
		return canMove;
	}
}
