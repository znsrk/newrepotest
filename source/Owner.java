package source;

public abstract class Owner {
    protected int id;
    protected String name;
    protected double balance;
    protected int yearsRegistered;
    
    public Owner(int id, String name, double balance, int yearsRegistered) {
        setId(id);
        setName(name);
        setBalance(balance);
        setYearsRegistered(yearsRegistered);
    }
    
    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getBalance() { return balance; }
    public int getYearsRegistered() { return yearsRegistered; }
    
    // Setters with exception handling
    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive!");
        }
        this.id = id;
    }
    
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        this.name = name;
    }
    
    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative!");
        }
        this.balance = balance;
    }
    
    public void setYearsRegistered(int yearsRegistered) {
        if (yearsRegistered < 0) {
            throw new IllegalArgumentException("Years registered cannot be negative!");
        }
        this.yearsRegistered = yearsRegistered;
    }

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