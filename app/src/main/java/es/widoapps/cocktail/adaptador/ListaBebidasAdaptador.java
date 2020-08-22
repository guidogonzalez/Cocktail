package es.widoapps.cocktail.adaptador;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.widoapps.cocktail.R;
import es.widoapps.cocktail.databinding.ItemBebidaBinding;
import es.widoapps.cocktail.modelo.Bebida;

public class ListaBebidasAdaptador extends RecyclerView.Adapter<ListaBebidasAdaptador.BebidaViewHolder> {

    private ArrayList<Bebida> listaBebidas;
    private String tipoBebida;

    public ListaBebidasAdaptador(ArrayList<Bebida> listaBebidas, String tipoBebida) {
        this.listaBebidas = listaBebidas;
        this.tipoBebida = tipoBebida;
    }

    public void actualizarListaBebidas(List<Bebida> nuevaListaBebidas) {

        listaBebidas.clear();
        listaBebidas.addAll(nuevaListaBebidas);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BebidaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemBebidaBinding view = DataBindingUtil.inflate(inflater, R.layout.item_bebida, parent, false);

        return new BebidaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BebidaViewHolder holder, int position) {

        holder.itemView.setBebida(listaBebidas.get(position));
        holder.itemView.clPrincipal.setOnClickListener(v -> {

            String idBebida = holder.itemView.tvListaIdBebida.getText().toString();

            Bundle bundle = new Bundle();
            bundle.putString("idBebida", idBebida);

            switch (tipoBebida) {
                case "Alcoholic":
                    Navigation.findNavController(v).navigate(R.id.action_navigation_lista_alcoholicas_to_navigation_detalles_bebida, bundle);
                    break;
                case "Non_Alcoholic":
                    Navigation.findNavController(v).navigate(R.id.action_navigation_lista_no_alcoholicas_to_navigation_detalles_bebida, bundle);
                    break;
                case "Popular":
                    Navigation.findNavController(v).navigate(R.id.action_navigation_lista_populares_to_navigation_detalles_bebida, bundle);
                    break;
                default:
                    break;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaBebidas.size();
    }

    public class BebidaViewHolder extends RecyclerView.ViewHolder {

        public ItemBebidaBinding itemView;

        public BebidaViewHolder(@NonNull ItemBebidaBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }
}