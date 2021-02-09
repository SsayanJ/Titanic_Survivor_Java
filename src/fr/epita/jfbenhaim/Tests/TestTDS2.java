package fr.epita.jfbenhaim.Tests;

import fr.epita.jfbenhaim.model.Passenger;
import fr.epita.jfbenhaim.services.PassengerCSVDAO;

import java.io.IOException;
import java.util.List;

public class TestTDS2 {

    public static void test() throws IOException {
        List<Passenger> passengerList= PassengerCSVDAO.readAll();
        for (Passenger passenger:passengerList){
            Double currAge=passenger.getAge();
            Double currPClass=passenger.PClassToDouble();
            Double currSex=passenger.SexToDouble();
            distance 

        }
    }
}
