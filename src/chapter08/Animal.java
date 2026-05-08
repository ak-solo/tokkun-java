package chapter08;

// ベースクラス（変更しない）
public class Animal {

    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String showProfile() {
        return name + "," + age + "歳";
    }

    public String speak() {
        return "......";
    }
}
