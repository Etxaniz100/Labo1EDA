import java.util.ArrayList;
import java.util.Collections;

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
    public void ordenarPalabras()
    {
        // se usa el collections para poder ordenar la lista de strings sin tener que programar de cero
        Collections.sort(listaPalabras);
    }
    public void anadirPalabra(String palabra)
    {
        // Se ordena despues de añadir la palabra porque el .add la añade al final.

        if (!listaPalabras.contains(palabra) && palabra != null){
            listaPalabras.add(palabra);
        }


    }
    public String obtenerPalabra(Integer id)
    {
        String devolver = null;
        if (id != null) {
            try {
                listaPalabras.get(id);
                devolver = listaPalabras.get(id);
            } catch (IndexOutOfBoundsException ioobe) {
                System.out.println("No existe la posicion");
            }
        }
        return devolver;
    }

    public Integer getLength()
    {
        return listaPalabras.size();
    }
    public ArrayList<String> getListaPalabras()
    {
        return listaPalabras;
    }
    public void borrarLista()
    {
        listaPalabras = new ArrayList<String>();
    }
}
