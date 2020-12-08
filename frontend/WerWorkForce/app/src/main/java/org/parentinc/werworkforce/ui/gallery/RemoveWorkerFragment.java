package org.parentinc.werworkforce.ui.gallery;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.parentinc.werworkforce.R;

public class RemoveWorkerFragment extends Fragment {

    private RemoveWorkerViewModel mViewModel;

    public static RemoveWorkerFragment newInstance() {
        return new RemoveWorkerFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_remove_worker, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RemoveWorkerViewModel.class);
        // TODO: Use the ViewModel
    }

}