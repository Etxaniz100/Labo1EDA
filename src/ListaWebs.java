import java.util.ArrayList;
import java.util.Iterator;

public class ListaWebs
{
    // ------ Atributos ------
    private ArrayList<Web> lista;
    private static ListaWebs miListaWebs;

    private ListaWebs()
    {
        lista = new ArrayList<Web>();
    }

    public static ListaWebs getMiListaWebs()
    {
        if (miListaWebs==null)
        {
            miListaWebs= new ListaWebs();
        }
        return miListaWebs;
    }

    private Iterator<Web> getIterator()
    {
        return this.lista.iterator();
    }
    public void anadirWeb(Web pWeb)
    {
        // hay que añadir una web a la lista, en el orden en el que le corresponda. Para ello habrá que usar un iterador y el identificador de la web a añadir
    }
    public void borrarWeb(Web pWeb)
    {
        // hay que borrar una web a la lista, en el orden en el que le corresponda
    }
    public Web buscarWebPorString(String pNombre)
    {
        // Desarrollar
        return null;
    }
    public Integer string2Id(String pNombre)
    {
        // hay que encontrar el Id del nombre de esa web, para eso hay que buscarla en la lista.

        return null;
    }
    public String id2String(Integer pId)
    {
        // hay que encontrar la string de esa web, y para eso no es necesario hacer una busqueda, sino que ya sabemos donde debería de estar
        Web unaWeb;
        String nom = null;
        try
        {
            unaWeb = this.lista.get(pId);
            nom = unaWeb.getNombre();
        }
        catch(NullPointerException nullPointerException)
        {
            System.out.println("La web no se encuentra en la lista");
        }
        return (nom);
    }


}
