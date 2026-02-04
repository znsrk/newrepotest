package source;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeterinarianDAO {
    
    // CREATE - Insert new veterinarian
    public void insert(Veterinarian vet) {
        String sql = "INSERT INTO veterinarians (id, name, salary, years_experience, specialization) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, vet.getId());
            stmt.setString(2, vet.getName());
            stmt.setDouble(3, vet.getBalance());
            stmt.setInt(4, vet.getYearsRegistered());
            stmt.setString(5, vet.getSpecialization());
            
            stmt.executeUpdate();
            System.out.println("Veterinarian added to database!");
            
        } catch (SQLException e) {
            System.out.println("Error inserting veterinarian: " + e.getMessage());
        }
    }
    
    // READ - Get all veterinarians
    public List<Veterinarian> getAll() {
        List<Veterinarian> vets = new ArrayList<>();
        String sql = "SELECT * FROM veterinarians";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Veterinarian vet = new Veterinarian(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("salary"),
                    rs.getInt("years_experience"),
                    rs.getString("specialization")
                );
                vets.add(vet);
            }
            
        } catch (SQLException e) {
            System.out.println("Error fetching veterinarians: " + e.getMessage());
        }
        return vets;
    }
    
    // READ - Get veterinarian by ID
    public Veterinarian getById(int id) {
        String sql = "SELECT * FROM veterinarians WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Veterinarian(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("salary"),
                    rs.getInt("years_experience"),
                    rs.getString("specialization")
                );
            }
            
        } catch (SQLException e) {
            System.out.println("Error fetching veterinarian: " + e.getMessage());
        }
        return null;
    }
    
    // UPDATE - Update veterinarian by ID
    public void update(Veterinarian vet) {
        String sql = "UPDATE veterinarians SET name = ?, salary = ?, years_experience = ?, specialization = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, vet.getName());
            stmt.setDouble(2, vet.getBalance());
            stmt.setInt(3, vet.getYearsRegistered());
            stmt.setString(4, vet.getSpecialization());
            stmt.setInt(5, vet.getId());
            
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Veterinarian updated successfully!");
            } else {
                System.out.println("Veterinarian not found.");
            }
            
        } catch (SQLException e) {
            System.out.println("Error updating veterinarian: " + e.getMessage());
        }
    }
    
    // DELETE - Delete veterinarian by ID
    public boolean delete(int id) {
        String sql = "DELETE FROM veterinarians WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Veterinarian deleted successfully!");
                return true;
            } else {
                System.out.println("Veterinarian not found.");
            }
            
        } catch (SQLException e) {
            System.out.println("Error deleting veterinarian: " + e.getMessage());
        }
        return false;
    }
    
    // SEARCH - Search by name (case-insensitive with ILIKE)
    public List<Veterinarian> searchByName(String name) {
        List<Veterinarian> vets = new ArrayList<>();
        String sql = "SELECT * FROM veterinarians WHERE name ILIKE ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Veterinarian vet = new Veterinarian(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("salary"),
                    rs.getInt("years_experience"),
                    rs.getString("specialization")
                );
                vets.add(vet);
            }
            
        } catch (SQLException e) {
            System.out.println("Error searching veterinarians: " + e.getMessage());
        }
        return vets;
    }
    
    // SEARCH - Search by years of experience (numeric field)
    public List<Veterinarian> searchByExperience(int minYears) {
        List<Veterinarian> vets = new ArrayList<>();
        String sql = "SELECT * FROM veterinarians WHERE years_experience >= ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, minYears);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Veterinarian vet = new Veterinarian(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("salary"),
                    rs.getInt("years_experience"),
                    rs.getString("specialization")
                );
                vets.add(vet);
            }
            
        } catch (SQLException e) {
            System.out.println("Error searching veterinarians: " + e.getMessage());
        }
        return vets;
    }
}
