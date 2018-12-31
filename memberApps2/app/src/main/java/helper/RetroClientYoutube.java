package helper;

import connection.LoginAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClientYoutube {
    /********
     * URLS
     *******/

    private static final String ROOT_URL = "https://www.googleapis.com/youtube/v3/";

    private static LoginAPI service;
    private static RetroClientYoutube retroClientYoutube;
    public static Retrofit retrofit;

    private RetroClientYoutube() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(LoginAPI.class);
    }

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ROOT_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static RetroClientYoutube getInstance() {
        if (retroClientYoutube == null) {
            retroClientYoutube = new RetroClientYoutube();
        }
        return retroClientYoutube;
    }


}
