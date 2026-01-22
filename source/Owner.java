package source;

public abstract class Owner {
    protected int id;
    protected String name;
    protected double balance;
    protected int yearsRegistered;
    public Owner(int id, String name, double balance, int yearsRegistered) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.yearsRegistered = yearsRegistered;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public double getBalance() { return balance; }
    public int getYearsRegistered() { return yearsRegistered; }

    public abstract void performActivity(); // Replaces work()
    public abstract String getType(); // Replaces getRole()
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance + " KZT");
        System.out.println("Registered: " + yearsRegistered + " years");
    }
    @Override
    public String toString() {
        return "[" + getType() + "] " + name + " (ID: " + id + ")";
    }
}