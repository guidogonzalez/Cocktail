package es.widoapps.cocktail.api;

import es.widoapps.cocktail.modelo.ListaBebidas;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BebidasApiServicio {

    private static final String URL_BASE = "https://www.thecocktaildb.com/api/json/v2/1/";

    private BebidasApi api;

    public BebidasApiServicio() {

        api = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(BebidasApi.class);
    }

    public Single<ListaBebidas> getBebidas(String tipoBebida) {

        return api.getBebidas(tipoBebida);
    }

    public Single<ListaBebidas> getBebida(String id) {

        return api.getBebida(id);
    }
}