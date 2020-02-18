import org.junit.*;

public class TestRun {
    Run run;
    //1 задание
    @Before
    public void init() {
       run = new Run();
    }
    @Test
    public void testCalcArray1_1() {
        Assert.assertArrayEquals(new int[]{1, 7}, run.calcArray(new int[] { 1, 2, 4, 4, 2, 3, 4, 1, 7 }));
    }

    @Test
    public void testCalcArray1_2() {
        Assert.assertArrayEquals(new int[] {}, run.calcArray(new int[] { 1, 2, 4, 4, 2, 3, 4, 1, 4 }));
    }
    @Test(expected = RuntimeException.class)
    public void testCalcArray1_3() {
        Assert.assertArrayEquals(new int[] {}, run.calcArray(new int[] { 1, 2, 5, 5, 2, 3, 5, 1, 0 }));
    }
    @Test()
    public void testCalcArray1_4() {
        Assert.assertArrayEquals(new int[] {}, run.calcArray(new int[] { 4 }));
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
