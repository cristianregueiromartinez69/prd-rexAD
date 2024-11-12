package com.cristianProyectoAD.prd_rex.registrolibros.xml;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroRegistroDTOWrapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para manejar la lógica de los elementos guardados en listas para escribir en xml
 * @author cristian
 * @version 1.0
 */
@Component
public class LibrosXMLSave {


    /**
     * Metodo para guardar datos en fichero xml
     *
     * @param librosRegistroDTO el libro ha guardar
     * @param filePath          la ruta donde estará el archivo
     * @throws IOException lanzamos una excepcion que será recogida en el controlador
     */
    public void guardarLibroEnXML(LibroDTO librosRegistroDTO, String filePath) throws IOException {

        /**
         * Flujo de ejecución de guardado de libro de xml
         * 1. creamos el objeto para mapear el xml XmlMapper
         * 2. registramos el JavaTimeModule porque si no salta error al leer el localDate
         * 3. establecemos identación con xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
         * 4. creamos una lista de libros y preguntamos si los libros existen
         * 5. si existen se leen y se añaden al arrayList
         */
        XmlMapper xmlMapper = new XmlMapper();

        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<LibroDTO> librosList = new ArrayList<>();
        File file = new File(filePath);
        if (file.exists()) {
            try {
                LibroRegistroDTOWrapper wrapper = xmlMapper.readValue(file, LibroRegistroDTOWrapper.class);
                librosList.addAll(wrapper.getLibro());
            } catch (IOException e) {
                System.out.println("Error al leer el archivo existente: " + e.getMessage());
            }
        }

        /**
         * Añadimos el libro a la lista de os libros
         * creamos el objeto de la clase que tiene las intrucciones para la creación del xml
         * Llamamos al metodo writeValue para escribir en el fichero y le pasamos la clase
         */
        librosList.add(librosRegistroDTO);

        LibroRegistroDTOWrapper wrapper = new LibroRegistroDTOWrapper(librosList);
        xmlMapper.writeValue(file, wrapper);
    }
}
