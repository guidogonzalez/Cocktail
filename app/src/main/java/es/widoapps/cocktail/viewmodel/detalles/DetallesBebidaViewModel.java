package es.widoapps.cocktail.viewmodel.detalles;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import es.widoapps.cocktail.modelo.ListaBebidas;

public class DetallesBebidaViewModel extends AndroidViewModel {

    private MutableLiveData<ListaBebidas> bebida = new MutableLiveData<ListaBebidas>();

    public DetallesBebidaViewModel(@NonNull Application application) {
        super(application);
    }
}