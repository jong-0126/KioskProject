package challenge.menu;

public enum Discount {
    VETERAN(1) ,SOLDIER(2), STUDENT(3), ORDINARY(4);

    private double discount;

    Discount(double discount){
        this.discount = discount;
    }

    public static Discount fromDouble(double discount){
        for(Discount dis : Discount.values()){
            if(dis.discount == discount){
                return dis;
            }
        }

        throw new IllegalArgumentException("해당하는 할인율이 없습니다.");
    }
}
