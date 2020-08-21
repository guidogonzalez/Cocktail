package es.widoapps.cocktail.view.bebidas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import es.widoapps.cocktail.R;
import es.widoapps.cocktail.adaptador.ListaBebidasAdaptador;
import es.widoapps.cocktail.viewmodel.ListaBebidasViewModel;

public class ListaBebidasFragment extends Fragment {

    private View view;
    private SwipeRefreshLayout srlListaBebidas;
    private RecyclerView rvListaBebidas;
    private TextView tvErrorCargar;
    private ProgressBar pbCargar;

    private ListaBebidasViewModel listaBebidasViewModel;
    private ListaBebidasAdaptador listaBebidasAdaptador = new ListaBebidasAdaptador(new ArrayList<>());

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_lista_bebidas, container, false);

        srlListaBebidas = view.findViewById(R.id.srlListaBebidas);
        rvListaBebidas = view.findViewById(R.id.rvListaBebidas);
        tvErrorCargar = view.findViewById(R.id.tvErrorCargar);
        pbCargar = view.findViewById(R.id.pbCargar);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listaBebidasViewModel = ViewModelProviders.of(this).get(ListaBebidasViewModel.class);
        listaBebidasViewModel.cargarRemoto("Alcoholic");

        rvListaBebidas.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvListaBebidas.setAdapter(listaBebidasAdaptador);

        observarViewModel();
    }

    private void observarViewModel() {

        listaBebidasViewModel.bebidas.observe(getViewLifecycleOwner(), bebidas -> {

            if (bebidas != null && bebidas instanceof List) {

                rvListaBebidas.setVisibility(View.VISIBLE);
                listaBebidasAdaptador.actualizarListaBebidas(bebidas);
            }
        });

        listaBebidasViewModel.bebidaErrorCargar.observe(getViewLifecycleOwner(), esError -> {

            if (esError != null && esError instanceof Boolean) {

                tvErrorCargar.setVisibility(esError ? View.VISIBLE : View.GONE);
            }
        });

        listaBebidasViewModel.cargando.observe(getViewLifecycleOwner(), estaCargando -> {

            if (estaCargando != null && estaCargando instanceof Boolean) {

                pbCargar.setVisibility(estaCargando ? View.VISIBLE : View.GONE);

                if (estaCargando) {
                    rvListaBebidas.setVisibility(View.GONE);
                    tvErrorCargar.setVisibility(View.GONE);
                }
            }
        });
    }
}
