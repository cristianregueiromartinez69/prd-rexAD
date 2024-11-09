package com.cristianProyectoAD.prd_rex.servicio_comunicacion;

import com.cristianProyectoAD.prd_rex.dto.LibroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "nonrelational-prd-query", url="http://localhost:8083")
public interface MongoPrdClientService {

    @PostMapping("/libros/guardar")
    ResponseEntity<String> saveBooksMongo(@RequestBody LibroDTO libroDTO);
}
