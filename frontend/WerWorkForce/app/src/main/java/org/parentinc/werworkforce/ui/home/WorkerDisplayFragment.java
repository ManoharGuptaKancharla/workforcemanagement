package org.parentinc.werworkforce.ui.home;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.parentinc.werworkforce.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WorkerDisplayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WorkerDisplayFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private CharSequence mParam1;
    private CharSequence mParam2;

    private TextView textLogInOut;
    private TextView textBarcodeId;

    private Button buttonOk;

    public WorkerDisplayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WorkerDisplayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WorkerDisplayFragment newInstance(CharSequence param1, CharSequence param2) {
        WorkerDisplayFragment fragment = new WorkerDisplayFragment();
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
        View root = inflater.inflate(R.layout.fragment_worker_display, container, false);

        textLogInOut = root.findViewById(R.id.text_log_in_out_type_at_worker_display);
        textBarcodeId = root.findViewById(R.id.text_barcode_id);

        buttonOk = root.findViewById(R.id.button_proceed_with_request);

        mParam1 = getArguments().get("log_in_out_type").toString();
        mParam2 = getArguments().get("bar_code_id").toString();

        textLogInOut.setText(mParam1);
        textBarcodeId.setText(mParam2);

        if(mParam1 == "login" && !buttonOk.isClickable()){
            buttonOk.setClickable(true);
            buttonOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    textBarcodeId.setText("Successfully Updated.");
                }
            });
        }

        return root;
    }
}