
import javax.print.DocFlavor;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class main {

    // ------ Atributos ------
    //private ArrayList<Escenario> lista;
    private static main miMain;

    // ----- Constructora -----
    private main()
    {
    }

    // ------ Metodos ------
    public static void main(String args[])
    {
        /*
        Stopwatch reloj = new Stopwatch();       // Inicialización
        System.out.println("Tiempo inicial: " + reloj.elapsedTime());
        System.out.println("Tiempo actual: " + reloj.elapsedTime());

        */
        Stopwatch reloj = new Stopwatch();       // Inicialización
        System.out.println("Tiempo inicial: " + reloj.elapsedTime());
        Path path = Paths.get("");
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\index-2022-2023");
        System.out.println("Tiempo: " + reloj.elapsedTime());
        main.getMiMain().cargarListaRelaciones( path.toAbsolutePath().toString() + "\\src\\pld-arcs-1-N-2022-2023");
        System.out.println("Tiempo: " + reloj.elapsedTime());
        main.getMiMain().cargarListaPalabras( path.toAbsolutePath().toString() + "\\src\\words.txt");
        System.out.println("Tiempo: " + reloj.elapsedTime());


        //ListaWebs.getMiListaWebs().insertarWeb(new Web("UwU.com", 2));
        //main.getMiMain().guardarListaIndex( path.toAbsolutePath().toString() + "\\src\\index-2022-2023");
        //ListaWebs.getMiListaWebs().word2Webs("argentina");
        // Prueba quicksort
        // Para probar el quicksort necesitamos añadir algunos elementos a la lista y borrar otros, para conseguir ver si el quicksort es efectivo.
        // realmente no es necesario implementar el quicksort ya que tenemos el método .sort que usa un comparator, que probablemente sea mas eficiente.
        ListaWebs.getMiListaWebs().insertarWeb(new Web("buenosdias.com", 4822));
        System.out.println(ListaWebs.getMiListaWebs().id2String(2039804));
        ListaWebs.getMiListaWebs().ordenarWebs();

        System.out.println(ListaWebs.getMiListaWebs().id2String(4822));
        System.out.println(ListaWebs.getMiListaWebs().id2String(4823));
        System.out.println("Tiempo: " + reloj.elapsedTime());
        // Prueba buscarWebPorString
        //System.out.println(ListaWebs.getMiListaWebs().buscarWebPorString("0-00.pl").getId()); // La primera web
        //System.out.println(ListaWebs.getMiListaWebs().buscarWebPorString("willcom.gr.jp").getId()); // Una web aleatoria
        //System.out.println(ListaWebs.getMiListaWebs().buscarWebPorString("zzzz6666.com").getId());  // Ultima web

        // Prueba string2Id
        //System.out.println(ListaWebs.getMiListaWebs().string2Id("0-00.pl")); // La primera web
        //System.out.println(ListaWebs.getMiListaWebs().string2Id("willcom.gr.jp")); // Una web aleatoria
        //System.out.println(ListaWebs.getMiListaWebs().string2Id("zzzz6666.com"));  // Ultima web

        // Prueba borrarWeb
        //Web unaWeb = ListaWebs.getMiListaWebs().buscarWebPorString("willcom.gr.jp");
        //ListaWebs.getMiListaWebs().borrarWeb(unaWeb);
        //Web laWeb = ListaWebs.getMiListaWebs().buscarWebPorString("willcom.gr.jp"); // como vemos, va a ser null ya que hemos borrado la web
        // aqui hariamos un assetnull en las J-Units

        // Pruebas de IMPORTACION DE FICHEROS
        //System.out.println(ListaWebs.getMiListaWebs().getLista().get(35452).getNombre());
        //System.out.println(ListaWebs.getMiListaWebs().getLista().get(11).getNombre());
        //System.out.println(ListaWebs.getMiListaWebs().getLista().get(11).getRelaciones().get(1));

        // Pruebas ListaPalabras
        //System.out.println(ListaPalabras.getMiListaPalabras().obtenerPalabra(78));
        //ListaPalabras.getMiListaPalabras().anadirPalabra("'saaassjdjd");  // hemos puesto este ejemplo ya que sabemos que tiene que ir en la posición 13
        //System.out.println(ListaPalabras.getMiListaPalabras().obtenerPalabra(354985));
        //ListaPalabras.getMiListaPalabras().ordenarPalabras();   // este sort es algo mas ineficiente ya que hemos usado el Collections.sort, pero no sacrifica demasiado
        //System.out.println(ListaPalabras.getMiListaPalabras().obtenerPalabra(13));
        //System.out.println(ListaPalabras.getMiListaPalabras().obtenerPalabra(354985));
        // ahora obtiene la palabra que estaba en la posicion anterior ya que hemos ordenado la lista

    //Metodo main
    }

    public static main getMiMain()
    {
    // el metodo getMiMAE, ya que estamos delante de una mae.
        if (miMain==null)
        {
            miMain = new main();
        }
        return (miMain);
    }

    public void cargarListaIndex(String nomF)
    {
        //Coste operativo : O(n) --> Lineal
        System.out.println("Cargando lista index");
        try{
            Scanner entrada = new Scanner(new FileReader(nomF));
            String linea;
            while (entrada.hasNext()) {
                linea = entrada.nextLine();
                String datos[] = linea.split(":+"); // el split para dividir los datos
                ListaWebs.getMiListaWebs().insertarWeb(new Web(datos[1],Integer.valueOf(datos[0]))); //Creamos la web con los dos datos leidos
            }
            entrada.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println("Lista Index cargada");

    }

    public void cargarListaPalabras(String nomF)
    {
        //Coste operativo : O(n) --> Lineal

        System.out.println("Cargando lista palabras");
        try{
            //Abrimos y preparamos el scanner
            Scanner entrada = new Scanner(new FileReader(nomF));
            String linea;

            while (entrada.hasNext()) {
                //Leemos la palabra
                linea = entrada.nextLine();

                //Y la metemos en la lista de la MAE
                ListaPalabras.getMiListaPalabras().anadirInicialPalabra(linea);

            }
            entrada.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println("Lista palabras cargada");
    }

    public void cargarListaRelaciones(String nomF)
    {
        //Coste operativo de esto : n * media de relaciones entre webs, pero no es mucho entonces O(n) --> coste lineal

        System.out.println("Cargando lista relaciones");
        try
        {
            //Abrimos y preparamos el scanner
            Scanner entrada = new Scanner(new FileReader(nomF));
            String linea;
            while (entrada.hasNext()) {
                //Leemos la linea correspondiente del texto
                linea = entrada.nextLine();

                //Separamos en dos la linea, en una parte el index, y en la otra todas las relaciones
                String datos[] = linea.split("\\s+?-+>+\\s+?");

                //Creamos la lista que usaremos para el metodo anadirRelacion que tiene que ser de integers
                ArrayList<Web> listaRelaciones = new ArrayList<Web>();

                //Separamos todas las relaciones en forma de Strings
                if (datos.length > 1) {
                    String[] relacionesTexto = datos[1].split("\\s+?#+\\s+?");

                    //En este bucle convertimos uno a uno las relaciones a Integer, buscamos en la lista webs y las añadimos a la lista
                    for(int i = 0; i < relacionesTexto.length; i++)
                    {
                        listaRelaciones.add(ListaWebs.getMiListaWebs().getLista().get(Integer.valueOf(relacionesTexto[i])));  // aqui convertimos la string a integer y luego a web
                    }

                }
                //Añadimos las relaciones a la web correspondiente
                ListaWebs.getMiListaWebs().anadirRelacion(Integer.valueOf(datos[0]), listaRelaciones);
            }
            entrada.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println("Lista relaciones cargada");
    }

    public void guardarListaIndex(String nomF)
    {
        BufferedWriter bw;
        try {
            ListaWebs.getMiListaWebs().ajustarIds();

            bw = new BufferedWriter(new FileWriter(nomF));
            ArrayList<Web> listaWeb = ListaWebs.getMiListaWebs().getLista();
            Integer cont = 0;
            Web webActual;
            while (cont < listaWeb.toArray().length){
                webActual = listaWeb.get(cont);
                bw.write(webActual.getId().toString() + ":" + webActual.getNombre());
                cont ++;
                bw.newLine();
            }
            bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void guardarRelaciones(String nomF)
    {

        // Abrimos el bufferedwriter que es el objeto que nos deja escribir en un fichero de texto.
        BufferedWriter bw;
        try
        {
            ListaWebs.getMiListaWebs().ajustarIds();
            bw = new BufferedWriter(new FileWriter(nomF));
            //ListaWebs.getMiListaWebs().ordenarWebs();
            ArrayList<Web> listaWeb = ListaWebs.getMiListaWebs().getLista();
            ArrayList<Web> listaRelaciones;
            Integer cont = 0;
            Web webActual;
            while (cont < listaWeb.size())
            {
                webActual = listaWeb.get(cont);
                listaRelaciones = webActual.enlacesSalientes();
                bw.write(webActual.getId().toString() + " ---> ");
                if (listaRelaciones.iterator().hasNext()){
                    bw.write(listaRelaciones.iterator().next().getId().toString());
                }
                Iterator<Web> itr =  listaRelaciones.iterator();
                while (itr.hasNext())
                {
                    bw.write(" ### " + itr.next().getId().toString());
                }

                cont ++;
                bw.newLine();
            }
            bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch(NullPointerException npe)
        {
            System.out.println("La lista es vacía");
        }
    }
}
