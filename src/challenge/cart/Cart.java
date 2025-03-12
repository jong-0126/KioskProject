package challenge.cart;

import challenge.menu.MenuItem;

public class Cart {

    private MenuItem menuItem;
    private Integer quantity;

    public Cart(MenuItem menuItem, Integer quantity){
        this.menuItem = menuItem;
        this.quantity = quantity;

    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double totalPrice(){
        return menuItem.getPrice() * quantity;
    }

}
