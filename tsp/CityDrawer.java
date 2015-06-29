package tsp;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jbisnardon on 18/06/15.
 */
public class CityDrawer extends JPanel {

    int xcoord = 0;
    int ycoord = 0;

    public CityDrawer(int xcity,int ycity) {

        super(true);

        xcoord = xcity;
        ycoord = ycity;

    }

    public void paintComponent(Graphics g){

        //Vous verrez cette phrase chaque fois que la méthode sera invoquée

        System.out.println("Drawing city");

        g.drawOval(xcoord+Panneau.offset, ycoord+Panneau.offset, 5, 5);

    }


}
