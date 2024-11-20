package com.cristianProyectoAD.prd_rex.consultas.isbn.xml.servicio;

import com.cristianProyectoAD.prd_rex.consultas.isbn.xml.excepcion.LibroNotFoundException;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroRegistroDTOWrapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class LibroIsbnServiceFicheros {

    public List<LibroDTO> readXmlFile(String path) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());

        File file = new File(path);
        if (file.exists()) {
            LibroRegistroDTOWrapper wrapper = xmlMapper.readValue(file, LibroRegistroDTOWrapper.class);
            return wrapper.getLibro();
        }
        return List.of();
    }

    public LibroDTO getLibroByIsbn(String isbn, String path) throws IOException {
        List<LibroDTO> libros = readXmlFile(path);

        return libros.stream()
                .filter(libro -> isbn.equals(libro.getIsbn()))
                .findFirst()
                .orElseThrow(() -> new LibroNotFoundException("Libro con ISBN " + isbn + " no encontrado."));
    }
}
