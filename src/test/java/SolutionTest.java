import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        int n = 5;
        int[][] queries = {
                {2,4},
                {0,2},
                {0,4}
        };

        int[] expected = {3,2,1};
        int[] actual = new Solution().shortestDistanceAfterQueries(n, queries);

        Assert.assertArrayEquals(expected, actual);
    }
}
