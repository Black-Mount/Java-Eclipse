package rental;

//Class implementing MotorVehicle interface with concrete implementations of its methods.
public class Motorcycle implements MotorVehicle {
 private String make; // Make of the motorcycle.
 private String model; // Model of the motorcycle.
 private int yearOfManufacture; // Year the motorcycle was manufactured.
 private int numberOfWheels; // Number of wheels on the motorcycle.
 private String motorcycleType; // Type of motorcycle (sport, cruiser, off-road).

 // Constructor to initialize basic motorcycle details.
 public Motorcycle(String make, String model, int yearOfManufacture) {
     this.make = make;
     this.model = model;
     this.yearOfManufacture = yearOfManufacture;
 }

 @Override
 public String getMake() {
     return make; // Return the make of the motorcycle.
 }

 @Override
 public String getModel() {
     return model; // Return the model of the motorcycle.
 }

 @Override
 public int getYearOfManufacture() {
     return yearOfManufacture; // Return the year the motorcycle was manufactured.
 }

 @Override
 public void setNumberOfWheels(int wheels) {
     this.numberOfWheels = wheels; // Set the number of wheels on the motorcycle.
 }

 @Override
 public int getNumberOfWheels() {
     return numberOfWheels; // Return the number of wheels on the motorcycle.
 }

 @Override
 public void setMotorcycleType(String type) {
     this.motorcycleType = type; // Set the type of motorcycle.
 }

 @Override
 public String getMotorcycleType() {
     return motorcycleType; // Return the type of motorcycle.
 }
}
