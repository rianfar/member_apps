package Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.support.v4.app.Fragment;

import com.google.gson.Gson;
import com.memberapps2.R;

import java.util.ArrayList;
import java.util.List;

import adapter.HomeAdapter;
import adapter.NewsFeedAdapter;
import connection.LoginAPI;
import datasource.remote.NewsFeedResponse;
import entity.NewsFeedCategory;
import entity.NewsFeedData;
import helper.RetroClient;
import model.Category;
import model.Datum;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFeedFragment extends Fragment {
    ListView lv;
    ProgressDialog pDialog;
    final ArrayList<NewsFeedFragment> artikels = new ArrayList<>();
    NewsFeedAdapter newsFeedAdapter;
    List<NewsFeedData> listNewsFeed;
    List<NewsFeedCategory> listNewsCategory;
    String id, post_title, post_date, post_url,post_picture,term_id,name;
    StringBuffer sb;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newsfragment, container, false);
        return view;
    }


    public void newsFeed(){
        RetroClient.getClient().create(LoginAPI.class).getNewsFeed().enqueue(new Callback<NewsFeedResponse>() {
            @Override
            public void onResponse(Call<NewsFeedResponse> call, Response<NewsFeedResponse> response) {
                if(response.isSuccessful()){
                    Gson gson = new Gson();
                    String data = gson.toJson(response.body());
                    Log.i("responseartikel", data);
                }
            }

            @Override
            public void onFailure(Call<NewsFeedResponse> call, Throwable t) {

            }
        });
    }
}
