
public abstract class Monster {

    private String name;

    Monster(String  name){
        this.name = name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
