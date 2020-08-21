package es.widoapps.cocktail.api;

import java.util.List;

import es.widoapps.cocktail.modelo.Bebida;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BebidasApiServicio {

    private static final String URL_BASE = "https://www.thecocktaildb.com/api/json/v2/1";

    private BebidasApi api;

    public BebidasApiServicio() {

        api = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(BebidasApi.class);
    }

    public Single<List<Bebida>> getBebidas(String tipo) {

        return api.getBebidas(tipo);
    }

    public Single<Bebida> getBebida(String id) {

        return api.getBebida(id);
    }
}