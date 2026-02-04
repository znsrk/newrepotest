# VET CLINIC - PostgreSQL Setup Guide

## Project Requirements Checklist

This project meets all the technical requirements:

| Requirement | Status |
|-------------|--------|
| 1. PostgreSQL Database | ✅ Database with tables matching entities |
| 2. JDBC Connection | ✅ DatabaseConnection class with getConnection/closeConnection |
| 3. DAO Pattern | ✅ VeterinarianDAO and PetDAO with PreparedStatement |
| 4. CREATE (INSERT) | ✅ insert() methods for each entity |
| 5. READ (SELECT) | ✅ getAll() and getById() methods |
| 6. UPDATE | ✅ update() methods with WHERE clause |
| 7. DELETE | ✅ delete() methods with confirmation |
| 8. SEARCH Operations | ✅ searchByName (ILIKE) and numeric search |
| 9. Menu System | ✅ Menu interface + ClinicMenu class (no ArrayList) |
| 10. Week 6 Requirements | ✅ Abstract class, 2 interfaces, exception handling, polymorphism |

---

## Step 1: Install PostgreSQL

### Download PostgreSQL:
1. Go to: https://www.postgresql.org/download/windows/
2. Click "Download the installer"
3. Download the latest version (e.g., PostgreSQL 16)
4. Run the installer

### During installation:
- Set password: `postgres` (remember this!)
- Keep default port: `5432`
- Select all components
- Finish installation

---

## Step 2: Create Database

### Option A: Using pgAdmin (GUI)
1. Open pgAdmin 4 (installed with PostgreSQL)
2. Connect to server with password `postgres`
3. Right-click "Databases" → "Create" → "Database"
4. Name: `vet_clinic`
5. Click "Save"
6. Right-click `vet_clinic` → "Query Tool"
7. Paste and run the SQL from `setup_database.sql`

### Option B: Using Command Line
1. Open Command Prompt as Administrator
2. Navigate to PostgreSQL bin folder:
```cmd
cd "C:\Program Files\PostgreSQL\16\bin"
```
3. Connect to PostgreSQL:
```cmd
psql -U postgres
```
4. Enter password: `postgres`
5. Create database:
```sql
CREATE DATABASE vet_clinic;
\c vet_clinic
```
6. Run the setup script (copy-paste from setup_database.sql)

---

## Step 3: Add PostgreSQL JDBC Driver

### For IntelliJ IDEA:
1. Download the driver: https://jdbc.postgresql.org/download/
2. Download `postgresql-42.7.1.jar` (or latest)
3. In IntelliJ: File → Project Structure → Libraries
4. Click "+" → "Java" → Select the downloaded JAR
5. Click OK

### Alternative - Add to project folder:
1. Create a `lib` folder in your project
2. Put `postgresql-42.7.1.jar` inside
3. Right-click JAR → "Add as Library"

---

## Step 4: Configure Connection

Edit `db/DatabaseConnection.java` if needed:
```java
private static final String URL = "jdbc:postgresql://localhost:5432/vet_clinic";
private static final String USER = "postgres";
private static final String PASSWORD = "postgres";  // Your PostgreSQL password
```

---

## Step 5: Run the Project

1. Run `Main.java`
2. The menu system will appear
3. All data is stored in PostgreSQL database!

---

## Project Structure

```
untitled/
├── Main.java                    # Entry point
├── db/
│   └── DatabaseConnection.java  # JDBC connection class
├── dao/
│   ├── VeterinarianDAO.java     # DAO for veterinarians
│   └── PetDAO.java              # DAO for pets
├── source/
│   ├── Owner.java               # Abstract class
│   ├── Veterinarian.java        # Extends Owner
│   ├── Pet.java                 # Extends Owner
│   ├── Vaccination.java         # Interface
│   └── Appointment.java         # Implements Vaccination
├── menu/
│   ├── Menu.java                # Interface
│   └── ClinicMenu.java          # Implements Menu
└── setup_database.sql           # Database setup script
```

---

## Troubleshooting

**"PostgreSQL Driver not found"**
- Make sure the JDBC JAR is added to your project

**"Database connection failed"**
- Check PostgreSQL is running (Services → postgresql-x64-16)
- Verify password in DatabaseConnection.java

**"Database does not exist"**
- Create the database first using pgAdmin or psql

---

## Features Summary

- **CREATE**: Add veterinarians and pets to database
- **READ**: View all entries or get by ID
- **UPDATE**: Modify existing records
- **DELETE**: Remove with confirmation prompt
- **SEARCH**: Case-insensitive name search (ILIKE) + numeric field search
- **Polymorphism**: performActivity() works differently for Vet vs Pet
- **Exception Handling**: Setters validate input
