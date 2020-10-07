<h1 align="center">Cocktail</h1>

<p align="center">  
Cocktail es una aplicación de demostración consumiendo un API Rest bajo el lenguaje Java y el patrón de diseño MVVM.
</p>
</br>

<p align="center">
<img src="/imagenes/imagen1.png" width="32%"/>
<img src="/imagenes/imagen2.png" width="32%"/>
<img src="/imagenes/imagen3.png" width="32%"/>
</p>


## Descargar

Clonar el proyecto y compilar

<img src="/imagenes/imagen4.png" align="right" width="32%"/>

## Tecnologías & librerías

- Mínimo SDK level 21
- Lenguaje Java
- JetPack
  - LiveData - notifica los cambios a las vistas.
  - Lifecycle - disponer de datos de observación cuando cambie el estado del ciclo de vida.
  - ViewModel - posee los datos relacionados con la UI.
- Patrón de diseño
  - MVVM (Modelo - Vista - VistaModelo)
- [Retrofit2](https://github.com/square/retrofit) - construir el API REST
- [Glide](https://github.com/bumptech/glide) - cargar imagenes.
- [Material-Components](https://github.com/material-components/material-components-android) - Componentes de Material design como Card Views

## Patrón de diseño

Cocktail está basado en el patrón de diseño MVVM.

![arquitectura](https://miro.medium.com/max/2732/1*n8Jzac0o-EXS_3mVCv-qeg.png)

## API abierta

Cocktail utiliza [TheCocktailDB](https://www.thecocktaildb.com/api.php) para construir el API REST.
