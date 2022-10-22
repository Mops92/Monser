import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Hero hero = new Hero();
        hero.inputName();

        System.out.println(hero.getName() + " �������� ���� �����������");

        Troll monster = new Troll("Troll");

        System.out.println(hero.getName() + " �������� � ������! �� ���� �� ���� �������� " + monster.getName());
        System.out.println(
                "���� ��������?" +
                "\n������� 1, ����� �������" +
                "\n������� 2, ����� �������" +
                "\n������� 3, ����� ����������� �������");


        Scanner scr = new Scanner(System.in);

        while(monster.getHp() > 0 && hero.getHp() > 0 ){
            String input = scr.nextLine();

            //  1 - ����� ������� ����

            if(input.equals("1")) {

                int heroDamage = (int) (1 + Math.random() * hero.getDamage());

                // ������ ��������� ���� � ���� � �����
                int monsterBlock = (int) (1 + Math.random() * 3);
                if (monsterBlock == 2){
                    System.out.println(monster.getName() + " ���������� ����");
                    System.out.println("� " + monster.getName() + " �������� " + monster.getHp() + " ������ ��������");
                    System.out.println(monster.getName() + " ������� �������� ����");
                    int monsterDamage = (int) (1 + Math.random() * monster.getDamage());

                    int heroBlock = (int) (1 + Math.random() * 3);
                    if (heroBlock == 2) {
                        System.out.println(hero.getName() + " ���������� ����");
                        System.out.println("� " + hero.getName() + " �������� " + hero.getHp() + " ������ ��������");
                    } else {
                        hero.setHp(hero.getHp() - monsterDamage);
                        System.out.println(monster.getName() + " ����� " + hero.getName() + " " + heroDamage + " ������ �����");
                        System.out.println("� " + hero.getName() + " �������� " + hero.getHp() + " ������ ��������");
                    }

                }else {
                    // ������ ���������� ����
                    monster.setHp(monster.getHp() - heroDamage);
                    System.out.println(hero.getName() + " ����� " + monster.getName() + " " + heroDamage + " ������ �����");
                                monster.regenerate();
                                if (monster.getHp() <= 0) {
                                System.out.println("� " + monster.getName() + " �������� 0 ������ ��������");
                                }else{
                                System.out.println("� " + monster.getName() + " �������� " + monster.getHp() + " ������ ��������");
                                }

                    // ������ �������
                    if (monster.getHp() <= 0) {
                        System.out.println(monster.getName() + " ����");

                    } else {

                        System.out.println(monster.getName() + " ������� �������� ����");
                        int monsterDamage = (int) (1 + Math.random() * monster.getDamage());

                        // ����� ��������� ����
                        int heroBlock = (int) (1 + Math.random() * 3);
                        if (heroBlock == 2) {
                            System.out.println(hero.getName() + " ���������� ����");
                            System.out.println("� " + hero.getName() + " �������� " + hero.getHp() + " ������ ��������");
                        } else {
                            // ����� ���������� ����
                            hero.setHp(hero.getHp() - monsterDamage);
                            System.out.println(monster.getName() + " ����� " + hero.getName() + " " + heroDamage + " ������ �����");
                            System.out.println("� " + hero.getName() + " �������� " + hero.getHp() + " ������ ��������");
                            // ������ �����
                            if (hero.getHp() <= 0){
                                System.out.println(hero.getName() + " ����. �� ���������");
                            }
                        }
                    }
                }

            // 2 - ����� �������
            }else if(input.equals("2")){
                System.out.println("�� �������!");
                hero.setHp(0);

            // 3 - ����� �������� �������
            }else if(input.equals("3")){
                int escape = (int) (1 + Math.random() * 4);
                if (escape >= 3){
                    System.out.println(hero.getName() + " ������� ������!");
                    monster.setHp(0);
                }else if (escape == 1){
                    System.out.println(monster.getName() + " ����� ����������� ���� � ����� �������� " + hero.getName() + "!");
                    hero.setHp(0);
                    System.out.println(hero.getName() + " ����. �� ���������");
                }else{
                    System.out.println(monster.getName() + " �� �������� " + hero.getName() + " �������� � ���� ���!");
                }
            }
        }
        System.out.println("���� ��������");
    }
}
