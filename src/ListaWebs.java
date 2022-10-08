import java.lang.reflect.Array;
import java.util.*;

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
        // tenemos que hacer que el pivote sea aleatorio dentro de un rango, ya que si la lista estuviese ordenada tardaría n^2 de media, cosa que es inaceptable.
        //Random aleatorio = new Random();
        //Integer pivote;
        //System.out.println(fin);
        // if (fin==0)
            //{
            //     pivote = aleatorio.nextInt(fin);
            // }
        //else
            // {
            //    pivote = aleatorio.nextInt(fin-1);
            //    if (pivote<0)
        //    {
        //        pivote = aleatorio.nextInt(fin);
        //    }
        //}
        //Integer indice = (inicio-1);
        // manera 2, hacer que el pivote sea el elemento del medio del array
        Integer indice = (inicio-1);
        Integer pivote;
        if ((fin-inicio) % 2 == 0)
        {
            pivote = (fin-inicio)/2;
        }
        else
        {
            pivote = ((fin-inicio)+1)/2;
        }
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
    {
            // aqui haremos el quicksort usando recursividad
        if (inicio<fin)
        {
            // aqui conseguimos la particion que nos interesa, obtenemos la posicion del elemento que ya esta ordenado
            Integer indice = particion(laLista, inicio,fin);
            // y dividimos el problema en dos trozos, que se llamaran recursivamente y se irán ordenando
            if (inicio<indice)
            {
                quicksort(laLista,inicio, indice-1);
            }
            quicksort(laLista, indice+1, fin );
        }

    }
    public void ordenarWebs()
    {
        // no se pueden ordenar con un sort, ya que tenemos que ordenar la lista de objetos web
        // por tanto tenemos que hacerlo de otra manera, empleando un algoritmo de ordenacion
        // por complejidad del tiempo es mejor idea usar el algoritmo QUICKSORT --> O(n*log(n))
        quicksort(this.lista, 0, this.lista.size()-1);
    }
    //Fin quicksort

    // intentar probar otro tipo de ordenar
    public void ordenarWebs2()
    {
        // esta es otra manera de comparar, en la que usamos un comparator.
        // coste lineal --> O(n*logn*c) donde c es el coste del comparator, que es despreciable, por tanto --> O(n*logn)
        lista.sort(Comparator.comparing(Web::getNombre));
    }
    public ArrayList<Web> getLista()
    {
        return this.lista;

    }

    public void insertarWeb(Web pWeb)
    {
        lista.add(pWeb);
    }
    public void anadirWeb(Web pWeb)
    {
        if (lista.contains(pWeb))
        {
            System.out.println("La web ya está en la lista.");
        }
        else
        {
            insertarWeb(pWeb);
            this.ordenarWebs2();
        }
        // este método ordena la lista usando el objeto comparator, respecto a su nombre
    }
    public void anadirRelacion(Integer id, ArrayList<Web> relaciones)
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
        // hay que encontrar el Id del nombre de esa web, para eso hay que buscarla en la lista.
        //Como hay muchas webs, empezamos en la mitad de la lista y comprobamos por que letra empiezan las webs, si nuestra
        //web coincide con esa letra, se comprobara la siguiente letra
        //Si no coincide y es mas pequeña obtenemos la nueva lista formada por todos los elementos a la izquierda y se vuelve a implementar
        //Lo mismo en caso de que sea mayor
        return buscarWebPorNombre(lista, 0, lista.size(), pNombre, 0);
    }

    public Web buscarWebPorNombre(ArrayList<Web> lista, Integer inicio, Integer fin, String nombre, Integer caracter)
    {
        //System.out.println("Inicio");
        Integer indxComprobador;
        //Obtenemos el index que este en medio de la lista
        if ((fin-inicio) % 2 == 0)
        {
            indxComprobador = (fin-inicio)/2;
        }
        else
        {
            indxComprobador = ((fin-inicio)+1)/2;
        }
        indxComprobador = indxComprobador + inicio;

        //System.out.println("La lista empieza en " + inicio + ", y acaba en " + fin + ". Entonces partimos en " + indxComprobador);
        //System.out.println("Tamaño de la lista : " + (fin - inicio));
        //Obtenemos el nombre de esa web
        Web devolver = null;
        boolean buscando = true;
        if (lista.get(indxComprobador)==null)
        {
            System.out.println("Fuera de rango!");
            devolver = null;
        }
        else
        {
            String nombreSeparador;
            nombreSeparador = lista.get(indxComprobador).getNombre();
            //Ahora comparamos la primera letra
            if (nombreSeparador.charAt(caracter) == nombre.charAt(caracter)) {
                //En este caso la primera letra coincide
                //System.out.println("La letra coincide");
                //System.out.println("Palabra actual : " + nombreSeparador);
                if (nombreSeparador == nombre) {
                    //System.out.println("La palabra coincide");
                    buscando = false;
                    //Pasa hasta el return
                } else if (nombreSeparador.charAt(1) >= nombre.charAt(1)) {
                    //System.out.println("Entramos en bucle hacia la izquierda");
                    //Mientras que la primera letra de la palabra coincida y no se haya encontrado
                    while (nombreSeparador.charAt(0) == nombre.charAt(0) && buscando) {
                        //Buscamos hacia la izquierda
                        //System.out.println("Disminuimos el indx");
                        indxComprobador--;
                        //System.out.println("Indx : " + indxComprobador);
                        nombreSeparador = lista.get(indxComprobador).getNombre();
                        //System.out.println("Palabra actual : " + nombreSeparador + ".");
                        if (Objects.equals(nombreSeparador, nombre)) {
                            //System.out.println("La palabra coincide");
                            devolver = lista.get(indxComprobador);
                            buscando = false;
                        }
                    }
                } else {
                    //System.out.println("Entramos en bucle hacia la derecha");
                    while (nombreSeparador.charAt(0) == nombre.charAt(0) && buscando) {
                        //Buscamos hacia la derecha
                        //System.out.println("Aumentamos el indx");
                        indxComprobador++;
                        //System.out.println("Indx : " + indxComprobador);
                        nombreSeparador = lista.get(indxComprobador).getNombre();
                        //System.out.println("Palabra actual : " + nombreSeparador + ".");
                        if (Objects.equals(nombreSeparador, nombre)) {
                            //System.out.println("La palabra coincide");
                            devolver = lista.get(indxComprobador);
                            buscando = false;
                        }
                    }
                }

                //En este caso la primera letra coincide
            }
            else if (nombreSeparador.charAt(caracter) > nombre.charAt(caracter))
            {
                //Crearemos la nueva lista con la primera mitad
                //System.out.println("La letra no coincide, partimos por la derecha");
                devolver = buscarWebPorNombre(lista, inicio, indxComprobador - 1, nombre, caracter);
                //System.out.println("Salimos de la recursividad derecha con la web : " + devolver.getNombre());

            }
            else
            {
                //Crearemos la nueva lista con la segunda mitad
                //System.out.println("La letra no coincide, partimos por la izquierda");
                devolver = buscarWebPorNombre(lista, indxComprobador + 1, fin, nombre, caracter);
                //System.out.println("Salimos de la recursividad izquierda con la web : " + devolver.getNombre());
            }
        }
        return devolver;
    }
    public Integer string2Id(String pNombre)
    {
        return buscarWebPorString(pNombre).getId();
    }
    public String id2String(Integer pId)
    {
        // hay que encontrar la string de esa web, y para eso no es necesario hacer una busqueda, sino que ya sabemos donde debería de estar
        Web unaWeb;
        String nom = null;
        try
        {
            unaWeb = this.lista.get(pId);
            while (unaWeb.getId()!=pId)
            {
                unaWeb = this.lista.get(pId);
                if (unaWeb.getId()> pId)
                {
                    pId++;
                }
                else if (unaWeb.getId()< pId)
                {
                    pId--;
                }
            }
            nom = unaWeb.getNombre();
        }
        catch(NullPointerException nullPointerException)
        {
            System.out.println("La web no se encuentra en la lista");
        }
        return (nom);
    }

    private Iterator<Web> getIterador()
    {
        return this.lista.iterator();
    }
    public ArrayList<String> word2Webs(String s){
        //En este metodo dada una palabra (que este en la lista de palabras, aunque no es necesario) devuelve una lista con las webs que la contengan en el nombre
        //Se usa el iterador para recorrer facilmente toda la lista de webs.
        Iterator<Web> itr = this.getIterador();
        Web webActual = null;
        ArrayList<String> listaReturn = new ArrayList<String>();
        String nombre;
        while (itr.hasNext()){
            nombre = itr.next().getNombre();
            if (nombre.contains(s)){
                listaReturn.add(nombre);
                System.out.println(nombre);
            }
        }
        return listaReturn;
    }

    public ArrayList<String> web2Words(String pWeb)
    {
        Web laWeb = buscarWebPorString(pWeb);
        ArrayList<String> listaReturn = new ArrayList<String>();
        Integer length = ListaPalabras.getMiListaPalabras().getLength();
        Integer cont = 0;
        String palabra;
        while (cont < length){
            palabra = ListaPalabras.getMiListaPalabras().obtenerPalabra(cont);
            if (laWeb.getNombre().contains(palabra)){
                listaReturn.add(palabra);
                System.out.println("Contador = " + cont + ", palabra = " + palabra);
            }
            cont ++;
        }
        return listaReturn;
    }
    public void borrarLista()
    {
        lista = new ArrayList<Web>();
    }


}
