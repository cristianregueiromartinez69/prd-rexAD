package com.cristianProyectoAD.prd_rex.dto;


import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class LibroDTO {

    @NotBlank
    private String isbn;
    @NotBlank
    private String autor;
    @NotBlank
    private String nombre;
    @NotBlank
    private LocalDate fechaLectura;
    @NotBlank
    private LocalDate fechaRegistro;

    public LibroDTO(String isbn, String autor, String nombre, LocalDate fechaLectura, LocalDate fechaRegistro) {
        this.isbn = isbn;
        this.autor = autor;
        this.nombre = nombre;
        this.fechaLectura = fechaLectura;
        this.fechaRegistro = fechaRegistro;
    }

    public LibroDTO() {
    }

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
