package Test;

public class Main {
    public static void main(String[] args) {
        //The fighters are created.
        Fighter f1 = new Fighter("Halit", 10, 120, 65, 30);
        Fighter f2 = new Fighter("Özgür", 15, 100, 75, 40);

        //The match has been created.
        Match firstMatch = new Match(f1, f2, 65, 75);
        firstMatch.run();
    }
}
