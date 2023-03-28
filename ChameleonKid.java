/**
 * A ChameleonKid takes on the color of the actor in front or behind; if
 * there are no actors there, then the ChameleonKid darkens.
 */
 
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;
public class ChameleonKid extends ChameleonCritter{
/**
 * Finds the actors above and below the ChameleonKid
 */
public ArrayList<Actor> getActors(){
	int row;
	ArrayList<Actor> ar = new ArrayList<Actor>();
	Location curLoc = getLocation();
	if(curLoc.getRow()>0){
		row = curLoc.getRow()-1;
		ar.add(getGrid().get(new Location(row, curLoc.getCol())));
		if(ar.get(0)==null)
			ar.remove(0);
	}
	if(curLoc.getRow()<getGrid().getNumRows()-1){
		row = curLoc.getRow()+1;
		ar.add(getGrid().get(new Location(row, curLoc.getCol())));
		if(ar.get(0)==null)
			ar.remove(0);
	}
	for(int a = 0;a<ar.size();a++){			
		if(ar.get(a)==null)
			ar.remove(a);
	}
	return ar;
    }
    /**
     * Turns towards the new location as it moves.
	 */
    public void makeMove(Location loc)
    {
        setDirection(getLocation().getDirectionToward(loc));
        super.makeMove(loc);
    }
}
