import java.lang.reflect.Array;
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

    // métodos para el quicksort:
    public void intercambiar(ArrayList<Web> laLista, Integer i, Integer j)
    {
        // aqui intercambiamos los elementos de la lista que nos interesen
        Web aux = laLista.get(i);
        laLista.set(i,laLista.get(j));
        laLista.set(j,aux);
    }
    private Integer particion(ArrayList<Web> laLista, Integer inicio, Integer fin)
    {
        Integer pivote = laLista.get(fin).getId();
        Integer indice = (inicio-1);
        // empezamos el bucle
        for (Integer indice2 = inicio; indice2<fin; indice2++)
        {
            if (laLista.get(indice2).getId()<=pivote)
            {
                indice++;
                intercambiar(laLista, indice, indice2);
            }
        }
        intercambiar(laLista, indice+1, fin);
        return (indice+1);
    }
    public void quicksort(ArrayList<Web> laLista, Integer inicio, Integer fin)
            // aqui haremos el quicksort usando recursividad
    {
        if (inicio<fin)
        {
            // aqui conseguimos la particion que nos interesa
            Integer indice = particion(laLista, inicio,fin);
            // y dividimos el problema en dos trozos, que se llamaran recursivamente y se irán ordenando
            quicksort(laLista,inicio, indice-1);
            quicksort(laLista, indice+1, fin );
        }
    }
    public void ordenarWebs()
    {
        // no se pueden ordenar con un sort, ya que tenemos que ordenar la lista de objetos web
        // por tanto tenemos que hacerlo de otra manera, empleando un algoritmo de ordenacion
        // por complejidad del tiempo es mejor idea usar el algoritmo QUICKSORT --> O(n*log(n))
        quicksort(this.lista, 0, this.lista.size());
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
        // puede que se intente borrar una web que no está en la lista, asi que hay que hacer un try
        // Complejidad de tiempo --> O(n) ya que solo tiene un bucle
        Integer identif= pWeb.getId();
        // lo eliminamos de la lista, y ahora tenemos que mover el resto de la lista que necesitamos
        try
        {
            lista.remove(pWeb);
            for (Integer i= identif; i<this.lista.size(); i++)
            {
                // con esto conseguimos que su posicion en el array y su id sean el mismo
                this.lista.get(i).setId(i);
            }
        }
        catch(IndexOutOfBoundsException ioobe)
        {
            System.out.println("La web no está en la lista!");
        }
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
