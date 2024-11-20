package com.cristianProyectoAD.prd_rex.consultas.isbn.xml.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroRegistroDTOWrapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LibroIsbnServiceFicheros {

    /**
     * metodo que devuelve una lista de libros de un sistema de ficheros xml
     * @param path el path del archivo
     * @return la lista de libros o null si no hay libros registrados
     * @throws IOException la excepcion por si la ruta no coincide
     */
    public List<LibroDTO> readXmlFile(String path) throws IOException {
        /*
            Explicacion:
            1. creamos el XmlMapper
            2. llamamos a un metodo para recoger bien los datos de tipo LocalDate
            3. comprobamos si existe el archivo
            4. si existe, leemos los datos y los campos se rellenan con los de la clase donde tenemos la informacion
            5. devolvemos la lista de libros o null si no existe el archivo
         */
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());

        File file = new File(path);
        if(file.exists()){
            LibroRegistroDTOWrapper wrapper = xmlMapper.readValue(file, LibroRegistroDTOWrapper.class);
            return wrapper.getLibro();
        }
        return new ArrayList<>();
    }
}
