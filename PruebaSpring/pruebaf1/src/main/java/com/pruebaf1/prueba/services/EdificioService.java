package com.pruebaf1.prueba.services;

import com.pruebaf1.prueba.dto.EdificioDto;
import com.pruebaf1.prueba.entities.Edificio;
import com.pruebaf1.prueba.repositories.EdificioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service()
public class EdificioService {

    @Autowired
    private EdificioRepo edificioRepo;

    public Map<String, Object> listAllEdficios() {
        Map<String, Object> data = new HashMap<>();
        List<EdificioDto> resp = new ArrayList<EdificioDto>();
        try {
            List<Edificio> edificios = edificioRepo.findAll();
            for (Edificio edificio : edificios) {
                EdificioDto dto = new EdificioDto();
                dto.setCodigoEdificio(edificio.getCodigoEdificio());
                dto.setNombreEdificio(edificio.getNombreEdificio());
                dto.setCodigoCiudad(edificio.getCodigoCiudad());
                dto.setUsuarioRegistro(edificio.getUsuarioRegistro());
                dto.setFechaRegistro(edificio.getFechaRegistro());
                resp.add(dto);
            }
            data.put("code", 200);
            data.put("message", "OK");
            data.put("data", resp);
        } catch (Exception e) {
            data.put("code", 500);
            data.put("message", "Errores no controlados");
            data.put("errorData", resp);
        }
        return data;
    }

}
