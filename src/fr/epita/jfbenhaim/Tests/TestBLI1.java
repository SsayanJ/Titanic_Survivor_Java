package fr.epita.jfbenhaim.Tests;

import fr.epita.jfbenhaim.model.Passenger;
import fr.epita.jfbenhaim.services.PassengerCSVDAO;
import fr.epita.jfbenhaim.services.PassengerDataService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestBLI1 {
    public static void test() throws IOException {
        List<Passenger> passengerList=PassengerCSVDAO.readAll();
        List<Passenger> filteredList= PassengerDataService.filterSurvived(passengerList,true);
        System.out.println(filteredList.size());
        int averageAge=PassengerDataService.averageAge(filteredList);
        System.out.println("The average age of the passengers who survived is: "+ averageAge);
        Map<String, Double> distribution=PassengerDataService.calculateAgeDistribution(passengerList);
        System.out.println(distribution);
        System.out.println("Number of passenger of the age 0: "+distribution.get("0"));
    }
}
