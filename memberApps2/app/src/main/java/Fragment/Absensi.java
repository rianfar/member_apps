package Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.memberapps2.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Absensi extends Fragment {
    private ZXingScannerView mScannerView;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_absensi, container, false);
        Button button = (Button) view.findViewById(R.id.btnshowqr);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScannerView = new ZXingScannerView(getActivity().getApplicationContext());
                getActivity().setContentView(mScannerView);
                mScannerView.setResultHandler(new ZXingScannerView.ResultHandler() {
                    @Override
                    public void handleResult(com.google.zxing.Result result) {
                        Log.v("TAG", result.getText()); // Prints scan results
                        Log.v("TAG", result.getBarcodeFormat().toString());
                        mScannerView.removeAllViews(); //<- here remove all the views, it will make an Activity having no View
                        mScannerView.stopCamera(); //<- then stop the camera
                        getActivity().setContentView(R.layout.fragment_absensi); //<- and set the View again.
                        final String vString = result.getText();
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity().getApplicationContext(), vString, Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
                mScannerView.startCamera();
            }
        });
        return view;
    }
}
