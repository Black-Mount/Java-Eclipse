package rental;

//Class implementing TruckVehicle interface with concrete implementations of its methods.
public class Truck implements TruckVehicle {
 private String make; // Make of the truck.
 private String model; // Model of the truck.
 private int yearOfManufacture; // Year the truck was manufactured.
 private double cargoCapacity; // Cargo capacity of the truck (in tons).
 private String transmissionType; // Transmission type of the truck (manual, automatic).

 // Constructor to initialize basic truck details.
 public Truck(String make, String model, int yearOfManufacture) {
     this.make = make;
     this.model = model;
     this.yearOfManufacture = yearOfManufacture;
 }

 @Override
 public String getMake() {
     return make; // Return the make of the truck.
 }

 @Override
 public String getModel() {
     return model; // Return the model of the truck.
 }

 @Override
 public int getYearOfManufacture() {
     return yearOfManufacture; // Return the year the truck was manufactured.
 }

 @Override
 public void setCargoCapacity(double capacity) {
     this.cargoCapacity = capacity; // Set the cargo capacity of the truck (in tons).
 }

 @Override
 public double getCargoCapacity() {
     return cargoCapacity; // Return the cargo capacity of the truck (in tons).
 }

 @Override
 public void setTransmissionType(String type) {
     this.transmissionType = type; // Set the transmission type of the truck (manual, automatic).
 }

 @Override
 public String getTransmissionType() {
     return transmissionType; // Return the transmission type of the truck.
 }
}
