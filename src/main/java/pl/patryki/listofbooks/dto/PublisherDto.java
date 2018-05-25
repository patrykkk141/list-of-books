package pl.patryki.listofbooks.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class PublisherDto {

    private Long publisherId;
    @NotBlank(message = "Name must not be blank")
    private String name;
    @NotBlank(message = "Address must not be blank")
    private String address;
    @Email
    private String email;

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
