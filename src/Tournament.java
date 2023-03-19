import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tournament {
    private final List<Wrestler> wrestlers;
    private final List<Match> matches;

    public Tournament(List<Wrestler> wrestlers) {
        this.wrestlers = wrestlers;
        this.matches = new ArrayList<>();
    }

    public void simulateTournament() {
        // Schedule the first round of matches by randomly assigning opponents
        List<Wrestler> winners = new ArrayList<>();
        ArrayList<Integer> pickedOpponent = new ArrayList<>();
        Random random1 = new Random();
        Random random2 = new Random();

        int roundCounter = 1;

        for (int i = 0; i < wrestlers.size(); i += 2) {
            int firstOpponent = random1.nextInt(wrestlers.size());
            int secondOpponent = random2.nextInt(wrestlers.size());

            while ((firstOpponent == secondOpponent) || (pickedOpponent.contains(firstOpponent))
                    || (pickedOpponent.contains(secondOpponent))) {
                firstOpponent = random1.nextInt(wrestlers.size());
                secondOpponent = random2.nextInt(wrestlers.size());
            }

            pickedOpponent.add(firstOpponent);
            pickedOpponent.add(secondOpponent);
            Wrestler wrestler1 = wrestlers.get(firstOpponent);
            Wrestler wrestler2 = wrestlers.get(secondOpponent);

            Match match = new Match(wrestler1, wrestler2);
            System.out.println("\nRound " + roundCounter + " Match - " + wrestler1.getName()
                    + " vs. " + wrestler2.getName());
            match.simulateMatch();
            matches.add(match);
            winners.add(match.getWinner());
        }
        // Keep playing rounds of matches until there is only one wrestler/winner left
        while (winners.size() > 1) {
            roundCounter++;
            List<Wrestler> roundWinners = new ArrayList<>();
            for (int i = 0; i < winners.size(); i += 2) {
                Wrestler wrestler1 = winners.get(i);
                Wrestler wrestler2 = winners.get(i + 1);

                if(winners.size() == 8) {
                    System.out.println("\nRound " + roundCounter + " [Quarter Finals] Match - "
                            + wrestler1.getName() + " (" + wrestler1.getPromotion() + ") vs. " + wrestler2.getName()
                    + " (" + wrestler2.getPromotion() + ")");
                    Match match = new Match(wrestler1, wrestler2);
                    match.simulateMatch();
                    matches.add(match);
                    roundWinners.add(match.getWinner());
                } else if (winners.size() == 4) {
                    System.out.println("\nRound " + roundCounter + " [Semi Finals] Match - "
                            + wrestler1.getName() + " (" + wrestler1.getPromotion() + ") vs. " + wrestler2.getName()
                            + " (" + wrestler2.getPromotion() + ")");
                    Match match = new Match(wrestler1, wrestler2);
                    match.simulateMatch();
                    matches.add(match);
                    roundWinners.add(match.getWinner());
                } else if (winners.size() == 2) {
                    System.out.println("\nRound " + roundCounter + " [Finals] Match - "
                            + wrestler1.getName() + " (" + wrestler1.getPromotion() + ") vs. " + wrestler2.getName()
                            + " (" + wrestler2.getPromotion() + ")");
                    Match match = new Match(wrestler1, wrestler2);
                    match.simulateMatch();
                    matches.add(match);
                    roundWinners.add(match.getWinner());
                } else {
                    Match match = new Match(wrestler1, wrestler2);
                    System.out.println("\nRound " + roundCounter + " Match - " + wrestler1.getName()
                            + " vs. " + wrestler2.getName());
                    match.simulateMatch();
                    matches.add(match);
                    roundWinners.add(match.getWinner());
                }
            }
            winners = roundWinners;
        }
        // The last remaining wrestler is the winner of the tournament
        Wrestler tournamentWinner = winners.get(0);
        System.out.println("*** The winner of All Star Wrestling Festival 2023 is "
                + tournamentWinner.getName() + "! ***");
    }
}