import java.util.ArrayList;

public class ListaPalabras
{
    // ------ Atributos ------
    private static ListaPalabras miListaPalabras;
    private ArrayList<String> listaPalabras;
    // ------ Constructora ------
    private ListaPalabras()
    {
        this.listaPalabras= new ArrayList<String>();
    }
    // ------ Métodos ------

    public static ListaPalabras getMiListaPalabras()
    {
        if (miListaPalabras==null)
        {
            miListaPalabras = new ListaPalabras();
        }
        return miListaPalabras;
    }

    public void anadirPalabra(String palabra){
        listaPalabras.add(palabra);
    }
}
