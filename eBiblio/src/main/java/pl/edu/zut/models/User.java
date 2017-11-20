package pl.edu.zut.models;

import org.hibernate.validator.constraints.NotBlank;
import pl.edu.zut.core.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user", schema = "public")
public class User extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(min = 1, max = 127)
    @Column(nullable = false)
    private String login;

    @NotBlank
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String password;

    @NotBlank
    @Size(min = 1, max = 127)
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Size(min = 1, max = 127)
    @Column(nullable = false)
    private String surname;

    @NotBlank
    @Size(min = 1, max = 127)
    @Column(nullable = false)
    private String email;

    @Size(max = 15)
    private String phoneNumber;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
