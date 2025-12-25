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
    public boolean isVaccinated(){ return Vaccination.getVaccineName().isEmpty();
    }
}