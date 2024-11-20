package com.cristianProyectoAD.prd_rex.consultas.isbn.xml.controlador;

import com.cristianProyectoAD.prd_rex.consultas.isbn.xml.servicio.LibroIsbnServiceFicheros;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prd-rex/libros/consulta/ficheros/")
public class LibroConsultasIsbnFicherosRestController {

    private final LibroIsbnServiceFicheros libroIsbnServiceFicheros;

    public LibroConsultasIsbnFicherosRestController(LibroIsbnServiceFicheros libroIsbnServiceFicheros) {
        this.libroIsbnServiceFicheros = libroIsbnServiceFicheros;
    }

    @GetMapping("isbn/{isbn}")
    public ResponseEntity<LibroDTO> getLibroByIbsFromXMl(@PathVariable String isbn){
        /*
            Explicacion:
            1. metemos el codigo en un try-catch
            2. creamos una lista de libros del metodo que devuelve la lista despues de leer el xml
            3. aplicamos el metodo Stream para realizar un filtro de búsqueda
            4. metemos el metodo findFirst para que devuelva la primera coincidencia
            5. devolvemos el libro con el .map si hay contenido
            6. devolvemos notFound si no hay contenido
         */
        try {
            List<LibroDTO> libros = libroIsbnServiceFicheros.readXmlFile("prd-rex/libros.xml");

            Optional<LibroDTO> libroEncontrado = libros.stream()
                    .filter(libro -> isbn.equals(libro.getIsbn()))
                    .findFirst();

            return libroEncontrado
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
