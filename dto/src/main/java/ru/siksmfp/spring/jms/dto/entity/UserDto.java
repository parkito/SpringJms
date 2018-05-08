package ru.siksmfp.spring.jms.dto.entity;

import java.io.Serializable;

/**
 * @author Artem Karnov @date 5/7/2018.
 * @email artem.karnov@t-systems.com
 */
public class UserDto implements Serializable {

    private String email;
    private String firstName;
    private String secondName;
    private Role role;

    public enum Role {
        ADMIN,
        USER,
        ROOT
    }

    public UserDto() {
    }

    public UserDto(String email, String firstName, String secondName, Role role) {
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto that = (UserDto) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (secondName != null ? !secondName.equals(that.secondName) : that.secondName != null) return false;
        return role == that.role;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", role=" + role +
                '}';
    }
}
