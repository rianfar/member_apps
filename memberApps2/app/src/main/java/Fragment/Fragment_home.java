package Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import Adapter.HomeAdapter;
import com.memberapps2.R;

public class Fragment_home extends Fragment {
    ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String[][] title = new String[][]{
                {"Day reappeared. The tempest still raged with undiminished","Corned beef prosciutto ground...","Pendidikan","ic_menu_home"},
                {"There were some signs of a calm at noon","Things to enjoy","Kajian","ic_menu_message"},
                {"Fun tropical escapes","The night was comparatively quiet. Some of the sails were again.","Sosial","ic_menu_person"},
                {"Pork loin sausage shankle, kielbasa bacon beef ribs","Drumstick turkey shoulder square...","Pendidikan","ic_menu_person_add"},
                {"Cherry blossoms in bloom","Spring is here and we all know...","Pendidikan","ic_menu_school"},
                {"Day reappeared. The tempest still raged with undiminished","Corned beef prosciutto ground...","Pendidikan","ic_menu_home"},
                {"There were some signs of a calm at noon","Things to enjoy","Kajian","ic_menu_message"},
                {"Fun tropical escapes","The night was comparatively quiet. Some of the sails were again.","Sosial","ic_menu_person"},
                {"Pork loin sausage shankle, kielbasa bacon beef ribs","Drumstick turkey shoulder square...","Pendidikan","ic_menu_person_add"},
                {"Cherry blossoms in bloom","Spring is here and we all know...","Pendidikan","ic_menu_school"}
        };

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        lv = (ListView) view.findViewById(R.id.listView1);
        HomeAdapter adapter = new HomeAdapter(this.getActivity(), title);
//        ArrayAdapter<String> adapterlistmenu = new ArrayAdapter<String>(getActivity(), R.layout.mylist, R.id.Itemname, title);
        lv.setAdapter(adapter);
        return view;

    }
}