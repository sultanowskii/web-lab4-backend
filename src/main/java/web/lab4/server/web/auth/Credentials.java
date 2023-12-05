package web.lab4.server.web.auth;

import jakarta.validation.constraints.*;

public class Credentials {
    @NotNull(message="Username required")
    @NotEmpty(message="Username must not be empty")
    @Size(min=3, message="Username is too short [3; 20]")
    @Size(max=20, message="Username is too long [3; 20]")
    private String username;

    @NotNull(message="Password required")
    @NotEmpty(message="Password must not be empty")
    @Size(min=5, message="Password is too short")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }
}
