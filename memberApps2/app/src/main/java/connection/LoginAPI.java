package connection;

//import model.RequestLogin;

import android.util.Log;

import model.Artikel;
import model.UserList;
import model.UserLogin;
import model.UserMember;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LoginAPI {
    @POST("api/members/login")

//    Call<UserLogin> loginUser(@Body RequestLogin login);
    Call<UserList> responseUser(@Body UserLogin requestUser);

    @GET("api/members/{key}/{user_id}")
    Call<UserMember> responseMember(@Query(value = "key") String key, @Query(value = "user_id") String user_id);

    @GET("api/articles/index/{page}")
    Call<Artikel> responseArtikel(@Query(value = "page") String page);
}

