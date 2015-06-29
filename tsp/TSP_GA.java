/*
* TSP_GA.java
* Create a tour and evolve a solution
*/

package tsp;

import javax.swing.*;

public class TSP_GA {

    static Tour bestTour;

    static int frameSizeX = 500;
    static int frameSizeY = 500;

    static void drawFrame(Tour tour) {
        JFrame fenetre = new JFrame();
        //Définit un titre pour notre fenêtre
        fenetre.setTitle("Genetic Basic Algorythm");

        //Définit sa taille : 400 pixels de large et 100 pixels de haut
        fenetre.setSize(frameSizeX, frameSizeY);
        //Nous demandons maintenant à notre objet de se positionner au centre
        fenetre.setLocationRelativeTo(null);

        //Termine le processus lorsqu'on clique sur la croix rouge
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Et enfin, la rendre visible

        fenetre.setVisible(true);

        fenetre.setContentPane(new Panneau());

        bestTour = tour;
    }

    public static void main(String[] args) {

        // Create and add our cities
        City city = new City(60, 200);
        TourManager.addCity(city);
        City city2 = new City(180, 200);
        TourManager.addCity(city2);
        City city3 = new City(80, 180);
        TourManager.addCity(city3);
        City city4 = new City(140, 180);
        TourManager.addCity(city4);
        City city5 = new City(20, 160);
        TourManager.addCity(city5);
        City city6 = new City(100, 160);
        TourManager.addCity(city6);
        City city7 = new City(200, 160);
        TourManager.addCity(city7);
        City city8 = new City(140, 140);
        TourManager.addCity(city8);
        City city9 = new City(40, 120);
        TourManager.addCity(city9);
        City city10 = new City(100, 120);
        TourManager.addCity(city10);
        City city11 = new City(180, 100);
        TourManager.addCity(city11);
        City city12 = new City(60, 80);
        TourManager.addCity(city12);
        City city13 = new City(120, 80);
        TourManager.addCity(city13);
        City city14 = new City(180, 60);
        TourManager.addCity(city14);
        City city15 = new City(20, 40);
        TourManager.addCity(city15);
        City city16 = new City(100, 40);
        TourManager.addCity(city16);
        City city17 = new City(200, 40);
        TourManager.addCity(city17);
        City city18 = new City(20, 20);
        TourManager.addCity(city18);
        City city19 = new City(60, 20);
        TourManager.addCity(city19);
        City city20 = new City(160, 20);
        TourManager.addCity(city20);

        // Initialize population
        Population pop = new Population(50, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());

        // Evolve population for 100 generations
        pop = GA.evolvePopulation(pop);
        int nbIteration = 0;
        int nbIterationMax = 50000;
        boolean failed = false;
        do {
            nbIteration++;
            pop = GA.evolvePopulation(pop);
            if(nbIteration > nbIterationMax) {
                failed = true;
                break;
            }
        } while (pop.getFittest().getDistance() > 1100);

        if(failed) {
            System.out.println("I failed, sorry ....");
        } else {
            // Print final results
            System.out.println("Finished in " + nbIteration + " iterations");
            System.out.println("Final distance: " + pop.getFittest().getDistance());
            System.out.println("Solution:");
            System.out.println(pop.getFittest());
            drawFrame(pop.getFittest());
        }
    }
}