public class Troll extends Monster{

    private int hp = 7;
    private int damage = 2;

    Troll(String name) {
        super(name);
    }

    public void regenerate(){
        int regenerate = (int) (1 + Math.random() * 3);
        if(regenerate == 2){
            hp += 1;
            System.out.println("Тролль восстанавливает 1 единицу здоровья с помощью регенерации");
        }
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

}
