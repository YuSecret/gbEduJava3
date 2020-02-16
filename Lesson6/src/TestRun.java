import org.junit.*;

public class TestRun {
    Calculator calculator;
    Run run;

    @Before
    public void init() {
       run = new Run();
       calculator=new Calculator();
    }
    @Test
    public void testCalcArray1() {
        Assert.assertEquals(new int[]{1, 7}, run.calcArray(new int[] { 1, 2, 4, 4, 2, 3, 4, 1, 7 }));
    }

    @Test
    public void testCalcArray2() {
        Assert.assertEquals(new int[] {}, run.calcArray(new int[] { 1, 2, 4, 4, 2, 3, 4, 1, 4 }));
    }
    @Test(expected = RuntimeException.class)
    public void testCalcArray3() {
        Assert.assertEquals(new int[] {}, run.calcArray(new int[] { 1, 2, 5, 5, 2, 3, 5, 1, 0 }));
    }
    @Test()
    public void testCalcArray4() {
        Assert.assertEquals(new int[] {}, run.calcArray(new int[] { 4 }));
    }
}
