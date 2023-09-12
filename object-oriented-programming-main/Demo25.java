public class Demo25 {
    public static void main(String[] args) {

    }
}

class User {
    protected String username;
    protected String password;
    protected String role;
    boolean logged;

    public void login() {
        System.out.printf("%s logged in \n", username);
        logged = true;
    }

    public void logout() {
        if (logged) {
            System.out.printf("%s logged out \n", username);
        } else {
            System.out.println("user hasn't logged");
        }

    }

    public void printUserDetails(){
        System.out.prinf("username=%s, password=%s,role=%s \n",username,password,role);
    }


}

class Admin extends User {
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = "ROLE_ADMIN";
    }
}

class GuestUser extends User {
public GuestUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = "ROLE_GUEST";
    }
}