public class T1 {
    private int id;
    private String name;

    public T1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @BeforeSuite
    public void method1() {
        System.out.println("Method1 marked BeforeSuite");
    }
    @Test(priority = 10)
    public void method2() {
        System.out.println("Method2");
    }
    @Test(priority = 6)
    public void method3() {
        System.out.println("Method3");
    }
    @Test()
    public void method4() {
        System.out.println("Method4");
    }
    @Test()
    public void method5() {
        System.out.println("Method5");
    }
    @Test(priority = 1)
    public void method6() {
        System.out.println("Method6");
    }

    @AfterSuite
    public void method7() {
        System.out.println("Method5 marked AfterSuite");
    }
}
