package Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.memberapps2.R;

import connection.LoginAPI;
import helper.RetroClient;
import helper.RetroClientYoutube;
import model.Kajian;
import model.UserMember;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class VideoKajian extends Fragment {
    ProgressDialog pDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_kajian, container, false);

        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);

        Log.i("masuk", "masuk video");

        VideoKajian("snippet", "UCLGTGGY_KFCAtb11zhy6xHA", "AIzaSyD9-nbKBoUys23cVeHpZFUd4Yj8di_a09A");
        return view;
    }

    public void VideoKajian(String part, String channelId, String key) {
        System.out.println(part + " " + channelId + " " + key);
        RetroClientYoutube.getClient().create(LoginAPI.class).responseVideo(part, channelId, key).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    pDialog.dismiss();
                    Gson gson = new Gson();
                    String j = gson.toJson(response.body());
                    Log.i("responsekajian", j);
                    Log.i("responsekajian2", response.raw().request().url().toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {

            }
        });
    }
}
