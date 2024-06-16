package rental;

//Class implementing CarVehicle interface with concrete implementations of its methods.
public class Car implements CarVehicle {
 private String make; // Make of the car.
 private String model; // Model of the car.
 private int yearOfManufacture; // Year the car was manufactured.
 private int numberOfDoors; // Number of doors in the car.
 private String fuelType; // Fuel type of the car.
//Test
 // Constructor to initialize basic car details.
 public Car(String make, String model, int yearOfManufacture) {
     this.make = make;
     this.model = model;
     this.yearOfManufacture = yearOfManufacture;
 }

 @Override
 public String getMake() {
     return make; // Return the make of the car.
 }

 @Override
 public String getModel() {
     return model; // Return the model of the car.
 }

 @Override
 public int getYearOfManufacture() {
     return yearOfManufacture; // Return the year the car was manufactured.
 }

 @Override
 public void setNumberOfDoors(int doors) {
     this.numberOfDoors = doors; // Set the number of doors in the car.
 }

 @Override
 public int getNumberOfDoors() {
     return numberOfDoors; // Return the number of doors in the car.
 }

 @Override
 public void setFuelType(String fuelType) {
     this.fuelType = fuelType; // Set the fuel type of the car.
 }

 @Override
 public String getFuelType() {
     return fuelType; // Return the fuel type of the car.
 }
}
