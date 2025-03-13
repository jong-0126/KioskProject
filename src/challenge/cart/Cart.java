package challenge.cart;

import challenge.menu.MenuItem;

public class Cart {

    private MenuItem menuItem;
    private int quantity;

    public Cart(MenuItem menuItem, int quantity){
        this.menuItem = menuItem;
        this.quantity = quantity;

    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double totalPrice(){
        return menuItem.getPrice() * quantity;
    }

}
