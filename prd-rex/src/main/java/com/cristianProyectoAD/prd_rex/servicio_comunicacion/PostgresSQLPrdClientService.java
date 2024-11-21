package com.cristianProyectoAD.prd_rex.servicio_comunicacion;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Cliente Feign para interactuar con el servicio de consulta y almacenamiento de libros en una base de datos relacional (PostgreSQL).
 * Utiliza la URL base <a href="http://localhost:8082">...</a> para la comunicación con el servicio.
 * @author cristian
 * @version 1.0
 */
@FeignClient(name = "relational-prd-query", url = "http://localhost:8082")
public interface PostgresSQLPrdClientService {

    /**
     * Guarda un libro en la base de datos PostgreSQL.
     *
     * @param libroDTO Objeto que contiene la información del libro a guardar.
     * @return ResponseEntity con el resultado de la operación (mensaje de éxito o error).
     */
    @PostMapping("/relational-prd-query/libros/guardar")
    ResponseEntity<String> saveBooksPostgres(@RequestBody LibroDTO libroDTO);

    /**
     * Obtiene un libro desde la base de datos PostgreSQL utilizando su ISBN.
     *
     * @param isbn El ISBN del libro a consultar.
     * @return ResponseEntity que contiene el libro encontrado en formato LibroDTO o un código de error si no se encuentra el libro.
     */
    @GetMapping("/relational-prd-query/libros/consultas/isbn{isbn}")
    ResponseEntity<LibroDTO> getLibroByIsbn(@PathVariable("isbn") String isbn);

    /**
     * Obtiene una lista de libros desde la base de datos PostgreSQL utilizando el autor como criterio de búsqueda.
     *
     * @param autor El nombre del autor de los libros a consultar.
     * @return ResponseEntity que contiene una lista de libros encontrados en formato LibroDTO.
     */
    @GetMapping("/relational-prd-query/libros/consultas/autor{autor}")
    ResponseEntity<List<LibroDTO>> getLibroByAutor(@PathVariable("autor") String autor);

    @GetMapping("/relational-prd-query/libros/consultas/nombre{nombre}")
    ResponseEntity<List<LibroDTO>> getLibroByNombre(@PathVariable("nombre") String nombre);


}
