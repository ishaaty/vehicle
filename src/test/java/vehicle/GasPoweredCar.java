package vehicle;

abstract class GasPoweredCar extends Car {
    private double mpg;
    private double fuelLevel;
    private double fuelCapacity;

    public GasPoweredCar(String make, String model, double startingMileage, double mpg, double fuelCapacityGallons){
        super(make, model, startingMileage);
        this.mpg = mpg;
        this.fuelLevel = fuelCapacityGallons;
        this.fuelCapacity = fuelCapacityGallons;
    }

    public GasPoweredCar(String make, String model, double mpg, double fuelCapacityGallons){
        super(make, model, 0);
        // how to reduce this repetitive code?
        this.mpg = mpg;
        this.fuelLevel = fuelCapacityGallons;
        this.fuelCapacity = fuelCapacityGallons;
    }

    public void drive(double miles){
        if (miles < 0 || miles > this.getRemainingRange()){
            throw new IllegalArgumentException();
        }
        this.decreaseFuelLevel(miles);
        addMileage(miles);
    }

    public double getMPG(){
        return this.mpg;
    }

    public double getFuelLevel(){
        return this.fuelLevel;
    }

    public double getfuelCapacity(){
        return this.fuelCapacity;
    }

    public void refillTank(){
        this.fuelLevel = this.fuelCapacity;
    }

    public void refillTank(double gallons){
        if (gallons < 0 || this.fuelLevel + gallons > this.fuelCapacity){
            throw new IllegalArgumentException();
        }
        this.fuelLevel += gallons;
    }

    public double getRemainingRange(){
        return this.mpg * this.fuelLevel;
    }

    protected void decreaseFuelLevel(double miles){
        double usedFuel = miles / this.mpg;
        this.fuelLevel -= usedFuel;
    }
}
