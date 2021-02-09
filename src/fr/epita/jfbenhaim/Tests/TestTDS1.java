package fr.epita.jfbenhaim.Tests;

import fr.epita.jfbenhaim.model.Centroid;
import fr.epita.jfbenhaim.model.Passenger;
import fr.epita.jfbenhaim.services.PassengerCSVDAO;
import fr.epita.jfbenhaim.services.PassengerDataService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestTDS1 {
    public static void test() throws IOException {
        List<Passenger> passengerList= PassengerCSVDAO.readAll();
        Map<Passenger.PassengerClass,Double> distributionPClass= PassengerDataService
                .calculatePClassDistribution(passengerList);
        System.out.println("Distribution of passengers per class: "+distributionPClass);

        Map<Integer,Centroid> Centroids= PassengerDataService.getSurvivedCentroids(passengerList);
        System.out.println("Typical surviving passenger: "+Centroids.get(1));
        System.out.println("Typical not surviving passenger: "+Centroids.get(0));
    }

}
