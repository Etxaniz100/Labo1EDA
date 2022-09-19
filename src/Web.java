import java.util.ArrayList;

public class Web
{
    // los tres atributos que usamos son el nombre de la web, el identificador y la lista de las relaciones que esta tiene con las demás
    private String nombre;
    private Integer id;
    private ArrayList<Integer> listaRelaciones;

    // la constructora que usaremos en la mayoría de los casos
    public Web(String pNombre, Integer pId)
    {
        this.id = pId;
        this.nombre = pNombre;
    }
    // esta constructora se usaría en caso de que tendríamos todos los datos de entrada, pero como por lo general tendremos
    // solo el id y el nombre cuando creemos el objeto web, no la utilizaremos.
    public Web(String pNombre, Integer pId, ArrayList<Integer> pLista)
    {
        this.id = pId;
        this.nombre = pNombre;
        this.listaRelaciones = pLista;
    }
    public Integer getId()
    {
        return (this.id);
    }
    public String getNombre()
    {
        return (this.nombre);
    }
    public ArrayList<Integer> getLista()
    {
        return (this.listaRelaciones);
    }
    public void editarLista(ArrayList<Integer> pLista)
    {
        this.listaRelaciones = pLista;
    }

}

