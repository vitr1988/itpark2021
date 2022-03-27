package lesson22;

import org.junit.Assert;
import org.junit.Test;

public class AverageServiceTest {

    @Test
    public void shouldGetAverage() {
        AverageService averageService = new AverageService();
        Assert.assertEquals(10, averageService.avg(5, 15));
    }

    @Test
    public void shouldGetAverageFromArray() {
        AverageService averageService = new AverageService();
        Assert.assertEquals(22, averageService.avg(5, 15, 20, 48));
    }
}
