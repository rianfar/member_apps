package Fragment;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import com.google.gson.Gson;
import com.memberapps2.R;

import java.util.ArrayList;

import adapter.AdapterVideo;
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
    public static final String DEVELOPER_KEY = "AIzaSyDXsnjNJO8o-zOdT_uDK1kXpx7s4dcbbHc";
    ListView listView;
    private YouTubePlayerView playerView;
    private YouTubePlayer player;
    ArrayList<Kajian> videoDetail = new ArrayList<>();;
    AdapterVideo adapterVideo;
    private FragmentActivity myContext;

    @Override
    public void onAttach(Activity activity) {

        if (activity instanceof FragmentActivity) {
            myContext = (FragmentActivity) activity;
        }

        super.onAttach(activity);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_kajian, container, false);

        playerView = (YouTubePlayerView)view.findViewById(R.id.player);
        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
        android.support.v4.app.FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.playerVideo, youTubePlayerFragment).commit();

        youTubePlayerFragment.initialize("AIzaSyD9-nbKBoUys23cVeHpZFUd4Yj8di_a09A", new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider arg0, YouTubePlayer youTubePlayer, boolean b) {
                if (!b) {
                    player = youTubePlayer;
//                    player.setFullscreen(true);
                    player.loadVideo("1pnBat4vmJs");
                    player.play();
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }

        });

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
