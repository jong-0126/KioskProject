package Lv3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /**
         * MenuItem 타입의 리스트를 생성하여 데이터를 담아둠
         */
        List<MenuItem> menu1 = List.of(
                new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거")
        );

        /**
         * 첫화면: 메뉴 표시
         */
        int number = 1;
        for(MenuItem m : menu1){
            System.out.println(number + "." + " | " + m.getName() + " | " + m.getPrice() + " | " + m.getDetail());
            number++;
        }
        System.out.println("0. 종료       | 종료");

        /**
         * 리스트 menu1 Kiosk 객체 생성과 동시에 넘겨줌
         * start()메서드를 사용하여 프로그램 시작
         */
        Kiosk kiosk = new Kiosk(menu1);
        kiosk.start();

    }
}
