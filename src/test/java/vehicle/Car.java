package vehicle;

import java.util.List;

abstract class Car {
    private String make;
    private String model;
    private double mileage;


    public Car(String make, String model, double startingMileage){
        this.make = make;
        this.model = model;
        this.mileage = startingMileage;
    }

    public Car(String make, String model){
        this(make, model, 0);
    }

    public  boolean canDrive(double miles){
        if (miles < 0){
            throw new IllegalArgumentException();
        }

        if (getRemainingRange() >= miles){
            return true;
        }
        return false;
    };

    public abstract void drive(double miles);

    public String toString(){
        return "<" + this.make + " and " + this.model + ">" + " (<" + this.mileage + "> mi)";
    }

    public double getMileage(){
        return this.mileage;
    }

    public String getMake(){
        return this.make;
    }

    public String getModel(){
        return this.model;
    }

    public abstract double getRemainingRange();

    protected void addMileage(double miles){
        if (miles < 0){
            throw new IllegalArgumentException();
        }
        this.mileage += miles;

    }

    public int roadTrip(List<Double> milesEachDay){
        int sum = 0;
        for (int i = 0; i < milesEachDay.size(); i++){
            if (milesEachDay.get(i) < 0){
                throw new IllegalArgumentException();
            }
            sum += milesEachDay.get(i);
            if (sum > getRemainingRange()){
                return i;
            }
        }
        return milesEachDay.size();
    }

}
