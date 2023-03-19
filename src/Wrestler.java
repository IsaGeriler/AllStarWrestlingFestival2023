import java.util.List;
import java.util.Random;

public class Wrestler {
    private final String name;
    private final int age;
    private final int height;
    private final int weight;
    private final String promotion;
    private final List<String> moveset;
    private int health = 50; // starting health point of each wrestler to keep the competition fair

    Wrestler(String name, int age, int height, int weight, String promotion, List<String> moveset) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.promotion = promotion;
        this.moveset = moveset;
    }

    public String getName() {return name;}
    public int getAge() {return age;}
    public int getHeight() {return height;}
    public int getWeight() {return weight;}
    public String getPromotion() {return promotion;}
    public List<String> getMoveset() {return moveset;}
    public int getHealth() {return health;}
    // Reduce health of a wrestler after their opponents' move successfully hits/connects.
    public void damage (int damage) {this.health -= damage;}
    // Regenerate a wrestlers' health to 100% rate (original value = 50) before their upcoming match.
    public void restoreHealth() {this.health = 50;}

    public void getWrestlerInfo() {
        System.out.println("Participant Name: "+ name + "\nParticipant's Age: " + age
                + "\nParticipant's Height: " + height + "cm\nParticipant's Weight: " + weight
                + "kg\nParticipant's Promotion: " + promotion
                + "\nParticipant's Special Moves: " + moveset + "\n");
    }

    public String performMove() {
        Random randomMove = new Random();
        return moveset.get(randomMove.nextInt(moveset.size()));
    }
}