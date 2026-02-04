-- VET CLINIC DATABASE SETUP SCRIPT
-- Run this script in PostgreSQL to create the database and tables

-- Step 1: Create the database (run this separately in psql)
-- CREATE DATABASE vet_clinic;

-- Step 2: Connect to the database
-- \c vet_clinic

-- Step 3: Create tables

-- Veterinarians table
CREATE TABLE IF NOT EXISTS veterinarians (
    id INTEGER PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    years_experience INTEGER NOT NULL,
    specialization VARCHAR(100) NOT NULL
);

-- Pets table
CREATE TABLE IF NOT EXISTS pets (
    id INTEGER PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    balance DECIMAL(10, 2) NOT NULL,
    years_registered INTEGER NOT NULL,
    visits_count INTEGER NOT NULL
);

-- Step 4: Insert sample data (optional)
INSERT INTO veterinarians (id, name, salary, years_experience, specialization) VALUES
    (101, 'Dr. Smith', 500000, 15, 'Surgery'),
    (102, 'Dr. Johnson', 450000, 8, 'Dermatology'),
    (103, 'Dr. Williams', 480000, 12, 'Cardiology');

INSERT INTO pets (id, name, balance, years_registered, visits_count) VALUES
    (201, 'Rex', 0, 3, 12),
    (202, 'Bella', 5000, 5, 25),
    (203, 'Max', 1500, 2, 8);

-- Verify data
SELECT * FROM veterinarians;
SELECT * FROM pets;
