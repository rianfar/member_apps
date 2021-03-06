package Fragments;
import com.memberapps2.R;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import Adapter.HomeAdapter;
import connection.Endpoint;
import helper.RetroClient;
import model.Artikel;
import model.Category;
import model.Datum;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.List;

public class Fragment_home extends Fragment {
    ListView lv;
    ProgressDialog pDialog;
    final ArrayList<Datum> artikels = new ArrayList<>();
    HomeAdapter homeAdapter;
    List<Datum> listdatum;
    List<Category> categoryList;
    String id, post_title, post_date, post_url,post_picture,term_id,name;
    StringBuffer sb;
    Context myContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        artikel("1");
        return view;
    }

    private void artikel(String page) {
        RetroClient.getClient().create(Endpoint.class).responseArtikel(page).enqueue(new Callback<Artikel>() {
            @Override
            public void onResponse(Call<Artikel> call, Response<Artikel> response) {
                if (response.isSuccessful()) {
                    pDialog.dismiss();
                    Gson gson = new Gson();
                    String j = gson.toJson(response.body());
                    Log.i("responseartikel", j);

                    listdatum = response.body().getData();
                    for (int i = 0; i < listdatum.size(); i++) {
                        id = listdatum.get(i).getID();
                        post_title = listdatum.get(i).getPostTitle();
                        post_date = listdatum.get(i).getPostDate();
                        post_url = listdatum.get(i).getPostUrl();

                        post_picture = (String) listdatum.get(i).getPostPicture();
                        if (post_picture == null) {
                            post_picture = (String) listdatum.get(1).getPostPicture();
                        } else {
                            post_picture = (String) listdatum.get(i).getPostPicture();
                        }
                        categoryList = listdatum.get(i).getPost_cats();
                        for (int k = i; k < categoryList.size(); k++) {
                            term_id = categoryList.get(k).getTerm_id();
                            name = categoryList.get(k).getName();
//                            sb.append(name);
                        }
                        artikels.add(new Datum(name, post_title, post_date, post_url, post_picture));
                        homeAdapter = new HomeAdapter(getActivity().getApplicationContext(), artikels);
//                        lv = (ListView) getView().findViewById(R.id.listView1);
                        lv.setAdapter(homeAdapter);
                        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Bundle args = new Bundle();
                                args.putString("url",listdatum.get(Integer.parseInt(Long.toString(id))).getID());
                                DetailHome detailHome = new DetailHome();
                                detailHome.setArguments(args);
                                FragmentManager manager = getFragmentManager();
                                FragmentTransaction transaction = manager.beginTransaction();
                                transaction.replace(R.id.content, detailHome);
                                transaction.commit();
                            }
                        });


                    }
                }
            }

            @Override
            public void onFailure(Call<Artikel> call, Throwable throwable) {

            }
        });
    }
}