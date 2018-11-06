package com.acme.serviceavailability;

import lu.tango.onlinestore.PostcodeStatus;

public class AvailabilityCheckerImpl implements AvailabilityChecker {

	@Override
	public String isPostCodeInServicableArea(String postCode) throws TechnicalFailureException {
		
		 String serviceStatus = getServiceCode(postCode);
	     return serviceStatus;
	}

	private static String getServiceCode(String postCode) throws TechnicalFailureException {
		
		//Verify if some postcode match
		for (PostcodeStatus codeStatus : PostcodeStatus.values()) {
			if (codeStatus.postcodeMatches(postCode)) {
				return codeStatus.getServiceStatus().name();
			}
		}

		//If any postcode match
		throw new TechnicalFailureException();
	}
}
