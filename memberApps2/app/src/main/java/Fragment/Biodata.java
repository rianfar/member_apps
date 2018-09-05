package Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

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
    EditText txtnama, txtnis, txtangkatan, txttmptlahir, txttgllahir, txtemail, txthp, txtalamat, txtkota, txtkodepos,
            txtpekerjaan, txtposisi, txtnamainstansi;
//    Button btnedit;

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
        txttgllahir = (EditText) v.findViewById(R.id.txttgllahir);
        txtemail = (EditText) v.findViewById(R.id.txtemail);
        txthp = (EditText) v.findViewById(R.id.txthp);
        txtalamat = (EditText) v.findViewById(R.id.txtalamat);
        txtkota = (EditText) v.findViewById(R.id.txtkota);
        txtkodepos = (EditText) v.findViewById(R.id.txtkodepos);
        txtpekerjaan = (EditText) v.findViewById(R.id.txtpekerjaan);
        txtposisi = (EditText) v.findViewById(R.id.txtjabatan);
        txtnamainstansi = (EditText) v.findViewById(R.id.namainstansi);

//        btnedit = (Button) v.findViewById(R.id.btnedit);
//        btnedit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity().getApplicationContext(), "Edit", Toast.LENGTH_SHORT).show();
//            }
//        });

        awal();
        calender();

        // Inflate the layout for this fragment
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        getMember("wkkssks0g88sss004wko08ok44kkw80osss40gkc", "8");
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
        txttgllahir.setOnClickListener(new View.OnClickListener() {
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
        txttgllahir.setEnabled(false);
        txtemail.setEnabled(false);
        txthp.setEnabled(false);
        txtalamat.setEnabled(false);
        txtkota.setEnabled(false);
        txtkodepos.setEnabled(false);
        txtpekerjaan.setEnabled(false);
        txtposisi.setEnabled(false);
        txtnamainstansi.setEnabled(false);
    }

    public void updatemember() {
        String key = "wkkssks0g88sss004wko08ok44kkw80osss40gkc",
                member_no = "", member_name = "", member_nickname = "", member_blood = "", member_pob = "", member_dob = "",
                member_hoby = "", member_alamat = "", member_kota = "", member_poscode = "", member_telp = "", member_hp = "",
                member_pinbb = "", member_jabatan = "", member_office_address = "",
                member_office_telp = "", member_angkatan = "";
        Integer id = 0, member_gender = 0, member_job = 0;

        RetroClient.getClient().create(LoginAPI.class).responseUpdateMember(key, id, member_no, member_name, member_nickname,
                member_gender,member_blood,member_pob,member_dob,member_hoby,member_alamat,member_kota,member_poscode,member_telp,member_hp,
                member_pinbb,member_job,member_jabatan,member_office_address,member_office_telp,member_angkatan).enqueue(new Callback<UserMember>() {
            @Override
            public void onResponse(Call<UserMember> call, Response<UserMember> response) {
                Gson gson = new Gson();
                String j = gson.toJson(response.body());

                Log.i("response", j);
                Log.i("response2", response.raw().request().url().toString());
            }

            @Override
            public void onFailure(Call<UserMember> call, Throwable throwable) {

            }
        });
    }
}
