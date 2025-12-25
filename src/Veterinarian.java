class Veterinarian {
    private String id, fullName, specialty, phone, license;
    public Veterinarian(String id, String fullName, String specialty, String phone, String license){
        this.id=id; this.fullName=fullName; this.specialty=specialty; this.phone=phone; this.license=license;
    }
    public String getId(){ return id; } public void setId(String id){ this.id=id; }
    public String getFullName(){ return fullName; } public void setFullName(String fullName){ this.fullName=fullName; }
    public String getSpecialty(){ return specialty; } public void setSpecialty(String specialty){ this.specialty=specialty; }
    public String getPhone(){ return phone; } public void setPhone(String phone){ this.phone=phone; }
    public String getLicense(){ return license; } public void setLicense(String license){ this.license=license; }
    public boolean hasLicense(){ return license != null && !license.isEmpty();
    }
}