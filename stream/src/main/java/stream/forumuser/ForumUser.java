package stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    int id;
    String username;
    char sex;
    LocalDate birthDate;
    int numberOfPosts;

    public ForumUser(int id, String username, char sex, LocalDate birthDate, int numberOfPosts) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.birthDate = birthDate;
        this.numberOfPosts = numberOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }
}
