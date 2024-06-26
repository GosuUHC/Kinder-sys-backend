package backend.service.user.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private Long id;
    private String login;
    private String password;
    private String role;

    public UserDTO() {
    }

    public UserDTO(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public UserDTO(Long id, String login, String password, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}