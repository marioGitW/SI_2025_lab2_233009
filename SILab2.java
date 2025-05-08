import java.util.List;

class Item {
    String name;
    int quantity; //numerical
    int price;
    double discount;

    public Item(String name, int quantity, int price, double discount) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}


public class SILab2 {
    public static double checkCart(List<Item> allItems, String cardNumber){
        if (allItems == null){  // BLOCK 1
            throw new RuntimeException("allItems list can't be null!"); // BLOCK 2
        }

        double sum = 0;

        for (int i = 0; i < allItems.size(); i++){     //  BLOCK 3 ( 3.1      3.2 )   // BLOCK 11(3.3)
            Item item = allItems.get(i);
            if (item.getName() == null || item.getName().length() == 0){    // BLOCK 4 (4.1      4.2)
                throw new RuntimeException("Invalid item!");    // BLOCK 5
            }

            if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10){ // BLOCK 6 (6.1   6.2   6.3)
                sum -= 30;      // BLOCK  7
            }

            if (item.getDiscount() > 0){    // BLOCK 8
                sum += item.getPrice()*(1-item.getDiscount())*item.getQuantity();   //  BLOCK 9
            }
            else {
                sum += item.getPrice()*item.getQuantity();  //  BLOCK 10
            }

        }
        if (cardNumber != null && cardNumber.length() == 16) {      // BLOCK 12 (12.1     12.2)
            String allowed = "0123456789";
            char[] chars = cardNumber.toCharArray();
            for (int j = 0; j < cardNumber.length(); j++) {  // BLOCK 13 (12.1    12.2)   BLOCK 16(12.3)
                char c = cardNumber.charAt(j);
                if (allowed.indexOf(c) == -1) {     // BLOCK 14
                    throw new RuntimeException("Invalid character in card number!");    // BLOCK 15
                }
            }
        }
        else{
            throw new RuntimeException("Invalid card number!");     // BLOCK 17
        }

        return sum;     // BLOCK 18

    } // BLOCK EXIT
}