// VetClinicModels.java

class Pet {
    private String id, name, species, breed, dob;
    public Pet(String id, String name, String species, String breed, String dob){
        this.id=id; this.name=name; this.species=species; this.breed=breed; this.dob=dob;
    }
    public String getId(){ return id; } public void setId(String id){ this.id=id; }
    public String getName(){ return name; } public void setName(String name){ this.name=name; }
    public String getSpecies(){ return species; } public void setSpecies(String species){ this.species=species; }
    public String getBreed(){ return breed; } public void setBreed(String breed){ this.breed=breed; }
    public String getDob(){ return dob; } public void setDob(String dob){ this.dob=dob; }
}

class Owner {
    private String id, fullName, phone, address, email;
    public Owner(String id, String fullName, String phone, String address, String email){
        this.id=id; this.fullName=fullName; this.phone=phone; this.address=address; this.email=email;
    }
    public String getId(){ return id; } public void setId(String id){ this.id=id; }
    public String getFullName(){ return fullName; } public void setFullName(String fullName){ this.fullName=fullName; }
    public String getPhone(){ return phone; } public void setPhone(String phone){ this.phone=phone; }
    public String getAddress(){ return address; } public void setAddress(String address){ this.address=address; }
    public String getEmail(){ return email; } public void setEmail(String email){ this.email=email; }
}

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
}

class Appointment {
    private String id, petId, ownerId, vetId, dateTime;
    public Appointment(String id, String petId, String ownerId, String vetId, String dateTime){
        this.id=id; this.petId=petId; this.ownerId=ownerId; this.vetId=vetId; this.dateTime=dateTime;
    }
    public String getId(){ return id; } public void setId(String id){ this.id=id; }
    public String getPetId(){ return petId; } public void setPetId(String petId){ this.petId=petId; }
    public String getOwnerId(){ return ownerId; } public void setOwnerId(String ownerId){ this.ownerId=ownerId; }
    public String getVetId(){ return vetId; } public void setVetId(String vetId){ this.vetId=vetId; }
    public String getDateTime(){ return dateTime; } public void setDateTime(String dateTime){ this.dateTime=dateTime; }
}

class Treatment {
    private String id, appointmentId, name, description;
    private int cost;
    public Treatment(String id, String appointmentId, String name, String description, int cost){
        this.id=id; this.appointmentId=appointmentId; this.name=name; this.description=description; this.cost=cost;
    }
    public String getId(){ return id; } public void setId(String id){ this.id=id; }
    public String getAppointmentId(){ return appointmentId; } public void setAppointmentId(String appointmentId){ this.appointmentId=appointmentId; }
    public String getName(){ return name; } public void setName(String name){ this.name=name; }
    public String getDescription(){ return description; } public void setDescription(String description){ this.description=description; }
    public int getCost(){ return cost; } public void setCost(int cost){ this.cost=cost; }
}

class Vaccination {
    private String id, petId, vaccineName, dateGiven, validUntil;
    public Vaccination(String id, String petId, String vaccineName, String dateGiven, String validUntil){
        this.id=id; this.petId=petId; this.vaccineName=vaccineName; this.dateGiven=dateGiven; this.validUntil=validUntil;
    }
    public String getId(){ return id; } public void setId(String id){ this.id=id; }
    public String getPetId(){ return petId; } public void setPetId(String petId){ this.petId=petId; }
    public String getVaccineName(){ return vaccineName; } public void setVaccineName(String vaccineName){ this.vaccineName=vaccineName; }
    public String getDateGiven(){ return dateGiven; } public void setDateGiven(String dateGiven){ this.dateGiven=dateGiven; }
    public String getValidUntil(){ return validUntil; } public void setValidUntil(String validUntil){ this.validUntil=validUntil; }
}
