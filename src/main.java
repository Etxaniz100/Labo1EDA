
import javax.print.DocFlavor;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
    public static void main(String args[]) {
        Path path = Paths.get("");
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\index-2022-2023");
    //Metodo main
    }

    public static main getMiMain()
    {

        if (miMain==null)
        {
            miMain = new main();
        }
        return (miMain);
    }

    public void cargarListaIndex(String nomF){
        //Coste operativo de esto : O(n)

        try{
            Scanner entrada = new Scanner(new FileReader(nomF));
            String linea;
            while (entrada.hasNext()) {
                linea = entrada.nextLine();
                String datos[] = linea.split("\\s+?:+\\s+?");

                ListaWebs.getMiListaWebs().anadirWeb(new Web(datos[1],Integer.valueOf(datos[0]))); //Creamos la web con los dos datos leidos
            }
            entrada.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarListaPlabras(String nomF){
        //Coste operativo de esto : O(n)


        try{
            //Abrimos y preparamos el scanner
            Scanner entrada = new Scanner(new FileReader(nomF));
            String linea;

            while (entrada.hasNext()) {
                //Leemos la palabra
                linea = entrada.nextLine();

                //Y la metemos en la lista de la MAE
                ListaPalabras.getMiListaPalabras().anadirPalabra(linea);

            }
            entrada.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarListaRelaciones(String nomF){
        //Coste operativo de esto : n * media de relaciones entre webs, pero no es mucho entonces O(n)


        try{
            //Abrimos y preparamos el scanner
            Scanner entrada = new Scanner(new FileReader(nomF));
            String linea;
            while (entrada.hasNext()) {
                //Leemos la linea correspondiente del texto
                linea = entrada.nextLine();

                //Separamos en dos la linea, en una parte el index, y en la otra todas las relaciones
                String datos[] = linea.split("\\s+?-+>+\\s+?"); //No estoy seguro de esto (la parte de dentro del split) ?????????????????????

                //Separamos todas las relaciones en forma de Strings
                String[] relacionesTexto = datos[1].split("\\s+?#+\\s+?");

                //Creamos la lista que usaremos para el metodo anadirRelacion que tiene que ser de integers
                ArrayList<Integer> listaRelaciones = null;

                //En este bucle convertimos uno a uno las relaciones a Integer y las añadimos a la lista
                for(int i = 0; i < relacionesTexto.length; i++){
                    listaRelaciones.add(Integer.valueOf(relacionesTexto[i]));
                }

                //Añadimos las relaciones a la web correspondiente
                ListaWebs.getMiListaWebs().anadirRelacion(Integer.valueOf(datos[0]), listaRelaciones);

            }
            entrada.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

}
