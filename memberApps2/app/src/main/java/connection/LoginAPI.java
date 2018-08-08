package connection;

import model.RequestLogin;
import model.UserList;
import model.UserLogin;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface LoginAPI {
    @POST("api/members/login")

//    Call<UserLogin> loginUser(@Body RequestLogin login);
    Call<UserList> responseUser(@Body UserLogin requestUser);
}

