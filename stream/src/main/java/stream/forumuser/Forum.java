package stream.forumuser;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    public static List<ForumUser> getUserList() {
        final List<ForumUser> userList = new ArrayList<>();

        userList.add(new ForumUser(29000, "Bakasumi", 'F', LocalDate.of(2005,9,9), 126));
        userList.add(new ForumUser(28652, "Theressia", 'F', LocalDate.of(2007,12,25), 54));
        userList.add(new ForumUser(29001, "Twilight", 'F', LocalDate.of(1566,2,22), 13));
        userList.add(new ForumUser(28997, "Hróðvitnir", 'M', LocalDate.of(1924,2,27), 0));

        return new ArrayList<>(userList);
    }
}
