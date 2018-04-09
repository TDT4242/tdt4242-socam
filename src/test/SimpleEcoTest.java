package test;

import no.ntnu.fp.model.SimpleEcu;
import no.ntnu.fp.model.Vehicle;
import org.junit.Assert;
import org.junit.Test;

import java.beans.PropertyChangeListener;

public class SimpleEcoTest {

    @Test
    public void constructorTests(){
        int ecuId = 1;
        int swId = 1;
        SimpleEcu ecu1 = new SimpleEcu(ecuId);
        SimpleEcu ecu2 = new SimpleEcu(ecuId, swId);
        SimpleEcu ecu3 = new SimpleEcu();

        Assert.assertEquals(ecu1.getEcuId(), ecuId);

        Assert.assertEquals(ecu2.getEcuId(), ecuId);
        Assert.assertEquals(ecu2.getSwId(), swId);
    }

    @Test
    public void gettersAndSettersTests(){
        int ecuId = 1;
        int swId = 1;
        SimpleEcu ecu = new SimpleEcu(ecuId, swId);


        ecu.setSwId(swId+1);
        Assert.assertEquals(ecu.getSwId(), swId+1);

        ecu.setEcuId(ecuId+1);
        Assert.assertEquals(ecu.getEcuId(), ecuId+1);

    }

    @Test
    public void addAndRemovePropertyChangeListenerTest(){
        int ecuId = 1;
        int swId = 1;
        SimpleEcu ecu = new SimpleEcu(ecuId, swId);

        PropertyChangeListener p = new Vehicle();
        ecu.addPropertyChangeListener(p);
        ecu.removePropertyChangeListener(p);

        // No getters for the propertyChangeListener, hence test is only that they work thus far.
    }

    @Test
    public void removePropertyChangeListenerNotPresentTest(){
        int ecuId = 1;
        int swId = 1;
        SimpleEcu ecu = new SimpleEcu(ecuId, swId);

        PropertyChangeListener p = new Vehicle();
        ecu.removePropertyChangeListener(p);
        // No getters for the propertyChangeListener, hence test is only that they work thus far.
    }

}
