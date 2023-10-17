package com.testing.forum.statistics;

public class Calculations {

    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double postsPerUserCount;
    private double commentsPerUserCount;
    private double commentsPerPostCount;

    public void calculateAdvStatistics(Statistics statistics) {
        usersCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();

        if (postsCount != 0) {
            commentsPerPostCount = (double) commentsCount / postsCount;
        }

        if (usersCount != 0) {
            postsPerUserCount = (double) postsCount / usersCount;
            commentsPerUserCount = (double) commentsCount / usersCount;
        }

    }

    public void showStatistics() {
        System.out.println(usersCount + " users, " + postsCount + " posts, " + commentsCount + "comments.");
        System.out.println("Posts per user: " + postsPerUserCount);
        System.out.println("Comments per user: " + commentsPerUserCount);
        System.out.println("Comments per post: " + commentsPerPostCount);

    }

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getPostsPerUserCount() {
        return postsPerUserCount;
    }

    public double getCommentsPerUserCount() {
        return commentsPerUserCount;
    }

    public double getCommentsPerPostCount() {
        return commentsPerPostCount;
    }
}
