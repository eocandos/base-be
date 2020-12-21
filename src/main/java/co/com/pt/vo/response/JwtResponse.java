package co.com.pt.vo.response;

import lombok.Data;

@Data
public class JwtResponse {
    private String token;
    private Long id;
    private String type = "Bearer";
    private String account;
    private String name;
    private String role;

    public JwtResponse(String token, Long id, String account, String name, String role) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.token = token;
        this.role = role;
    }
}
