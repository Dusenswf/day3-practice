import org.junit.Assert;
import org.junit.Test;

public class StringCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) return 0;
        return getSum(text.split("-"));
    }

    private static int getSum(String[] values) {
        int result = 0;
        for (String value : values) {
            result += Integer.parseInt(value);
        }
        return result;
    }

    @Test
    public void testSplitAndSum(){
        StringCalculator s = new StringCalculator();
        int ret = s.splitAndSum("55-22-33");
        Assert.assertEquals(110, ret);
    }
}
