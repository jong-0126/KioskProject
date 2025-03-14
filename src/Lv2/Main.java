package Lv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // List 선언 및 초기화
        List<MenuItem> menuItems = new ArrayList<>();

        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // Scanner 선언
        Scanner sc = new Scanner(System.in);

        int number = 1;
        // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
        for(MenuItem m : menuItems){
            System.out.println(number + "." + " | " + m.getName() + " | " + m.getPrice() + " | " + m.getDetail());
            number++;
        }
        System.out.println("0. 종료       | 종료");

        while(true){
            // 숫자를 입력 받기
            System.out.println("원하시는 번호를 입력해주세요");

            int num;
            try{
                num = sc.nextInt();
                sc.nextLine();
            }catch (InputMismatchException e) {
                System.out.println("잘못 입력하셨습니다. 숫자를 입력해주세요.");
                sc.nextLine();
                continue;
            }

            // 입력된 숫자에 따른 처리
            if(num == 1){
                // 선택한 메뉴 : 이름, 가격, 설명
                System.out.println("선택하신 버거는 " + menuItems.get(0).getName() + "입니다. " + "가격은 " + menuItems.get(0).getPrice() + " 입니다.");
            }else if(num == 2){
                System.out.println("선택하신 버거는 " + menuItems.get(1).getName() + "입니다. " + "가격은 " + menuItems.get(1).getPrice() + " 입니다.");
            }else if(num == 3){
                System.out.println("선택하신 버거는 " + menuItems.get(2).getName() + "입니다. " + "가격은 " + menuItems.get(2).getPrice() + " 입니다.");
            }else if(num == 4){
                System.out.println("선택하신 버거는 " + menuItems.get(3).getName() + "입니다. " + "가격은 " + menuItems.get(3).getPrice() + " 입니다.");
            }else if(num == 0){
                // 프로그램을 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }else{
                System.out.println("번호를 잘못 입력하셨습니다.");
            }
        }
        sc.close();
    }
}
