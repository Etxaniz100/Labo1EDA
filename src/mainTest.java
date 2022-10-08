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
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\pruebavacia");
        System.out.println("Se carga el archivo: " + "pruebavacia");
        // cargar una lista vacía
        assertTrue((ListaWebs.getMiListaWebs().getLista().isEmpty()));
            // subcaso 1, buscar un elemento que no esta
        assertNull(ListaWebs.getMiListaWebs().buscarWebPorString("buenosdddias.com"));
        // CASO 2
        // cargar una lista que solo tiene un elemento
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\prueba1elemento");
        System.out.println("Se carga el archivo: " + "prueba1elemento");
        assertFalse((ListaWebs.getMiListaWebs().getLista().isEmpty()));
            // subcaso 1, buscar el primer elemento
        assertTrue(ListaWebs.getMiListaWebs().getLista().get(0).getNombre().equals("hola.as"));
            // subcaso 2, buscar un elemento que no esta
        assertNull(ListaWebs.getMiListaWebs().buscarWebPorString("buenosdddias.com"));
        // CASO 3
        // cargar una lista con varios elementos
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\pruebatxt");
        System.out.println("Se carga el archivo: " + "pruebatxt");
        assertFalse((ListaWebs.getMiListaWebs().getLista().isEmpty()));
            // subcaso 1, buscar el primer elemento
        assertTrue(ListaWebs.getMiListaWebs().getLista().get(0).getNombre().equals("abex.pl"));
            // subcaso 2, buscar el ultimo elemento
        assertTrue(ListaWebs.getMiListaWebs().getLista().get(2).getNombre().equals("merto.al"));
            // subcaso 3, buscar un elemento del medio
        assertTrue(ListaWebs.getMiListaWebs().getLista().get(1).getNombre().equals("gertu.eus"));
            // subcaso 4, buscar un elemento que no esta
        assertNull(ListaWebs.getMiListaWebs().buscarWebPorString("buenosdddias.com"));
        // CASO 4
        // cargar la lista con todos los elementos
        ListaWebs.getMiListaWebs().borrarLista();
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\index-2022-2023");
        System.out.println("Se carga el archivo: " + "index-2022-2023");
        assertFalse((ListaWebs.getMiListaWebs().getLista().isEmpty()));
            // subcaso 1, buscar el primer elemento
        assertTrue(ListaWebs.getMiListaWebs().getLista().get(0).getNombre().equals("0-00.pl"));
            // subcaso 2, buscar el ultimo elemento
        assertTrue(ListaWebs.getMiListaWebs().getLista().get(ListaWebs.getMiListaWebs().getLista().size()-1).getNombre().equals("zzzz6666.com"));
            // subcaso 3, buscar un elemento del medio
        assertTrue(ListaWebs.getMiListaWebs().getLista().get(544425).getNombre().equals("dsw.edu.pl"));
        // subcaso 4, buscar un elemento que no esta
        assertNull(ListaWebs.getMiListaWebs().buscarWebPorString("buenosdddias.com"));
    }

    @org.junit.jupiter.api.Test
    void cargarListaPalabras()
    {
        Path path = Paths.get("");
        // CASOS DE PRUEBA
        // CASO 1
        // cargar una lista vacía
        main.getMiMain().cargarListaPalabras(path.toAbsolutePath().toString() + "\\src\\pruebavacia");
        assertTrue((ListaPalabras.getMiListaPalabras().getListaPalabras().isEmpty()));
            // subcaso 1, buscar un elemento que no esta
        assertNull(ListaPalabras.getMiListaPalabras().obtenerPalabra(0));
        ListaPalabras.getMiListaPalabras().borrarLista();
        // CASO 2
        // cargar una lista que solo tiene un elemento
        main.getMiMain().cargarListaPalabras( path.toAbsolutePath().toString() + "\\src\\prueba1elemento");
        assertFalse((ListaPalabras.getMiListaPalabras().getListaPalabras().isEmpty()));
            // subcaso 1, buscar un elemento que esta
        assertEquals(ListaPalabras.getMiListaPalabras().obtenerPalabra(0), "0:hola.as");
            // subcaso 2, buscar un elemento que no esta
        assertNull(ListaPalabras.getMiListaPalabras().obtenerPalabra(78));
        ListaPalabras.getMiListaPalabras().borrarLista();
        // CASO 3
        // cargar una lista con varios elementos
        main.getMiMain().cargarListaPalabras( path.toAbsolutePath().toString() + "\\src\\pruebatxt");
        assertFalse((ListaPalabras.getMiListaPalabras().getListaPalabras().isEmpty()));
            // subcaso 1, buscar un elemento que esta al principio
        assertEquals(ListaPalabras.getMiListaPalabras().obtenerPalabra(0), "0:abex.pl");
            // subcaso 2, buscar un elemento que esta al final
        assertEquals(ListaPalabras.getMiListaPalabras().obtenerPalabra(2), "2:merto.al");
            // subcaso 2, buscar un elemento que no esta
        assertNull(ListaPalabras.getMiListaPalabras().obtenerPalabra(852));
    }

    @org.junit.jupiter.api.Test
    void cargarListaRelaciones()
    {
    }

    @org.junit.jupiter.api.Test
    void guardarListaIndex()
    {
    }
}