package test;

import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Project;
import no.ntnu.fp.model.Vehicle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;

public class ProjectTest {

    Project p;
    Person per1;
    Person per2;

    @Before
    public void constructorTests(){
        p = new Project();
        per1 = new Person(1);
        per2 = new Person(2, "Mr. Person", "mrperson@gmail.com", "someStreet", "someCity", "123");
    }

    @Test
    public void testIndexOf(){
        // Expect -1 when not present, index when present
        Assert.assertEquals(-1, p.indexOf(per1));

        p.addPerson(per1);
        Assert.assertEquals(0, p.indexOf(per1));
    }

    @Test
    public void testToString(){
        p.addPerson(per1);
        Assert.assertEquals("project:\n" + per1.toString() + "\n", p.toString());
    }

    @Test
    public void testEqual(){
        Project p2 = new Project();
        Assert.assertTrue(p.equals(p2));

        Object o = new Object();
        Assert.assertFalse(p.equals(o));

        p.addPerson(per1);
        p2.addPerson(per1);
        Assert.assertTrue(p.equals(p2));

        p.addPerson(per2);
        Assert.assertFalse(p.equals(p2));

        p.removePerson(per1);
        Assert.assertFalse(p.equals(p2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetPerson(){
        p.addPerson(per1);
        Assert.assertEquals(per1, p.getPerson(p.indexOf(per1)));

        // Test that you cannot get person at indexOutOfBounds
        p.getPerson(9000); }

    @Test
    public void testProperyChange(){
        Vehicle v = new Vehicle();
        String oldVal = "0";
        String newVal = "1";
        v.setVehicleID(oldVal);
        v.setVehicleID(newVal);
        v.addPropertyChangeListener(p);
        PropertyChangeEvent e = new PropertyChangeEvent(v, "vehicleId", oldVal, newVal);
        p.propertyChange(e);
        Assert.assertEquals(newVal, v.getVehicleID());

    }

    @Test
    public void testAddRemoveChangeListener(){
        PropertyChangeListener p= new Vehicle();

        // Remove on that is not added
        this.p.removePropertyChangeListener(p);

        // Remove one that is added
        this.p.addPropertyChangeListener(p);
        this.p.removePropertyChangeListener(p);

        // No getters for the propertyChangeListener, hence test is only that they work thus far.

    }

    @Test
    public void testRemovePerson(){
        p.addPerson(per1);
        p.removePerson(per1);
        Assert.assertFalse(p.contains(per1));
        p.removePerson(per2);
    }

    @Test
    public void testGetLargestCustId(){
        Assert.assertEquals(0, p.getLargestCustId());

        p.addPerson(per1);
        Assert.assertEquals(per1.getCustId(), p.getLargestCustId());

        p.addPerson(per2);
        Assert.assertEquals(per2.getCustId(), p.getLargestCustId());

    }

    @Test
    public void testIterator(){
        ArrayList perList = new ArrayList();
        perList.add(per1);
        perList.add(per2);

        p.addPerson(per1);
        p.addPerson(per2);

        Iterator pIt = p.iterator();
        Iterator perListIt = perList.iterator();
        while(pIt.hasNext()){
            Assert.assertEquals(perListIt.next(), pIt.next());
        }

    }


    @Test
    public void testGetPersonIndex(){
        // TODO: The getpersonindex methods make no sense, as you can see I have to case the vehicleid to an int although data type is string q.q
        // It works for now though
        ArrayList<Integer> list = new ArrayList<>();
        Assert.assertEquals(list, p.getPersonIndex(per2.getName()));
        Assert.assertEquals(-1, p.getPersonIndex(Integer.parseInt(per2.getVehicleID())));

        p.addPerson(per2);
        list.add(p.indexOf(per2));
        Assert.assertEquals(list, p.getPersonIndex(per2.getName()));
        Assert.assertEquals(0, p.getPersonIndex(Integer.parseInt(per2.getVehicleID())));
    }

    @Test
    public void testAddPerson(){
        Assert.assertFalse(p.contains(per1));

        p.addPerson(per1);
        Assert.assertTrue(p.contains(per1));
    }

    @Test
    public void testContains(){
        Assert.assertFalse(p.contains(per1));

        p.addPerson(per1);
        Assert.assertTrue(p.contains(per1));
    }

}
