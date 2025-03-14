package Lv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("[SHAKESHACK MENU]");
        System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        System.out.println("3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        System.out.println("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
        System.out.println("0. 종료       | 종료");
        while (true) {
            System.out.println("번호를 입력해주세요: ");
            String num;
            // 입력 예외 처리
            try{
                num = sc.nextLine();
            }catch (NumberFormatException e){
                System.out.println("잘못 입력하셨습니다. 숫자를 입력해주세요.");
                continue;
            }

            if (num.equals("1")) {
                System.out.println("1. ShackBurger 선택하셨습니다. 가격은 $6.9 입니다.");
            } else if (num.equals("2")) {
                System.out.println("2. SmokeShack 선택하셨습니다. 가격은 $8.9 입니다.");
            } else if (num.equals("3")) {
                System.out.println("3. Cheeseburger 선택하셨습니다. 가격은 $6.9 입니다.");
            } else if (num.equals("4")) {
                System.out.println("4. Hamburger를 선택하셨습니다. 가격은 $5.4 입니다.");
            } else if (num.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            }
        }
        sc.close();
    }
}

