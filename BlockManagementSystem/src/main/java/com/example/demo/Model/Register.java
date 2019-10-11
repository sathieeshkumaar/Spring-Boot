package com.example.demo.Model;
        import lombok.Data;
        import javax.validation.constraints.NotBlank;
        import javax.validation.constraints.Size;

@Data
public class Register {
    @NotBlank
    @Size(min = 2,message = "Atleast 2 characters")
    private String name;
    @NotBlank
    @Size(min = 5,message = "Must be minimum 5 characters")
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }



}
