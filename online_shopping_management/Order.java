package online_shopping_management;

class Order {
    private int id;
    private int userId;
    private int productId;
    private int quantity;
    private double total;
    private String status;
    private String address;

    public Order(int id, int userId, int productId, int quantity, double total, String status, String address) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.total = total;
        this.status = status;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String toString() {
    	return "Order{" +
                "id=" + id +
                ", userId=" + userId + 
                ", productId="+ productId+
        ", quantity="+quantity+
        ", total="+ total+
        ", status='"+status+'\''+
        ", address='"+ address+'\''+
                '}';
    }
}

