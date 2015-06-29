package tsp;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jbisnardon on 18/06/15.
 */
public class Panneau extends JPanel {

    static public int offset = 100;

    public void paintComponent(Graphics g){

        //Vous verrez cette phrase chaque fois que la méthode sera invoquée

        System.out.println("Drawing frame");

        for(int i=0; i<=200;i=i+20) {
            g.drawString(""+(i/10), i+offset-5, TSP_GA.frameSizeY-(offset-20)+20);
            g.drawLine(i+offset, TSP_GA.frameSizeY-(offset-20), i+offset, TSP_GA.frameSizeY-(200+offset+20));
            g.drawString(""+(i/10), offset-20-20, TSP_GA.frameSizeY-(i+offset)+5);
            g.drawLine(offset-20, TSP_GA.frameSizeY-(i+offset), 200+offset+20, TSP_GA.frameSizeY-(i+offset));
        }

        System.out.println("Drawing cities");
        for (int cityIndex = 0; cityIndex < TourManager.numberOfCities(); cityIndex++) {
            City city = TourManager.getCity(cityIndex);
            g.fillOval(city.getX()+Panneau.offset-5, TSP_GA.frameSizeY-(city.getY()+Panneau.offset+5), 10, 10);
        }

        g.setColor(Color.RED);

        System.out.println("Drawing tour: "+TSP_GA.bestTour.tourSize());
        boolean first = true;
        City fromCity = new City();
        City toCity   = new City();
        City firstCity= new City();

        for (int cityIndex=0; cityIndex < TSP_GA.bestTour.tourSize(); cityIndex++) {
            toCity = TSP_GA.bestTour.getCity(cityIndex);
            if(first == false) {
                //System.out.println("draw segment "+fromCity.getX()+":"+ fromCity.getY()+" to "+ toCity.getX()+":"+ toCity.getY());
                g.drawLine(fromCity.getX()+Panneau.offset, TSP_GA.frameSizeY-(fromCity.getY()+Panneau.offset), toCity.getX()+Panneau.offset, TSP_GA.frameSizeY-(toCity.getY()+Panneau.offset));
            } else {
                first = false;
                firstCity = toCity;
            }
            fromCity = toCity;
        }
        g.drawLine(fromCity.getX()+Panneau.offset, TSP_GA.frameSizeY-(fromCity.getY()+Panneau.offset), firstCity.getX()+Panneau.offset, TSP_GA.frameSizeY-(firstCity.getY()+Panneau.offset));
    }

}
