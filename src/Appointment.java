package src;
public class Appointment {
    private String id;
    private String petId;
    private String ownerId;
    private String vetId;
    private String dateTime;

    public Appointment(String id, String petId, String ownerId, String vetId, String dateTime) {
        setId(id);
        setPetId(petId);
        setOwnerId(ownerId);
        setVetId(vetId);
        setDateTime(dateTime);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            System.out.println("Warning: Appointment id cannot be empty.");
            this.id = "UNKNOWN";
        }
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        if (petId != null && !petId.trim().isEmpty()) {
            this.petId = petId;
        } else {
            System.out.println("Warning: Pet id cannot be empty.");
            this.petId = "UNKNOWN";
        }
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        if (ownerId != null && !ownerId.trim().isEmpty()) {
            this.ownerId = ownerId;
        } else {
            System.out.println("Warning: Owner id cannot be empty.");
            this.ownerId = "UNKNOWN";
        }
    }

    public String getVetId() {
        return vetId;
    }

    public void setVetId(String vetId) {
        if (vetId != null && !vetId.trim().isEmpty()) {
            this.vetId = vetId;
        } else {
            System.out.println("Warning: Vet id cannot be empty.");
            this.vetId = "UNKNOWN";
        }
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        if (dateTime != null && !dateTime.trim().isEmpty()) {
            this.dateTime = dateTime;
        } else {
            System.out.println("Warning: Date/time cannot be empty.");
            this.dateTime = "";
        }
    }

    public boolean isAvailable() {
        return dateTime.isEmpty();
    }

    @Override
    public String toString() {
        return "Appointment{id='" + id + '\'' +
                ", petId='" + petId + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", vetId='" + vetId + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
