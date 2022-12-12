package Test;

public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    //Constructor of the Match class.
    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    //Here I start the rounds.
    void run() {
        if (isCheck()) {
            while (this.f1.health > 0 && this.f2.health > 0) {
                System.out.println("=== NEW ROUND ===");
                double randomChance = Math.random() * 100;
                if (randomChance > 50) {
                    this.f2.health = this.f1.hit(this.f2);
                    if (isWin()) {
                        break;
                    }
                    this.f1.health = this.f2.hit(this.f1);
                    if (isWin()) {
                        break;
                    }
                    printHealth();
                } else {
                    this.f1.health = this.f2.hit(this.f1);
                    if (isWin()) {
                        break;
                    }
                    this.f2.health = this.f1.hit(this.f2);
                    if (isWin()) {
                        break;
                    }
                    printHealth();
                }
            }
        } else {
            System.out.println("Athletes' weights do not match.");
        }
    }

    //Here I checked whether these 2 fighter can fight or not.
    boolean isCheck() {
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    //Here is the declaration of the winner.
    boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println(this.f2.name + " won!");
            return true;
        }
        if (this.f2.health == 0) {
            System.out.println(this.f1.name + " won!");
            return true;
        }
        return false;
    }

    public void printHealth() {
        System.out.println(this.f1.name + "'s health: " + this.f1.health + " ||| " + this.f2.name + "'s health: " + this.f2.health);
    }
}
