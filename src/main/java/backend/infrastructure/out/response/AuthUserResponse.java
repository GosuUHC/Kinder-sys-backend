package backend.infrastructure.out.response;

public class AuthUserResponse {
    private String login;
    private String token;
    private String role;

    public AuthUserResponse() {
    }

    public AuthUserResponse(String login, String token, String role) {
        this.login = login;
        this.token = token;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
