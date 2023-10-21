package stream;

import extra.Mirror;
import stream.beautifier.PoemBeautifier;
import stream.forumuser.Forum;

import stream.forumuser.ForumUser;
import stream.lambda.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

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
        beautifier.beautify("Cute meowing baby Kittens. ", (text) -> "^_^ " + text + "<3");
        beautifier.beautify("Cute meowing baby Kittens. ", (text) -> text.toUpperCase());
        beautifier.beautify("Cute meowing baby Kittens. ", (text) -> text.repeat(3));
        beautifier.beautify("Cute meowing baby Kittens. ", (text) -> text + text.substring(18, 25) + "!");

        // 7.3
        System.out.println("Only males:");
        Forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .forEach(System.out::println);

        System.out.println("\nOnly older than 20:");
        Forum.getUserList().stream()
                .filter(forumUser -> forumUser.getBirthDate().isBefore(LocalDate.now().minusYears(20)))
                .forEach(System.out::println);

        System.out.println("\nOnly with at least 1 post:");
        Forum.getUserList().stream()
                .filter(forumUser -> forumUser.getNumberOfPosts() > 0)
                .forEach(System.out::println);

        Map<Integer, ForumUser> theResultMapOfUsers = Forum.getUserList().stream()
                .collect(Collectors.toMap(ForumUser::getId, forumUser -> forumUser));

        System.out.println("\nMap elements: " + theResultMapOfUsers.size());
        theResultMapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);


        //Extra
        Mirror mirror = new Mirror();
        String text = String.valueOf(mirror.stringMirror("Geostigma"));
        System.out.println(text);

    }
}