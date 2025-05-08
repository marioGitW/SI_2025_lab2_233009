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
        if (allItems == null){  // B1
            throw new RuntimeException("allItems list can't be null!"); // B2
        }

        double sum = 0; // B3

        for (int i = 0; i < allItems.size(); i++){     //  B4
            Item item = allItems.get(i); // B5
            if (item.getName() == null || item.getName().length() == 0){ // B6
                throw new RuntimeException("Invalid item!");    // B7
            }

            if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10){ // B8
                sum -= 30;      // B9
            }

            if (item.getDiscount() > 0){    // B10
                sum += item.getPrice()*(1-item.getDiscount())*item.getQuantity();   //  B11
            }
            else {
                sum += item.getPrice()*item.getQuantity();  //  B12
            }

        }
        if (cardNumber != null && cardNumber.length() == 16) {      // B13
            String allowed = "0123456789"; // B14
            char[] chars = cardNumber.toCharArray(); //B15
            for (int j = 0; j < cardNumber.length(); j++) {  // B16
                char c = cardNumber.charAt(j); // B17
                if (allowed.indexOf(c) == -1) {     // B18
                    throw new RuntimeException("Invalid character in card number!");    // B19
                }
            }
        }
        else{
            throw new RuntimeException("Invalid card number!");     // B20
        }

        return sum;     // B21

    }
}