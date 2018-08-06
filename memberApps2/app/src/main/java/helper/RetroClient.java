package helper;

import connection.LoginAPI;
import model.UserLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {
    /********
     * URLS
     *******/

    private static final String ROOT_URL = "http://internal.yisc-alazhar.or.id/";

    private static LoginAPI service;
    private static RetroClient retroClient;

    private RetroClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(LoginAPI.class);
    }

    public static RetroClient getInstance() {
        if (retroClient == null) {
            retroClient = new RetroClient();
        }
        return retroClient;
    }

    public void loginUser(UserLogin user, Callback<UserLogin> callback) {
        Call<UserLogin> userCall = service.loginUser(user);
        userCall.enqueue(callback);
    }
}
