package lu.tango.onlinestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum BroadbandProducts implements Product {

	TANGO_INTERNET_S {
        @Override
        public List<AddOn> getAddOns() {
            return new ArrayList<>();
        }
    },
	
	TANGO_INTERNET_M {
        @Override
        public List<AddOn> getAddOns() {        			
            return new ArrayList<AddOn>(
            		Arrays.asList(AddOn.BB_FIX_COMMUNICATION_ADD_ON, AddOn.BB_FIXED_SINGLE_IP_ADDRESS));
        }
    },
	
	TANGO_INTERNET_L {
        @Override
        public List<AddOn> getAddOns() {
        	return new ArrayList<AddOn>(
        			Arrays.asList(AddOn.BB_FIXED_SINGLE_IP_ADDRESS, AddOn.BB_FIXED_MULTIPLE_IP_ADDRESS));
        }
    }

}
