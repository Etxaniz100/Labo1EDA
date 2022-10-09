import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaPalabrasTest {

    @Test
    void getMiListaPalabras()
    {
        // es un getter y por lo tanto no necesita casos de prueba.
    }

    @Test
    void ordenarPalabras() {
        String palabra1 = "aaaaaa.com";
        String palabra2 = "bbbbbb.es";
        String palabra3 = "cccccc.eus";
        assertTrue(ListaPalabras.getMiListaPalabras().getListaPalabras().isEmpty());
        ListaPalabras.getMiListaPalabras().anadirPalabra(palabra1);
        ListaPalabras.getMiListaPalabras().anadirPalabra(palabra3);
        ListaPalabras.getMiListaPalabras().anadirPalabra(palabra2);

        assertEquals(ListaPalabras.getMiListaPalabras().obtenerPalabra(0),palabra1);
        assertEquals(ListaPalabras.getMiListaPalabras().obtenerPalabra(1),palabra3);
        assertEquals(ListaPalabras.getMiListaPalabras().obtenerPalabra(2),palabra2);

        ListaPalabras.getMiListaPalabras().ordenarPalabras();

        assertEquals(ListaPalabras.getMiListaPalabras().obtenerPalabra(0),palabra1);
        assertEquals(ListaPalabras.getMiListaPalabras().obtenerPalabra(1),palabra2);
        assertEquals(ListaPalabras.getMiListaPalabras().obtenerPalabra(2),palabra3);

        ListaPalabras.getMiListaPalabras().ordenarPalabras();

        ListaPalabras.getMiListaPalabras().borrarLista();

        ListaPalabras.getMiListaPalabras().ordenarPalabras();
    }

    @Test
    void anadirPalabra() {
        //CASO 1
        //Anadimos una palabra a una lista vacia
        String palabra1 = "documento.com";
        assertTrue(ListaPalabras.getMiListaPalabras().getListaPalabras().isEmpty());
        ListaPalabras.getMiListaPalabras().anadirPalabra(palabra1);
        assertEquals(ListaPalabras.getMiListaPalabras().getLength(),1);

        //CASO 2
        //Anadimos una palabra a una lista con al menos un elemento
        assertFalse(ListaPalabras.getMiListaPalabras().getListaPalabras().isEmpty());
        String palabra2 = "hoja.es";
        ListaPalabras.getMiListaPalabras().anadirPalabra(palabra2);
        assertEquals(ListaPalabras.getMiListaPalabras().getLength(),2);

        //CASO 3
        //Anadimos una palabra que ya esta en la lista (no se anade)
        String palabra3 = "hoja.es";
        assertEquals(ListaPalabras.getMiListaPalabras().obtenerPalabra(1),palabra3);
        ListaPalabras.getMiListaPalabras().anadirPalabra(palabra3);
        assertEquals(ListaPalabras.getMiListaPalabras().getLength(),2);

        //CASO 4
        //Anadimos una palabra null (no se anade)
        String palabra4 = null;
        ListaPalabras.getMiListaPalabras().anadirPalabra(palabra4);
        assertEquals(ListaPalabras.getMiListaPalabras().getLength(),2);

    }

    @Test
    void obtenerPalabra() {
        //CASO 1
        //Damos un id para una lista vacia
        assertTrue(ListaPalabras.getMiListaPalabras().getListaPalabras().isEmpty());
        ListaPalabras.getMiListaPalabras().obtenerPalabra(0);

        //CASO 2
        //Damos un id valido
        String palabra1 = "documento.com";
        String palabra2 = "hoja.es";
        assertTrue(ListaPalabras.getMiListaPalabras().getListaPalabras().isEmpty());
        ListaPalabras.getMiListaPalabras().anadirPalabra(palabra1);
        ListaPalabras.getMiListaPalabras().anadirPalabra(palabra2);
        assertEquals(ListaPalabras.getMiListaPalabras().obtenerPalabra(0),palabra1);
        assertEquals(ListaPalabras.getMiListaPalabras().obtenerPalabra(1),palabra2);
        assertNotEquals(ListaPalabras.getMiListaPalabras().obtenerPalabra(1),palabra1);

        //CASO 3
        //Damos un id fuera de rango en una lista con elementos
        ListaPalabras.getMiListaPalabras().obtenerPalabra(35);


        //CASO 4
        //Anadimos un id null
        ListaPalabras.getMiListaPalabras().obtenerPalabra(null);
    }

    @Test
    void getLength() {
        String palabra1 = "documento.com";
        String palabra2 = "oihhi.com";
        assertEquals(ListaPalabras.getMiListaPalabras().getLength(),0);
        ListaPalabras.getMiListaPalabras().anadirPalabra(palabra1);
        assertEquals(ListaPalabras.getMiListaPalabras().getLength(),1);
        ListaPalabras.getMiListaPalabras().anadirPalabra(palabra2);
        assertEquals(ListaPalabras.getMiListaPalabras().getLength(),2);
    }

    @Test
    void getListaPalabras() {
        //Es un getter, no es necesaria la comprobacion
    }

    @Test
    void borrarLista() {
        String palabra1 = "documento.com";
        assertEquals(ListaPalabras.getMiListaPalabras().getLength(),0);
        ListaPalabras.getMiListaPalabras().anadirPalabra(palabra1);
        assertEquals(ListaPalabras.getMiListaPalabras().getLength(),1);
        ListaPalabras.getMiListaPalabras().borrarLista();
        assertEquals(ListaPalabras.getMiListaPalabras().getLength(),0);

        //Borrar una lista vacia :
        ListaPalabras.getMiListaPalabras().borrarLista();
        assertEquals(ListaPalabras.getMiListaPalabras().getLength(),0);
    }
}