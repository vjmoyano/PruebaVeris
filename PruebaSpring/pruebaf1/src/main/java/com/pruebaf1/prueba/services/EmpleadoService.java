package com.pruebaf1.prueba.services;

import com.pruebaf1.prueba.dto.EmpleadoDto;
import com.pruebaf1.prueba.entities.Empleado;
import com.pruebaf1.prueba.repositories.EmpleadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@PersistenceContext
@Service()
public class EmpleadoService {

    @Autowired
    private EmpleadoRepo empleadoRepo;

    EntityManager em;
    //select user from dual;

    public int createEmpleado(EmpleadoDto data){
        System.out.println("servicio empleado");
        Empleado empleado = new Empleado();
        empleado.setCodigoEmpleado(Integer.parseInt(data.getCodigoEmpleado()));
        empleado.setCodigoEdificio(data.getCodigoEdificio());
        empleado.setEstado(data.getEstado());
        empleado.setFechaNacimiento(data.getFechaNacimiento());
        empleado.setMail(data.getMail());
        empleado.setFechaRegistro(data.getFechaRegistro());
        empleado.setPrimerApellido(data.getPrimerApellido());
        empleado.setSegundoApellido(data.getSegundoApellido());
        empleado.setPrimerNombre(data.getPrimerNombre());
        empleado.setSegundoNombre(data.getSegundoNombre());
        empleado.setSexo(data.getSexo());
        empleado.setNombreCompleto(data.getNombreCompleto());
        empleado.setUsuarioRegistro(data.getUsuarioRegistro());
        empleado.setTipoIdentificacion(data.getTipoIdentificacion());
        empleado.setNumeroIdentificacion(data.getNumeroIdentificacion());

        Empleado empleadoNew = empleadoRepo.save(empleado);
        System.out.println("servicio");
        return empleadoNew.getCodigoEmpleado();

    }



}
