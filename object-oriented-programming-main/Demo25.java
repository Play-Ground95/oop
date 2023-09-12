import java.time.LocalDateTime;

public class Demo25 {
    public static void main(String[] args) {
        User admin = new Admin("Kavindu95", "1995");
        User admin2 = new Admin("Osi", "1996");
        User guestUser = new GuestUser("Kasun", "1994");

        admin.login();
        admin2.login();
        guestUser.login();
    }
}

abstract class User {
    String username;
    String password;
    String role;
    boolean logged;

    public abstract void login();

    public void logout() {
        if (logged) {
            System.out.printf("%s logged out \n", username);
        } else {
            System.out.println("user hasn't logged");
        }

    }

    public void printUserDetails() {
        System.out.prinf("username=%s, password=%s,role=%s \n", username, password, role);
    }

}

class Admin extends User {
    private String[] passwords = { "IJSE_123", "IJSE_345" };

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = "ROLE_ADMIN";
    }

    @Override
    public void login() {
        for (String password : passwords) {
            if (password.equals(this.password)) {
                System.out.printf("%s logged in at: %s \n", username, LocalDateTime.now());

                return;
            }

        }
        System.out.println("Invalid login Credentials");
    }
}

class GuestUser extends User {
    private static final String[] GUEST_PW = { "IJSE_123456" };

    public GuestUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = "ROLE_GUEST";
    }

    @Override
    public void login() {
        for (String password : GUEST_PW) {
            if (password.equals(GUEST_PW))

            {
                System.out.printf("%s logged in at: %s \n", username, LocalDateTime.now());

                return;
            } else {
                System.out.println("Invalid login Credentials");
            }

        }
    }
}