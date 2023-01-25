import static org.junit.Assert.*;
import org.junit.*;

public class ArrayTests {
	@Test 
	public void testReverseInPlace() {
    int[] input1 = { 1, 2, 3 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{ 3, 2, 1 }, input1);
	}


  @Test
  public void testReversed() {
    int[] input1 = { 1, 2, 3, 4 };
    assertArrayEquals(new int[]{ 4, 3, 2, 1 }, ArrayExamples.reversed(input1));
  }

  @Test
  public void testAverageWithoutLowest()
  {
    double[] testAry = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
    double testAns = ArrayExamples.averageWithoutLowest(testAry);
    assertEquals(2.0, testAns, 0.001);
  }
}
