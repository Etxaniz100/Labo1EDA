
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main {
    //Ayuda por favor

    // ------ Atributos ------
    //private ArrayList<Escenario> lista;
    private static main miMain;

    // ----- Constructora -----
    private main()
    {

    }

    // ------ Metodos ------
    public static void main(String args[]) {
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
        try{
            Scanner entrada = new Scanner(new FileReader(nomF));
            String linea;
            while (entrada.hasNext()) {
                linea = entrada.nextLine();




            }
            entrada.close();
        }
        catch(IOException e) {e.printStackTrace();}
    }

}
