package assignment;

public class StoreEntity {

	int userId;
	int orderId;
	String orderDate;
	int orderTotal;
	String orderStatus;
	String userName;
	int productId;
	String pName;
	
	public int getUserId() {
		return userId;
	}
	
	public void setId(int userId) {
		this.userId = userId;
	}
	
	public void setPid(int pId) {
		this.productId = pId;
	}
	
	public int getPid() {
		return productId;
	}
	
	public void setPname(String pName) {
		this.pName = pName;
	}
	
	public String getPname() {
		return pName;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getOrderTotal() {
		return orderTotal;
	}
	
	public void setUserName(String name) {
		this.userName = name;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}
	
	public String getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	@Override
	public String toString() {
		return "UserId: " + userId + "\t OrderId: " + orderId + "\t OrderDate: "
				+ orderDate + "\t OrderTotal: " + orderTotal + "\t OrderStatus: "
				+ orderStatus;
	}

}
