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