package source;


public class Veterinarian extends Owner {
    private String specialization;

    public Veterinarian(int id, String name, double salary, int yearsExperience, String specialization) {
        super(id, name, salary, yearsExperience);
        this.specialization = specialization;
    }
    public String getSpecialization() {
        return specialization;
    }
    @Override
    public void performActivity() {
        System.out.println("Dr. " + name + " is treating patients in " + specialization + ".");
    }
    @Override
    public String getType() {
        return "Veterinarian";
    }
    public boolean isSeniorVet() {
        return yearsRegistered >= 10; // Using yearsRegistered as Experience
    }
    @Override
    public String toString() {
        String star = isSeniorVet() ? "SENIOR VET" : "";
        return super.toString() + " | Spec: " + specialization + " " + star;
    }
}