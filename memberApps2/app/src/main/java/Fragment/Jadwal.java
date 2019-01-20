package Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import Adapter.HomeAdapter;
import Adapter.JadwalAdapter;
import connection.Endpoint;
import helper.RetroClient;
import model.Artikel;
import model.Category;
import model.Datum;
import model.InfoJadwal;
import model.InfoListSchedule;
import model.InfoPendidikan;
import model.UserList;
import model.UserLogin;
import model.UserSchedule;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.google.gson.Gson;
import com.memberapps2.Home;
import com.memberapps2.LoginActivity;
import com.memberapps2.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Jadwal extends Fragment {
    ListView lv;
    public static String KEY_ANDROID ="wkkssks0g88sss004wko08ok44kkw80osss40gkc";
    ProgressDialog pDialog;
    final ArrayList<InfoJadwal> jadwalArrayList = new ArrayList<>();
    JadwalAdapter jadwalAdapter;
    List<InfoJadwal> listJadwal;
    StringBuffer sb;
    private int load = 1;
    private Context context;
    private boolean loadMore = false;
    String id, tema, tanggal, waktu, tempat, nama, semester, tipe;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jadwal, container, false);

        lv = (ListView) view.findViewById(R.id.listViewJadwal);
        jadwalAdapter = new JadwalAdapter(getActivity().getApplicationContext(), jadwalArrayList);
        lv.setAdapter(jadwalAdapter);
        loadData();
        return view;
    }

    private void loadData() {
        Log.i("masuk", "loadData");
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        SharedPreferences sharedPref = getActivity().getSharedPreferences("data",MODE_PRIVATE);
        String id = sharedPref.getString("id", "");

        schedule(KEY_ANDROID,"1",id);
    }

    private void schedule(String key, String type, String user_id) {
        //login
        final UserSchedule userSchedule = new UserSchedule();
        userSchedule.setKey(key);
        userSchedule.setType(type);
        userSchedule.setUser_id(user_id);
        RetroClient.getClient().create(Endpoint.class).responseJadwal(userSchedule).enqueue(new Callback<InfoListSchedule>() {
            @Override
            public void onResponse(Call<InfoListSchedule> call, Response<InfoListSchedule> response) {
                if (response.isSuccessful()) {
                    Gson gson = new Gson();
                    String j = gson.toJson(response.body());
                    Log.i("response",j);
                    Log.i("response2", response.raw().request().url().toString());
                    pDialog.dismiss();
                    listJadwal = response.body().getData();
                    for(int i = 0 ; i< listJadwal.size() ; i++) {
                         id = listJadwal.get(i).getId();
                         tema     = listJadwal.get(i).getTema();
                         tanggal  = listJadwal.get(i).getTanggal();
                         waktu    = listJadwal.get(i).getWaktu();
                         nama     = listJadwal.get(i).getNama();
                         semester = listJadwal.get(i).getSemester();
                         tempat   = listJadwal.get(i).getTempat();
                         tipe     = listJadwal.get(i).getTipe();

                    }

                    jadwalArrayList.add(new InfoJadwal(id,tema,tanggal,waktu,tempat,nama,semester,tipe));
                }
            }

            @Override
            public void onFailure(Call<InfoListSchedule> call, Throwable t) {

            }
        });

    }

}