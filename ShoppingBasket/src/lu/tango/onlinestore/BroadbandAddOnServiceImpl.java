package lu.tango.onlinestore;

import java.util.Arrays;
import java.util.logging.Logger;

import com.acme.serviceavailability.AvailabilityChecker;
import com.acme.serviceavailability.AvailabilityCheckerImpl;
import com.acme.serviceavailability.ServiceStatus;
import com.acme.serviceavailability.TechnicalFailureException;

public class BroadbandAddOnServiceImpl implements BroadbandAddOnService {

	private final static Logger logger = Logger.getLogger("BroadbandAddOnServiceImpl");

	@Override
	public void checkForAddOnProducts(Basket basket, String postCode) {

		try {
			AvailabilityChecker ac = new AvailabilityCheckerImpl();
			String serviceStatus = ac.isPostCodeInServicableArea(postCode);

			//define status in the basket
			basket.setStatus(serviceStatus);

			//If service available put products in the basket
			if (serviceStatus.equals(ServiceStatus.SERVICE_AVAILABLE.name())) {
				basket.setAvailableProducts(Arrays.asList((BroadbandProducts.values())));
				logger.info("Products added");
			}
		} catch (TechnicalFailureException tfe) {
			logger.warning("Technical Failure.");
			tfe.printStackTrace();
		}

	}

}
