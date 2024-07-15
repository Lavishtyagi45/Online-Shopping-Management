package online_shopping_management;

import java.io.*;
import java.util.*;

public class OrderManagement {
    private List<Order> orders = new ArrayList<>();
    private static final String FILE_PATH = "order.txt";

    public OrderManagement() {
        loadOrdersFromFile();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        saveOrdersToFile();
    }

    private void loadOrdersFromFile() {
    	orders.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] orderData = line.split(",");
                if (orderData.length == 7) {
                    int id = Integer.parseInt(orderData[0]);
                    int userId = Integer.parseInt(orderData[1]);
                    int productId = Integer.parseInt(orderData[2]);
                    int quantity = Integer.parseInt(orderData[3]);
                    double total = Double.parseDouble(orderData[4]);
                    String status = orderData[5];
                    String address = orderData[6];
                    orders.add(new Order(id, userId, productId, quantity, total, status, address));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading orders from file: " + e.getMessage());
        }
    }

    private void saveOrdersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Order order : orders) {
                writer.write(order.getId() + "," + order.getUserId() + "," +
                        order.getProductId() + "," + order.getQuantity() + "," +
                        order.getTotal() + "," + order.getStatus() + "," +
                        order.getAddress());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing orders to file: " + e.getMessage());
        }
    }

    protected int generateOrderId() {
        int lastUsedId = orders.isEmpty() ? 0 : orders.get(orders.size() - 1).getId();
        return lastUsedId + 1;
    }

	public List<Order> getOrdersByUserId(int userId) {
		List<Order> results = new ArrayList<>();
        for (Order order : orders) {
            if (order.getUserId()==userId) {
                results.add(order);
            }
        }
        return results;
        }

	public boolean cancelOrder(int orderIdToCancel, int id) {
		Order order=getOrderByOrderId(orderIdToCancel);
		if(order!=null) {
			orders.remove(order);
			saveOrdersToFile();
			return true;
		}
		return false;
	}

	public Order getOrderByOrderId(int orderIdToCancel) {
		loadOrdersFromFile();
        for (Order order : orders) {
            if (order.getId()==orderIdToCancel) {
                return order;
            }
        }
		return null;
	}

	public List<Order> getAllOrders() {
		return orders;
	}

	public void updateOrder(Order updatedOrder) {
	    int orderIdToUpdate = updatedOrder.getId();
	    for (int i = 0; i < orders.size(); i++) {
	        Order existingOrder = orders.get(i);
	        if (existingOrder.getId() == orderIdToUpdate) {
	            existingOrder.setStatus(updatedOrder.getStatus());
	            existingOrder.setAddress(updatedOrder.getAddress());
	            saveOrdersToFile();
	            System.out.println("Order with ID " + orderIdToUpdate + " updated successfully.");
	            return; 
	        }
	    }
	    System.out.println("Order with ID " + orderIdToUpdate + " not found. No update performed.");
	}


}
