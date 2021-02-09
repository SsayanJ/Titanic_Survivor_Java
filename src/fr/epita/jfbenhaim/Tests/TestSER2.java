package fr.epita.jfbenhaim.Tests;

import fr.epita.jfbenhaim.services.PassengerCSVDAO;

import java.io.IOException;

public class TestSER2 {
    public static void test() throws IOException {
        PassengerCSVDAO.readAll();
    }
}
