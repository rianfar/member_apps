package Fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.memberapps2.DatePickerDialogFragment;
import com.memberapps2.R;

public class Biodata extends Fragment {
    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_biodata, container, false);
        Log.e("tanggalclick", "masuk");
        editText = (EditText) v.findViewById(R.id.txttgllahir);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment df = new DatePickerDialogFragment();
                df.show(getFragmentManager(), "Date Picker");
//                Log.e("tanggalclick", "error");
            }
        });
        // Inflate the layout for this fragment
        return v;
    }


//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EditText editText = (EditText) getActivity().findViewById(R.id.txttgllahir);
//        editText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DialogFragment df = new DatePickerDialogFragment();
//                df.show(getFragmentManager(), "Date Picker");
//            }
//        });
//    }
}
