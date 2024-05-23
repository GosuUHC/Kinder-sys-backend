package backend.infrastructure.in.rest.request;

public class AuthUserRequest {
    private String login;
    private String password;

    public AuthUserRequest() {
    }

    public AuthUserRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
