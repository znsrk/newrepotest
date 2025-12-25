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
    public boolean isCat(){ return "Cat".equals(species); }
}
