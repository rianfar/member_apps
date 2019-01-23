package Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.memberapps2.R;

import Adapter.InfoAdapter;

public class Bsq extends Fragment {
    ListView lv;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final String[][] title = new String[][]{
                {"Jadwal Pendidikan", "", "", "ic_menu_home"},
                {"Materi", "", "", "ic_menu_home"},
                {"Quiz", "", "", "ic_menu_home"},
                {"Nilai", "", "", "ic_menu_home"},
        };
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        lv = (ListView) view.findViewById(R.id.listViewBsq);

        final InfoAdapter adapter = new InfoAdapter(this.getActivity(), title);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1) {
                    Materi materi = new Materi();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.framebsq, materi).commit();
                }else if(i == 3){
                    Nilai nilai = new Nilai();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.framebsq, nilai).commit();
                }
            }
        });
        return view;
    }
}
