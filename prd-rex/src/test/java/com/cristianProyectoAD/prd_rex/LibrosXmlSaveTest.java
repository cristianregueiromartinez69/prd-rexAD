package com.cristianProyectoAD.prd_rex;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.registrolibros.xml.LibrosXMLSave;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LibrosXmlSaveTest {

    @Test
    void testCheckIfIsbnIsRepeat() {

        LibroDTO libroNuevo = new LibroDTO();
        libroNuevo.setIsbn("12345");

        LibroDTO libroExistente1 = new LibroDTO();
        libroExistente1.setIsbn("12345");

        LibroDTO libroExistente2 = new LibroDTO();
        libroExistente2.setIsbn("67890");

        List<LibroDTO> listaLibros = List.of(libroExistente1, libroExistente2);


        Assertions.assertFalse(new LibrosXMLSave().checkIfISbnISRepeat(libroNuevo, listaLibros));


        libroNuevo.setIsbn("99999");
        Assertions.assertTrue(new LibrosXMLSave().checkIfISbnISRepeat(libroNuevo, listaLibros));

        List<LibroDTO> listaVacia = List.of();
        Assertions.assertTrue(new LibrosXMLSave().checkIfISbnISRepeat(libroNuevo, listaVacia));
    }
}
