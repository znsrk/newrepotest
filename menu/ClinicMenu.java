package menu;
import source.*;
import java.util.ArrayList;
import java.util.Scanner;
public class ClinicMenu implements Menu{
    private ArrayList<Owner> allEntities;
    private ArrayList<Appointment> allServices;
    private Scanner scanner;

    public ClinicMenu() {
        this.allEntities = new ArrayList<>();
        this.allServices = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        // test data
        try {
            allEntities.add(new Veterinarian(101, "Dr. Smith", 500000, 15, "Surgery"));
            allEntities.add(new Pet(201, "Rex", 0, 3, 12));

            allServices.add(new Appointment("Rabies Shot", 5000, "Vaccine"));
            allServices.add(new Appointment("General Checkup", 3000, "Consultation"));
            allServices.add(new Appointment("Grooming", 7000, "Hygiene"));
        } catch (Exception e) {
            System.out.println("Error initializing data.");
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("    VET CLINIC MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Veterinarian");
        System.out.println("2. Add Pet");
        System.out.println("3. View All Entities");
        System.out.println("4. View Veterinarians Only");
        System.out.println("5. View Pets Only");
        System.out.println("6. Clinic Activity (Polymorphism)");
        System.out.println("7. Add Service/Appointment");
        System.out.println("8. View All Services");
        System.out.println("9. Perform Vaccination/Service");
        System.out.println("0. Exit");
        System.out.println("========================================");
    }

    @Override
    public void run(){
        boolean running = true;
        while (running){
            displayMenu();
            System.out.println("Choice");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){
                    case 1: addVeterinarian(); break;
                    case 2: addPet(); break;
                    case 3: viewAllEntities(); break;
                    case 4: viewVeterinarians(); break;
                    case 5: viewPets(); break;
                    case 6: demonstratePolymorphism(); break;
                    case 7: addService(); break;
                    case 8: viewAllServices(); break;
                    case 9: performService(); break;
                    case 0:
                        running = false;
                        System.out.println("Bye");
                        break;
                    default: System.out.println("Wrong choice");
                }
            }catch (Exception exc){
                System.out.println("Error: Invalid input.");
                scanner.nextLine();
            }
        }
    }
    private void addVeterinarian(){
        System.out.println("ID: "); int id = scanner.nextInt(); scanner.nextLine();
        System.out.println("Name: "); String name = scanner.nextLine();
        System.out.println("Salary: "); int salary = scanner.nextInt(); scanner.nextLine();
        System.out.println("Experience (Years): "); int experience = scanner.nextInt(); scanner.nextLine();
        System.out.println("Specialization: "); String specialization = scanner.nextLine();

        allEntities.add(new Veterinarian(id, name, salary, experience, specialization));
        System.out.println("Added");
    }
    private void addPet() {
        System.out.println("\n Add Pet ");
        try {
            System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
            System.out.print("Name: "); String name = scanner.nextLine();
            System.out.print("Balance/Credit: "); double bal = scanner.nextDouble(); scanner.nextLine();
            System.out.print("Years Registered: "); int years = scanner.nextInt(); scanner.nextLine();
            System.out.print("Total Visits: "); int visits = scanner.nextInt(); scanner.nextLine();

            allEntities.add(new Pet(id, name, bal, years, visits));
            System.out.println("Pet added!");
        } catch (Exception e) {
            System.out.println("Input Error.");
            scanner.nextLine();
        }
    }

    private void viewVeterinarians() {
        System.out.println("\n--- Veterinarians ---");
        for (Owner o : allEntities) {
            if (o instanceof Veterinarian) System.out.println(o);
        }
    }

    private void viewAllEntities(){
        System.out.println("\nAll Vets");
        for(Owner o : allEntities){
            if(o instanceof Veterinarian) System.out.println(o);
        }

    }
    private void viewPets(){
        for (Owner o : allEntities){
            if(o instanceof Pet) System.out.println(o);
        }
    }
    private void demonstratePolymorphism(){
        System.out.println("Clinic activity");
        for (Owner o : allEntities){
            o.performActivity();
        }
    }
    private void addService(){

        try{
            System.out.println();
            String name = scanner.nextLine();
            double price = scanner.nextInt(); scanner.nextLine();
            String cat = scanner.nextLine();
            allServices.add(new Appointment(name, price, cat));

        }   catch (Exception e){
            System.out.println("Error");
            scanner.nextLine();
        }
    }
    private void viewAllServices() {
        System.out.println("\n--- Available Services ---");
        for (int i = 1; i < allServices.size() + 1; i++) {
            System.out.println(allServices.get(i));
        }
    }
    private void performService() {
        System.out.println("\n--- Perform Service ---");
        if (allServices.isEmpty()) {
            System.out.println("No services available.");
            return;
        }
        viewAllServices();
        System.out.print("Select service number: ");
        try {
            int choice = scanner.nextInt();
            if (choice > 0 && choice <= allServices.size()) {
                allServices.get(choice - 1).performVaccination();
            } else {
                System.out.println("Invalid number.");
            }
        } catch (Exception e) {
            System.out.println("Error.");
            scanner.nextLine();
        }
    }
}