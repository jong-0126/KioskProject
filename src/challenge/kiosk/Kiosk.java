package challenge.kiosk;

import challenge.cart.Cart;
import challenge.menu.Discount;
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

    double total = 0.0;

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

            //메인 메뉴 출력 메서드 호출
            mainMenu();

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
                    if(cartList.isEmpty()) break;
                    continue;
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
                    int detailMenuNum = sc.nextInt();

                    /**
                     * detailMenuNum의 숫자에 따라 0을 입력 받으면 상위 카테고리로 돌아가기
                     * 1 부터 앞에서 선택한 상세메뉴에 개수를 범위로 잡고 인덱스로 접근하여 선택된 메뉴를 출력
                     */
                    if (detailMenuNum == 0) {

                    } else if (detailMenuNum >= 1 && detailMenuNum <= selectedMenu.getMenuItems().size()) {
                        MenuItem selectedMenuItem = selectedMenu.getMenuItems().get(detailMenuNum - 1);
                        // 메뉴 확인 출력
                        System.out.println("선택한 메뉴는: " + selectedMenuItem.getName() + " | " + selectedMenuItem.getPrice() + "|" + selectedMenuItem.getContent() + " 입니다");
                        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                        System.out.println("1. 확인       2. 취소");
                        int addCart = sc.nextInt();
                        // 장바구니 추가
                        if (addCart == 1) {
                            // 장바구니 추가 메서드
                            addCart(selectedMenuItem);
                        // 장바구니 취소
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

    /**
     * List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
     * Menu 클래스 타입의 리스트를 반복문으로 순환하면서 카테고리 출력
     */
    public void mainMenu(){
        // 장바구니가 비어있으면 Main Menu만 출력
        if (cartList.isEmpty()) {
            int num = 1;
            System.out.println("[Main Menu]");
            for (Menu menu : menuList) {
                System.out.println(num++ + ". " + menu.getCategory());
            }
            System.out.println("0. 종료       | 종료");
        // 장바구니가 채워져 있으면 Main, Order Menu 출력
        } else {
            System.out.println("아래 메뉴판을 보시고 골라 입력해주세요");
            System.out.println("[Main Menu]");
            int num = 1;
            for (Menu menu : menuList) {
                System.out.println(num++ + ". " + menu.getCategory());
            }
            System.out.println("0. 종료       | 종료");
            System.out.println();
            // Order Menu
            System.out.println("[Order Menu]");
            System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
        }
    }

    /**
     * 장바구니 추가 메서드
     * @param menuItem 메뉴 아이템
     */
    private void addCart(MenuItem menuItem) {
        int quantity = 1;
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

        for (Cart cart : cartList) {
            System.out.println(cart.getMenuItem().getName() + " | W " +
                    cart.getMenuItem().getPrice() + " | " + cart.getMenuItem().getContent()
                    + " | 수량: " + cart.getQuantity());
            total += cart.totalPrice();
        }
        System.out.println(String.format("W %.2f", total));
        System.out.println("1. 주문      2. 메뉴판");
        int order = sc.nextInt();
        if (order == 1) {
            total = discount(total);
            System.out.println(String.format("주문이 완료되었습니다. 금액은 W %.2f 입니다.", total));
            cartList.clear();
            return;
        }else if(order == 2){
            return;
        }else{
            System.out.println("잘못 입력하셨습니다.");
        }
    }

    private double discount(double total){
        System.out.println("할인 정보를 입력해주세요.");
        System.out.println("1. 국가유공자 : 10%");
        System.out.println("2. 군인     :  5%");
        System.out.println("3. 학생     :  3%");
        System.out.println("4. 일반     :  0%");

        int num = sc.nextInt();

        Discount dis = Discount.fromDouble(num);
        return switch (dis){
            case VETERAN -> total * 0.9;
            case SOLDIER -> total * 0.95;
            case STUDENT -> total * 0.97;
            case ORDINARY -> total * 1.0;
        };
    }
}
