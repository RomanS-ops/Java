package src.lb1.Firma;

public class exemplum_7 {
    public static void main(String[] args) {
        try{
            System.out.println("0");
            throw new NullPointerException("�������");
        } catch (NullPointerException e) {
            System.out.println("1" );
            throw new ArithmeticException("�������");
        } catch (ArithmeticException e) {
            System.out.println("2" );
        }
        System.out.println("3");
    }
}
