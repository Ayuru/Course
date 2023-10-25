package exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            System.out.println(secondChallenge.probablyIWillThrowException(2.0, 3.0));
        } catch (Exception e) {
            System.out.println("Problem with calculations!");
        } finally {
            System.out.println("I am gonna be here... always!");
        }

    }
}
