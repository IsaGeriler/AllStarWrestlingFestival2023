import java.util.Random;

public class Match {
    private Wrestler wrestler1;
    private Wrestler wrestler2;
    private Wrestler winner;
    private Wrestler loser;

    Match(Wrestler wrestler1, Wrestler wrestler2) {
        this.wrestler1 = wrestler1;
        this.wrestler2 = wrestler2;
    }

    public Wrestler getWrestler1() {return wrestler1;}
    public Wrestler getWrestler2() {return wrestler2;}
    public Wrestler getWinner() {return winner;}
    public Wrestler getLoser() {return loser;}

    public void simulateMatch() {
        Random randomDamage1 = new Random();
        Random randomDamage2 = new Random();

        String movePerformedByWrestler1;
        String movePerformedByWrestler2;

        int wrestler1AttackDamage;
        int wrestler2AttackDamage;
        boolean ongoingMatch = true;

        while(ongoingMatch) {
            movePerformedByWrestler1 = wrestler1.performMove();
            wrestler1AttackDamage = 1 + randomDamage1.nextInt(10);
            movePerformedByWrestler2 = wrestler2.performMove();
            wrestler2AttackDamage = 1 + randomDamage2.nextInt(10);

            if(wrestler1AttackDamage > wrestler2AttackDamage) {
                System.out.println(wrestler1.getName() + " has performed " + movePerformedByWrestler1
                        + " to " + wrestler2.getName() + "! [ATK: " + wrestler1AttackDamage + "]");
                wrestler2.damage(wrestler1AttackDamage);
            } else {
                System.out.println(wrestler2.getName() + " has reversed " + wrestler1.getName() + "'s " +
                        movePerformedByWrestler1 + " attempt into a " + movePerformedByWrestler2 + "! [ATK: "
                        + wrestler2AttackDamage + "]");
                wrestler1.damage(wrestler2AttackDamage);
                // update move performed by wrestler 1
                movePerformedByWrestler1 = movePerformedByWrestler2;
                // update move performed by wrestler 2
                movePerformedByWrestler2 = wrestler1.getName() + "'s " + movePerformedByWrestler1;
                switchTurns();
            }

            if(wrestler1.getHealth() <= 0) {
                this.winner = wrestler2;
                this.loser = wrestler1;
                System.out.println("\n*** " + winner.getName() + ", with a remaining health of " + winner.getHealth()
                        + ", has defeated " + loser.getName() + " with " + movePerformedByWrestler2 + "! ***");
                winner.restoreHealth();
                ongoingMatch = false;
            } else if (wrestler2.getHealth() <= 0) {
                this.winner = wrestler1;
                this.loser = wrestler2;
                System.out.println("\n*** " + winner.getName() + ", with a remaining health of " + winner.getHealth()
                        + ", has defeated " + loser.getName() + " with " + movePerformedByWrestler1 + "! ***");
                winner.restoreHealth();
                ongoingMatch = false;
            }
        }
    }

    private void switchTurns() {
        Wrestler temp = wrestler1;
        wrestler1 = wrestler2;
        wrestler2 = temp;
    }
}