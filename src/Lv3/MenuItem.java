package Lv3;

public class MenuItem {

    /**
     * 필드
     */
    private String name;
    private double price;
    private String detail;

    /**
     * 생성자
     * @param name 이름
     * @param price 가격
     * @param detail 상세
     */
    public MenuItem(String name, double price, String detail){
        this.name = name;
        this.price = price;
        this.detail = detail;
    }

    /**
     * Getter
     */
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDetail() {
        return detail;
    }
}
