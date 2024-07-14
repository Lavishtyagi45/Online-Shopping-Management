package online_shopping_management;

import java.util.HashMap;
import java.util.Map;

public class OrderTracking {
	private Map<Integer, String> orderStatusMap = new HashMap<>();
	OrderManagement orderManagement = new OrderManagement();

	public boolean updateOrderStatus(int id, String status) {
		Order order = orderManagement.getOrderByOrderId(id);
		if (order != null) {
			orderStatusMap.put(id, status);
			System.out.println("Order " + id + " status updated to: " + status);
			return true;
		}
		return false;
	}

	public String getOrderStatus(int id) {
		return orderStatusMap.getOrDefault(id, "Order not found");
	}
}