package rental;

//Interface extending Vehicle with additional methods specific to cars.
public interface CarVehicle extends Vehicle {
 void setNumberOfDoors(int doors); // Method to set the number of doors in the car.
 int getNumberOfDoors(); // Method to get the number of doors in the car.
 void setFuelType(String fuelType); // Method to set the fuel type of the car.
 String getFuelType(); // Method to get the fuel type of the car.
}
