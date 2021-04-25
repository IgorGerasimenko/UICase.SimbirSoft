package apiTests.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserPojo {
    private int id;
    private String email;
    @JsonProperty
    private String first_name;
    @JsonProperty
    private String last_name;
    private String avatar;
}




//[{"id":1,"email":"george.bluth@reqres.in","first_name":"George","last_name":"Bluth","avatar":"https://reqres.in/img/faces/1-image.jpg"},



