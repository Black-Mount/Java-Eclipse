package rental;

//Interface extending Vehicle with additional methods specific to motorcycles.
public interface MotorVehicle extends Vehicle {
 void setNumberOfWheels(int wheels); // Method to set the number of wheels on the motorcycle.
 int getNumberOfWheels(); // Method to get the number of wheels on the motorcycle.
 void setMotorcycleType(String type); // Method to set the type of motorcycle (sport, cruiser, off-road).
 String getMotorcycleType(); // Method to get the type of motorcycle.
}
