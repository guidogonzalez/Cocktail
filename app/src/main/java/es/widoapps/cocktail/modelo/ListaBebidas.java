package es.widoapps.cocktail.modelo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListaBebidas {

    @SerializedName("drinks")
    public ArrayList<Bebida> listaBebidas;
}
