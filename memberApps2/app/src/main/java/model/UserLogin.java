package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLogin {

    @SerializedName("key")
    @Expose
    private String key;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("paswword")
    @Expose
    private String password;

    @SerializedName("user_id")
    @Expose
    private String user_id;

    @SerializedName("status")
    @Expose
    private Boolean status;

    @SerializedName("message")
    @Expose
    private String message;

    public UserLogin(String key, String email, String password){
        this.key = key;
        this.email = email;
        this.password = password;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
