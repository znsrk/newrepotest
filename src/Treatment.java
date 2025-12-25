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
    public boolean isExpensive(){ return cost >= 20000; }
}