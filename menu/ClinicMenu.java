package menu;

import source.PetDAO;
import source.VeterinarianDAO;
import source.DatabaseConnection;
import source.*;

import java.util.List;
import java.util.Scanner;

public class ClinicMenu implements Menu {
    private VeterinarianDAO vetDAO;
    private PetDAO petDAO;
    private Scanner scanner;

    public ClinicMenu() {
        this.vetDAO = new VeterinarianDAO();
        this.petDAO = new PetDAO();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("    VET CLINIC MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1.  Add Veterinarian");
        System.out.println("2.  Add Pet");
        System.out.println("3.  View All Veterinarians");
        System.out.println("4.  View All Pets");
        System.out.println("5.  Update Veterinarian");
        System.out.println("6.  Update Pet");
        System.out.println("7.  Delete Veterinarian");
        System.out.println("8.  Delete Pet");
        System.out.println("9.  Search Veterinarian by Name");
        System.out.println("10. Search Pet by Name");
        System.out.println("11. Search Vet by Experience");
        System.out.println("12. Search Pet by Visits");
        System.out.println("13. Clinic Activity (Polymorphism)");
        System.out.println("0.  Exit");
        System.out.println("========================================");
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: addVeterinarian(); break;
                    case 2: addPet(); break;
                    case 3: viewAllVeterinarians(); break;
                    case 4: viewAllPets(); break;
                    case 5: updateVeterinarian(); break;
                    case 6: updatePet(); break;
                    case 7: deleteVeterinarian(); break;
                    case 8: deletePet(); break;
                    case 9: searchVetByName(); break;
                    case 10: searchPetByName(); break;
                    case 11: searchVetByExperience(); break;
                    case 12: searchPetByVisits(); break;
                    case 13: demonstratePolymorphism(); break;
                    case 0:
                        running = false;
                        DatabaseConnection.closeConnection();
                        System.out.println("Goodbye!");
                        break;
                    default: System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input.");
                scanner.nextLine();
            }
        }
    }

    private void addVeterinarian() {
        System.out.println("\n--- Add Veterinarian ---");
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Years of Experience: ");
            int experience = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Specialization: ");
            String spec = scanner.nextLine();

            Veterinarian vet = new Veterinarian(id, name, salary, experience, spec);
            vetDAO.insert(vet);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Input Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private void addPet() {
        System.out.println("\n--- Add Pet ---");
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Years Registered: ");
            int years = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Total Visits: ");
            int visits = scanner.nextInt();
            scanner.nextLine();

            Pet pet = new Pet(id, name, balance, years, visits);
            petDAO.insert(pet);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Input Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private void viewAllVeterinarians() {
        System.out.println("\n--- All Veterinarians ---");
        List<Veterinarian> vets = vetDAO.getAll();
        if (vets.isEmpty()) {
            System.out.println("No veterinarians found.");
        } else {
            for (Veterinarian vet : vets) {
                System.out.println(vet);
            }
        }
    }

    private void viewAllPets() {
        System.out.println("\n--- All Pets ---");
        List<Pet> pets = petDAO.getAll();
        if (pets.isEmpty()) {
            System.out.println("No pets found.");
        } else {
            for (Pet pet : pets) {
                System.out.println(pet);
            }
        }
    }

    private void updateVeterinarian() {
        System.out.println("\n--- Update Veterinarian ---");
        try {
            System.out.print("Enter Veterinarian ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Veterinarian vet = vetDAO.getById(id);
            if (vet == null) {
                System.out.println("Veterinarian not found!");
                return;
            }

            System.out.println("Current: " + vet);
            System.out.print("New Name (or press Enter to keep): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) vet.setName(name);

            System.out.print("New Salary (or 0 to keep): ");
            double salary = scanner.nextDouble();
            scanner.nextLine();
            if (salary > 0) vet.setBalance(salary);

            System.out.print("New Specialization (or press Enter to keep): ");
            String spec = scanner.nextLine();
            if (!spec.isEmpty()) vet.setSpecialization(spec);

            vetDAO.update(vet);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private void updatePet() {
        System.out.println("\n--- Update Pet ---");
        try {
            System.out.print("Enter Pet ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Pet pet = petDAO.getById(id);
            if (pet == null) {
                System.out.println("Pet not found!");
                return;
            }

            System.out.println("Current: " + pet);
            System.out.print("New Name (or press Enter to keep): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) pet.setName(name);

            System.out.print("New Balance (or -1 to keep): ");
            double balance = scanner.nextDouble();
            scanner.nextLine();
            if (balance >= 0) pet.setBalance(balance);

            System.out.print("New Visits Count (or -1 to keep): ");
            int visits = scanner.nextInt();
            scanner.nextLine();
            if (visits >= 0) pet.setVisitsCount(visits);

            petDAO.update(pet);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private void deleteVeterinarian() {
        System.out.println("\n--- Delete Veterinarian ---");
        try {
            System.out.print("Enter Veterinarian ID to delete: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Veterinarian vet = vetDAO.getById(id);
            if (vet == null) {
                System.out.println("Veterinarian not found!");
                return;
            }

            System.out.println("Found: " + vet);
            System.out.print("Are you sure you want to delete? (yes/no): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("yes")) {
                vetDAO.delete(id);
            } else {
                System.out.println("Deletion cancelled.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private void deletePet() {
        System.out.println("\n--- Delete Pet ---");
        try {
            System.out.print("Enter Pet ID to delete: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Pet pet = petDAO.getById(id);
            if (pet == null) {
                System.out.println("Pet not found!");
                return;
            }

            System.out.println("Found: " + pet);
            System.out.print("Are you sure you want to delete? (yes/no): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("yes")) {
                petDAO.delete(id);
            } else {
                System.out.println("Deletion cancelled.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private void searchVetByName() {
        System.out.println("\n--- Search Veterinarian by Name ---");
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        List<Veterinarian> results = vetDAO.searchByName(name);
        if (results.isEmpty()) {
            System.out.println("No veterinarians found matching '" + name + "'");
        } else {
            System.out.println("Found " + results.size() + " result(s):");
            for (Veterinarian vet : results) {
                System.out.println(vet);
            }
        }
    }

    private void searchPetByName() {
        System.out.println("\n--- Search Pet by Name ---");
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        List<Pet> results = petDAO.searchByName(name);
        if (results.isEmpty()) {
            System.out.println("No pets found matching '" + name + "'");
        } else {
            System.out.println("Found " + results.size() + " result(s):");
            for (Pet pet : results) {
                System.out.println(pet);
            }
        }
    }

    private void searchVetByExperience() {
        System.out.println("\n--- Search Veterinarian by Experience ---");
        System.out.print("Minimum years of experience: ");
        int years = scanner.nextInt();
        scanner.nextLine();

        List<Veterinarian> results = vetDAO.searchByExperience(years);
        if (results.isEmpty()) {
            System.out.println("No veterinarians found with " + years + "+ years experience.");
        } else {
            System.out.println("Found " + results.size() + " result(s):");
            for (Veterinarian vet : results) {
                System.out.println(vet);
            }
        }
    }

    private void searchPetByVisits() {
        System.out.println("\n--- Search Pet by Visits ---");
        System.out.print("Minimum number of visits: ");
        int visits = scanner.nextInt();
        scanner.nextLine();

        List<Pet> results = petDAO.searchByVisits(visits);
        if (results.isEmpty()) {
            System.out.println("No pets found with " + visits + "+ visits.");
        } else {
            System.out.println("Found " + results.size() + " result(s):");
            for (Pet pet : results) {
                System.out.println(pet);
            }
        }
    }

    private void demonstratePolymorphism() {
        System.out.println("\n--- Clinic Activity (Polymorphism Demo) ---");
        
        List<Veterinarian> vets = vetDAO.getAll();
        List<Pet> pets = petDAO.getAll();

        if (vets.isEmpty() && pets.isEmpty()) {
            System.out.println("No entities in the database.");
            return;
        }

        for (Veterinarian vet : vets) {
            vet.performActivity();
        }
        for (Pet pet : pets) {
            pet.performActivity();
        }
    }
}
