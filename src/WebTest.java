import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WebTest {

    @Test
    void getId()
    {
        // es un getter y por lo tanto no necesita casos de prueba.
    }
    @Test
    void getNombre()
    {
        // es un getter y por lo tanto no necesita casos de prueba.
    }
    @Test
    void enlacesSalientes()
    {
        // es un getter (this.listarelaciones) y por lo tanto no necesita casos de prueba.
    }

    @Test
    void setId()
    {
        // Simplemente hace que el id de la web sea el dado
        // aunque la web no este en la lista
        Web laWeb = new Web("buenas.com", 4);
        laWeb.setId(8);
        assertEquals(laWeb.getId(),8);
    }
    @Test
    void editarLista()
    {
        // Simplemente hace que la listarelaciones de la web sea la dada
        // aunque la web no este en la lista
        Web laWeb = new Web("buenas.com", 4);
        Web web1 = new Web("asdrt.as", 2);
        Web web2 = new Web("loplo.lks", 3);
        assertNull(laWeb.enlacesSalientes());
        ArrayList<Web> listaRelaciones = new ArrayList<Web>();
        listaRelaciones.add(web1);
        listaRelaciones.add(web2);
        laWeb.editarLista(listaRelaciones);
        assertNotNull(laWeb.enlacesSalientes());


    }
    @Test
    void getIterator()
    {
        // es un getter y por lo tanto no necesita casos de prueba.
    }
}