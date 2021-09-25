package clasificacion;

public interface IGeneradorDatos {

    public abstract int[] generarDatosAleatorios(int tamanioMax);
    public abstract int[] generarDatosAleatorios();

    public abstract int[] generarDatosAscendentes(int tamanioMax);
    public abstract int[] generarDatosAscendentes();

    public abstract int[] generarDatosDescendentes(int tamanioMax);
    public abstract int[] generarDatosDescendentes();

}
