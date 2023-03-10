package vehicle;

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
        return "<" + make + " and " + model + ">" + " (<" + mileage + "> mi)";
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
        for (int i = 0; i < milesEachDay.length; i++){
            if (milesEachDay[i] < 0){
                throw new IllegalArgumentException();
            }
            sum += milesEachDay[i];
            if (sum > getRemainingRange()){
                return i;
            }
        }
    }

}
