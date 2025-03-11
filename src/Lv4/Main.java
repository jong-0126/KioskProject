package Lv4;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        /**
         * Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
         */
        List<MenuItem> burgerList = List.of(
                new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거")
        );

        List<MenuItem> DrinkList = List.of(
                new MenuItem("Coke", 2.0, "맛있는 코카콜라")
        );

        List<MenuItem> DesertList = List.of(
                new MenuItem("iceCream", 1.0, "시원한 아이스크림")
        );


        /**
         * Menu 객체 생성하면서 카테고리 이름 설정
         */
        List<Menu> menuList = List.of(
                new Menu("Burgers",burgerList),
                new Menu("Drink", DrinkList),
                new Menu("Desert", DesertList)
        );


        /**
         * Kiosk 객체 생성
         */
        Kiosk kiosk = new Kiosk(menuList);

        /**
         * Kiosk 내 시작하는 함수 호출
         */
        kiosk.start();


    }
}
