package com.acme.serviceavailability;

public interface AvailabilityChecker {
	public String isPostCodeInServicableArea(String postCode) throws TechnicalFailureException;
}
