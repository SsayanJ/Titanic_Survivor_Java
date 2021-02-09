package fr.epita.jfbenhaim.main;


import fr.epita.jfbenhaim.Test.TestDMO2;
import fr.epita.jfbenhaim.Test.TestSER1;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        TestDMO2.test();
        TestSER1.test();
    }
}
