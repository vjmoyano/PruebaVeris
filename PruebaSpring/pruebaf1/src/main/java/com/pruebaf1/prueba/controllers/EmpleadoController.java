package com.pruebaf1.prueba.controllers;

import com.pruebaf1.prueba.dto.EmpleadoDto;
import com.pruebaf1.prueba.entities.Empleado;
import com.pruebaf1.prueba.repositories.EmpleadoRepo;
import com.pruebaf1.prueba.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import java.util.*;


@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

	//@PersistenceContext
	@Autowired
    EntityManager em;

    @Autowired
    private EmpleadoService empleadoServices;

    EmpleadoRepo repo;

    @PostMapping("")
    public ResponseEntity<?> createEmpleado(@RequestBody EmpleadoDto empleado) {
        boolean validacion = false;
        System.out.println("controlador empleado");
        Map<String, Object> resp = new LinkedHashMap<>();
        Map<String, Object> check = new LinkedHashMap<>();
        Map<String, Object> data = new LinkedHashMap<>();

        if(Objects.isNull(empleado.getEstado())||empleado.getEstado().isEmpty()){
            validacion = true;
            resp.put("code", 400);
            resp.put("message", "Validaciones");
            resp.put("data", new ArrayList());
            check.put("estado","Falta parametro estado");

        }
        if(Objects.isNull(empleado.getCodigoEmpleado())){
            validacion = true;
            resp.put("code", 400);
            resp.put("message", "Validaciones");
            resp.put("data", new ArrayList());
            check.put("codigoEmpleado","Falta parametro codigoEmpleado");
        }
        if(Objects.isNull(empleado.getTipoIdentificacion())||
                empleado.getTipoIdentificacion().isEmpty()){
            validacion = true;
            resp.put("code", 400);
            resp.put("message", "Validaciones");
            resp.put("data", new ArrayList());
            check.put("TipoIdentificacion","Falta parametro TipoIdentificacion");

        }
        if(Objects.isNull(empleado.getNumeroIdentificacion())||
                empleado.getNumeroIdentificacion().isEmpty()){
            validacion = true;
            resp.put("code", 400);
            resp.put("message", "Validaciones");
            resp.put("data", new ArrayList());
            check.put("NumeroIdentificacion","Falta parametro NumeroIdentificacion");

        }
        if(Objects.isNull(empleado.getPrimerNombre())||
                empleado.getPrimerNombre().isEmpty()){
            validacion = true;
            resp.put("code", 400);
            resp.put("message", "Validaciones");
            resp.put("data", new ArrayList());
            check.put("PrimerNombre","Falta parametro PrimerNombre");

        }
        if(Objects.isNull(empleado.getPrimerApellido())||
                empleado.getPrimerApellido().isEmpty()){
            validacion = true;
            resp.put("code", 400);
            resp.put("message", "Validaciones");
            resp.put("data", new ArrayList());
            check.put("PrimerApellido","Falta parametro PrimerApellido");

        }
        if(Objects.isNull(empleado.getCodigoEdificio())){
            validacion = true;
            resp.put("code", 400);
            resp.put("message", "Validaciones");
            resp.put("data", new ArrayList());
            check.put("CodigoEdificio","Falta parametro CodigoEdificio");

        }
        if(validacion){
            resp.put("Parametros faltantes",check);
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        }

        int codigo = empleadoServices.createEmpleado(empleado);
        try {
            if (!Objects.isNull(codigo)) {
                resp.put("code", 200);
                resp.put("succes", true);
                data.put("codigoEmpleado", codigo);
                resp.put("data", data);
                return new ResponseEntity<>(resp, HttpStatus.OK);
            } else {
                resp.put("code", 400);
                resp.put("succes", false);
                resp.put("message", "Errores dentro del Servicio");
                resp.put("data", new ArrayList());
                return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("succes",false);
            resp.put("message", "Error no controlado");
            resp.put("errorData", new ArrayList());
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getEmpleados(@RequestParam(name = "esActivo", required = false) String estado,
                                          @RequestParam(name = "codigoCiudad", required = false) String codigoCiudad,
                                          @RequestParam(name = "tipoF", required = false) String tipoF,
                                          @RequestParam(name = "valorF", required = false) String valorF) {
        Map<String, Object> resp = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT  c.nombre_ciudad, ed.nombre_edificio, e.* FROM EMPLEADO e INNER JOIN EDIFICIO ed ON e.codigo_edificio =ed.codigo_edificio");
        sb.append(" INNER JOIN CIUDAD c ON ed.codigo_ciudad = c.codigo_ciudad ");
        try {
            
            if (!Objects.isNull(estado)) {
                sb.append("WHERE e.estado = '"+estado+"'");
                                
                System.out.println(sb.toString());

                resp.put("code", 200);
                resp.put("message", "OK");
                if (!Objects.isNull(codigoCiudad)) {
                    sb.setLength(0); sb = new StringBuilder();
                    sb.append("SELECT e.*, c.nombre_ciudad, nombre_edificio FROM EMPLEADO e INNER JOIN EDIFICIO ed ON e.codigo_edificio =ed.codigo_edificio");
                    sb.append(" INNER JOIN CIUDAD c ON ed.codigo_ciudad = c.codigo_ciudad");
                    sb.append(" WHERE e.estado = '"+estado+"' ");
                    sb.append(" AND c.codigo_ciudad = "+codigoCiudad);
                }
                else if (!Objects.isNull(tipoF)  && !Objects.isNull(valorF)) {
                    switch (tipoF) {
                        case "numeroIdentificacion":

                            if(!Objects.isNull(codigoCiudad)){
                                sb.append(" AND e.numero_identificacion = '" + valorF + "'");
                                TypedQuery<Tuple> query = (TypedQuery<Tuple>) em.createNativeQuery(sb.toString(), Tuple.class);
                                List<Tuple> lsResult = query.getResultList();
                                resp.put("Resultado",lsResult);
                                return new ResponseEntity<>(resp, HttpStatus.OK);
                            }else{
                                sb.setLength(0); sb = new StringBuilder();
                                sb.append("SELECT e.*, c.nombre_ciudad, nombre_edificio FROM EMPLEADO e INNER JOIN EDIFICIO ed ON e.codigo_edificio =ed.codigo_edificio");
                                sb.append(" INNER JOIN CIUDAD c ON ed.codigo_ciudad = c.codigo_ciudad");
                                sb.append(" WHERE e.estado = '"+estado+"' ");
                                sb.append(" AND e.numero_identificacion = '" + valorF+"'");
                                TypedQuery<Tuple> query = (TypedQuery<Tuple>) em.createNativeQuery(sb.toString(), Tuple.class);
                                List<Tuple> lsResult = query.getResultList();
                                resp.put("Resultado",lsResult);
                                return new ResponseEntity<>(resp, HttpStatus.OK);
                                
                            }
                        case "nombreEmpleado":

                            if(!Objects.isNull(codigoCiudad)){
                                sb.append(" AND e.nombre_completo LIKE '%" + valorF+"%'");
                                TypedQuery<Tuple> query = (TypedQuery<Tuple>) em.createNativeQuery(sb.toString(), Tuple.class);
                                List<Tuple> lsResult = query.getResultList();
                                resp.put("Resultado",lsResult);
                                return new ResponseEntity<>(resp, HttpStatus.OK);
                            }else{
                                sb.setLength(0); sb = new StringBuilder();
                                sb.append("SELECT e.*, c.nombre_ciudad, nombre_edificio FROM EMPLEADO e INNER JOIN EDIFICIO ed ON e.codigo_edificio =ed.codigo_edificio");
                                sb.append(" INNER JOIN CIUDAD c ON ed.codigo_ciudad = c.codigo_ciudad");
                                sb.append(" WHERE e.estado = '"+estado+"' ");
                                sb.append(" AND e.nombre_completo LIKE '%" + valorF+"%'");
                                TypedQuery<Tuple> query = (TypedQuery<Tuple>) em.createNativeQuery(sb.toString(), Tuple.class);
                                List<Tuple> lsResult = query.getResultList();
                                resp.put("Resultado",lsResult);
                                return new ResponseEntity<>(resp, HttpStatus.OK);
                            }

                        default:
                            resp.put("code", 400);
                            resp.put("message", "El campo valorFiltro es obligatorio.");
                            resp.put("data", new ArrayList());

                            return new ResponseEntity<>(resp, HttpStatus.OK);
                    }
                } else {
                    System.out.println(sb.toString());

                    Query query = em.createNativeQuery(sb.toString());
                    List<Tuple> lsResult = query.getResultList();
                    resp.put("Resultado",lsResult);
                    return new ResponseEntity<>(resp, HttpStatus.OK);
                }
                System.out.println(sb.toString());
                Query query = em.createNativeQuery(sb.toString());
                List<Tuple> lsResult = (List<Tuple>) query.getResultList();
                resp.put("Resultado",lsResult);
                return new ResponseEntity<>(resp, HttpStatus.OK);
            } else {
                resp.put("code", 400);
                resp.put("succes",false);
                resp.put("message", "El estado del empleado es obligatorio.");
                resp.put("data", new ArrayList());
                return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("message", "Error no controlado");
            resp.put("errorData", e );
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
