package es.widoapps.cocktail.adaptador;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.widoapps.cocktail.R;
import es.widoapps.cocktail.databinding.ItemBebidaBinding;
import es.widoapps.cocktail.modelo.Bebida;

public class ListaBebidasAdaptador extends RecyclerView.Adapter<ListaBebidasAdaptador.BebidaViewHolder> {

    private ArrayList<Bebida> listaBebidas;

    public ListaBebidasAdaptador(ArrayList<Bebida> listaBebidas) {
        this.listaBebidas = listaBebidas;
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
    }

    @Override
    public int getItemCount() {
        return listaBebidas.size();
    }

    public class BebidaViewHolder extends RecyclerView.ViewHolder {

        public ItemBebidaBinding itemView;

        public BebidaViewHolder(ItemBebidaBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }
}