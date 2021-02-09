package fr.epita.jfbenhaim.Tests;

import fr.epita.jfbenhaim.model.Passenger;
import fr.epita.jfbenhaim.services.PassengerCSVDAO;

import java.io.IOException;
import java.util.List;

public class TestSER3 {
    public static void test() throws IOException {
        List<Passenger> passengerList= PassengerCSVDAO.readAll();
        PassengerCSVDAO.writeAll(passengerList);

    }
}
