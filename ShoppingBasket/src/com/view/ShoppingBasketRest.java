package com.view;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.acme.serviceavailability.ServiceStatus;

import lu.tango.onlinestore.Basket;
import lu.tango.onlinestore.BroadbandAddOnServiceImpl;

@Path("/service")
public class ShoppingBasketRest {

	@GET
	@Path("/showBasket")
	@Produces(MediaType.TEXT_HTML)
	public Response sendMessage(@QueryParam("postcode") String postcode) {

		Response response = null;
		try {
			Basket basket = new Basket();
			new BroadbandAddOnServiceImpl().checkForAddOnProducts(basket, postcode);

			if (basket.getStatus() != null) {
				if (basket.getStatus().equals(ServiceStatus.SERVICE_AVAILABLE.name())) {
					String availableProducts = basket.getAvailableProductsAsString();
					response = Response.status(Response.Status.OK)
							.entity(basket.getStatus() + "<br>" + availableProducts).build();
				} else {
					response = Response.status(Response.Status.OK).entity(basket.getStatus()).build();
				}
			} else {
				response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			}

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}

		return response;
	}
}