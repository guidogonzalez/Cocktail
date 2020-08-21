package es.widoapps.cocktail.utils;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import es.widoapps.cocktail.R;

public class Util {

    public static void cargarImagen(ImageView imageView, String url, CircularProgressDrawable progressDrawable) {

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(progressDrawable)
                .error(R.mipmap.ic_launcher);

        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(url)
                .into(imageView);
    }

    public static CircularProgressDrawable getProgressDrawable(Context context) {

        CircularProgressDrawable cpd = new CircularProgressDrawable(context);

        cpd.setStrokeWidth(8f);
        cpd.setCenterRadius(50f);
        cpd.start();

        return cpd;
    }

    @BindingAdapter("android:imageUrl")
    public static void cargarImagen(ImageView view, String url) {

        cargarImagen(view, url, getProgressDrawable(view.getContext()));
    }
}