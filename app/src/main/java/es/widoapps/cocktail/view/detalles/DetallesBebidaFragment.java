package es.widoapps.cocktail.view.detalles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import es.widoapps.cocktail.R;
import es.widoapps.cocktail.databinding.FragmentDetallesBebidaBinding;
import es.widoapps.cocktail.modelo.Bebida;
import es.widoapps.cocktail.viewmodel.detalles.DetallesBebidaViewModel;

public class DetallesBebidaFragment extends Fragment {

    private DetallesBebidaViewModel detallesBebidaViewModel;
    private FragmentDetallesBebidaBinding fragmentDetallesBebidaBinding;

    private String idBebida;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentDetallesBebidaBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detalles_bebida, container, false);

        return fragmentDetallesBebidaBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {

            idBebida = DetallesBebidaFragmentArgs.fromBundle(getArguments()).getIdBebida();
        }

        detallesBebidaViewModel = ViewModelProviders.of(this).get(DetallesBebidaViewModel.class);
        detallesBebidaViewModel.cargarBebidaRemoto(idBebida);

        observarViewModel();
    }

    private void observarViewModel() {

        detallesBebidaViewModel.bebida.observe(getViewLifecycleOwner(), bebida -> {

            if (bebida != null && bebida instanceof Bebida && getContext() != null) {

                fragmentDetallesBebidaBinding.setBebida(bebida);
            }
        });
    }
}