package fr.epita.jfbenhaim.model;


public class Passenger {
    public enum PassengerClass{
    first,second,third
    }
    public enum Sex{
        male,female
    }
    private String name;
    private PassengerClass passengerClass;
    private Double age;
    private Sex sex;
    private Boolean survived;

    public Passenger(String name, PassengerClass    passengerClass, Double age, Sex sex, Boolean survived) {
        this.name = name;
        this.passengerClass = passengerClass;
        this.age = age;
        this.sex = sex;
        this.survived = survived;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", passengerClass=" + passengerClass +
                ", age=" + age +
                ", sex=" + sex +
                ", survived=" + survived +
                '}';
    }
}
