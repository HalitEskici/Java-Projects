package Test;

public class Fighter {
    String name;
    int damage;
    int health;
    int weight;
    int dodge;

    //Constructor of the Fighter class.
    Fighter(String name, int damage, int health, int weight, int dodge) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        this.dodge = dodge;
        if (this.dodge >= 0 && this.dodge <= 100) {
            this.dodge = dodge;
        } else {
            this.dodge = 0;
        }
    }

    //Here is the health and damage process of the match.
    int hit(Fighter opponent) {
        System.out.println(this.name + " hit " + opponent.name + " " + this.damage + " damage.");

        if (opponent.isDodge()) {
            System.out.println(opponent.name + " has blocked the damage.");
            System.out.println("=================");
            return opponent.health;
        }

        if (opponent.health - this.damage < 0) {
            return 0;
        }
        return opponent.health - this.damage;
    }

    //The dodge rate has been calculated here.
    boolean isDodge() {
        double randomNumber = Math.random() * 100;
        return randomNumber <= this.dodge;
    }
}
