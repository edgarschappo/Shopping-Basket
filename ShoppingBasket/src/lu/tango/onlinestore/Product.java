package lu.tango.onlinestore;

import java.util.List;

public interface Product {
	
	List<AddOn> getAddOns();
    String name();
}
