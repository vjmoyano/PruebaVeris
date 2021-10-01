package com.pruebaf1.prueba.controllers;

import com.pruebaf1.prueba.services.EdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/api/edificios")
public class EdificioController {

    @Autowired
    private EdificioService edificioServices;

    @GetMapping("")
    public Map<String, Object> getSucursales() {
        return edificioServices.listAllEdficios();
    }

}
