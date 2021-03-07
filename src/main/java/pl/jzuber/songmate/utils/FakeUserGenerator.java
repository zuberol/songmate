package pl.jzuber.songmate.utils;


import org.springframework.stereotype.Service;
import pl.jzuber.songmate.exceptions.CantGenerateMoreData;
import pl.jzuber.songmate.model.SongmateUser;
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

    public static SongmateUser generateUser() {
        String line;
        try {
            line = readUserDataFromFile();
        } catch(CantGenerateMoreData e) {
            return null;
        }
        List<String> userData = Arrays.stream(line.split(","))
                                        .map(str -> str.trim().strip())
                                        .collect(Collectors.toList());

        return SongmateUser.builder().username(userData.get(2))
                .password( userData.get(2) + String.valueOf(rand.nextInt()) )
                .isAccountNonExpired(rand.nextBoolean())
                .isAccountNonLocked(rand.nextBoolean())
                .isEnabled(rand.nextBoolean())
                .isCredentialsNonExpired(rand.nextBoolean())
                .role( getRandomRoleSet() )
                .id(rand.nextLong() % 20)    //todo
                .build();
    }

    // may return list of users shorter than desired in case of exception
    public static List<SongmateUser> getUserList(long numUsers) {
        List<SongmateUser> fillWithSongmateUsers = new LinkedList<>();
        for(int i=0; i<numUsers; ++i) {
            SongmateUser u = generateUser();
            if(u != null) fillWithSongmateUsers.add(u);
            else return fillWithSongmateUsers;
        }
        return fillWithSongmateUsers;
    }


}
