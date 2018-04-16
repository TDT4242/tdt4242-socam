package test;

import no.ntnu.fp.model.Software;
import no.ntnu.fp.model.Vehicle;
import org.junit.Assert;
import org.junit.Test;

import java.beans.PropertyChangeListener;

public class SoftwareTest {

    @Test
    public void constructorTests(){
        int sw = 1;
        int mv = 1;
        String url = "superUrl";

        Software s1 = new Software();

        Software s2 = new Software(sw, mv, url);

        Assert.assertEquals(s2.getSwVersion(), sw);
        Assert.assertEquals(s2.getMinorVersion(), mv);
        Assert.assertEquals(s2.getUrl(), url);
    }

    @Test
    public void getterAndSetterTests(){
        int sw = 1;
        int mv = 1;
        String url = "superUrl";

        Software s2 = new Software(sw, mv, url);

        s2.setSwVersion(sw+1);
        s2.setMinorVersion(mv+1);
        s2.setUrl(url+"@");

        Assert.assertEquals(s2.getSwVersion(), sw+1);
        Assert.assertEquals(s2.getMinorVersion(), mv+1);
        Assert.assertEquals(s2.getUrl(), url+"@");
    }

    @Test
    public void addAndRemovePropertyChangeListenerTest(){
        int sw = 1;
        int mv = 1;
        String url = "superUrl";

        Software s2 = new Software(sw, mv, url);

        PropertyChangeListener p = new Vehicle();
        s2.addPropertyChangeListener(p);
        s2.removePropertyChangeListener(p);

        // No getters for the propertyChangeListener, hence test is only that they work thus far.
    }

    @Test
    public void removePropertyChangeListenerNotPresentTest(){
        int sw = 1;
        int mv = 1;
        String url = "superUrl";

        Software s2 = new Software(sw, mv, url);

        PropertyChangeListener p = new Vehicle();
        s2.removePropertyChangeListener(p);
        // No getters for the propertyChangeListener, hence test is only that they work thus far.
    }

}
