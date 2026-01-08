package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lists to store many objects
        List<Pet> pets = new ArrayList<>();
        List<Owner> owners = new ArrayList<>();
        List<Veterinarian> vets = new ArrayList<>();
        List<Appointment> appointments = new ArrayList<>();
        List<Treatment> treatments = new ArrayList<>();
        List<Vaccination> vaccinations = new ArrayList<>();

        // Optional: one initial sample object (like you had)
        pets.add(new Pet("P1", "Barsik", "Cat", "White", "2021-03-10"));
        owners.add(new Owner("O1", "Zhanserik", "7777", "Astana", "aa@example.com"));
        vets.add(new Veterinarian("V1", "Dr. Kim", "Therapy", "7701", "LIC1"));

        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("VET CLINIC SYSTEM");
            System.out.println("1. Add Pet");
            System.out.println("2. Add Owner");
            System.out.println("3. View Pets");
            System.out.println("4. View Owners");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    addPet(scanner, pets);
                    break;
                case 2:
                    addOwner(scanner, owners);
                    break;
                case 3:
                    viewPets(pets);
                    break;
                case 4:
                    viewOwners(owners);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            if (running) {
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void addPet(Scanner scanner, List<Pet> pets) {
        System.out.println("--- ADD PET ---");
        System.out.print("Enter pet id: ");
        String id = scanner.nextLine();
        System.out.print("Enter pet name: ");
        String name = scanner.nextLine();
        System.out.print("Enter species: ");
        String species = scanner.nextLine();
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();

        Pet pet = new Pet(id, name, species, color, dob);
        pets.add(pet);
        System.out.println("Pet added: " + pet);
    }

    private static void addOwner(Scanner scanner, List<Owner> owners) {
        System.out.println("--- ADD OWNER ---");
        System.out.print("Enter owner id: ");
        String id = scanner.nextLine();
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Owner owner = new Owner(id, fullName, phone, address, email);
        owners.add(owner);
        System.out.println("Owner added: " + owner);
    }

    private static void viewPets(List<Pet> pets) {
        System.out.println("--- PETS ---");
        if (pets.isEmpty()) {
            System.out.println("No pets.");
            return;
        }
        for (Pet p : pets) {
            System.out.println(p);
        }
    }

    private static void viewOwners(List<Owner> owners) {
        System.out.println("--- OWNERS ---");
        if (owners.isEmpty()) {
            System.out.println("No owners.");
            return;
        }
        for (Owner o : owners) {
            System.out.println(o);
        }
    }
}


