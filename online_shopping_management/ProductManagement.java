package online_shopping_management;

import java.util.*;
import java.io.*;

public class ProductManagement {
	private List<Product> products = new ArrayList<>();
	private static String FILE_PATH = "product.txt";

	public ProductManagement() {
		loadProductsFromFile();
	}

	public void addProduct(Product product) {
		products.add(product);
		saveProductsToFile();
	}

	public void editProduct(Product product) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId() == product.getId()) {
				products.set(i, product);
				break;
			}
		}
		saveProductsToFile();
	}

	public boolean deleteProduct(int id) {
		for (Product product : products) {
			if (product.getId() == id) {
				products.remove(product);
				saveProductsToFile();
				return true;
			}
		}
		return false;
	}

	public List<Product> getProducts() {
		return products;
	}

	private void loadProductsFromFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
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
			System.out.println("Error reading products from file: " + e.getMessage());
		}
	}

	private void saveProductsToFile() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
			for (Product product : products) {
				writer.write(product.getId() + "," + product.getName() + "," + product.getDescription() + ","
						+ product.getPrice() + "," + product.getCategory() + "," + product.getQuantity());
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error writing products to file: " + e.getMessage());
		}
	}

	protected Product getProductById(int productId) {
		for (Product product : products) {
			if (product.getId() == productId) {
				return product;
			}
		}
		return null;
	}

	protected int generateProductId() {
		int lastUsedId = products.isEmpty() ? 0 : products.get(products.size() - 1).getId();
		return lastUsedId + 1;
	}

	public void updateProduct(Product existingProduct) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Enter new product name : ");
			String name = scanner.nextLine();
			existingProduct.setName(name);

			System.out.print("Enter new product description : ");
			String description = scanner.nextLine();
			existingProduct.setDescription(description);

			System.out.print("Enter new product price : ");
			double price =Double.parseDouble(scanner.nextLine());
			existingProduct.setPrice(price);

			System.out.print("Enter new product category : ");
			String category = scanner.nextLine();
			existingProduct.setCategory(category);

			System.out.print("Enter new product quantity : ");
			int quantity = Integer.parseInt(scanner.nextLine());
			existingProduct.setQuantity(quantity);
		}catch(Exception e){
			System.out.println("Error while editing product");
		}
		scanner.close();
		editProduct(existingProduct);
	}

	public void updateProductQuantity(int productId, int i) {
		Product product = getProductById(productId);
		System.out.print("Enter new product quantity (enter -1 to keep current): ");
		int quantity = i;
		if (quantity != -1) {
			product.setQuantity(quantity);
		}
	}
}
