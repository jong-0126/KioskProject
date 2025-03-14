package Lv4_5;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    /**
     * 카테고리 이름 필드 추가
     */
    private final String category;

    /**
     * MenuItem 클래스를 List로 관리
     */
    private final List<MenuItem> menuItems = new ArrayList<>();

    /**
     * @param category 카테고리
     * @param menuItems 상세 메뉴 리스트
     */
    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems.addAll(menuItems);
    }

    /**
     * List에 포함된 MenuItem을 순차적으로 보여주는 함수
     */
    public void showMenuItem(){
        int num = 1;
        for(MenuItem menuItem : menuItems){
            System.out.println(num++ + ". " + menuItem.getName() +
                    " | W" + menuItem.getPrice() +
                    " | " + menuItem.getContent());
        }
        System.out.println("0. 돌아가기       | 돌아가기");
    }

    /**
     * List를 리턴하는 함수
     */
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public String getCategory() {
        return category;
    }
}
