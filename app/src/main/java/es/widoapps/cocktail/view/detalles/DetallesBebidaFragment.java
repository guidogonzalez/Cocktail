package es.widoapps.cocktail.view.detalles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import es.widoapps.cocktail.R;
import es.widoapps.cocktail.viewmodel.DetallesBebidaViewModel;

public class DetallesBebidaFragment extends Fragment {

    private DetallesBebidaViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        dashboardViewModel = ViewModelProviders.of(this).get(DetallesBebidaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_detalles_bebida, container, false);

        return root;
    }
}
