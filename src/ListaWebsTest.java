import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListaWebsTest {

    @Test
    void getMiListaWebs()
    {
        // es un getter y por lo tanto no necesita casos de prueba.
    }

    @Test
    void intercambiar()
    {
        // CASOS DE PRUEBA
        // CASO 1 que la lista este vacía
        ArrayList<Web> laLista = new ArrayList<Web>();
        assertTrue(laLista.isEmpty());
        ListaWebs.getMiListaWebs().intercambiar(laLista,0,1);
        // CASO 2 que la lista solo tenga 1 elemento
        laLista.add(new Web("buenas.ad", 0));
        assertFalse(laLista.isEmpty());
        ListaWebs.getMiListaWebs().intercambiar(laLista,0,1);
        // CASO 3 que la lista tenga dos elementos
        assertFalse(laLista.isEmpty());
        laLista.add(new Web("snayds.hf", 1));
        ListaWebs.getMiListaWebs().intercambiar(laLista,0,1);
        assertEquals(laLista.get(0).getNombre(),"snayds.hf");
        // CASO 4 que la lista tenga mas de dos elementos
        assertFalse(laLista.isEmpty());
        laLista.add(new Web("lopez.sa", 2));
        laLista.add(new Web("sinose.re", 3));
        ListaWebs.getMiListaWebs().intercambiar(laLista,1,3);
        assertEquals(laLista.get(1).getNombre(),"sinose.re");
        assertEquals(laLista.get(3).getNombre(),"buenas.ad");
    }

    @Test
    void quicksort()
    {
        // CASOS DE PRUEBA
        // CASO 1 que la lista este vacía
        ArrayList<Web> laLista = new ArrayList<Web>();
        assertTrue(laLista.isEmpty());
        ListaWebs.getMiListaWebs().quicksort(laLista, 0,3);
        // CASO 2 que la lista solo tenga 1 elemento
        laLista.add(new Web("buenas.ad", 0));
        assertFalse(laLista.isEmpty());
        ListaWebs.getMiListaWebs().quicksort(laLista, 0,3);
        // CASO 3 que la lista tenga dos elementos
        assertFalse(laLista.isEmpty());
        laLista.add(new Web("snayds.hf", 1));
        ListaWebs.getMiListaWebs().quicksort(laLista, 0,1);
        // como vemos no hay ningun tipo de problema a la hora de tener solo dos elementos y los ordena correctamente
        // CASO 4 que la lista tenga mas de dos elementos
        assertFalse(laLista.isEmpty());
        laLista.add(new Web("lopez.sa", 3));
        laLista.add(new Web("sinose.re", 2));
        ListaWebs.getMiListaWebs().quicksort(laLista, 0,3);
        // como vemos el elemento que hemos añadido en la posicion 3 ahora esta
        // en la posicion 2, que es la que le corresponde por id
        assertEquals(laLista.get(2).getNombre(), "sinose.re");
    }

    @Test
    void ordenarWebs()
    {
        // este método llama a el método quicksort, por tanto
        // no es necesario hacer casos de prueba para este.
    }

    @Test
    void ordenarWebs2()
    {
        // CASOS DE PRUEBA
        // usamos el comparator para comparar las webs por su nombre.
        // CASO 1 que la lista este vacía
        Path path = Paths.get("");
        main.getMiMain().cargarListaIndex( path.toAbsolutePath().toString() + "\\src\\pruebavacia");
        System.out.println("Se carga el archivo: " + "pruebavacia");
        assertTrue(ListaWebs.getMiListaWebs().getLista().isEmpty());
        ListaWebs.getMiListaWebs().ordenarWebs2();
        // CASO 2 que la lista solo tenga 1 elemento
        ListaWebs.getMiListaWebs().anadirWeb(new Web("buenas.ad", 0));
        assertFalse(ListaWebs.getMiListaWebs().getLista().isEmpty());
        ListaWebs.getMiListaWebs().ordenarWebs2();
        // CASO 3 que la lista tenga dos elementos
        assertFalse(ListaWebs.getMiListaWebs().getLista().isEmpty());
        ListaWebs.getMiListaWebs().anadirWeb(new Web("snayds.hf", 1));
        ListaWebs.getMiListaWebs().ordenarWebs2();
        // como vemos no hay ningun tipo de problema a la hora de tener solo dos elementos y los ordena correctamente
        // CASO 4 que la lista tenga mas de dos elementos
        assertFalse(ListaWebs.getMiListaWebs().getLista().isEmpty());
        ListaWebs.getMiListaWebs().anadirWeb(new Web("lopez.sa", 3));
        ListaWebs.getMiListaWebs().anadirWeb(new Web("sinose.re", 2));
        ListaWebs.getMiListaWebs().ordenarWebs2();
        // como vemos el elemento que hemos añadido en la posicion 3 ahora esta
        // en la posicion 2, que es la que le corresponde por nombre
        assertEquals(ListaWebs.getMiListaWebs().getLista().get(2).getNombre(), "sinose.re");
    }

    @Test
    void getLista()
    {
        // es un getter y por lo tanto no necesita casos de prueba.
    }

    @Test
    void insertarWeb()
    {
        // Simplemente inserta una web a la lista
        ListaWebs.getMiListaWebs().borrarLista();
        // CASOS DE PRUEBA
        // CASO 1 insertar una web a una lista vacia
        ListaWebs.getMiListaWebs().insertarWeb(new Web("buenas.ad", 0));
        assertEquals(ListaWebs.getMiListaWebs().getLista().get(0).getId(),0);
        // CASO 2 insertar una web a una lista no vacia
        ListaWebs.getMiListaWebs().insertarWeb(new Web("sadads.yt", 521));
        assertEquals(ListaWebs.getMiListaWebs().getLista().get(1).getId(),521);
    }

    @Test
    void anadirWeb()
    {
        // anade una una web a la lista, comprobando si ya estuviese
        ListaWebs.getMiListaWebs().borrarLista();
        // CASOS DE PRUEBA
        // CASO 1 anadir una web a una lista vacia
        ListaWebs.getMiListaWebs().anadirWeb(new Web("buenas.ad", 0));
        assertEquals(ListaWebs.getMiListaWebs().getLista().get(0).getId(),0);
        // CASO 2 anadir una web a una lista no vacia
        Web laWeb = new Web("sadads.yt", 521);
        ListaWebs.getMiListaWebs().anadirWeb(laWeb);
        assertEquals(ListaWebs.getMiListaWebs().getLista().get(1).getId(),521);
        // CASO 3 anadir una web que ya esté en la lista
        ListaWebs.getMiListaWebs().anadirWeb(laWeb);
        // nos sale un aviso, y sabemos que no se va a anadir a la lista

    }
    @Test
    void anadirRelacion()
    {
        // este metodo llama al metodo
        // editarLista de la clase Web
        // CASOS DE PRUEBA
        // CASO 1 anadir una relacion a una lista vacia
        ListaWebs.getMiListaWebs().borrarLista();
        ArrayList<Web> lasRelaciones = new ArrayList<Web>();
        Web laWeb = new Web("sadads.yt", 521);
        lasRelaciones.add(laWeb);
        ListaWebs.getMiListaWebs().anadirRelacion(2, lasRelaciones);
        // CASO 2 anadir una relacion a una lista con un elemento
        ListaWebs.getMiListaWebs().anadirWeb(new Web("buenas.ad", 0));
        ListaWebs.getMiListaWebs().anadirRelacion(0, lasRelaciones);
        // CASO 3 anadir una relacion a una lista con mas de un elemento
        ListaWebs.getMiListaWebs().anadirWeb(laWeb);
        ListaWebs.getMiListaWebs().anadirWeb(new Web("laksas.sa", 2));
        ListaWebs.getMiListaWebs().anadirRelacion(2, lasRelaciones);
    }

    @Test
    void borrarWeb()
    {
        // CASOS DE PRUEBA
        // CASO 1 intentar borrar una web en una lista vacia
        ListaWebs.getMiListaWebs().borrarLista();
        ListaWebs.getMiListaWebs().borrarWeb(new Web("sadads.yt", 521));
        // CASO 2 lista con un elemento
            // subcaso 1 borrar el elemento
        Web laWeb = new Web("buenas.ad", 0);
        ListaWebs.getMiListaWebs().anadirWeb(laWeb);
        ListaWebs.getMiListaWebs().borrarWeb(laWeb);
        assertTrue(ListaWebs.getMiListaWebs().getLista().isEmpty());
            // subcaso 2 borrar una web que no este en la lista
        laWeb = new Web("buenas.ad", 0);
        ListaWebs.getMiListaWebs().anadirWeb(laWeb);
        ListaWebs.getMiListaWebs().borrarWeb(new Web("sadads.yt", 521));
        assertFalse(ListaWebs.getMiListaWebs().getLista().isEmpty());
        // CASO 3 lista con mas de un elemento
        Web web1 = new Web("sadads.yt", 1);
        ListaWebs.getMiListaWebs().anadirWeb(web1);
        Web web2 = new Web("dfadfads.ds", 2);
        ListaWebs.getMiListaWebs().anadirWeb(web2);
            // subcaso 1 borrar el elemento del principio
        ListaWebs.getMiListaWebs().borrarWeb(laWeb);
        assertEquals(ListaWebs.getMiListaWebs().getLista().size(),2);
        assertEquals(ListaWebs.getMiListaWebs().getLista().get(0), web2);
        ListaWebs.getMiListaWebs().anadirWeb(laWeb);
            // subcaso 2 borrar elemento del final
        ListaWebs.getMiListaWebs().borrarWeb(web2);
        assertEquals(ListaWebs.getMiListaWebs().getLista().size(),2);
        assertEquals(ListaWebs.getMiListaWebs().getLista().get(0), laWeb);
        ListaWebs.getMiListaWebs().anadirWeb(web2);
            // subcaso 3 borrar elemento del medio
        ListaWebs.getMiListaWebs().borrarWeb(web1);
        assertEquals(ListaWebs.getMiListaWebs().getLista().size(),2);
        assertEquals(ListaWebs.getMiListaWebs().getLista().get(1), web2);
        ListaWebs.getMiListaWebs().anadirWeb(web1);
            // subcaso 4 borrar una web que no este en la lista
        ListaWebs.getMiListaWebs().borrarWeb(new Web("sjshnjds.dsf", 34));
        assertEquals(ListaWebs.getMiListaWebs().getLista().size(),3);
    }

    @Test
    void buscarWebPorString()
    {
        // este método llama al método buscarWebPorNombre, por tanto
        // no es necesario hacer casos de prueba para este.
    }

    @Test
    void buscarWebPorNombre()
    {
        // CASOS DE PRUEBA
        Web laWeb = new Web("buenas.ad", 0);
        Web web1 = new Web("sadads.yt", 1);
        Web web2 = new Web("dfadfads.ds", 2);
        // CASO 1 buscar una web en una lista vacia
        ListaWebs.getMiListaWebs().borrarLista();
        assertTrue(ListaWebs.getMiListaWebs().getLista().isEmpty());
        assertNull(ListaWebs.getMiListaWebs().buscarWebPorString(laWeb.getNombre()));
        // CASO 2 lista de un elemento
        ListaWebs.getMiListaWebs().anadirWeb(laWeb);
        assertFalse(ListaWebs.getMiListaWebs().getLista().isEmpty());
        // subcaso 1 buscar la web que esta en la lista
        assertEquals(ListaWebs.getMiListaWebs().buscarWebPorString("buenas.ad").getNombre(),"buenas.ad" );
        // subcaso 2 buscar una web que no esta en la lista
        assertNull(ListaWebs.getMiListaWebs().buscarWebPorString(web1.getNombre()));
        // CASO 3 lista de varios elementos
        assertFalse(ListaWebs.getMiListaWebs().getLista().isEmpty());
        ListaWebs.getMiListaWebs().anadirWeb(web1);
        ListaWebs.getMiListaWebs().anadirWeb(web2);
        // subcaso 1 buscar la primera web
        assertEquals(ListaWebs.getMiListaWebs().buscarWebPorString("buenas.ad").getNombre(),"buenas.ad" );
        // subcaso 2 buscar la ultima web
        assertEquals(ListaWebs.getMiListaWebs().buscarWebPorString("dfadfads.ds").getNombre(),"dfadfads.ds");
        // subcaso 3 buscar una web del medio
        assertEquals(ListaWebs.getMiListaWebs().buscarWebPorString("sadads.yt").getNombre(),"sadads.yt" );
        // subcaso 4 buscar una web que no esta en la lista
        assertNull(ListaWebs.getMiListaWebs().buscarWebPorString("estawebnoexiste.com"));
    }

    @Test
    void string2Id()
    {
        // CASOS DE PRUEBA
        Web laWeb = new Web("buenas.ad", 0);
        Web web1 = new Web("sadads.yt", 1);
        Web web2 = new Web("dfadfads.ds", 2);
        // CASO 1 buscar una web en una lista vacia
        ListaWebs.getMiListaWebs().borrarLista();
        assertTrue(ListaWebs.getMiListaWebs().getLista().isEmpty());
        assertNull(ListaWebs.getMiListaWebs().string2Id(laWeb.getNombre()));
        // CASO 2 lista de un elemento
        ListaWebs.getMiListaWebs().anadirWeb(laWeb);
        assertFalse(ListaWebs.getMiListaWebs().getLista().isEmpty());
        // subcaso 1 buscar la web que esta en la lista
        assertEquals(ListaWebs.getMiListaWebs().string2Id("buenas.ad"),0 );
        // subcaso 2 buscar una web que no esta en la lista
        assertNull(ListaWebs.getMiListaWebs().buscarWebPorString(web1.getNombre()));
        // CASO 3 lista de varios elementos
        assertFalse(ListaWebs.getMiListaWebs().getLista().isEmpty());
        ListaWebs.getMiListaWebs().anadirWeb(web1);
        ListaWebs.getMiListaWebs().anadirWeb(web2);
        // subcaso 1 buscar la primera web
        assertEquals(ListaWebs.getMiListaWebs().string2Id("buenas.ad"),0 );
        // subcaso 2 buscar la ultima web
        assertEquals(ListaWebs.getMiListaWebs().string2Id("dfadfads.ds"),2);
        // subcaso 3 buscar una web del medio
        assertEquals(ListaWebs.getMiListaWebs().string2Id("sadads.yt"),1);
        // subcaso 4 buscar una web que no esta en la lista
        assertNull(ListaWebs.getMiListaWebs().string2Id("estawebnoexiste.com"));
    }

    @Test
    void id2String()
    {
        // CASOS DE PRUEBA
        Web laWeb = new Web("buenas.ad", 0);
        Web web1 = new Web("sadads.yt", 1);
        Web web2 = new Web("dfadfads.ds", 2);
        // CASO 1 buscar una web en una lista vacia
        ListaWebs.getMiListaWebs().borrarLista();
        assertTrue(ListaWebs.getMiListaWebs().getLista().isEmpty());
        assertNull(ListaWebs.getMiListaWebs().id2String(0));
        // CASO 2 lista de un elemento
        ListaWebs.getMiListaWebs().anadirWeb(laWeb);
        assertFalse(ListaWebs.getMiListaWebs().getLista().isEmpty());
        // subcaso 1 buscar la web que esta en la lista
        assertEquals(ListaWebs.getMiListaWebs().id2String(0), "buenas.ad");
        // subcaso 2 buscar una web que no esta en la lista
        assertNull(ListaWebs.getMiListaWebs().buscarWebPorString(web1.getNombre()));
        // CASO 3 lista de varios elementos
        assertFalse(ListaWebs.getMiListaWebs().getLista().isEmpty());
        ListaWebs.getMiListaWebs().borrarLista();
        ListaWebs.getMiListaWebs().anadirWeb(laWeb);
        ListaWebs.getMiListaWebs().anadirWeb(web1);
        ListaWebs.getMiListaWebs().anadirWeb(web2);
        // subcaso 1 buscar la primera web
        assertEquals(ListaWebs.getMiListaWebs().id2String(0), "buenas.ad");
        // subcaso 2 buscar la ultima web
        assertEquals(ListaWebs.getMiListaWebs().id2String(2), "dfadfads.ds");
        // subcaso 3 buscar una web del medio
        assertEquals(ListaWebs.getMiListaWebs().id2String(1),"sadads.yt" );
        // subcaso 4 buscar una web que no esta en la lista
        assertNull(ListaWebs.getMiListaWebs().id2String(4));
    }

    @Test
    void word2Webs()
    {
        // CASOS DE PRUEBA
        Web laWeb = new Web("buenas.ad", 0);
        Web web1 = new Web("sadads.yt", 1);
        Web web2 = new Web("dfadfads.ds", 2);
        // CASO 1 lista vacia
        assertTrue(ListaWebs.getMiListaWebs().getLista().isEmpty());
        assertEquals(ListaWebs.getMiListaWebs().word2Webs("buenas"), new ArrayList<String>());
        // CASO 2 lista con 1 elemento
        ListaWebs.getMiListaWebs().anadirWeb(laWeb);
        assertFalse(ListaWebs.getMiListaWebs().getLista().isEmpty());
        assertNotNull(ListaWebs.getMiListaWebs().word2Webs("buenas"));
        assertEquals(ListaWebs.getMiListaWebs().word2Webs("adios"), new ArrayList<String>());
        // CASO 3 lista con varios elementos
        ListaWebs.getMiListaWebs().anadirWeb(web1);
        ListaWebs.getMiListaWebs().anadirWeb(web2);
        assertFalse(ListaWebs.getMiListaWebs().getLista().isEmpty());
            // subcaso 1 palabra que contenga 1 sola web
        assertNotNull(ListaWebs.getMiListaWebs().word2Webs("buenas"));
            // subcaso 2 palabra que contengan mas de una web
        assertNotNull(ListaWebs.getMiListaWebs().word2Webs("ad"));
            // subcaso 3 palabra que no esta dentro
        assertEquals(ListaWebs.getMiListaWebs().word2Webs("adios"), new ArrayList<String>());
    }

    @Test
    void web2Words()
    {
        // CASOS DE PRUEBA
        Web laWeb = new Web("buenas.ad", 0);
        Web web1 = new Web("sadads.yt", 1);
        Web web2 = new Web("dfadfads.ds", 2);
        // CASO 1 lista vacia
        assertTrue(ListaWebs.getMiListaWebs().getLista().isEmpty());
        assertEquals(ListaWebs.getMiListaWebs().web2Words("buenas.ad"), new ArrayList<String>());
        // CASO 2 lista con 1 elemento
        ListaWebs.getMiListaWebs().anadirWeb(laWeb);
        assertFalse(ListaWebs.getMiListaWebs().getLista().isEmpty());
        assertNotNull(ListaWebs.getMiListaWebs().web2Words("buenas.ad"));
        assertEquals(ListaWebs.getMiListaWebs().web2Words("adios.sd"), new ArrayList<String>());
        // CASO 3 lista con varios elementos
        ListaWebs.getMiListaWebs().anadirWeb(web1);
        ListaWebs.getMiListaWebs().anadirWeb(web2);
        assertFalse(ListaWebs.getMiListaWebs().getLista().isEmpty());
            // subcaso 1 web que contiene varias palabras
        assertNotNull(ListaWebs.getMiListaWebs().web2Words("buenas.ad"));
            // subcaso 2 web que no esta dentro
        assertEquals(ListaWebs.getMiListaWebs().web2Words("adios.sd"), new ArrayList<String>());
    }

    @Test
    void borrarLista()
    {
        Web laWeb = new Web("buenas.ad", 0);
        Web web1 = new Web("sadads.yt", 1);
        Web web2 = new Web("dfadfads.ds", 2);
        assertTrue(ListaWebs.getMiListaWebs().getLista().isEmpty());
        ListaWebs.getMiListaWebs().anadirWeb(laWeb);
        assertFalse(ListaWebs.getMiListaWebs().getLista().isEmpty());
        ListaWebs.getMiListaWebs().anadirWeb(web1);
        assertFalse(ListaWebs.getMiListaWebs().getLista().isEmpty());
        ListaWebs.getMiListaWebs().anadirWeb(web2);
        assertFalse(ListaWebs.getMiListaWebs().getLista().isEmpty());
        ListaWebs.getMiListaWebs().borrarLista();
        assertTrue(ListaWebs.getMiListaWebs().getLista().isEmpty());

    }
}