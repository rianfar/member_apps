package Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.memberapps2.DatePickerDialogFragment;
import com.memberapps2.Home;
import com.memberapps2.LoginActivity;
import com.memberapps2.R;

import connection.LoginAPI;
import helper.RetroClient;
import model.Artikel;
import model.UserMember;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Biodata extends Fragment {
    ProgressDialog pDialog;
    EditText txtnama,txtnis,txtangkatan,txttmptlahir,editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_biodata, container, false);
        UserMember listMember = new UserMember();
        UserMember.ListMember listMember1 = listMember.new ListMember();
        listMember1.getUserId();

        txtnama = (EditText) v.findViewById(R.id.txtnama);
        txtnis = (EditText) v.findViewById(R.id.txtnis);
        txtangkatan = (EditText) v.findViewById(R.id.txtangkatan);
        txttmptlahir = (EditText) v.findViewById(R.id.txttmptlahir);
        editText = (EditText) v.findViewById(R.id.txttgllahir);

        Log.e("tanggalclick", "masuk");

        awal();
        calender();
        // Inflate the layout for this fragment
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
        Log.i("getuserid",listMember.getData().getUserId());
        getMember("wkkssks0g88sss004wko08ok44kkw80osss40gkc", listMember.getData().getUserId());
        return v;
    }

    public void getMember(String key, String user_id) {
        RetroClient.getClient().create(LoginAPI.class).responseMember(key, user_id).enqueue(new Callback<UserMember>() {
            @Override
            public void onResponse(Call<UserMember> call, Response<UserMember> response) {
                if (response.isSuccessful()) {
                    pDialog.dismiss();
                    Gson gson = new Gson();
                    String j = gson.toJson(response.body());

                    Log.i("response", j);
                    Log.i("response2", response.raw().request().url().toString());

                    txtnama.setText(response.body().data.getMemberName());
                    txtnis.setText(response.body().data.getId());
                    txtangkatan.setText(response.body().data.getMemberAngkatan());
                }
            }

            @Override
            public void onFailure(Call<UserMember> call, Throwable throwable) {

            }
        });
    }

    public void calender() {
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment df = new DatePickerDialogFragment();
                df.show(getFragmentManager(), "Date Picker");
//                Log.e("tanggalclick", "error");
            }
        });
    }

    public void awal() {
        txtnama.setEnabled(false);
        txtnis.setEnabled(false);
        txtangkatan.setEnabled(false);
        txttmptlahir.setEnabled(false);
    }
}
