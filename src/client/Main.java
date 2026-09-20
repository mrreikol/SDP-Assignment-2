package client;

import abstractfactory.GUIFactory;
import abstractfactory.MacOSFactory;
import abstractfactory.WindowsFactory;
import factorymethod.Logistics;
import factorymethod.RoadLogistics;
import factorymethod.SeaLogistics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter delivery mode (ROAD / SEA): ");
        String deliveryMode = scanner.nextLine().trim().toUpperCase();

        System.out.println("Enter UI platform (WINDOWS / MACOS): ");
        String platform = scanner.nextLine().trim().toUpperCase();

        Logistics logistics = configureLogistics(deliveryMode);
        GUIFactory guiFactory = configureGUI(platform);

        if (logistics == null || guiFactory == null) {
            System.out.println("Error: Application stopped due to invalid selection. Please try again.");
            return;
        }

        DeliveryApplication app = new DeliveryApplication(guiFactory, logistics);

        System.out.println();
        app.renderAndDeliver("laboratory equipment", "Aktau");
    }

    private static Logistics configureLogistics(String mode) {
        switch (mode) {
            case "ROAD":
                return new RoadLogistics();
            case "SEA":
                return new SeaLogistics();
            default:
                System.out.println("Validation error: Unsupported delivery mode '" + mode + "'.");
                return null;
        }
    }

    private static GUIFactory configureGUI(String platform) {
        switch (platform) {
            case "WINDOWS":
                return new WindowsFactory();
            case "MACOS":
                return new MacOSFactory();
            default:
                System.out.println("Validation error: Unsupported platform '" + platform + "'.");
                return null;
        }
    }
}