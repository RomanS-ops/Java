package src.lb1.Firma;

public class exemplum_5 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("�������");
        } catch (NullPointerException e) {
            System.out.println("1");
        }
        System.out.println("2");
    }
}
