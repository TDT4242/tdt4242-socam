package test;

import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Vehicle;
import org.junit.Assert;
import org.junit.Test;

import java.beans.PropertyChangeListener;

public class PersonTest {

    @Test
    public void constructorTests(){

        int custId = 1;
        String name = "Hal 9000";
        String email = "hal@ntnu.no";
        String street = "Munkegata";
        String city = "Trondheim";
        String vehicleID = "1";

        Person p1 = new Person(custId);

        Person p2 = new Person(custId, name, email, street, city, vehicleID);

        Assert.assertEquals(p1.getCustId(), custId);

        Assert.assertEquals(p2.getCustId(), custId);
        Assert.assertEquals(p2.getName(), name);
        Assert.assertEquals(p2.getEmail(), email);
        Assert.assertEquals(p2.getStreet(), street);
        Assert.assertEquals(p2.getCity(), city);
        Assert.assertEquals(p2.getVehicleID(), vehicleID);
    }

    @Test
    public void setterTests(){
        int custId = 1;
        String name = "Hal 9000";
        String email = "hal@ntnu.no";
        String street = "Munkegata";
        String city = "Trondheim";
        String vehicleID = "1";

        Person p2 = new Person(custId, name, email, street, city, vehicleID);

        p2.setCustId(custId+1);
        p2.setCity(city+"1");
        p2.setEmail(email+"1");
        p2.setName(name+"1");
        p2.setStreet(street+"1");
        p2.setVehicleID(p2.getVehicleID()+"1");

        Assert.assertEquals(p2.getId(), custId);
        Assert.assertEquals(p2.getCustId(), custId+1);
        Assert.assertEquals(p2.getName(), name+"1");
        Assert.assertEquals(p2.getEmail(), email+"1");
        Assert.assertEquals(p2.getStreet(), street+"1");
        Assert.assertEquals(p2.getCity(), city+"1");
        Assert.assertEquals(p2.getVehicleID(), vehicleID+"1");

    }

    @Test
    public void addAndRemovePropertyChangeListenerTests(){
        int custId = 1;
        String name = "Hal 9000";
        String email = "hal@ntnu.no";
        String street = "Munkegata";
        String city = "Trondheim";
        String vehicleID = "1";

        Person p2 = new Person(custId, name, email, street, city, vehicleID);

        PropertyChangeListener p = new Vehicle();
        p2.addPropertyChangeListener(p);
        p2.removePropertyChangeListener(p);
        // No getters for the propertyChangeListener, hence test is only that they work thus far.
    }

    @Test
    public void removePropertyChangeListenerTests(){
        int custId = 1;
        String name = "Hal 9000";
        String email = "hal@ntnu.no";
        String street = "Munkegata";
        String city = "Trondheim";
        String vehicleID = "1";

        Person p2 = new Person(custId, name, email, street, city, vehicleID);

        PropertyChangeListener p = new Vehicle();
        p2.removePropertyChangeListener(p);
        // No getters for the propertyChangeListener, hence test is only that they work thus far.
    }

    @Test
    public void toStringTest(){
        int custId = 1;
        String name = "Hal 9000";
        String email = "hal@ntnu.no";
        String street = "Munkegata";
        String city = "Trondheim";
        String vehicleID = "1";

        Person p2 = new Person(custId, name, email, street, city, vehicleID);

        String expectedString = "Name: " + name + "; " +
                "Email: " + email + "; " +
                "Street: " + street;

        Assert.assertEquals(p2.toString(), expectedString);
    }

    @Test
    public void equalsTests(){
        int custId = 1;
        String name = "Hal 9000";
        String email = "hal@ntnu.no";
        String street = "Munkegata";
        String city = "Trondheim";
        String vehicleID = "1";

        Person p2 = new Person(custId, name, email, street, city, vehicleID);

        Object p3 = new Object();

        Person p4 = new Person(custId, name+"stuff", email, street, city, vehicleID);

        Person p5 = new Person(custId, name, email+"stuff", street, city, vehicleID);

        Person p6 = new Person(custId, name, email, street+"stuff", city, vehicleID);

        Person p7 = new Person(custId+1, name, email, street, city, vehicleID);

        Person p8 = new Person(custId, name, email, street, city+"stuff", vehicleID);

        Person p9 = new Person(custId, name, email, street, city, vehicleID+"1");

        Person p10 = new Person(custId, name, email, street, city, vehicleID);


        Assert.assertTrue(p2.equals(p2));
        Assert.assertFalse(p2.equals(p3));
        Assert.assertFalse(p2.equals(p4));
        Assert.assertFalse(p2.equals(p5));
        Assert.assertFalse(p2.equals(p6));
        Assert.assertFalse(p2.equals(p7));
        Assert.assertFalse(p2.equals(p8));
        Assert.assertFalse(p2.equals(p9));
        Assert.assertTrue(p2.equals(p10));

    }

}
