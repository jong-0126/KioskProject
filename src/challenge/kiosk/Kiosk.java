package challenge.kiosk;

import challenge.cart.Cart;
import challenge.menu.Menu;
import challenge.menu.MenuItem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    // 스캐너 선언
    Scanner sc = new Scanner(System.in);

    private List<Menu> menuList;

    // Cart 리스트 선언
    private List<Cart> cartList = new ArrayList<>();

    /**
     * @param menuList Menu 클래스
     */
    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    /**
     * 키오스크 시작 메서드
     */
    public void start() {
        while (true) {
            /**
             * List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
             * Menu 클래스 타입의 리스트를 반복문으로 순환하면서 카테고리 출력
             */
            if (cartList.isEmpty()) {
                int num = 1;
                System.out.println("[Main Menu]");
                for (Menu menu : menuList) {
                    System.out.println(num++ + ". " + menu.getCategory());
                }
                System.out.println("0. 종료       | 종료");
            } else {
                System.out.println("아래 메뉴판을 보시고 골라 입력해주세요");
                System.out.println("[Main Menu]");
                int num = 1;
                for (Menu menu : menuList) {
                    System.out.println(num++ + ". " + menu.getCategory());
                }
                System.out.println("0. 종료       | 종료");
                System.out.println();
                System.out.println("[Order Menu]");
                System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
            }


            try{
                // 숫자 입력 받기
                System.out.println("번호를 입력해주세요");
                int menuNum = sc.nextInt();

                // 키오스크 종료
                if (menuNum == 0) {
                    System.out.println("Kiosk가 종료됩니다.");
                    break;
                } else if (menuNum == 4) {
                    orderCart();
                    break;
                } else if (menuNum == 5) {
                    cartList.clear();
                    continue;
                }
                /**
                 * 입력 받는 숫자의 범위를 지정하여 올바르다면 MenuList의 인덱스로 활용하여 List에 접근하기
                 * selectedMenu라는 이름의 Menu 객체를 담을 수 있는 변수를 선언하여 특정 객체 담기
                 * 특정 객체에 따른 MenuItem 보여주기
                 */
                if (menuNum >= 1 && menuNum <= menuList.size()) {
                    Menu selectedMenu = menuList.get(menuNum - 1);
                    System.out.println("[ " + selectedMenu.getCategory() + "MENU ]");
                    selectedMenu.showMenuItem();

                    // 상위 메뉴인 카테고리 메뉴로 돌아가기
                    System.out.println("원하는 메뉴 번호를 눌러주세요 (0을 누르면 돌아갑니다.)");
                    // 숫자 입력 받기
                    Integer detailMenuNum = sc.nextInt();

                    /**
                     * detailMenuNum의 숫자에 따라 0을 입력 받으면 상위 카테고리로 돌아가기
                     * 1 부터 앞에서 선택한 상세메뉴에 개수를 범위로 잡고 인덱스로 접근하여 선택된 메뉴를 출력
                     */
                    if (detailMenuNum == 0) {

                    } else if (detailMenuNum >= 1 && detailMenuNum <= selectedMenu.getMenuItems().size()) {
                        MenuItem selectedMenuItem = selectedMenu.getMenuItems().get(detailMenuNum - 1);
                        System.out.println("선택한 메뉴는: " + selectedMenuItem.getName() + " | " + selectedMenuItem.getPrice() + "|" + selectedMenuItem.getContent() + " 입니다");
                        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                        System.out.println("1. 확인       2. 취소");
                        int addCart = sc.nextInt();
                        if (addCart == 1) {
                            addCart(selectedMenuItem);
                        } else if (addCart == 2) {
                            System.out.println("취소되었습니다.");
                        } else {
                            System.out.println("잘못된 입력입니다.");
                        }
                    } else {
                        System.out.println("잘못된 입력입니다.");
                    }
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            }catch (InputMismatchException e){
                System.out.println("잘못된 입력입니다.");
                sc.nextLine();
            }
        }
    }

    // inputMismatch


    private void addCart(MenuItem menuItem) {
        Integer quantity = 1;
        for (Cart cart : cartList) {
            if (cart.getMenuItem().equals(menuItem)) {
                cart.setQuantity(cart.getQuantity() + 1);
                System.out.println(menuItem.getName() + "가 장바구니에 추가되었습니다.");
                return;
            }
        }
        cartList.add(new Cart(menuItem, quantity));
        System.out.println(menuItem.getName() + "가 장바구니에 추가되었습니다.");
    }

    private void orderCart() {
        if (cartList.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
            return;
        }
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");
        double total = 0.0;
        for (Cart cart : cartList) {
            System.out.println(cart.getMenuItem().getName() + " | W " +
                    cart.getMenuItem().getPrice() + " | " + cart.getMenuItem().getContent());
            total = cart.totalPrice();
        }
        System.out.println("W " + total);
        System.out.println("1. 주문      2. 메뉴판");
        int order = sc.nextInt();
        if (order == 1) {
            System.out.println("주문이 완료되었습니다. 금액은 W " + total + "입니다.");
        }else if(order == 2){
            return;
        }else{
            System.out.println("잘못 입력하셨습니다.");
        }
    }
}
