package git.javabootcamp.orders;

public class Order {
	private int ClientId;
	private long RequestId;
	private String Name;
	private int Quantity;
	private float Price;

	public Order(int clientId, long requestId, String name, int quantity, float price) {
		this.ClientId = clientId;
		this.RequestId = requestId;
		this.Name = name;
		this.Quantity = quantity;
		this.Price = price;
	}

	public int getClientId() {
		return ClientId;
	}

	public void setClientId(int clientId) {
		ClientId = clientId;
	}

	public long getRequestId() {
		return RequestId;
	}

	public void setRequestId(long requestId) {
		RequestId = requestId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "Order [ClientId=" + ClientId + ", RequestId=" + RequestId + ", Name=" + Name + ", Quantity=" + Quantity
				+ ", Price=" + Price + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof Order) {
			Order order = (Order) obj;

			if (order.getClientId() == this.getClientId() && order.getRequestId() == this.getRequestId()
					&& order.getName().equals(this.getName()) && order.getQuantity() == this.getQuantity()
					&& order.getPrice() == this.getPrice()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.getClientId()*3 + this.getQuantity()*5;
	}

}