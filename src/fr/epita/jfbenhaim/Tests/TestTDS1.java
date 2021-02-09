package fr.epita.jfbenhaim.Tests;

import fr.epita.jfbenhaim.model.Centroid;
import fr.epita.jfbenhaim.model.Passenger;
import fr.epita.jfbenhaim.services.PassengerCSVDAO;
import fr.epita.jfbenhaim.services.PassengerDataService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestTDS1 {
    public static void test() throws IOException {
        List<Passenger> passengerList= PassengerCSVDAO.readAll();
        Map<Passenger.PassengerClass,Double> distributionPClass= PassengerDataService
                .calculatePClassDistribution(passengerList);
        System.out.println("Distribution of passengers per class: "+distributionPClass);

        Map<Integer,Centroid> Centroids= getSurvivedCentroids(passengerList);
        System.out.println("Typical surviving passenger: "+Centroids.get(1));
        System.out.println("Typical not surviving passenger: "+Centroids.get(0));
    }

    public static Map<Integer,Centroid> getSurvivedCentroids(List<Passenger> passengerList){
        // Create a Survivors and Deceased groups
        List<Passenger> Survivors= PassengerDataService.filterSurvived(passengerList,true);
        List<Passenger> Deceased= PassengerDataService.filterSurvived(passengerList,false);

        // Averages for the deceased group
        int averageAgeDeceased=PassengerDataService.averageAge(Deceased);
        Double averagePClassDeceased=PassengerDataService.averagePClass(Deceased);
        Double averageSexDeceased=PassengerDataService.averageSex(Deceased);


        // averages for the Survivors group
        int averageAgeSurvivors=PassengerDataService.averageAge(Survivors);
        Double averagePClassSurvivors=PassengerDataService.averagePClass(Survivors);
        Double averageSexSurvivors=PassengerDataService.averageSex(Survivors);


        // Create centroids and the map
        Centroid deceasedCentroid=new Centroid();
        Centroid survivorCentroid=new Centroid();
        deceasedCentroid.setAverageAge(averageAgeDeceased);
        deceasedCentroid.setAveragePclass(averagePClassDeceased);
        deceasedCentroid.setAverageSex(averageSexDeceased);
        survivorCentroid.setAverageAge(averageAgeSurvivors);
        survivorCentroid.setAveragePclass(averagePClassSurvivors);
        survivorCentroid.setAverageSex(averageSexSurvivors);

        Map<Integer,Centroid>  centroids= new HashMap<>();
        centroids.put(0,deceasedCentroid);
        centroids.put(1,survivorCentroid);

        return centroids;
    }
}
