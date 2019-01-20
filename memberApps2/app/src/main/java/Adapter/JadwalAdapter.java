package Adapter;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.memberapps2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import model.Datum;
import model.InfoJadwal;

public class JadwalAdapter extends ArrayAdapter<InfoJadwal> {
    private Context context;
    TextView tanggal, bulan, nama,materi,tempat;
    String date,month;
    String [] arrmonth = {"Jan","Feb","Mar","Apr","Mei","Jun","Jul","Agt","Sept","Okt","Nov","Des"};
    public JadwalAdapter(Context context, ArrayList<InfoJadwal> jadwalAdapter) {
        super(context, 0, jadwalAdapter);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.listjadwal, null);
        }

        InfoJadwal jadwal = getItem(position);
        tanggal = (TextView) convertView.findViewById(R.id.tanggal);
        date = jadwal.getTanggal().substring(8,1);
        tanggal.setText(date);
        bulan = (TextView) convertView.findViewById(R.id.bulan);
        month = jadwal.getTanggal().substring(6,1);
        bulan.setText(arrmonth[Integer.parseInt(month)-1]);
        nama = (TextView) convertView.findViewById(R.id.nama);
        nama.setText(jadwal.getNama());
        materi = (TextView) convertView.findViewById(R.id.materi);
        materi.setText(jadwal.getTema());
        tempat = (TextView) convertView.findViewById(R.id.tempat);
        tempat.setText(jadwal.getTempat());
        return convertView;
    }
}

