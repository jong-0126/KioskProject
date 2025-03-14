package challenge.menu;

public enum Discount {
    VETERAN(0.1) ,SOLDIER(0.05), STUDENT(0.03), ORDINARY(0);

    private double discount;

    Discount(double discount){
        this.discount = discount;
    }

    /**
     * 할인률 계산 메서드
     * @param total 총금액
     * @return
     */
    public double applyDiscount(double total){
        return total * (1 - discount);
    }

    /**
     * 입력된 번호에 따른 할인률 리턴
     * @param number 입력된 번호
     * @return 번호에 따른 할인률
     */
    public static Discount fromNumber(int number){
        switch (number){
            case 1: return VETERAN;
            case 2: return SOLDIER;
            case 3: return STUDENT;
            case 4: return ORDINARY;
            default: throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
