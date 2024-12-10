package MotoPartsShop.Entity;

public class BillDetail {
	private int id;
	private int id_product;
	private int id_bills;
	private int quanty;
	private double total;
	public BillDetail() {
		super();
	}
	public int getId_bills() {
		return id_bills;
	}
	public void setId_bills(int id_bills) {
		this.id_bills = id_bills;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public int getQuanty() {
		return quanty;
	}
	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
