package org.parentinc.werworkforce.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import org.parentinc.werworkforce.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        //final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }
        });

        Button addWorkerbutton = root.findViewById(R.id.button_add_worker);
        addWorkerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putCharSequence("param1", "add_worker");
                Navigation.findNavController(v).navigate(R.id.action_nav_gallery_to_addWorkerFragment, bundle);
            }
        });

        Button modifyWorkerbutton = root.findViewById(R.id.button_modify_worker);
        modifyWorkerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putCharSequence("param1", "modify_worker");
                Navigation.findNavController(v).navigate(R.id.action_nav_gallery_to_nav_barcode_scanner, bundle);
            }
        });

        Button removeWorkerbutton = root.findViewById(R.id.button_remove_worker);
        removeWorkerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putCharSequence("param1", "remove_worker");
                Navigation.findNavController(v).navigate(R.id.action_nav_gallery_to_nav_barcode_scanner, bundle);
            }
        });

        Button workerDetailsbutton = root.findViewById(R.id.button_worker_details);
        workerDetailsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putCharSequence("param1", "worker_details");
                Navigation.findNavController(v).navigate(R.id.action_nav_gallery_to_nav_barcode_scanner, bundle);
            }
        });

        return root;
    }
}