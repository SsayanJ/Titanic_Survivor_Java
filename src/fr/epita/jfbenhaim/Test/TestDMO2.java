package fr.epita.jfbenhaim.Test;

import fr.epita.jfbenhaim.model.Passenger;


public class TestDMO2 {
    public static void test(){
        Passenger passenger=new Passenger("Abbing, Mr Anthony",
                Passenger.PassengerClass.first,30.0, Passenger.Sex.male,true);
        System.out.println(passenger);
    }
}
