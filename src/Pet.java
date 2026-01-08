public class Pet {
    private String id;
    private String name;
    private String species;
    private String color;
    private String dob;
    public Pet(String id, String name, String species, String color, String dob) {
        setId(id);
        setName(name);
        setSpecies(species);
        setColor(color);
        setDob(dob);
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            System.out.println("Warning: Pet id cannot be empty.");
            this.id = "UNKNOWN";
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Warning: Pet name cannot be empty.");
            this.name = "Unknown Pet";
        }
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        if (species != null && !species.trim().isEmpty()) {
            this.species = species;
        } else {
            System.out.println("Warning: Species cannot be empty.");
            this.species = "Unknown";
        }
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        if (color != null && !color.trim().isEmpty()) {
            this.color = color;
        } else {
            System.out.println("Warning: Color cannot be empty.");
            this.color = "Unknown";
        }
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        if (dob != null && !dob.trim().isEmpty()) {
            this.dob = dob;
        } else {
            System.out.println("Warning: Date of birth cannot be empty.");
            this.dob = "0000-00-00";
        }
    }
    @Override
    public String toString() {
        return "Pet{id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", color='" + color + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}

