package exception.extra;

public class Power {

    public double calculate(int a, int b) {
        double result;

        if (b == 0) {
            result = 1;
        }else if (a == 0) {
            result = 0;
        } else if (b > 0) {
            result = a;
            for (int i = 1; i < b; i++)
                result = result * a;
        } else {
            result = (double) 1 / a;
            for (int i = -1; i > b; i--)
                result = result / a;

        }
        return result;
    }
}
