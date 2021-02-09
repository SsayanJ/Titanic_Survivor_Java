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

    public Passenger() {
        this.name = name;
        this.passengerClass = passengerClass;
        this.age = age;
        this.sex = sex;
        this.survived = survived;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PassengerClass getPassengerClass() {
        return passengerClass;
    }

    public void setPassengerClass(String passengerClass) {
        if (passengerClass.equals("1st")){
            this.passengerClass = PassengerClass.first;
        } else if (passengerClass.equals("2nd")){
            this.passengerClass = PassengerClass.second;
        } else if (passengerClass.equals("3rd")){
            this.passengerClass = PassengerClass.third;
        } else{
            this.passengerClass=null;
        }
    }

    public Double getAge() {
        return age;
    }

    public void setAge(String age) {
        if (age.equals("")){
            // if no age is available, -1 is used to avoid issue during sorting while knowing the value was empty
            this.age=-1.0;
        } else {
            this.age = Double.parseDouble(age);
        }

    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(String sex) {
        if (sex.equals("male")){
            this.sex = Sex.male;
        } else if (sex.equals("female")){
            this.sex = Sex.female;
        } else{
            this.sex=null;
        }
    }

    public Boolean getSurvived() {
        return survived;
    }

    public void setSurvived(String survived) {
        if (survived.equals("1")){
            this.survived=true;
        } else {
            this.survived = false;
        }

    }

    @Override
    public String toString() {
        return "Passenger [" +
                "name='" + name + '\'' +
                ", survived=" + survived +
                ']';
    }
}
