package fr.epita.jfbenhaim.main;


import fr.epita.jfbenhaim.Tests.*;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        TestDMO2.test();
        TestSER1.test();
        TestSER2.test();
        TestSER3.test();
        TestBLI1.test();
    }
}
