# AGENTS.md

This file provides guidance to WARP (warp.dev) when working with code in this repository.

## Project Overview

Educational Java repository containing programming exercises and practices organized by assessment units (AEA = Activitat d'Ensenyament-Aprenentatge).

## Build & Run Commands

```bash
# Compile all files in a package to out/
javac -d out src/AEA2/*.java

# Run a compiled program (use package.ClassName)
java -cp out AEA2.alguien_ha_suspendido

# Compile a single file
javac -d out src/AEA3/CalculNotes.java

# For files without package declaration (like CalculNotes.java)
java -cp out CalculNotes
```

## Code Structure

```
src/
├── AEA2/          # Arrays and matrices exercises (package AEA2)
├── AEA3/          # Functions and methods exercises
│   └── AA5/       # OOP classes (Client, Encarrec, Sucursal, etc.)
└── EXAMEN AEA2/   # Exam exercises
```

## Language Conventions

- **Variable names and comments**: Written in Catalan/Spanish
- **User prompts**: Use Catalan (e.g., "Introdueix la nota", "Quantes notes vols introduir?")
- **Package declarations**: Must match folder structure (e.g., `package AEA2;`)
- Files in `src/AEA3/` root may omit package declaration

## Code Patterns

- Use `Scanner` for user input with `Scanner s = new Scanner(System.in);`
- Always close Scanner: `s.close();`
- For robust input, validate with `hasNextDouble()` / `hasNextInt()` before reading
