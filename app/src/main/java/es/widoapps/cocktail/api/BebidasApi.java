package es.widoapps.cocktail.api;

import es.widoapps.cocktail.modelo.ListaBebidas;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BebidasApi {

    // Observable que retorna un único valor y lo cierra Alcoholic / Non_Alcoholic
    @GET("filter.php")
    Single<ListaBebidas> getBebidas(@Query("a") String tipoBebida);

    @GET("lookup.php")
    Single<ListaBebidas> getBebida(@Query("i") String id);

    @GET("popular.php")
    Single<ListaBebidas> getBebidasPopulares();
}