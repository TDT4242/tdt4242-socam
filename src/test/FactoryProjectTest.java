package test;

import no.ntnu.fp.model.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;

public class FactoryProjectTest {
    FactoryProject factoryProject;
    Software software;
    Vehicle vehicle;
    Ecu ecu;
    SimpleEcu simpleEcu;

    @Test
    public void constructorTest() {
        FactoryProject factoryProject1 = new FactoryProject();

        Assert.assertNotNull(factoryProject1);

        ArrayList vehicleList = new ArrayList();
        ArrayList softwareList = new ArrayList();
        ArrayList ecuList = new ArrayList();

        FactoryProject factoryProject2 = new FactoryProject(vehicleList, softwareList, ecuList);

        // No getters for the propertyChangeListener, hence test is only that they work thus far.
    }


    @Before
    public void setUp() throws Exception {
        factoryProject = new FactoryProject();
        software = new Software();
        vehicle = new Vehicle();
        ecu = new Ecu(1);
        simpleEcu = new SimpleEcu();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getVehicleCount() {
        Assert.assertEquals(0, factoryProject.getVehicleCount());
        factoryProject.addVehicle(vehicle);
        Assert.assertEquals(1, factoryProject.getVehicleCount());

    }

    @Test
    public void getSoftwareCount() {
        Assert.assertEquals(0, factoryProject.getSoftwareCount());

        factoryProject.addSoftware(software);
        Assert.assertEquals(1, factoryProject.getSoftwareCount());
    }

    @Test
    public void getVehicle() {

        factoryProject.addVehicle(vehicle);
        Assert.assertEquals(vehicle, factoryProject.getVehicle(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getVehicleEmptyList() {
        factoryProject.getVehicle(0);

    }

    @Test
    public void getSoftware() {
        factoryProject.addSoftware(software);
        Assert.assertEquals(software, factoryProject.getSoftware(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getSoftwareEmptyList() {
        factoryProject.getSoftware(0);
    }


    @Test
    public void getEcuCount() {
        factoryProject.addEcu(simpleEcu);
        Assert.assertEquals(1, factoryProject.getEcuCount());
    }

    @Test
    public void getLatestSoftware() {
        factoryProject.addSoftware(software);
        Software software1 = new Software();
        factoryProject.addSoftware(software1);
        Assert.assertEquals(software1, factoryProject.getLatestSoftware());

    }

    @Test
    public void getLatestVehicle() {
        factoryProject.addVehicle(vehicle);
        Vehicle vehicle1 = new Vehicle();
        factoryProject.addVehicle(vehicle1);
        Assert.assertEquals(vehicle1, factoryProject.getLatestVehicle());
    }

    @Test
    public void getLatestEcu() {
        factoryProject.addEcu(simpleEcu);
        SimpleEcu simpleEcu1 = new SimpleEcu();
        factoryProject.addEcu(simpleEcu1);
        Assert.assertEquals(simpleEcu1, factoryProject.getLatestEcu());
    }

    @Test
    public void getSoftwareIndex() {
        factoryProject.addSoftware(software);
        Assert.assertEquals(0, factoryProject.getSoftwareIndex(software));
    }

    @Test
    public void getEcu() {
        factoryProject.addEcu(simpleEcu);
        Assert.assertEquals(simpleEcu, factoryProject.getEcu(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getEcuEmptyList() {
        factoryProject.getEcu(0);
    }

    @Test
    public void getVehicleIndex() {
        Assert.assertEquals(-1, factoryProject.getVehicleIndex("2"));
        vehicle.setVehicleID("2");
        factoryProject.addVehicle(vehicle);
        Assert.assertEquals(0, factoryProject.getVehicleIndex("2"));
    }

    @Test
    public void indexOf() {
        Assert.assertEquals(-1, factoryProject.indexOf(vehicle));
        factoryProject.addVehicle(vehicle);
        Assert.assertEquals(0, factoryProject.indexOf(vehicle));
    }

    @Test
    public void iterator() {
        factoryProject.addVehicle(vehicle);
        Vehicle vehicle1 = new Vehicle();
        factoryProject.addVehicle(vehicle1);

        Iterator iterator = factoryProject.iterator();

        Assert.assertEquals(factoryProject.getVehicle(0), iterator.next());
        Assert.assertEquals(factoryProject.getVehicle(1), iterator.next());

    }


    @Test
    public void removeVehicle() {
        factoryProject.addVehicle(vehicle);
        Assert.assertEquals(1, factoryProject.getVehicleCount());
        factoryProject.removeVehicle(vehicle);
        Assert.assertEquals(0, factoryProject.getVehicleCount());
    }

    @Test
    public void equalsTest(){
        Assert.assertEquals(true, factoryProject.equals(factoryProject));
        Assert.assertEquals(false, factoryProject.equals(vehicle));

        FactoryProject factoryProject1 = new FactoryProject();

        Assert.assertEquals(true, factoryProject.equals(factoryProject1));

        factoryProject.addVehicle(vehicle);
        Assert.assertEquals(false, factoryProject.equals(factoryProject1));

        factoryProject1.addVehicle(vehicle);
        Assert.assertEquals(true, factoryProject.equals(factoryProject1));


        Vehicle vehicle1 = new Vehicle();
        factoryProject.removeVehicle(vehicle);
        factoryProject.addVehicle(vehicle1);
        Assert.assertEquals(false, factoryProject.equals(factoryProject1));



    }

    @Test
    public void toStringTest(){
        String expected = "project:\n";
        Assert.assertEquals(expected,factoryProject.toString());
        expected = "project:\n"+vehicle.toString()+"\n";
        factoryProject.addVehicle(vehicle);
        Assert.assertEquals(expected,factoryProject.toString());

    }

    @Test
    public void propertyChangeTest(){
        PropertyChangeListener p = new FactoryProject();
        factoryProject.addPropertyChangeListener(p);
        factoryProject.removePropertyChangeListener(p);

        Vehicle v = new Vehicle();
        String oldVal = "0";
        String newVal = "1";
        v.setVehicleID(oldVal);
        v.setVehicleID(newVal);
        v.addPropertyChangeListener(factoryProject);
        PropertyChangeEvent e = new PropertyChangeEvent(v, "vehicleId", oldVal, newVal);
        p.propertyChange(e);
        Assert.assertEquals(newVal, v.getVehicleID());

    }

}
