package source;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {
    
    // CREATE - Insert new pet
    public void insert(Pet pet) {
        String sql = "INSERT INTO pets (id, name, balance, years_registered, visits_count) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, pet.getId());
            stmt.setString(2, pet.getName());
            stmt.setDouble(3, pet.getBalance());
            stmt.setInt(4, pet.getYearsRegistered());
            stmt.setInt(5, pet.getVisitsCount());
            
            stmt.executeUpdate();
            System.out.println("Pet added to database!");
            
        } catch (SQLException e) {
            System.out.println("Error inserting pet: " + e.getMessage());
        }
    }
    
    // READ - Get all pets
    public List<Pet> getAll() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Pet pet = new Pet(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("balance"),
                    rs.getInt("years_registered"),
                    rs.getInt("visits_count")
                );
                pets.add(pet);
            }
            
        } catch (SQLException e) {
            System.out.println("Error fetching pets: " + e.getMessage());
        }
        return pets;
    }
    
    // READ - Get pet by ID
    public Pet getById(int id) {
        String sql = "SELECT * FROM pets WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Pet(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("balance"),
                    rs.getInt("years_registered"),
                    rs.getInt("visits_count")
                );
            }
            
        } catch (SQLException e) {
            System.out.println("Error fetching pet: " + e.getMessage());
        }
        return null;
    }
    
    // UPDATE - Update pet by ID
    public void update(Pet pet) {
        String sql = "UPDATE pets SET name = ?, balance = ?, years_registered = ?, visits_count = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, pet.getName());
            stmt.setDouble(2, pet.getBalance());
            stmt.setInt(3, pet.getYearsRegistered());
            stmt.setInt(4, pet.getVisitsCount());
            stmt.setInt(5, pet.getId());
            
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Pet updated successfully!");
            } else {
                System.out.println("Pet not found.");
            }
            
        } catch (SQLException e) {
            System.out.println("Error updating pet: " + e.getMessage());
        }
    }
    
    // DELETE - Delete pet by ID
    public boolean delete(int id) {
        String sql = "DELETE FROM pets WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Pet deleted successfully!");
                return true;
            } else {
                System.out.println("Pet not found.");
            }
            
        } catch (SQLException e) {
            System.out.println("Error deleting pet: " + e.getMessage());
        }
        return false;
    }
    
    // SEARCH - Search by name (case-insensitive with ILIKE)
    public List<Pet> searchByName(String name) {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets WHERE name ILIKE ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Pet pet = new Pet(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("balance"),
                    rs.getInt("years_registered"),
                    rs.getInt("visits_count")
                );
                pets.add(pet);
            }
            
        } catch (SQLException e) {
            System.out.println("Error searching pets: " + e.getMessage());
        }
        return pets;
    }
    
    // SEARCH - Search by visits count (numeric field)
    public List<Pet> searchByVisits(int minVisits) {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets WHERE visits_count >= ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, minVisits);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Pet pet = new Pet(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("balance"),
                    rs.getInt("years_registered"),
                    rs.getInt("visits_count")
                );
                pets.add(pet);
            }
            
        } catch (SQLException e) {
            System.out.println("Error searching pets: " + e.getMessage());
        }
        return pets;
    }
}
