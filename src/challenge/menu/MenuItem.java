package challenge.menu;

public class MenuItem {

    /**
     * 이름, 가격, 설명 필드 선언하여 관리
     */
    private String name;
    private Double price;
    private String content;

    /**
     * @param name 메뉴 이름
     * @param price 메뉴 가격
     * @param content 메뉴 설명
     */
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
