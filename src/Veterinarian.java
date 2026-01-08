public class Veterinarian {
    private String id;
    private String fullName;
    private String specialty;
    private String phone;
    private String licenseNumber;

    public Veterinarian(String id, String fullName, String specialty, String phone, String licenseNumber) {
        setId(id);
        setFullName(fullName);
        setSpecialty(specialty);
        setPhone(phone);
        setLicenseNumber(licenseNumber);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            System.out.println("Warning: Vet id cannot be empty.");
            this.id = "UNKNOWN";
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName != null && !fullName.trim().isEmpty()) {
            this.fullName = fullName;
        } else {
            System.out.println("Warning: Vet name cannot be empty.");
            this.fullName = "Unknown Vet";
        }
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        if (specialty != null && !specialty.trim().isEmpty()) {
            this.specialty = specialty;
        } else {
            System.out.println("Warning: Specialty cannot be empty.");
            this.specialty = "General";
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone != null && !phone.trim().isEmpty()) {
            this.phone = phone;
        } else {
            System.out.println("Warning: Phone cannot be empty.");
            this.phone = "N/A";
        }
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        if (licenseNumber != null && !licenseNumber.trim().isEmpty()) {
            this.licenseNumber = licenseNumber;
        } else {
            System.out.println("Warning: License number cannot be empty.");
            this.licenseNumber = "N/A";
        }
    }

    @Override
    public String toString() {
        return "Veterinarian{id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", phone='" + phone + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                '}';
    }
}
