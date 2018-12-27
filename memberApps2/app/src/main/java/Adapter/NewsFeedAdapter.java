package adapter;

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

import entity.NewsFeedData;
import model.Datum;

public class NewsFeedAdapter extends ArrayAdapter<NewsFeedData> {
    private Context context;
    TextView name, post_title, post_date;
    ImageView post_picture;

    public NewsFeedAdapter(Context context, ArrayList<NewsFeedData> newsFeedAdapter) {
        super(context, 0, newsFeedAdapter);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.mylist, null);
        }

        NewsFeedData newsFeedData = getItem(position);
        name = (TextView) convertView.findViewById(R.id.Itemname);
        name.setText(newsFeedData.getName());
        name.setTextColor(Color.BLACK);
        post_title = (TextView) convertView.findViewById(R.id.Desc);
        post_title.setText(newsFeedData.getPostTitle());
        post_title.setTextColor(Color.BLACK);
        post_date = (TextView) convertView.findViewById(R.id.Bidang);
        post_date.setText(newsFeedData.getPostDate());
        post_date.setTextColor(Color.BLACK);
        post_picture = (ImageView) convertView.findViewById(R.id.imageNewsFeed);
        Picasso.with(context)
                .load(newsFeedData.getPostPicture().toString())
                .into(post_picture);

        return convertView;
    }
}
