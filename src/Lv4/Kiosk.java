package Lv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    /**
     * 스캐너 선언
     */
    Scanner sc = new Scanner(System.in);
    List<Menu> menuList;

    public Kiosk(List<Menu> menuList){
        this.menuList = menuList;
    }

    /**
     * 반복문 시작
     */
    public void start(){
        while(true){
            System.out.println("[Main Menu]");

            /**
             * List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
             */
            int num = 1;
            for(Menu menu : menuList){
                System.out.println(num++ + ". " + menu.getCategory());
            }
            System.out.println("0. 종료       | 종료");

            /**
             * 숫자 입력 받기
             */
            System.out.println("번호를 입력해주세요");
            Integer menuNum = sc.nextInt();
            if(menuNum == 0){
                System.out.println("Kiosk가 종료됩니다.");
                break;
            }

            /**
             * 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
             * List<Menu>에 인덱스로 접근하여 Menu만 추출
             */
            if(menuNum >= 1 && menuNum <= menuList.size()) {
                Menu selectedMenu = menuList.get(menuNum - 1);
                System.out.println("[ " + selectedMenu.getCategory() + "MENU ]");
                selectedMenu.showMenuItem();

                /**
                 * Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력
                 * 숫자 입력 받기
                 */
                System.out.println("원하는 메뉴 번호를 눌러주세요 (0을 누르면 돌아갑니다.)");
                Integer detailMenuNum = sc.nextInt();

                /**
                 * 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
                 * menu.getMenuItems().get(i); 같은 형식으로 하나씩 들어가서 얻어와야 합니다
                 */
                if (detailMenuNum == 0) {
                    continue;
                } else if (detailMenuNum >= 1 && detailMenuNum <= selectedMenu.getMenuItems().size()) {
                    MenuItem selectedMenuItem = selectedMenu.menuItems.get(detailMenuNum - 1);
                    System.out.println("선택한 메뉴는: " + selectedMenuItem.getName() + " | " + selectedMenuItem.getPrice() + "|" + selectedMenuItem.getContent() + " 입니다");
                } else {
                    System.out.println("잘못된 입력입니다.");
                }

            }else{
                System.out.println("잘못된 입력입니다.");
            }

        }

    }

}
