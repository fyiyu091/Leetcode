package miscellaneous;

import org.junit.Assert;
import org.junit.Test;

public class HappyNumberTest {
    @Test
    public void test() {
        HappyNumber hn = new HappyNumber();
        boolean res = hn.isHappy(25);
        Assert.assertFalse(res);
    }

    @Test
    public void testTrue() {
        HappyNumber hn = new HappyNumber();
        boolean res = hn.isHappy(1);
        Assert.assertFalse(res);
    }

    
}
