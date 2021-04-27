package apiTests.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserPojo {

    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    public String getFirst_Name() {
        return first_name;
    }

    public String getLast_Name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

}
