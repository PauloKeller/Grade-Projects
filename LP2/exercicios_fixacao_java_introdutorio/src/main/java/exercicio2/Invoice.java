package exercicio2;

public class Invoice {

    private int itemNumber;
    private String itemDesc;
    private int itemQuantity = 0;
    private Double itemPrice = 0.0;

    public Invoice(int itemNumber, String itemDesc, int itemQuantity, Double itemPrice) {
        this.itemNumber = itemNumber;
        this.itemDesc = itemDesc;
       if (itemQuantity > 0 ) this.itemQuantity = itemQuantity;
       if (itemPrice > 0.0) this.itemPrice = itemPrice;
    }

    double getInvoiceAmount() {
        return this.itemPrice * itemQuantity;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
