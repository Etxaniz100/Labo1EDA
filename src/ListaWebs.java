import java.util.ArrayList;
import java.util.Collections;
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
    public void ordenarWebs()
    {
        // no se pueden ordenar con un sort, ya que tenemos que ordenar la lista de objetos web
        // por tanto tenemos que hacerlo de otra manera, empleando un algoritmo de ordenacion

        Integer n = this.lista.size();
        for (Integer i = 1; i < n; i++) {
            Integer aux = this.lista.get(i).getId();
            Integer j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && lista.get(j).getId() > aux) {
                lista.get(j+1).setId(lista.get(j).getId());
                j = j - 1;
            }
            lista.get(j+1).setId(aux);
        }
    }
    public ArrayList<Web> getLista()
    {
        return this.lista;

    }

    public void insertarWeb(Web pWeb)
    {
        this.lista.add(pWeb);
        //this.ordenarWebs();

    }

    public void anadirRelacion(Integer id, ArrayList<Integer> relaciones)
    {
        // hay que añadir una las relaciones de la web, a la web posicionada en la posicion index de la lista
        this.lista.get(id).editarLista(relaciones);
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
