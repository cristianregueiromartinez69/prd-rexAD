package com.cristianProyectoAD.prd_rex.registrolibros.controlador;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.registrolibros.servicio.PrdRexLibroService;
import com.cristianProyectoAD.prd_rex.registrolibros.xml.LibrosXMLSave;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Restcontroller del registro de libros de prd-rex
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/prd-rex/libros")
public class RestControllerRegistroLibros {

    //variable del servicio de libros
    private final PrdRexLibroService prdRexLibroService;
    private final LibrosXMLSave librosXMLSave;

    /**
     * Constructor de la clase
     * @param prdRexLibroService el servicio prd-rex
     */
    public RestControllerRegistroLibros(PrdRexLibroService prdRexLibroService, LibrosXMLSave librosXMLSave) {
        this.prdRexLibroService = prdRexLibroService;
        this.librosXMLSave = librosXMLSave;
    }

    /**
     * Metodo para mandar los datos que van a venir de con-external
     * @param libroDTO el libro
     * @return el registro en las bases de datos
     */
    @PostMapping("/registro")
    public ResponseEntity<String> registroLibrosBasesDatos(@RequestBody LibroDTO libroDTO){
        try{
            librosXMLSave.guardarLibroEnXML(libroDTO, "C:/Users/crm23/Downloads/prd-rex/prd-rex/libros.xml");
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("no se pudo guardar el libro en el sistema de ficheros");
        }
        return prdRexLibroService.registroLibrosBases(libroDTO);
    }
}
