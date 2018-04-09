package test;

import no.ntnu.fp.model.Ecu;
import no.ntnu.fp.model.Vehicle;
import org.junit.Assert;
import org.junit.Test;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class VehicleTest {

    @Test
    public void constructorTests(){
        String veh1ID = "1";
        String veh1Series = "2";
        String veh1histoy = "3";
        ArrayList veh1ecus = new ArrayList(3);

        Vehicle veh1 = new Vehicle(veh1ID, veh1histoy, veh1ecus, veh1Series);
        Vehicle veh2 = new Vehicle();

        Assert.assertEquals(veh1.getVehicleID(), veh1ID);
        Assert.assertEquals(veh2.getVehicleID(), "");

        Assert.assertEquals(veh1.getHistoryLog(), veh1histoy);
        Assert.assertEquals(veh2.getHistoryLog(), "");

        Assert.assertEquals(veh1.getSeries(), veh1Series);
        Assert.assertEquals(veh2.getSeries(), "");

        Assert.assertEquals(veh1.getEcus(), veh1ecus);
        Assert.assertEquals(veh2.getEcus(), new ArrayList());
    }
}
