package Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.memberapps2.R;

import Adapter.HomeAdapter;
import Adapter.InfoAdapter;

public class Info extends Fragment {
    ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String[][] title = new String[][]{
                {"Day reappeared. The tempest still raged with undiminished", "Corned beef prosciutto ground...", "10 min", "ic_menu_home"},
                {"Day reappeared. The tempest still raged with undiminished", "Corned beef prosciutto ground...", "10 min", "ic_menu_home"},
                {"Day reappeared. The tempest still raged with undiminished", "Corned beef prosciutto ground...", "10 min", "ic_menu_home"},
                {"Day reappeared. The tempest still raged with undiminished", "Corned beef prosciutto ground...", "10 min", "ic_menu_home"},
                {"Day reappeared. The tempest still raged with undiminished", "Corned beef prosciutto ground...", "10 min", "ic_menu_home"},
                {"Day reappeared. The tempest still raged with undiminished", "Corned beef prosciutto ground...", "10 min", "ic_menu_home"},
                {"Day reappeared. The tempest still raged with undiminished", "Corned beef prosciutto ground...", "10 min", "ic_menu_home"},
                {"Day reappeared. The tempest still raged with undiminished", "Corned beef prosciutto ground...", "10 min", "ic_menu_home"},
                {"Day reappeared. The tempest still raged with undiminished", "Corned beef prosciutto ground...", "10 min", "ic_menu_home"}
        };
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        lv = (ListView) view.findViewById(R.id.listView2);
        InfoAdapter adapter = new InfoAdapter(this.getActivity(), title);
//        ArrayAdapter<String> adapterlistmenu = new ArrayAdapter<String>(getActivity(), R.layout.mylist, R.id.Itemname, title);
        lv.setAdapter(adapter);

        return view;
    }
}
