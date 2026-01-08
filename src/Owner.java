package src;
public class Owner {
    private String id;
    private String fullName;
    private String phone;
    private String address;
    private String email;

    public Owner(String id, String fullName, String phone, String address, String email) {
        setId(id);
        setFullName(fullName);
        setPhone(phone);
        setAddress(address);
        setEmail(email);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            System.out.println("Warning: Owner id cannot be empty.");
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
            System.out.println("Warning: Owner name cannot be empty.");
            this.fullName = "Unknown Owner";
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            this.address = address;
        } else {
            System.out.println("Warning: Address cannot be empty.");
            this.address = "N/A";
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Warning: Invalid email.");
            this.email = "unknown@example.com";
        }
    }

    @Override
    public String toString() {
        return "Owner{id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
