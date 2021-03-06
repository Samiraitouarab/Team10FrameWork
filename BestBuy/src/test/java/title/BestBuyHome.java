package title;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ApplicationLog;
import reporting.TestLogger;

import javax.smartcardio.CommandAPDU;

public class BestBuyHome extends CommonAPI {
    @Test
    public void test() {
        ApplicationLog.epicLogger();
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        String tittle = driver.getTitle();
        System.out.println(tittle);
        Assert.assertEquals(tittle, "Best Buy | Official Online Store | Shop Now & Save");
    }
}