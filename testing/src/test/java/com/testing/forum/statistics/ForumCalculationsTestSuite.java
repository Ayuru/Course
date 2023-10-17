package com.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ForumCalculationsTestSuite {

    private static int testCounter = 0;
    @Mock
    private Statistics statisticsMock;
    private List<String> generateListOfUsers(int usersQuantity) {
        List<String> usersList = new ArrayList<>();
        for (int i = 0; i < usersQuantity; i++) {
            usersList.add("User" + i);
        }

        return usersList;
    }

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    Calculations calculations = new Calculations();


    @Test
    void testStatisticsCalculations0Posts() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(10));
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);

        // When
        calculations.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(10, calculations.getUsersCount());
        assertEquals(0, calculations.getPostsCount());
        assertEquals(0, calculations.getCommentsCount());
        assertEquals(0, calculations.getPostsPerUserCount());
        assertEquals(0, calculations.getCommentsPerPostCount());
        assertEquals(0, calculations.getCommentsPerUserCount());

    }

    @Test
    void testStatisticsCalculations1000Posts(){
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(10));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(500);

        // When
        calculations.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(100, calculations.getPostsPerUserCount());
        assertEquals(0.5, calculations.getCommentsPerPostCount());
        assertEquals(50, calculations.getCommentsPerUserCount());

    }

    @Test
    void testStatisticsCalculations0Comments(){
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(10));
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(0);

        // When
        calculations.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(10, calculations.getPostsPerUserCount());
        assertEquals(0, calculations.getCommentsPerPostCount());
        assertEquals(0, calculations.getCommentsPerUserCount());

    }

    @Test
    void testStatisticsCalculationsLessCommentsThanPosts(){
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(10));
        when(statisticsMock.postsCount()).thenReturn(200);
        when(statisticsMock.commentsCount()).thenReturn(50);

        // When
        calculations.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(20, calculations.getPostsPerUserCount());
        assertEquals(0.25, calculations.getCommentsPerPostCount());
        assertEquals(5, calculations.getCommentsPerUserCount());

    }

    @Test
    void testStatisticsCalculationsMoreCommentsThanPosts(){
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(10));
        when(statisticsMock.postsCount()).thenReturn(200);
        when(statisticsMock.commentsCount()).thenReturn(400);

        // When
        calculations.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(20, calculations.getPostsPerUserCount());
        assertEquals(2, calculations.getCommentsPerPostCount());
        assertEquals(40, calculations.getCommentsPerUserCount());

    }

    @Test
    void testStatisticsCalculations0Users(){
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(0));
        when(statisticsMock.postsCount()).thenReturn(2);
        when(statisticsMock.commentsCount()).thenReturn(4);

        // When
        calculations.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(0, calculations.getPostsPerUserCount());
        assertEquals(2, calculations.getCommentsPerPostCount());
        assertEquals(0, calculations.getCommentsPerUserCount());

    }

    @Test
    void testStatisticsCalculations100Users(){
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(100));
        when(statisticsMock.postsCount()).thenReturn(5);
        when(statisticsMock.commentsCount()).thenReturn(20);

        // When
        calculations.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(0.05, calculations.getPostsPerUserCount());
        assertEquals(4, calculations.getCommentsPerPostCount());
        assertEquals(0.2, calculations.getCommentsPerUserCount());

    }


}
