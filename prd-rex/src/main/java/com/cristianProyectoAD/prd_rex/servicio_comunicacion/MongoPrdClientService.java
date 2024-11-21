package com.cristianProyectoAD.prd_rex.servicio_comunicacion;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Cliente Feign para interactuar con el servicio de consulta y almacenamiento de libros en una base de datos no relacional (MongoDB).
 * Utiliza la URL base <a href="http://localhost:8083">...</a> para la comunicación con el servicio.
 * @author cristian
 * @version 1.0
 */
@FeignClient(name = "nonrelational-prd-query", url="http://localhost:8083")
public interface MongoPrdClientService {


    /**
     * Guarda un libro en la base de datos MongoDB.
     *
     * @param libroDTO Objeto que contiene la información del libro a guardar.
     * @return ResponseEntity con el resultado de la operación (mensaje de éxito o error).
     */
    @PostMapping("/nonrelational-prd-query/libros/guardar")
    ResponseEntity<String> saveBooksMongo(@RequestBody LibroDTO libroDTO);

    /**
     * Obtiene un libro desde la base de datos MongoDB utilizando su ISBN.
     *
     * @param isbn El ISBN del libro a consultar.
     * @return ResponseEntity que contiene el libro encontrado en formato LibroDTO o un código de error si no se encuentra el libro.
     */
    @GetMapping("/nonrelational-prd-query/libros/consultas/isbn{isbn}")
    ResponseEntity<LibroDTO> getLibroByIsbn(@PathVariable("isbn") String isbn);

    @GetMapping("/nonrelational-prd-query/libros/consultas/autor{autor}")
    ResponseEntity<List<LibroDTO>> getLibroByAutor(@PathVariable("autor") String autor);

    @GetMapping("/nonrelational-prd-query/libros/consultas/nombre{nombre}")
    ResponseEntity<List<LibroDTO>> getLibroByNombre(@PathVariable("nombre") String nombre);


}
