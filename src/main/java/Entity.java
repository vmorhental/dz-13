public class Entity {
    private int id;
    private String firstName;
    private int age;
    private int rate;

    public Entity(int id, String firstName, int age, int rate) {
        this.id = id;
        this.firstName = firstName;
        this.age = age;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
