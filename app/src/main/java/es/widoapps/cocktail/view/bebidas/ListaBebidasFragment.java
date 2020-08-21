package es.widoapps.cocktail.view.bebidas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import es.widoapps.cocktail.R;
import es.widoapps.cocktail.viewmodel.ListaBebidasViewModel;

public class ListaBebidasFragment extends Fragment {

    private ListaBebidasViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = ViewModelProviders.of(this).get(ListaBebidasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_lista_bebidas, container, false);

        return root;
    }
}
