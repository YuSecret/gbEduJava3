public class Cat {
    String name;
    public String color;
    private int age;

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @MyAnon
    public void info1() {
        System.out.println("info1 " + name + " " + color + " " + age);
    }

    @MyAnon(priotity = 2)
    public void info2() {
        System.out.println("info2 " + name + " " + color + " " + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
