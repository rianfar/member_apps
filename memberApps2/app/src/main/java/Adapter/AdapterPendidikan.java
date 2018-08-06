package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import Fragment.Info;
import Fragment.Absensi;
import Fragment.Nilai;

import static Fragment.Profile.int_items;

public class AdapterPendidikan extends FragmentPagerAdapter {

    public AdapterPendidikan(FragmentManager fm) {
        super(fm);
    }

    /**
     * Return fragment with respect to Position .
     */

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Info tab1 = new Info();
                return tab1;
            case 1:
                Absensi tab2 = new Absensi();
                return tab2;
            case 2:
                Nilai tab3 = new Nilai();
                return tab3;
        }
        return null;
    }

    @Override
    public int getCount() {

        return int_items;

    }

    /**
     * This method returns the title of the tab according to the position.
     */

    @Override
    public CharSequence getPageTitle(int position) {
        String namatab;
        if (position==0){
            namatab = "Info";
        }else if (position==1){
            namatab = "Absensi";
        }else{
            namatab = "Nilai";
        }
        return namatab;
    }
}
