package is.musix.dto;

import java.util.Date;

public class UserDto {
    private String id;
    private String username;
    private String email;
    private Date dateOfBirth;
    private Date createdDate;

    public UserDto() {
    }

    public UserDto(String id, String username, String email, Date dateOfBirth, Date createdDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getCreatedDate() {
        return createdDate;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
