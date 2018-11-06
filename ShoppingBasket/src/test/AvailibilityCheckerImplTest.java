package test;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.acme.serviceavailability.AvailabilityChecker;
import com.acme.serviceavailability.AvailabilityCheckerImpl;
import com.acme.serviceavailability.ServiceStatus;
import com.acme.serviceavailability.TechnicalFailureException;

public class AvailibilityCheckerImplTest {
    
    private static AvailabilityChecker availabilityChecker;
    
    @BeforeClass
    public static void defineAvailabilityChecker(){
    	
    	//AvailabilityChecker Init
        availabilityChecker = new AvailabilityCheckerImpl();
    }

    @Test
    public void isPostCodeInServicableAreaTest() throws TechnicalFailureException {
    	
    	//Test SERVICE_AVAILABLE
        String expected = ServiceStatus.SERVICE_AVAILABLE.name();
        String result = availabilityChecker.isPostCodeInServicableArea("1111");
        Assert.assertEquals(expected, result);
        
        //Test SERVICE_UNAVAILABLE
        expected = ServiceStatus.SERVICE_UNAVAILABLE.name();
        result = availabilityChecker.isPostCodeInServicableArea("2222");
        Assert.assertEquals(expected, result);
        
        //Test SERVICE_PLANNED
        expected = ServiceStatus.SERVICE_PLANNED.name();
        result = availabilityChecker.isPostCodeInServicableArea("3333");
        Assert.assertEquals(expected, result);
        
        //Test POSTCODE_INVALID
        expected = ServiceStatus.POSTCODE_INVALID.name();
        result = availabilityChecker.isPostCodeInServicableArea("4444");
        Assert.assertEquals(expected, result);
    }
    
    @Test(expected=TechnicalFailureException.class)
    public void isPostCodeInServicableAreaExceptionTest() throws TechnicalFailureException {
    	
    	//Test TechnicalFailureException
        String expected = "";
        String result = availabilityChecker.isPostCodeInServicableArea("5555");
        Assert.assertEquals(expected, result);
    }
    
}
