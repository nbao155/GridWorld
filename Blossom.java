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
 */

import java.awt.Color;
import info.gridworld.actor.Actor;

/**
 * A <code>Blossom</code> is an actor that darkens over time and then removes itself
 * from the grid when its lifetime is up. Some actors drop
 * blossoms as they move. <br />
 * The API of this class is testable on the AP CS A and AB exams.
 */

public class Blossom extends Actor
{
    private static final Color DEFAULT_COLOR = Color.BLUE;
    private static final double DARKENING_FACTOR = 0.05;
    private int LIFETIME_STEPS = 0;
    private int numSteps = 0;

    // lose 5% of color value in each step

    /**
     * Constructs a blue blossom.
     */
    public Blossom()
    {
        setColor(DEFAULT_COLOR);
        LIFETIME_STEPS = 10;
    }

    /**
     * Constructs a blossom
     * @param initialColor the initial color of this flower
     */
    public Blossom(int lifetimeLength)
    {
        setColor(DEFAULT_COLOR);
        LIFETIME_STEPS = lifetimeLength;
    }

    /**
     * Causes the color of this flower to darken.
     */
    public void act()
    {
		//System.out.println("blossom moved");
		if(numSteps<LIFETIME_STEPS){
			Color c = getColor();
			int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
			int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
			int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
			setColor(new Color(red, green, blue));
			numSteps++;
			//System.out.println(numSteps+" "+LIFETIME_STEPS);
		}
		else{
			removeSelfFromGrid();
		}
    }
}
