public class Treatment {
    private String id;
    private String appointmentId;
    private String name;
    private String description;
    private int cost;

    public Treatment(String id, String appointmentId, String name, String description, int cost) {
        setId(id);
        setAppointmentId(appointmentId);
        setName(name);
        setDescription(description);
        setCost(cost);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            System.out.println("Warning: Treatment id cannot be empty.");
            this.id = "UNKNOWN";
        }
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        if (appointmentId != null && !appointmentId.trim().isEmpty()) {
            this.appointmentId = appointmentId;
        } else {
            System.out.println("Warning: Appointment id cannot be empty.");
            this.appointmentId = "UNKNOWN";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Warning: Treatment name cannot be empty.");
            this.name = "Unknown";
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null && !description.trim().isEmpty()) {
            this.description = description;
        } else {
            System.out.println("Warning: Description cannot be empty.");
            this.description = "No description";
        }
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if (cost >= 0) {
            this.cost = cost;
        } else {
            System.out.println("Warning: Cost cannot be negative.");
            this.cost = 0;
        }
    }

    public boolean isExpensive() {
        return cost > 20000;
    }

    @Override
    public String toString() {
        return "Treatment{id='" + id + '\'' +
                ", appointmentId='" + appointmentId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
