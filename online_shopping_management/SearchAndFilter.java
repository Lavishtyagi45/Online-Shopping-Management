package online_shopping_management;

import java.util.ArrayList;
import java.util.List;

public class SearchAndFilter {
    private List<Product> products = new ArrayList<>();

    // Method to search products based on a query
    public List<Product> searchProducts(String query) {
        List<Product> results = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(query.toLowerCase()) ||
                product.getDescription().toLowerCase().contains(query.toLowerCase())) {
                results.add(product);
            }
        }
        return results;
    }

    // Method to filter products based on price range
    public List<Product> filterProducts(double minPrice, double maxPrice) {
        List<Product> results = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                results.add(product);
            }
        }
        return results;
    }

    // Method to set the list of products
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}