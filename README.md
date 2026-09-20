# SDP Assignment 2 - Logistics Application

## Project Purpose
This project is a console-based Java application that simulates a logistics delivery system with a cross-platform user interface. It demonstrates the use of two creational design patterns:
- **Factory Method**: Used to create different types of transport (Truck for road, Ship for sea) while keeping the core delivery workflow independent of concrete transport classes.
- **Abstract Factory**: Used to create related families of UI components (Windows or macOS buttons and checkboxes) ensuring that components from different platforms are never mixed.

## Prerequisites
- **Java Development Kit (JDK):** Version 21 
- **IDE:** IntelliJ IDEA (or any other Java IDE)

## Package Structure
The code is organized into separate packages to separate responsibilities according to Clean Code principles:
- `factorymethod/` - Contains the logistics business logic, `Transport` interface, concrete products (`Truck`, `Ship`), and creators (`Logistics`, `RoadLogistics`, `SeaLogistics`).
- `abstractfactory/` - Contains UI component interfaces (`Button`, `Checkbox`), their concrete platform implementations, and the factories (`GUIFactory`, `WindowsFactory`, `MacOSFactory`).
- `client/` - Contains the `DeliveryApplication` which consumes the abstractions, and `Main` which handles startup, validation, and configuration.

## Supported Input Values
When prompted, the application accepts the following inputs (case-insensitive):
* **Delivery mode:** `ROAD` or `SEA`
* **UI platform:** `WINDOWS` or `MACOS`

*Note: Entering unsupported values or leaving the input empty will trigger validation, and the application will stop cleanly with an error message.*

## Build and Run Instructions

### Using IntelliJ IDEA:
1. Open the project in IntelliJ IDEA.
2. Ensure Project SDK is set to JDK 21 (`File` -> `Project Structure` -> `Project`).
3. Locate `Main.java` inside the `client` package.
4. Right-click on `Main.java` and select `Run 'Main.main()'`.
