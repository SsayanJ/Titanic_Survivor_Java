package fr.epita.jfbenhaim.Tests;

import fr.epita.jfbenhaim.model.Passenger;
import fr.epita.jfbenhaim.services.PassengerCSVDAO;
import fr.epita.jfbenhaim.services.PassengerDataService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestTDS1 {
    public static void test() throws IOException {
        List<Passenger> passengerList= PassengerCSVDAO.readAll();
        Map<Passenger.PassengerClass,Double> distributionPClass= PassengerDataService
                .calculatePClassDistribution(passengerList);
        System.out.println("Distribution of passengers per class: "+distributionPClass);
        // Create a Survivors and Deceased groups
        List<Passenger> Survivors= PassengerDataService.filterSurvived(passengerList,true);
        List<Passenger> Deceased= PassengerDataService.filterSurvived(passengerList,false);
        int averageAgeDeceased=PassengerDataService.averageAge(Deceased);
        Double averagePClassDeceased=PassengerDataService.averagePClass(Deceased);
        Double averageSexDeceased=PassengerDataService.averageSex(Deceased);
        System.out.println("For the Deceased Group:");
        System.out.printf("Average age: "+averageAgeDeceased+"\nAverage PClass: "+
                averagePClassDeceased+"\nAverage Sex: "+averageSexDeceased+"\n");
        int averageAgeSurvivors=PassengerDataService.averageAge(Survivors);
        Double averagePClassSurvivors=PassengerDataService.averagePClass(Survivors);
        Double averageSexSurvivors=PassengerDataService.averageSex(Survivors);
        System.out.println("For the Survivors Group:");
        System.out.printf("Average age: "+averageAgeSurvivors+"\nAverage PClass: "+
                averagePClassSurvivors+"\nAverage Sex: "+averageSexSurvivors+"\n");
        Passenger deceasedCentroid=new Passenger();
        Passenger survivorCentroid=new Passenger();
        deceasedCentroid.setPassengerClass();

    }
}
