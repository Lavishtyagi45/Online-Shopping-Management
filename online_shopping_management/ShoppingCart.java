package online_shopping_management;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products = new ArrayList<>();
    ProductManagement productManagement=new ProductManagement();

    public List<Product> getProducts() {
        return products;
    }

	public void addProductToCart(int id, Product product, int quantity) {
		products.add(product);
	}

	public boolean updateProductQuantity(int id, int productId, int quantity) {
		Product product=productManagement.getProductById(productId);
		if (products.contains(product)) {
            System.out.println("Updating quantity of " + product.getName() + " to " + quantity);
            return true;
        } else {
            System.out.println("Product " + product.getName() + " not found in cart.");
        }
		return false;
	}

	public boolean removeProductFromCart(int productId) {
		Product product=productManagement.getProductById(productId);
		if(products.contains(product)) {
		 products.remove(product);
		}
		return false;
	}

}