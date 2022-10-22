import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Hero hero = new Hero();
        hero.inputName();

        System.out.println(hero.getName() + " начинает свое путешествие");

        Troll monster = new Troll("Troll");

        System.out.println(hero.getName() + " попадает в засаду! »з леса на него нападает " + monster.getName());
        System.out.println(
                "¬аши действи€?" +
                "\nнажмите 1, чтобы ударить" +
                "\nнажмите 2, чтобы сдатьс€" +
                "\nнажмите 3, чтобы попробовать убежать");


        Scanner scr = new Scanner(System.in);

        while(monster.getHp() > 0 && hero.getHp() > 0 ){
            String input = scr.nextLine();

            //  1 - герой наносит удар

            if(input.equals("1")) {

                int heroDamage = (int) (1 + Math.random() * hero.getDamage());

                // монстр блокирует удар и бьет в ответ
                int monsterBlock = (int) (1 + Math.random() * 3);
                if (monsterBlock == 2){
                    System.out.println(monster.getName() + " блокировал удар");
                    System.out.println("” " + monster.getName() + " осталось " + monster.getHp() + " единиц здоровь€");
                    System.out.println(monster.getName() + " наносит ответный удар");
                    int monsterDamage = (int) (1 + Math.random() * monster.getDamage());

                    int heroBlock = (int) (1 + Math.random() * 3);
                    if (heroBlock == 2) {
                        System.out.println(hero.getName() + " блокировал удар");
                        System.out.println("” " + hero.getName() + " осталось " + hero.getHp() + " единиц здоровь€");
                    } else {
                        hero.setHp(hero.getHp() - monsterDamage);
                        System.out.println(monster.getName() + " нанес " + hero.getName() + " " + heroDamage + " единиц урона");
                        System.out.println("” " + hero.getName() + " осталось " + hero.getHp() + " единиц здоровь€");
                    }

                }else {
                    // монстр пропускает удар
                    monster.setHp(monster.getHp() - heroDamage);
                    System.out.println(hero.getName() + " нанес " + monster.getName() + " " + heroDamage + " единиц урона");
                                monster.regenerate();
                                if (monster.getHp() <= 0) {
                                System.out.println("” " + monster.getName() + " осталось 0 единиц здоровь€");
                                }else{
                                System.out.println("” " + monster.getName() + " осталось " + monster.getHp() + " единиц здоровь€");
                                }

                    // смерть монстра
                    if (monster.getHp() <= 0) {
                        System.out.println(monster.getName() + " убит");

                    } else {

                        System.out.println(monster.getName() + " наносит ответный удар");
                        int monsterDamage = (int) (1 + Math.random() * monster.getDamage());

                        // герой блокирует удар
                        int heroBlock = (int) (1 + Math.random() * 3);
                        if (heroBlock == 2) {
                            System.out.println(hero.getName() + " блокировал удар");
                            System.out.println("” " + hero.getName() + " осталось " + hero.getHp() + " единиц здоровь€");
                        } else {
                            // герой пропускает удар
                            hero.setHp(hero.getHp() - monsterDamage);
                            System.out.println(monster.getName() + " нанес " + hero.getName() + " " + heroDamage + " единиц урона");
                            System.out.println("” " + hero.getName() + " осталось " + hero.getHp() + " единиц здоровь€");
                            // смерть геро€
                            if (hero.getHp() <= 0){
                                System.out.println(hero.getName() + " убит. ¬ы проиграли");
                            }
                        }
                    }
                }

            // 2 - герой сдаетс€
            }else if(input.equals("2")){
                System.out.println("¬ы сдались!");
                hero.setHp(0);

            // 3 - герой пытаетс€ убежать
            }else if(input.equals("3")){
                int escape = (int) (1 + Math.random() * 4);
                if (escape >= 3){
                    System.out.println(hero.getName() + " удалось бежать!");
                    monster.setHp(0);
                }else if (escape == 1){
                    System.out.println(monster.getName() + " нанес смертельный удар в спину бегущему " + hero.getName() + "!");
                    hero.setHp(0);
                    System.out.println(hero.getName() + " убит. ¬ы проиграли");
                }else{
                    System.out.println(monster.getName() + " не позволил " + hero.getName() + " скрытьс€ с пол€ бо€!");
                }
            }
        }
        System.out.println("»гра окончена");
    }
}
