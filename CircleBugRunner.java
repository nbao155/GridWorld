import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
 * This class runs a world that contains circle bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class CircleBugRunner
{
    public static void main(String[] args)
    {
        UnboundedGrid<Actor> ug = new UnboundedGrid<Actor>();
        ActorWorld world = new ActorWorld(ug);
        CircleBug alice = new CircleBug(3);
        world.add(new Location(8, 0), alice);
        world.show();
    }
}
