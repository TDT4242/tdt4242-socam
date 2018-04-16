package test;


import no.ntnu.fp.model.Ecu;
import no.ntnu.fp.model.Vehicle;
import org.junit.Assert;
import org.junit.Test;

import java.beans.PropertyChangeListener;

public class EcuTest {

    @Test
    public void constructorTests(){
        int ecuId = 1;
        int swId = 1;
        int sub = 1;
        int newSub = 1;
        Ecu ecu1 = new Ecu(ecuId);
        Ecu ecu2 = new Ecu(ecuId, swId, sub);
        Ecu ecu3 = new Ecu(ecuId, swId, sub,true, newSub);

        Assert.assertEquals(ecu1.getEcuId(), ecuId);

        Assert.assertEquals(ecu2.getEcuId(), ecuId);
        Assert.assertEquals(ecu2.getSwId(), swId);
        Assert.assertEquals(ecu2.getSubSwId(), sub);

        Assert.assertEquals(ecu3.getEcuId(), ecuId);
        Assert.assertEquals(ecu3.getSwId(), swId);
        Assert.assertEquals(ecu3.getSubSwId(), sub);
        Assert.assertEquals(ecu3.getNewestSub(), newSub);
        Assert.assertTrue(ecu3.isNewest());

    }

    @Test
    public void gettersAndSettersTests(){
        int ecuId = 1;
        int swId = 1;
        int sub = 1;
        int newSub = 1;

        Ecu ecu = new Ecu(ecuId, swId, sub,true, newSub);

        ecu.setSubSwId(sub+1);
        Assert.assertEquals(ecu.getSubSwId(), sub+1);

        ecu.setSwId(swId+1);
        Assert.assertEquals(ecu.getSwId(), swId+1);

        ecu.setEcuId(ecuId+1);
        Assert.assertEquals(ecu.getEcuId(), ecuId+1);

        ecu.setNewestSub(newSub+1);
        Assert.assertEquals(ecu.getNewestSub(), newSub+1);

        ecu.setNewest(false);
        Assert.assertFalse(ecu.isNewest());
    }

    @Test
    public void addAndRemovePropertyChangeListenerTest(){
        int ecuId = 1;
        int swId = 1;
        int sub = 1;
        int newSub = 1;

        Ecu ecu = new Ecu(ecuId, swId, sub,true, newSub);

        PropertyChangeListener p = new Vehicle();
        ecu.addPropertyChangeListener(p);
        ecu.removePropertyChangeListener(p);

        // No getters for the propertyChangeListener, hence test is only that they work thus far.
    }

    @Test
    public void removePropertyChangeListenerNotPresentTest(){
        int ecuId = 1;
        int swId = 1;
        int sub = 1;
        int newSub = 1;

        Ecu ecu = new Ecu(ecuId, swId, sub,true, newSub);

        PropertyChangeListener p = new Vehicle();
        ecu.removePropertyChangeListener(p);
        // No getters for the propertyChangeListener, hence test is only that they work thus far.
    }

    @Test
    public void testGetECUID_PROPERTY_NAME(){
        // For some reason there is a getter for a public final static field in this class, but for 100% coverage we need this test.
        Assert.assertEquals(Ecu.getECUID_PROPERTY_NAME(), Ecu.ECUID_PROPERTY_NAME);
    }


}
