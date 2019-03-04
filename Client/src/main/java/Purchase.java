public class Purchase {
    private  String productName;

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    private  double price;

    private Purchase(){

    }

    public Purchase(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }
}