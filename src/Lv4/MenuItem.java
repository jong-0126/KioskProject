package Lv4;

public class MenuItem {

    /**
     * 이름, 가격, 설명 필드 선언하여 관리
     */
    private String name;
    private Double price;
    private String content;

    public MenuItem(String name, Double price, String content) {
        this.name = name;
        this.price = price;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getContent() {
        return content;
    }
}
