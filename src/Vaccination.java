package src;
public class Vaccination {
    private String id;
    private String petId;
    private String vaccineName;
    private String dateGiven;
    private String validUntil;
    public Vaccination(String id, String petId, String vaccineName, String dateGiven, String validUntil) {
        setId(id);
        setPetId(petId);
        setVaccineName(vaccineName);
        setDateGiven(dateGiven);
        setValidUntil(validUntil);
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            System.out.println("Warning: Vaccination id cannot be empty.");
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
    public String getVaccineName() {
        return vaccineName;
    }
    public void setVaccineName(String vaccineName) {
        if (vaccineName != null && !vaccineName.trim().isEmpty()) {
            this.vaccineName = vaccineName;
        } else {
            System.out.println("Warning: Vaccine name cannot be empty.");
            this.vaccineName = "Unknown";
        }
    }
    public String getDateGiven() {
        return dateGiven;
    }
    public void setDateGiven(String dateGiven) {
        if (dateGiven != null && !dateGiven.trim().isEmpty()) {
            this.dateGiven = dateGiven;
        } else {
            System.out.println("Warning: Date given cannot be empty.");
            this.dateGiven = "0000-00-00";
        }
    }
    public String getValidUntil() {
        return validUntil;
    }
    public void setValidUntil(String validUntil) {
        if (validUntil != null && !validUntil.trim().isEmpty()) {
            this.validUntil = validUntil;
        } else {
            System.out.println("Warning: Valid until cannot be empty.");
            this.validUntil = "0000-00-00";
        }
    }
    public boolean isVaccinated() {
        return !vaccineName.isEmpty();
    }
    @Override
    public String toString() {
        return "Vaccination{id='" + id + '\'' +
                ", petId='" + petId + '\'' +
                ", vaccineName='" + vaccineName + '\'' +
                ", dateGiven='" + dateGiven + '\'' +
                ", validUntil='" + validUntil + '\'' +
                '}';
    }
}
