import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
 * This class runs a world that contains dancing bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class DancingBugRunner
{
    public static void main(String[] args)
    {
		UnboundedGrid<Actor> ug = new UnboundedGrid<Actor>();
        ActorWorld world = new ActorWorld(ug);
        DancingBug alice = new DancingBug();
        world.add(new Location(7, 8), alice);
        world.show();
    }
}
