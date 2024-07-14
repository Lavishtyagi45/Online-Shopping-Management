package online_shopping_management;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products = new ArrayList<>();
    private static String CART_FILE_PATH = "cart.txt"; 
    ProductManagement productManagement = new ProductManagement();
    
    public ShoppingCart() {
        loadCartFromFile();
    }
        
    public List<Product> getProducts() {
        loadCartFromFile();
        return products;
    }

    public void addProductToCart(int id, Product product, int quantity) {
        product.setQuantity(quantity);
        products.add(product);
        saveCartToFile();
    }

    public boolean updateProductQuantity(int id, int productId, int quantity) {
        for (Product product : products) {
            if (product.getId() == productId) {
                product.setQuantity(quantity);
                saveCartToFile();
                System.out.println("Updating quantity of " + product.getName() + " to " + quantity);
                return true;
            }
        }
        System.out.println("Product with ID " + productId + " not found in cart.");
        return false;
    }

    public boolean removeProductFromCart(int productId) {
        Product productToRemove = null;
        for (Product product : products) {
            if (product.getId() == productId) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            products.remove(productToRemove);
            saveCartToFile();
            return true;
        }
        return false;
    }

    private void loadCartFromFile() {
        products.clear(); // Clear current products before loading from file
        try (BufferedReader reader = new BufferedReader(new FileReader(CART_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productData = line.split(",");
                if (productData.length == 6) {
                    int id = Integer.parseInt(productData[0]);
                    String name = productData[1];
                    String description = productData[2];
                    double price = Double.parseDouble(productData[3]);
                    String category = productData[4];
                    int quantity = Integer.parseInt(productData[5]);
                    products.add(new Product(id, name, description, price, category, quantity));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading cart from file: " + e.getMessage());
        }	
    }
    
    private void saveCartToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CART_FILE_PATH))) {
            for (Product product : products) {
                writer.write(product.getId() + "," + product.getName() + "," +
                        product.getDescription() + "," + product.getPrice() + "," +
                        product.getCategory() + "," + product.getQuantity());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing cart data to file: " + e.getMessage());
        }
    }
}
