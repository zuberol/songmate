package pl.jzuber.songmate.utils;


import org.springframework.stereotype.Service;
import pl.jzuber.songmate.exceptions.CantGenerateMoreData;
import pl.jzuber.songmate.model.User;
import pl.jzuber.songmate.security.Role;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FakeUserGenerator {
    final static String FILE_WITH_USERNAMES = "/Users/zuber/java/songmate/src/main/java/pl/jzuber/songmate/utils/names.csv";
    final static Random rand = new Random();
    static Scanner sc;


    static {
        Path source = Paths.get(FILE_WITH_USERNAMES);
        try {
            sc = new Scanner(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* returns Strings in format:   1974,B,Stuart,710,14,"   14"
    * */
    private static String readUserDataFromFile() throws CantGenerateMoreData {
            Path source = Paths.get(FILE_WITH_USERNAMES);
            if(sc.hasNext()) return sc.nextLine();
            else throw new CantGenerateMoreData();
    }

    private static Set<Role> getRandomRoleSet() {
        Set<Role> roles = new TreeSet<>();
        final Role [] enum_roles = Role.class.getEnumConstants();
        roles.add(
                enum_roles[rand.nextInt(enum_roles.length)]
        );
        return roles;
    }

    public static User generateUser() {
        String line;
        try {
            line = readUserDataFromFile();
        } catch(CantGenerateMoreData e) {
            return null;
        }
        List<String> userData = Arrays.stream(line.split(","))
                                        .map(str -> str.trim().strip())
                                        .collect(Collectors.toList());

        return User.builder().setUsername(userData.get(2))
                .setPassword( userData.get(2) + String.valueOf(rand.nextInt()) )
                .setAccountNonExpired(rand.nextBoolean())
                .setAccountNonLocked(rand.nextBoolean())
                .setEnabled(rand.nextBoolean())
                .setCredentialsNonExpired(rand.nextBoolean())
                .setRole( getRandomRoleSet() )
                .setId(rand.nextLong() % 20)    //todo
                .build();
    }

    // may return list of users shorter than desired in case of exception
    public static List<User> getUserList(long numUsers) {
        List<User> fillWithUsers = new LinkedList<>();
        for(int i=0; i<numUsers; ++i) {
            User u = generateUser();
            if(u != null) fillWithUsers.add(u);
            else return fillWithUsers;
        }
        return fillWithUsers;
    }


}
