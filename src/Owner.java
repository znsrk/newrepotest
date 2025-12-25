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
    public boolean livesInAstana(){ return "Astana".equals(address); }
}