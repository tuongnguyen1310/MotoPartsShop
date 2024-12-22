package MotoPartsShop.DTO;

public class BillDetailDto {
    private int bill_detail_id; // ID chi tiết hóa đơn (trùng với tên trong SQL)
    private int bill_id;        // ID hóa đơn
    private String user;        // Người tạo hóa đơn
    private String phone;       // Số điện thoại người tạo hóa đơn
    private String product_name; // Tên sản phẩm
    private int quanty;         // Số lượng sản phẩm trong hóa đơn
    private double total;       // Tổng giá trị sản phẩm (số lượng * giá)

    // Getters và Setters
    public int getBill_detail_id() {
        return bill_detail_id;
    }

    public void setBill_detail_id(int bill_detail_id) {
        this.bill_detail_id = bill_detail_id;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
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
