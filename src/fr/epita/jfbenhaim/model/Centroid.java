package fr.epita.jfbenhaim.model;

public class Centroid {

    private int averageAge;
    private double averagePclass;
    private double averageSex;

    @Override
    public String toString() {
        return
                "PClass=" + averagePclass +
                ", Sex=" + averageSex +
                ", Age=" + averageAge ;
    }

    public int getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(int averageAge) {
        this.averageAge = averageAge;
    }

    public double getAveragePclass() {
        return averagePclass;
    }

    public void setAveragePclass(double averagePclass) {
        this.averagePclass = averagePclass;
    }

    public double getAverageSex() {
        return averageSex;
    }

    public void setAverageSex(double averageSex) {
        this.averageSex = averageSex;
    }
}
