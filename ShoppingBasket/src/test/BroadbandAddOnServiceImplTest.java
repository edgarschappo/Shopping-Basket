package test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.acme.serviceavailability.TechnicalFailureException;

import lu.tango.onlinestore.Basket;
import lu.tango.onlinestore.BroadbandAddOnService;
import lu.tango.onlinestore.BroadbandAddOnServiceImpl;
import lu.tango.onlinestore.BroadbandProducts;

public class BroadbandAddOnServiceImplTest{

	private static BroadbandAddOnService broadbandAddOnService;
	
    @BeforeClass
    public static void defineBroadbandAddOnService(){
    	
    	//BroadbandAddOnService init
    	broadbandAddOnService = new BroadbandAddOnServiceImpl();
    }
    
    @Test
    public void serviceAllProductsAvailable(){
    	
    	//Test Available Products in the basket
        Basket basket = new Basket();
        broadbandAddOnService.checkForAddOnProducts(basket, "1111");
        int expected = BroadbandProducts.values().length;
        int result = basket.getAvailableProducts().size();
        Assert.assertEquals(expected, result);        
    }
    
    @Test
    public void serviceNoneProductsAvailable(){
    	
    	//Test non available products in the basket
    	int expected = 0;
    	
        Basket basket = new Basket();
        broadbandAddOnService.checkForAddOnProducts(basket, "2222");        
        int result = basket.getAvailableProducts().size();
        Assert.assertEquals(expected, result);
        
        basket = new Basket();
        broadbandAddOnService.checkForAddOnProducts(basket, "3333");
        result = basket.getAvailableProducts().size();
        Assert.assertEquals(expected, result);
        
        basket = new Basket();
        broadbandAddOnService.checkForAddOnProducts(basket, "4444");
        result = basket.getAvailableProducts().size();
        Assert.assertEquals(expected, result);        
    }
    
}
