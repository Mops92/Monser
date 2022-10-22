import java.sql.SQLOutput;
import java.util.Scanner;
public class Hero {

    String name;
    int hp = 10;
    int damage = 2;

    public void inputName() {
        System.out.println("Вашего героя зовут...");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        System.out.println("Приветствую, " + name + "!");

    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
