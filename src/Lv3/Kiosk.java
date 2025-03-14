package Lv3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스입니다.
 */
public class Kiosk {

    Scanner sc = new Scanner(System.in);

    /**
     *  MenuItem을 관리하는 리스트가 필드로 존재합니다.
     */
    List<MenuItem> menuItems = new ArrayList<>();

    /**
     * List<MenuItem> menuItems 는 Kiosk 클래스 생성자를 통해 값을 할당합니다.
     * @param menuItems
     */
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems.addAll(menuItems);
    }

    /**
     * main 함수에서 관리하던 입력과 반복문 로직은 이제 start 함수를 만들어 관리합니다.
     */
    public void start() {
        while (true) {
            System.out.println("원하시는 번호를 눌러주세요.");

            int num;
            try{
                num = sc.nextInt();
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("잘못 입력하셨습니다. 숫자를 입력해주세요.");
                sc.nextLine();
                continue;
            }

            if (num == 0) {
                System.out.println("프로그램을 종료하겠습니다.");
                break;
            } else if (num == 1) {
                System.out.println("선택하신 버거는 " + menuItems.get(0).getName() + "입니다. " + "가격은 " + menuItems.get(0).getPrice() + " 입니다.");
            } else if (num == 2) {
                System.out.println("선택하신 버거는 " + menuItems.get(1).getName() + "입니다. " + "가격은 " + menuItems.get(1).getPrice() + " 입니다.");
            } else if (num == 3) {
                System.out.println("선택하신 버거는 " + menuItems.get(2).getName() + "입니다. " + "가격은 " + menuItems.get(2).getPrice() + " 입니다.");
            } else if (num == 4) {
                System.out.println("선택하신 버거는 " + menuItems.get(3).getName() + "입니다. " + "가격은 " + menuItems.get(3).getPrice() + " 입니다.");
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
}