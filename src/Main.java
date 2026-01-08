import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Simple test objects
        Pet pet = new Pet("P1", "Barsik", "Cat", "White", "2021-03-10");
        Owner owner = new Owner("O1", "Zhanserik", "7777", "Astana", "aa@example.com");
        Veterinarian vet = new Veterinarian("V1", "Dr. Kim", "Therapy", "7701", "LIC1");
        Appointment appointment = new Appointment("A1", pet.getId(), owner.getId(), vet.getId(), "2025-01-01 10:00");
        Treatment treatment = new Treatment("T1", appointment.getId(), "Exam", "Basic exam", 15000);
        Vaccination vaccination = new Vaccination("VC1", pet.getId(), "Rabies", "2025-12-25", "2026-12-25");

        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("VET CLINIC SYSTEM");
            System.out.println("1. View Pet");
            System.out.println("2. View Owner");
            System.out.println("3. View Veterinarian");
            System.out.println("4. View Appointment");
            System.out.println("5. View Treatment");
            System.out.println("6. View Vaccination");
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
                    System.out.println("--- PET ---");
                    System.out.println(pet);
                    break;
                case 2:
                    System.out.println("--- OWNER ---");
                    System.out.println(owner);
                    break;
                case 3:
                    System.out.println("--- VETERINARIAN ---");
                    System.out.println(vet);
                    break;
                case 4:
                    System.out.println("--- APPOINTMENT ---");
                    System.out.println(appointment);
                    System.out.println("Is available: " + (appointment.isAvailable() ? "Yes" : "No"));
                    break;
                case 5:
                    System.out.println("--- TREATMENT ---");
                    System.out.println(treatment);
                    System.out.println("Is expensive: " + (treatment.isExpensive() ? "Yes" : "No"));
                    break;
                case 6:
                    System.out.println("--- VACCINATION ---");
                    System.out.println(vaccination);
                    System.out.println("Is vaccinated: " + (vaccination.isVaccinated() ? "Yes" : "No"));
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
}


