package es.widoapps.cocktail.api;

import java.util.List;

import es.widoapps.cocktail.modelo.Bebida;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BebidasApi {

    // Observable que retorna un único valor y lo cierra Alcoholic / Non_Alcoholic
    @GET("filter.php")
    Single<List<Bebida>> getBebidas(@Query("a") String tipo);

    @GET("lookup.php")
    Single<Bebida> getBebida(@Query("i") String id);
}