package es.widoapps.cocktail.viewmodel.bebidas;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import es.widoapps.cocktail.api.BebidasApiServicio;
import es.widoapps.cocktail.modelo.Bebida;
import es.widoapps.cocktail.modelo.ListaBebidas;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ListaBebidasViewModel extends AndroidViewModel {

    public MutableLiveData<List<Bebida>> bebidas = new MutableLiveData<List<Bebida>>();
    public MutableLiveData<Boolean> bebidaErrorCargar = new MutableLiveData<Boolean>();
    public MutableLiveData<Boolean> cargando = new MutableLiveData<Boolean>();

    private BebidasApiServicio bebidasApiServicio = new BebidasApiServicio();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ListaBebidasViewModel(@NonNull Application application) {
        super(application);
    }

    public void cargarRemoto(String tipoBebida) {

        cargando.setValue(true);

        if (tipoBebida.equalsIgnoreCase("Alcoholic") || tipoBebida.equalsIgnoreCase("Non_Alcoholic")) {

            compositeDisposable.add(
                    bebidasApiServicio.getBebidas(tipoBebida)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeWith(new DisposableSingleObserver<ListaBebidas>() {

                                @Override
                                public void onSuccess(ListaBebidas bebidas) {

                                    bebidasRecibidas(bebidas.listaBebidas);
                                }

                                @Override
                                public void onError(Throwable e) {

                                    bebidaErrorCargar.setValue(true);
                                    cargando.setValue(false);
                                    e.printStackTrace();
                                }
                            })
            );

        } else {

            compositeDisposable.add(
                    bebidasApiServicio.getBebidasPopulares()
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeWith(new DisposableSingleObserver<ListaBebidas>() {

                                @Override
                                public void onSuccess(ListaBebidas bebidas) {

                                    bebidasRecibidas(bebidas.listaBebidas);
                                }

                                @Override
                                public void onError(Throwable e) {

                                    bebidaErrorCargar.setValue(true);
                                    cargando.setValue(false);
                                    e.printStackTrace();
                                }
                            })
            );
        }
    }

    private void bebidasRecibidas(List<Bebida> listaBebidas) {

        bebidas.setValue(listaBebidas);
        bebidaErrorCargar.setValue(false);
        cargando.setValue(false);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}