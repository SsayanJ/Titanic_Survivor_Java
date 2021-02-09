package fr.epita.jfbenhaim.main;


import fr.epita.jfbenhaim.Tests.*;
import fr.epita.jfbenhaim.model.Passenger;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        TestDMO2.test();
        TestSER1.test();
        TestSER2.test();
        TestSER3.test();
        TestBLI1.test();
        TestTDS1.test();


    }
}
