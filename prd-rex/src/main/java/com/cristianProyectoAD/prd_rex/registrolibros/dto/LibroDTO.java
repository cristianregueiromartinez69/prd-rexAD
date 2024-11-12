package com.cristianProyectoAD.prd_rex.registrolibros.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
/**
 * Clase dto con los datos de registro de los libros
 * @author cristian
 * @version 1.0
 */
public class LibroDTO {

    /**
     * variables de los libros
     * La anotación indica que no pueden estar en blanco al mandarlo
     */
    @NotBlank
    @JacksonXmlProperty(localName = "isbn")
    private String isbn;
    @NotBlank
    @JacksonXmlProperty(localName = "autor")
    private String autor;
    @NotBlank
    @JacksonXmlProperty(localName = "nombre")
    private String nombre;
    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JacksonXmlProperty(localName = "fechaLectura")
    private LocalDate fechaLectura;
    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JacksonXmlProperty(localName = "fechaRegistro")
    private LocalDate fechaRegistro;

    /**
     * Contructor de la clase
     * @param isbn el isbn del libro
     * @param nombre el nombre del libro
     * @param autor el autor del libro
     * @param fechaLectura la fecha de lectura del libro
     * @param fechaRegistro la fecha de registro del libro
     */
    public LibroDTO(String isbn, String autor, String nombre, LocalDate fechaLectura, LocalDate fechaRegistro) {
        this.isbn = isbn;
        this.autor = autor;
        this.nombre = nombre;
        this.fechaLectura = fechaLectura;
        this.fechaRegistro = fechaRegistro;
    }

    //constructor por defecto
    public LibroDTO() {
    }

    /**
     * Getter y setter de la clase
     * @return los atributos del libro
     */
    public @NotBlank String getIsbn() {
        return isbn;
    }

    public void setIsbn(@NotBlank String isbn) {
        this.isbn = isbn;
    }

    public @NotBlank String getAutor() {
        return autor;
    }

    public void setAutor(@NotBlank String autor) {
        this.autor = autor;
    }

    public @NotBlank String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank LocalDate getFechaLectura() {
        return fechaLectura;
    }

    public void setFechaLectura(@NotBlank LocalDate fechaLectura) {
        this.fechaLectura = fechaLectura;
    }

    public @NotBlank LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(@NotBlank LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
