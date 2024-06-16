package rental;

import java.util.InputMismatchException;
import java.util.Scanner;

// Main class to interact with the user and manage vehicle information.
public class VehicleInformationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a scanner for user input.

        boolean continueRunning = true; // Flag to control the loop.

        while (continueRunning) {
            try {
                // Prompt user to choose a vehicle type.
                System.out.println("Choose a vehicle type: 1. Car 2. Motorcycle 3. Truck");
                int choice = scanner.nextInt(); // Read the user's choice.
                scanner.nextLine(); // Consume newline left-over.

                // Handle user choice and create respective vehicle objects.
                switch (choice) {
                    case 1:
                        // Create a Car object and prompt user for car-specific details.
                        Car car = new Car("Toyota", "Corolla", 2020);
                        System.out.println("Enter number of doors: ");
                        car.setNumberOfDoors(scanner.nextInt()); // Set the number of doors.
                        scanner.nextLine(); // Consume newline left-over.
                        System.out.println("Enter fuel type (petrol, diesel, electric): ");
                        car.setFuelType(scanner.nextLine()); // Set the fuel type.

                        // Display car details.
                        System.out.println("Car Details:");
                        System.out.println("Make: " + car.getMake());
                        System.out.println("Model: " + car.getModel());
                        System.out.println("Year: " + car.getYearOfManufacture());
                        System.out.println("Doors: " + car.getNumberOfDoors());
                        System.out.println("Fuel Type: " + car.getFuelType());
                        break;

                    case 2:
                        // Create a Motorcycle object and prompt user for motorcycle-specific details.
                        Motorcycle motorcycle = new Motorcycle("Yamaha", "YZF-R3", 2019);
                        System.out.println("Enter number of wheels: ");
                        motorcycle.setNumberOfWheels(scanner.nextInt()); // Set the number of wheels.
                        scanner.nextLine(); // Consume newline left-over.
                        System.out.println("Enter motorcycle type (sport, cruiser, off-road): ");
                        motorcycle.setMotorcycleType(scanner.nextLine()); // Set the motorcycle type.

                        // Display motorcycle details.
                        System.out.println("Motorcycle Details:");
                        System.out.println("Make: " + motorcycle.getMake());
                        System.out.println("Model: " + motorcycle.getModel());
                        System.out.println("Year: " + motorcycle.getYearOfManufacture());
                        System.out.println("Wheels: " + motorcycle.getNumberOfWheels());
                        System.out.println("Type: " + motorcycle.getMotorcycleType());
                        break;

                    case 3:
                        // Create a Truck object and prompt user for truck-specific details.
                        Truck truck = new Truck("Volvo", "FH16", 2021);
                        System.out.println("Enter cargo capacity (in tons): ");
                        truck.setCargoCapacity(scanner.nextDouble()); // Set the cargo capacity.
                        scanner.nextLine(); // Consume newline left-over.
                        System.out.println("Enter transmission type (manual, automatic): ");
                        truck.setTransmissionType(scanner.nextLine()); // Set the transmission type.

                        // Display truck details.
                        System.out.println("Truck Details:");
                        System.out.println("Make: " + truck.getMake());
                        System.out.println("Model: " + truck.getModel());
                        System.out.println("Year: " + truck.getYearOfManufacture());
                        System.out.println("Cargo Capacity: " + truck.getCargoCapacity());
                        System.out.println("Transmission Type: " + truck.getTransmissionType());
                        break;

                    default:
                        // Handle invalid choice.
                        System.out.println("Invalid choice. Please choose 1, 2, or 3.");
                }
            } catch (InputMismatchException e) {
                // Handle invalid input type.
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input.
            }

            // Ask user if they want to enter details for another vehicle.
            System.out.println("Do you want to enter details for another vehicle? (yes/no)");
            String userResponse = scanner.nextLine().trim().toLowerCase();

            // Check the user's response.
            if (!userResponse.equals("yes")) {
                continueRunning = false; // Exit the loop if the user does not want to continue.
            }
        }

        System.out.println("Thank you for using the Vehicle Information System. Goodbye!"); // Final message.
        scanner.close(); // Close the scanner to avoid resource leaks.
    }
}
