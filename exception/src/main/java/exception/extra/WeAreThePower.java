package exception.extra;

public class WeAreThePower {

    public static void main(String[] args) {

        Power power = new Power();

        System.out.println(power.calculate(2,0));
        System.out.println(power.calculate(5,1));
        System.out.println(power.calculate(2,4));
        System.out.println(power.calculate(2,-1));
        System.out.println(power.calculate(2,-3));
        System.out.println(power.calculate(0,-6));

    }
}
