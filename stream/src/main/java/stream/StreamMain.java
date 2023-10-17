package stream;

import stream.beautifier.PoemBeautifier;
import stream.lambda.*;

public class StreamMain {

    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

        SaySomething saySomething = new SaySomething();
        saySomething.say();

        Processor processor = new Processor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);

        processor.execute(() -> System.out.println("This is an example text."));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        // 7.1
        PoemBeautifier beautifier = new PoemBeautifier();
        beautifier.beautify("Cute meowing baby Kittens. ", (text) -> "^_^ "+ text + "<3");
        beautifier.beautify("Cute meowing baby Kittens. ", (text) -> text.toUpperCase());
        beautifier.beautify("Cute meowing baby Kittens. ", (text) -> text.repeat(3));
        beautifier.beautify("Cute meowing baby Kittens. ", (text) -> text + text.substring(18, 25) + "!");
    }
}