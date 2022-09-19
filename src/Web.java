import java.util.ArrayList;

public class Web
{
    private String nombre;
    private Integer id;
    private ArrayList<Integer> listaRelaciones;

    public Web(String pNombre, Integer pId)
    {
        this.id = pId;
        this.nombre = pNombre;
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
    public void editarLista()
    {

    }
}

