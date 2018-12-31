package Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.memberapps2.R;

import connection.LoginAPI;
import helper.RetroClient;
import model.Kajian;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoKajian extends Fragment {
    ProgressDialog pDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_kajian, container, false);


        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);

        VideoKajian("snippet","UCLGTGGY_KFCAtb11zhy6xHA","AIzaSyD9-nbKBoUys23cVeHpZFUd4Yj8di_a09A");
        return view;
    }
    public void VideoKajian(String part, String channelId, String key){
        RetroClient.getClient().create(LoginAPI.class).responseVideo(part,channelId,key).enqueue(new Callback<Kajian>() {
            @Override
            public void onResponse(Call<Kajian> call, Response<Kajian> response) {
                if (response.isSuccessful()) {
                    pDialog.dismiss();
                    Gson gson = new Gson();
                    String j = gson.toJson(response.body());
                    Log.i("responsekajian", j);
                }
            }

            @Override
            public void onFailure(Call<Kajian> call, Throwable throwable) {

            }
        });
    }
}
