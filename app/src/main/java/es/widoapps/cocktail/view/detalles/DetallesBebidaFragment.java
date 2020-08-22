package es.widoapps.cocktail.view.detalles;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

                List<String> listaIngredientes = new ArrayList<>();
                List<String> listaMedidas = new ArrayList<>();

                listaIngredientes.addAll(Arrays.asList(bebida.ingrediente1, bebida.ingrediente2, bebida.ingrediente3, bebida.ingrediente4, bebida.ingrediente5,
                        bebida.ingrediente6, bebida.ingrediente7, bebida.ingrediente8, bebida.ingrediente9, bebida.ingrediente10,
                        bebida.ingrediente11, bebida.ingrediente12, bebida.ingrediente13, bebida.ingrediente14, bebida.ingrediente15));

                listaMedidas.addAll(Arrays.asList(bebida.medida1, bebida.medida2, bebida.medida3, bebida.medida4, bebida.medida5,
                        bebida.medida6, bebida.medida7, bebida.medida8, bebida.medida9, bebida.medida10,
                        bebida.medida11, bebida.medida12, bebida.medida13, bebida.medida14, bebida.medida15));

                for (int i = 0; i < 15; i++) {

                    if (listaIngredientes.get(i) != null) {

                        LinearLayout linearLayout = new LinearLayout(getContext());
                        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                        TextView tvMedida = new TextView(getContext());
                        tvMedida.setText(listaMedidas.get(i));
                        tvMedida.setTypeface(null, Typeface.BOLD);

                        TextView tvIngrediente = new TextView(getContext());
                        tvIngrediente.setText(listaIngredientes.get(i));

                        linearLayout.addView(tvMedida);
                        linearLayout.addView(tvIngrediente);
                        fragmentDetallesBebidaBinding.llIngredientes.addView(linearLayout);
                    }
                }
            }
        });
    }
}