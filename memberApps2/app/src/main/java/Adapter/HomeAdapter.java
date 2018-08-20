package adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.memberapps2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import connection.LoginAPI;
import model.Artikel;
import model.Datum;

public class HomeAdapter extends ArrayAdapter<Datum> {
    private Context context;
    TextView ID, post_title, post_date;
    ImageView post_picture;

    public HomeAdapter(Context context, ArrayList<Datum> homeAdapter) {
        super(context, 0, homeAdapter);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.mylist, null);
        }

        Datum Datum = getItem(position);

        ID = (TextView) convertView.findViewById(R.id.Itemname);
        ID.setText(Datum.getID());
        ID.setTextColor(Color.RED);
        post_title = (TextView) convertView.findViewById(R.id.Desc);
        post_title.setText(Datum.getPostTitle());
        post_title.setTextColor(Color.RED);
        post_date = (TextView) convertView.findViewById(R.id.Bidang);
        post_date.setText(Datum.getPostDate());
        post_date.setTextColor(Color.RED);
        post_picture = (ImageView) convertView.findViewById(R.id.image1);
        Picasso.with(context)
                .load(Datum.getPostPicture().toString())
                .into(post_picture);

        return convertView;
    }
}
