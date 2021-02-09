package fr.epita.jfbenhaim.Tests;

import fr.epita.jfbenhaim.model.Passenger;
import fr.epita.jfbenhaim.services.PassengerCSVDAO;

import java.io.IOException;
import java.util.List;

public class TestTDS3 {

    public static void test {
        try {
            List<Passenger> passengerList= PassengerCSVDAO.readAllPredictions();
            int TruePositive;
            int TrueNegative;
            int FalsePositive;
            int FalseNegative;
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
