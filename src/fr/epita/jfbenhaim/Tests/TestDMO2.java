package fr.epita.jfbenhaim.Tests;

import fr.epita.jfbenhaim.model.Passenger;


public class TestDMO2 {
    public static void test(){
        Passenger passenger=new Passenger();
        passenger.setName("Abbing, Mr Anthony");
        passenger.setSurvived("0");

        System.out.println(passenger);
    }
}
