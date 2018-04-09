package test;

import no.ntnu.fp.model.Project;
import no.ntnu.fp.model.Vehicle;
import no.ntnu.fp.model.Ecu;
import org.junit.Assert;
import org.junit.Test;

import java.beans.PropertyChangeEvent;
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

    @Test
    public void setterTests(){
        String veh1ID = "IDSTRING";
        String veh1Series = "SeriesString";
        String veh1history = "HistoryString";

        Vehicle veh1 = new Vehicle();

        veh1.setVehicleID(veh1ID);
        Assert.assertEquals(veh1.getVehicleID(), veh1ID);

        veh1.setSeries(veh1Series);
        Assert.assertEquals(veh1.getSeries(), veh1Series);

        veh1.setHistoryLog(veh1history);
        Assert.assertEquals(veh1.getHistoryLog(), veh1history);
    }

    @Test
    public void ecuTests(){
        Ecu ecu1 = new Ecu(4);
        Ecu ecu2 = new Ecu(8);


        Vehicle veh1 = new Vehicle();

        veh1.addEcu(ecu1);
        veh1.addEcu(ecu2);

        Assert.assertEquals(veh1.getEcuCount(), 2);
        Assert.assertEquals(veh1.getEcu(0), ecu1);
        Assert.assertEquals(veh1.getLargestEcuId(), 8);
        Assert.assertEquals(veh1.contains(ecu1), true);

        veh1.removeEcu(ecu1);
        Assert.assertEquals(veh1.getEcuCount(), 1);

    }

    @Test
    public void propertyChangeTests(){
        Vehicle vh1 = new Vehicle();
        Vehicle vh2 = new Vehicle();
        Project pj1 = new Project();
        PropertyChangeEvent pce = new PropertyChangeEvent(new Object(), "", new Object(), new Object() );

        vh1.addPropertyChangeListener(vh2);
        vh1.propertyChange(pce);
        vh2.addPropertyChangeListener(pj1);
        vh2.removePropertyChangeListener(vh2);

    }

    @Test
    public void findDotTest(){
        Vehicle vh1 = new Vehicle();
        String dotString = "abc.abc";
        String noDot = "abcabc";
        int loc = 3;
        int noLoc = -1;

        Assert.assertEquals(vh1.findDot(dotString), loc);
        Assert.assertEquals(vh1.findDot(noDot), noLoc);
    }
}
