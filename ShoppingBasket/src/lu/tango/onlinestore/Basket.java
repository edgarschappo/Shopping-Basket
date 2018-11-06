package lu.tango.onlinestore;

import java.util.ArrayList;
import java.util.List;

public class Basket {

	private List<Product> availableProducts = new ArrayList<>();
	private String status;

	public List<Product> getAvailableProducts() {
		return availableProducts;
	}

	public void setAvailableProducts(List<Product> availableProducts) {
		this.availableProducts = availableProducts;
	}
	
	public String getAvailableProductsAsString() {
		StringBuilder result = new StringBuilder();
		for (Product product : availableProducts) {
			result.append(product.name() + "[ ");
			for (AddOn addOn : product.getAddOns())
				result.append(addOn.name() + ", ");
			result.append("] <br>");
		}
		return result.toString();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
