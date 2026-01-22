package source;

public class Appointment implements Vaccination {
    private String serviceName;
    private double price;
    private String category;

    public Appointment(String serviceName, double price, String category) {
        this.serviceName = serviceName;
        this.price = price;
        this.category = category;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void performVaccination() {
        System.out.println("💉 Performing " + serviceName + "...");
        System.out.println("   Type: " + category);
        System.out.println("   Cost: " + price + " KZT");
        System.out.println("✅ Service complete!");
    }

    @Override
    public String getDetails() {
        return "Service: " + serviceName + " (" + category + ")";
    }

    @Override
    public String toString() {
        return serviceName + " - " + price + " KZT (" + category + ")";
    }
}