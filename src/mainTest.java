import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class mainTest
{

    @org.junit.jupiter.api.Test
    void main()
    {
        // la constructora de la clase main no lleva nada de contenido por tanto no necesitamos probar nada
    }

    @org.junit.jupiter.api.Test
    void getMiMain()
    {
        // es un getter y por lo tanto no necesita casos de prueba.
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
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\prueba.txt");
        System.out.println("Se carga el archivo: " + "prueba.txt");
        assertFalse((ListaWebs.getMiListaWebs().getLista().isEmpty()));
            // subcaso 1, buscar el primer elemento
        assertTrue(ListaWebs.getMiListaWebs().getLista().get(0).getNombre().equals("abex.pl"));
            // subcaso 2, buscar el ultimo elemento
        assertTrue(ListaWebs.getMiListaWebs().getLista().get(2).getNombre().equals("asda.as"));
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
        main.getMiMain().cargarListaPalabras( path.toAbsolutePath().toString() + "\\src\\prueba.txt");
        assertFalse((ListaPalabras.getMiListaPalabras().getListaPalabras().isEmpty()));
            // subcaso 1, buscar un elemento que esta al principio
        assertEquals(ListaPalabras.getMiListaPalabras().obtenerPalabra(0), "0:abex.pl");
            // subcaso 2, buscar un elemento que esta al final
        assertEquals(ListaPalabras.getMiListaPalabras().obtenerPalabra(4), "4:merto.al");
            // subcaso 2, buscar un elemento que no esta
        assertNull(ListaPalabras.getMiListaPalabras().obtenerPalabra(852));
    }

    @org.junit.jupiter.api.Test
    void cargarListaRelaciones()
    {
        Path path = Paths.get("");
        // CASOS DE PRUEBA
        // CASO 1
        // cargar una lista vacía
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\pruebavacia");
        main.getMiMain().cargarListaRelaciones( path.toAbsolutePath().toString() + "\\src\\pruebavacia");
        System.out.println("Se carga el archivo: " + "pruebavacia");
        assertTrue((ListaWebs.getMiListaWebs().getLista().isEmpty()));
            // subcaso 1 no hay relaciones que buscar
        // CASO 2
        // cargar una lista con 1 elemento no tendría sentido, ya que un elemento no tiene ninguna relación con ningun
        // otro elemento asi que no es necesario probar este caso
        // CASO 3
        // cargar una lista con varios elementos
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\prueba.txt");
        main.getMiMain().cargarListaRelaciones( path.toAbsolutePath().toString() + "\\src\\pruebarelaciones.txt");
        System.out.println("Se carga el archivo: " + "pruebarelaciones.txt");
        assertFalse((ListaWebs.getMiListaWebs().getLista().isEmpty()));
            // subcaso 1 encontrar las relaciones del primer elemento
        assertEquals(ListaWebs.getMiListaWebs().getLista().get(0).enlacesSalientes().get(0).getNombre(), ListaWebs.getMiListaWebs().getLista().get(1).getNombre());
            // subcaso 2 encontrar las relaciones del ultimo elemento
        assertEquals(ListaWebs.getMiListaWebs().getLista().get(4).enlacesSalientes().get(0).getNombre(), ListaWebs.getMiListaWebs().getLista().get(3).getNombre());
            // subcaso 3 encontrar las relaciones de un elemento del medio
        assertEquals(ListaWebs.getMiListaWebs().getLista().get(3).enlacesSalientes().get(0).getNombre(), ListaWebs.getMiListaWebs().getLista().get(0).getNombre());
            // subcaso 4 encontrar las relaciones de un elemento que no esta
        assertFalse(ListaWebs.getMiListaWebs().getLista().get(0).enlacesSalientes().contains(ListaWebs.getMiListaWebs().getLista().get(2)));
    }

    @org.junit.jupiter.api.Test
    void guardarListaIndex()
    {
        Path path = Paths.get("");
        // CASOS DE PRUEBA
        // CASO 1
        // escribir una lista vacía
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\pruebavacia");
        main.getMiMain().guardarListaIndex( path.toAbsolutePath().toString() + "\\src\\pruebavacia");
        ListaWebs.getMiListaWebs().borrarLista();
        // como vemos, no ha guardado nada en la lista y no nos da ningún error
        // CASO 2
        // escribir una lista con un elemento
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\prueba1elemento");
        main.getMiMain().guardarListaIndex( path.toAbsolutePath().toString() + "\\src\\pruebavacia");
        // como vemos ahora se ha escrito en el archivo vacío el elemento
        // CASO 3
        // escribir una lista con varios elementos
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\prueba.txt");
        // aqui nos guardará los elementos a partir del elemento que hemos guardado previamente en el caso 2
        main.getMiMain().guardarListaIndex( path.toAbsolutePath().toString() + "\\src\\pruebavacia");
        ListaWebs.getMiListaWebs().borrarLista();
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\pruebavacia");
        ListaWebs.getMiListaWebs().ordenarWebs2();
        main.getMiMain().guardarListaIndex( path.toAbsolutePath().toString() + "\\src\\pruebavacia");
    }
    @org.junit.jupiter.api.Test
    void guardarRelaciones()
    {
        Path path = Paths.get("");
        // CASOS DE PRUEBA
        // CASO 1
        // guardar las relaciones de una lista vacía
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\pruebavacia");
        main.getMiMain().guardarRelaciones(path.toAbsolutePath().toString() + "\\src\\pruebavacia");
        assertTrue(ListaWebs.getMiListaWebs().getLista().isEmpty());
        // CASO 2
        // guardar una lista con 1 elemento no tendría sentido, ya que un elemento no tiene ninguna
        // relación con ningun otro elemento asi que no es necesario probar este caso
        // CASO 3
        // guardar una lista con varios elementos
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\prueba.txt");
        main.getMiMain().cargarListaRelaciones(path.toAbsolutePath().toString() + "\\src\\pruebarelaciones.txt");
        main.getMiMain().guardarRelaciones(path.toAbsolutePath().toString() + "\\src\\prueba.txt");
        assertFalse(ListaWebs.getMiListaWebs().getLista().isEmpty());

        // esto lo hacemos para que se guarde otra vez la lista original y no perder los datos
        main.getMiMain().guardarListaIndex(path.toAbsolutePath().toString() + "\\src\\prueba.txt");
    }
}