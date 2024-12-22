package MotoPartsShop.DTO;

public class BillStatisticsDto {
    private int month;
    private int year;
    private int billCount; // Số lượng hóa đơn
    private double totalIncome; // Tổng thu nhập

    public BillStatisticsDto() {}

    public BillStatisticsDto(int month, int year, int billCount, double totalIncome) {
        this.month = month;
        this.year = year;
        this.billCount = billCount;
        this.totalIncome = totalIncome;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getBillCount() {
        return billCount;
    }

    public void setBillCount(int billCount) {
        this.billCount = billCount;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }
    
    @Override
    public String toString() {
        return "BillStatisticsDto{" +
                "month=" + month +
                ", year=" + year +
                ", billCount=" + billCount +
                ", totalIncome=" + totalIncome +
                '}';
    }

}
