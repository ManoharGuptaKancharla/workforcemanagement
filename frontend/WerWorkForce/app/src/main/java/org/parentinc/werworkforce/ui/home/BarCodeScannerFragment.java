package org.parentinc.werworkforce.ui.home;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.Navigation;
import com.google.android.material.snackbar.Snackbar;
import org.parentinc.werworkforce.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BarCodeScannerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BarCodeScannerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private CharSequence mParam1;
    private CharSequence mParam2;

    private TextView textView;
    private Button buttonToWorkerDisplayFragment;

    public BarCodeScannerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BarCodeScannerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BarCodeScannerFragment newInstance(CharSequence param1, CharSequence param2) {
        BarCodeScannerFragment fragment = new BarCodeScannerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1.toString());
        args.putString(ARG_PARAM2, param2.toString());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_bar_code_scanner, container, false);

        textView = root.findViewById(R.id.text_view);

        mParam1 = getArguments().get("param1").toString();

        textView.setText(mParam1);

        final EditText workerId = root.findViewById(R.id.edit_text_worker_id);

        buttonToWorkerDisplayFragment = root.findViewById(R.id.button_to_worker_display);

        buttonToWorkerDisplayFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!workerId.getText().toString().equals("Worker Id")){
                    Bundle bundle1 = new Bundle();
                    bundle1.putCharSequence("log_in_out_type", mParam1);
                    bundle1.putCharSequence("bar_code_id", workerId.getText().toString());
                    if(mParam1 == "login"){
                        Navigation.findNavController(v).navigate(R.id.action_nav_barcode_scanner_to_nav_worker_display, bundle1);
                    }
                    if(mParam1 == "modify_worker"){
                        Navigation.findNavController(v).navigate(R.id.action_nav_barcode_scanner_to_nav_modify_worker_fragment, bundle1);
                    }
                    if(mParam1 == "remove_worker"){
                        Navigation.findNavController(v).navigate(R.id.action_nav_barcode_scanner_to_nav_remove_worker_fragment, bundle1);
                    }
                    if(mParam1 == "worker_details"){
                        Navigation.findNavController(v).navigate(R.id.action_nav_barcode_scanner_to_nav_download_worker_fragment, bundle1);
                    }
                }else{
                    Snackbar snackbar = Snackbar
                            .make(v, "Please Enter Worker Id", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });

        return root;
    }
}