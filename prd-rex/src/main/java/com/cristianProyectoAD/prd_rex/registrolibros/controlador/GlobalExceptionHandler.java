package com.cristianProyectoAD.prd_rex.registrolibros.controlador;

import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controlador global para manejar excepciones en la aplicación.
 * Proporciona una respuesta personalizada para excepciones específicas de Feign.
 * @author cristian
 * @version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja las excepciones de tipo {@link FeignException.BadRequest}.
     *
     * @param ex la excepción lanzada cuando se encuentra un error de tipo "Bad Request".
     * @return una respuesta HTTP con un código de estado 400 y un mensaje de error detallado.
     */
    @ExceptionHandler(FeignException.BadRequest.class)
    public ResponseEntity<String> handleBadRequest(FeignException.BadRequest ex) {
        return ResponseEntity.badRequest().body("Error: El libro con el ISBN ya existe");
    }

    /**
     * Maneja las excepciones de tipo {@link FeignException.NotFound}.
     *
     * @param ex la excepción lanzada cuando no se encuentra un recurso.
     * @return una respuesta HTTP con un código de estado 404 y un mensaje de error personalizado.
     */
    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<String> handleNotFound(FeignException.NotFound ex) {
        return ResponseEntity.status(404).body("Error: Recurso no encontrado.");
    }


}
