import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
 * This class runs a world that contains spiral bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class SpiralBugRunner
{
    public static void main(String[] args)
    {
		Grid<Actor> ug = new UnboundedGrid<Actor>();
        ActorWorld world = new ActorWorld(ug);
        SpiralBug alice = new SpiralBug(1);
        world.add(new Location(7, 8), alice);
        world.show();
    }
}
