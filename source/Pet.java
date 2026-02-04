package source;


public class Pet extends Owner {
    private int visitsCount;
    
    public Pet(int id, String name, double balance, int yearsRegistered, int visitsCount) {
        super(id, name, balance, yearsRegistered);
        setVisitsCount(visitsCount);
    }
    
    public int getVisitsCount() {
        return visitsCount;
    }
    
    public void setVisitsCount(int visitsCount) {
        if (visitsCount < 0) {
            throw new IllegalArgumentException("Visits count cannot be negative!");
        }
        this.visitsCount = visitsCount;
    }
    
    @Override
    public void performActivity() {
        System.out.println("Pet " + name + " is waiting for the doctor.");
    }
    @Override
    public String getType() {
        return "Pet";
    }
    public boolean isVIP() {
        return visitsCount > 50 && yearsRegistered >= 2;
    }
    @Override
    public String toString() {
        return super.toString() + " | Visits: " + visitsCount;
    }
}

