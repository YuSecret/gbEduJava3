import org.junit.*;

public class TestRun {
    Run run;

    @Before
    public void init() {
       run = new Run();
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
    //2 задание
    @Test()
    public void testCalcArray2_1() {
        Assert.assertEquals(true, run.find1or4int(new int[] { 4 }));
    }
    //2 задание
    @Test()
    public void testCalcArray2_2() {
        Assert.assertEquals(false, run.find1or4int(new int[] { 8, 3 , 5, 9 }));
    }

}
