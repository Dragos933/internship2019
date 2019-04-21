package Tests.Distance;

import Model.Distance.Distance;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestDistance
{
    @Test
    public void testDistance()
    {
        Distance d1 = new Distance(1, "User", "ATM 1", 5);
        Distance d2 = new Distance(2, "User", "ATM 2", 60);

        assertEquals((int) d1.getID(), 1);
        assertEquals(d1.getFrom(), "User");
        assertEquals(d1.getTo(), "ATM 1");
        assertEquals(d1.getDuration(), 5);

        assertEquals(d2.getDuration(), 60);
        d2.setDuration(100);
        assertEquals(d2.getDuration(), 100);

        //System.out.println(d1.toString());
    }
}
