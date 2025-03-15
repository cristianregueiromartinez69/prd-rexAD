package com.cristianProyectoAD.prd_rex.servicio_comunicacion;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Cliente Feign para interactuar con el servicio de consulta y almacenamiento de libros en una base de datos no relacional (MongoDB).
 * Utiliza la URL base <a href="http://localhost:8083">http://localhost:8083</a> para la comunicación con el servicio.
 * Los métodos proporcionan operaciones para guardar libros, consultar por ISBN, autor, nombre y fecha de registro.
 *
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
    @GetMapping("/nonrelational-prd-query/libros/consultas/isbn/{isbn}")
    ResponseEntity<LibroDTO> getLibroByIsbn(@PathVariable("isbn") String isbn);

    /**
     * Obtiene una lista de libros desde la base de datos MongoDB utilizando el nombre del autor.
     *
     * @param autor El nombre del autor de los libros a consultar.
     * @return ResponseEntity que contiene una lista de libros encontrados en formato LibroDTO o un código de error si no se encuentran libros.
     */
    @GetMapping("/nonrelational-prd-query/libros/consultas/autor/{autor}")
    ResponseEntity<List<LibroDTO>> getLibroByAutor(@PathVariable("autor") String autor);

    /**
     * Obtiene una lista de libros desde la base de datos MongoDB utilizando el nombre del libro.
     *
     * @param nombre El nombre del libro a consultar.
     * @return ResponseEntity que contiene una lista de libros encontrados en formato LibroDTO o un código de error si no se encuentran libros.
     */
    @GetMapping("/nonrelational-prd-query/libros/consultas/nombre/{nombre}")
    ResponseEntity<List<LibroDTO>> getLibroByNombre(@PathVariable("nombre") String nombre);

    /**
     * Obtiene una lista de libros desde la base de datos MongoDB dentro de un rango de fechas de registro.
     *
     * @param fechaInicio La fecha de inicio del rango de búsqueda.
     * @param fechaFin La fecha de fin del rango de búsqueda.
     * @return ResponseEntity que contiene una lista de libros encontrados en formato LibroDTO o un código de error si no se encuentran libros en el rango de fechas.
     */
    @GetMapping("/nonrelational-prd-query/libros/consultas/fecharegistro")
    ResponseEntity<List<LibroDTO>> getLibroByFechaRegistro(@RequestParam("fechaInicio") LocalDate fechaInicio, @RequestParam("fechaFin") LocalDate fechaFin);

    /**
     * Metodo llamando al servicio de la base de mongo para realizar consultas entre fechas de lectura
     * @param fechaInicio la fecha de inicio
     * @param fechaFin la fecha de fin
     * @return la lista de libros entre esas fechas
     */
    @GetMapping("/nonrelational-prd-query/libros/consultas/fechalectura")
    ResponseEntity<List<LibroDTO>> getLirboByFechaLectura(@RequestParam("fechaInicio") LocalDate fechaInicio, @RequestParam("fechaFin") LocalDate fechaFin);

}
