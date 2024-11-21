package com.cristianProyectoAD.prd_rex.consultas.isbn.xml.servicio;

import com.cristianProyectoAD.prd_rex.consultas.isbn.xml.excepcion.LibroNotFoundException;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroRegistroDTOWrapper;
import com.cristianProyectoAD.prd_rex.registrolibros.xml.LibrosXMLSave;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio encargado de gestionar la lectura de libros desde un archivo XML y la búsqueda de libros por ISBN.
 * Utiliza `XmlMapper` para deserializar el archivo XML en objetos Java.
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroIsbnServiceFicheros {

    /**
     * Lee un archivo XML y convierte su contenido en una lista de objetos `LibroDTO`.
     *
     * @param path Ruta del archivo XML.
     * @return Lista de objetos `LibroDTO` deserializados desde el archivo XML.
     * @throws IOException Si ocurre un error durante la lectura del archivo.
     */
    public List<LibroDTO> readXmlFile(String path) throws IOException, XMLStreamException {
        return new LibrosXMLSave().readXmlFile(path);
    }

    /**
     * Obtiene un libro a partir de su ISBN buscando en un archivo XML.
     *
     * @param isbn El ISBN del libro que se desea consultar.
     * @param path Ruta del archivo XML.
     * @return El objeto `LibroDTO` correspondiente al ISBN.
     * @throws IOException Si ocurre un error durante la lectura del archivo.
     * @throws LibroNotFoundException Si no se encuentra el libro con el ISBN especificado.
     */
    public LibroDTO getLibroByIsbn(String isbn, String path) throws IOException, XMLStreamException {
        List<LibroDTO> libros = readXmlFile(path);

        return libros.stream()
                .filter(libro -> isbn.equals(libro.getIsbn()))
                .findFirst()
                .orElseThrow(() -> new LibroNotFoundException("Libro con ISBN " + isbn + " no encontrado."));
    }
}
