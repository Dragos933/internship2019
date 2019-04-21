package Tests.Distance;

import Exceptions.ValidatorException;
import Model.Distance.Distance;
import Repository.DistanceRepo;
import Service.DistanceService;
import Validator.DistanceValidator;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class TestDistanceService
{
    @Test
    public void testDistanceService() throws ValidatorException {
        DistanceValidator validator = new DistanceValidator();
        DistanceRepo repo = new DistanceRepo(validator);
        DistanceService srv = new DistanceService(repo);

        Distance d1 = new Distance(1, "User", "ATM 1", 5);
        Distance d2 = new Distance(2, "User", "ATM 2", 60);
        Distance d3 = new Distance(3, "User", "ATM 3", 45);

        assertEquals(srv.size(), 0);

        srv.add(d1);
        assertEquals(srv.size(), 1);
        srv.add(d2);
        srv.add(d3);
        assertEquals(srv.size(), 3);

        srv.delete(d1.getID());
        assertEquals(srv.size(), 2);
        assertEquals(srv.find(1), null);
        assertEquals(srv.find(2), d2);

        Distance d4 = new Distance(3, "ATM 1", "ATM 3", 50);
        srv.update(d4);

        Map<Integer, Distance> distances = new HashMap<Integer, Distance>();
        distances.put(d2.getID(), d2);
        distances.put(d3.getID(), d3);
        distances.put(d4.getID(), d4);
        assertEquals(distances.toString(), srv.getDistances().toString());

        //System.out.println(srv.toString());
    }
}
