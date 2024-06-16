package rental;

//Interface extending Vehicle with additional methods specific to trucks.
public interface TruckVehicle extends Vehicle {
 void setCargoCapacity(double capacity); // Method to set the cargo capacity of the truck (in tons).
 double getCargoCapacity(); // Method to get the cargo capacity of the truck (in tons).
 void setTransmissionType(String type); // Method to set the transmission type of the truck (manual, automatic).
 String getTransmissionType(); // Method to get the transmission type of the truck.
}
