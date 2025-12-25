public class Main {
    public static void main(String[] args) {
        Pet p = new Pet("P1","Barsik","Cat","Beliy","2021-03-10");
        Owner o = new Owner("O1","Zhanserik","+7777","Astana","a@a.com");
        Veterinarian v = new Veterinarian("V1","Dr.Kim","Therapy","+7701","LIC1");
        Appointment a = new Appointment("A1", p.getId(), o.getId(), v.getId(), "2025");
        Treatment t = new Treatment("T1", a.getId(), "Exam", "Basic exam", 15000);
        Vaccination vac = new Vaccination("VC1", p.getId(), "Rabies", "2025-12-25", "2026-12-25");
        System.out.println(p.getId()+" "+p.getName()+" "+p.getSpecies()+" "+p.getDob());
        System.out.println(o.getId()+" "+o.getFullName()+" "+o.getPhone());
        System.out.println(v.getId()+" "+v.getFullName()+" "+v.getSpecialty());
        System.out.println(a.getId()+" "+a.getPetId()+" "+a.getOwnerId()+" "+a.getDateTime());
        System.out.println(t.getId()+" "+t.getAppointmentId()+" "+t.getName()+" "+t.getCost());
        System.out.println(vac.getId()+" "+vac.getPetId()+" "+vac.getVaccineName()+" "+vac.getValidUntil());
    }
}

