
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        main.getMiMain().cargarLista( path.toAbsolutePath().toString() + "\\src\\index-2022-2023");
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

    public void cargarLista(String nomF){

        int cont = 0; //Borrar, es para que no compruebe los 5000000

        try{
            Scanner entrada = new Scanner(new FileReader(nomF));
            String linea;
            while (entrada.hasNext() && cont < 5) { //Borrar, es para que no compruebe los 5000000
                linea = entrada.nextLine();
                String datos[] = linea.split(":+");
                System.out.println(datos[0]);
                System.out.println(datos[1]);
                cont += 1; //Borrar, es para que no compruebe los 5000000

                ListaWebs.getMiListaWebs().anadirWeb(new Web(datos[1],Integer.valueOf(datos[0])));


            }
            entrada.close();
        }
        catch(IOException e) {e.printStackTrace();}


    }

}
