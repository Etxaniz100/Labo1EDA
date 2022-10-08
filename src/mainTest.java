import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class mainTest
{

    @org.junit.jupiter.api.Test
    void main() {
    }

    @org.junit.jupiter.api.Test
    void getMiMain() {
    }

    @org.junit.jupiter.api.Test
    void cargarListaIndex()
    {
        Path path = Paths.get("");
        //cargarListaIndex();
        // CASOS DE PRUEBA
        // CASO 1
        // cargar una lista vacía
            // subcaso 1, buscar un elemento que no esta
        // CASO 2
        // cargar una lista que solo tiene un elemento
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\pruebatxt");
        assertFalse((ListaWebs.getMiListaWebs().getLista().isEmpty()));
            // subcaso 1, buscar el primer elemento
        assertTrue(ListaWebs.getMiListaWebs().getLista().get(0).getNombre().equalsIgnoreCase("abex.pl"));
            // subcaso 4, buscar un elemento que no esta
        // CASO 3
        // cargar una lista con varios elementos
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\pruebatxt");
        assertFalse((ListaWebs.getMiListaWebs().getLista().isEmpty()));
            // subcaso 1, buscar el primer elemento
        assertTrue(ListaWebs.getMiListaWebs().getLista().get(0).getNombre().equalsIgnoreCase("abex.pl"));
            // subcaso 2, buscar el ultimo elemento
            // subcaso 3, buscar un elemento del medio
            // subcaso 4, buscar un elemento que no esta
        // CASO 4
        // cargar la lista con todos los elementos
        ListaWebs.getMiListaWebs().borrarLista();
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\index-2022-2023");
        assertFalse((ListaWebs.getMiListaWebs().getLista().isEmpty()));
            // subcaso 1, buscar el primer elemento
        assertTrue(ListaWebs.getMiListaWebs().getLista().get(0).getNombre().equals("0-00.pl"));
            // subcaso 2, buscar el ultimo elemento
        assertTrue(ListaWebs.getMiListaWebs().getLista().get(ListaWebs.getMiListaWebs().getLista().size()-1).getNombre().equalsIgnoreCase("zzzz6666.com"));
            // subcaso 3, buscar un elemento del medio
        // subcaso 4, buscar un elemento que no esta

        //System.out.println(ListaWebs.getMiListaWebs().getLista().get(35452).getNombre());
        //System.out.println(ListaWebs.getMiListaWebs().getLista().get(11).getNombre());
        //System.out.println(ListaWebs.getMiListaWebs().getLista().get(11).getRelaciones().get(1));
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
    }

    @org.junit.jupiter.api.Test
    void cargarListaPalabras() {
    }

    @org.junit.jupiter.api.Test
    void cargarListaRelaciones() {
    }

    @org.junit.jupiter.api.Test
    void guardarListaIndex() {
    }
}