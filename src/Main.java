import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Populate the list of wrestlers from the "Wrestlers.txt" file (64 wrestlers in total).
        menu();
        List<Wrestler> wrestlers = new ArrayList<>();
        Wrestler wrestler;
        try (BufferedReader reader = new BufferedReader(new FileReader("Wrestlers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] wrestlerData = line.split(",");
                String name = wrestlerData[0];
                int age = Integer.parseInt(wrestlerData[1]);
                int height = Integer.parseInt(wrestlerData[2]);
                int weight = Integer.parseInt(wrestlerData[3]);
                String promotion = wrestlerData[4];
                List<String> moveset = new ArrayList<>(Arrays.asList(wrestlerData).subList(5, wrestlerData.length));
                wrestler = new Wrestler(name, age, height, weight, promotion, moveset);
                wrestlers.add(wrestler);
            }
        } catch (Exception e) {
            System.err.println("Error reading wrestlers from file: " + e.getMessage());
            return;
        }
        for (Wrestler participant : wrestlers) {
            participant.getWrestlerInfo();
        }
        // Create the tournament environment and simulate the tournament
        System.out.println("---------------");
        Tournament tournament = new Tournament(wrestlers);
        tournament.simulateTournament();
    }

    public static void menu() {
        System.out.println("Welcome to All Star Wrestling Festival 2023!");
        System.out.println("All Star Wrestling Festival 2023 is a one-night only special event, and a " +
                "single-elimination format based tournament.");
        System.out.println("There will be a total of 64 participant wrestlers on this tournament across Japan,"
                + " regardless of their promotions, age, and their weight divisions.");
        System.out.println("Here are all 64 of our participant wrestlers...\n");
    }
}