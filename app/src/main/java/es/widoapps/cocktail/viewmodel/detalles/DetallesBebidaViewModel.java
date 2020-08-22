package es.widoapps.cocktail.viewmodel.detalles;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import es.widoapps.cocktail.api.BebidasApiServicio;
import es.widoapps.cocktail.modelo.Bebida;
import es.widoapps.cocktail.modelo.ListaBebidas;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DetallesBebidaViewModel extends AndroidViewModel {

    public MutableLiveData<Bebida> bebida = new MutableLiveData<Bebida>();

    private BebidasApiServicio bebidasApiServicio = new BebidasApiServicio();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public DetallesBebidaViewModel(@NonNull Application application) {
        super(application);
    }

    public void cargarBebidaRemoto(String idBebida) {

        compositeDisposable.add(
                bebidasApiServicio.getBebida(idBebida)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<ListaBebidas>() {

                            @Override
                            public void onSuccess(ListaBebidas bebidas) {

                                bebida.setValue(bebidas.listaBebidas.get(0));
                            }

                            @Override
                            public void onError(Throwable e) {

                                e.printStackTrace();
                            }
                        })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}