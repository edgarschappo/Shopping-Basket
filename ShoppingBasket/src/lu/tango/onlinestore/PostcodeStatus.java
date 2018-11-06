package lu.tango.onlinestore;

import com.acme.serviceavailability.ServiceStatus;

public enum PostcodeStatus {

	AVAILABLE("1", ServiceStatus.SERVICE_AVAILABLE), UNAVAILABLE("2", ServiceStatus.SERVICE_UNAVAILABLE), PLANNED("3",
			ServiceStatus.SERVICE_PLANNED), INVALID("4", ServiceStatus.POSTCODE_INVALID);

	public ServiceStatus getServiceStatus() {
		return serviceStatus;
	}

	private String prefix;
	private ServiceStatus serviceStatus;

	PostcodeStatus(String prefix, ServiceStatus serviceStatus) {
		this.prefix = prefix;
		this.serviceStatus = serviceStatus;
	}

	// Verify if postCode start with a mapped prefix
	public boolean postcodeMatches(String postCode) {
		return postCode.startsWith(prefix);
	}
}
