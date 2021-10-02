package com.pruebaf1.prueba.controllers;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.pruebaf1.prueba.dto.EmpleadoDto;
import com.pruebaf1.prueba.dto.ResponseDto;
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
        this.currentUser();

        if(Objects.isNull(empleado.getEstado())||empleado.getEstado().isEmpty()){
            validacion = true;
            check.put("estado","Falta parametro estado");
        }
        if(Objects.isNull(empleado.getCodigoEmpleado())||empleado.getCodigoEmpleado().isEmpty()){
            validacion = true;
            check.put("codigoEmpleado","Falta parametro codigoEmpleado");
        }
        if(Objects.isNull(empleado.getTipoIdentificacion())||
            empleado.getTipoIdentificacion().isEmpty()){
            validacion = true;
            check.put("TipoIdentificacion","Falta parametro TipoIdentificacion");
        }
        if(Objects.isNull(empleado.getNumeroIdentificacion())||
            empleado.getNumeroIdentificacion().isEmpty()){
            validacion = true;
            check.put("NumeroIdentificacion","Falta parametro NumeroIdentificacion");
        }
        if(Objects.isNull(empleado.getPrimerNombre())||
            empleado.getPrimerNombre().isEmpty()){
            validacion = true;

            check.put("PrimerNombre","Falta parametro PrimerNombre");

        }
        if(Objects.isNull(empleado.getPrimerApellido())||
            empleado.getPrimerApellido().isEmpty()){
            validacion = true;

            check.put("PrimerApellido","Falta parametro PrimerApellido");

        }
        if(Objects.isNull(empleado.getCodigoEdificio())){
            validacion = true;

            check.put("CodigoEdificio","Falta parametro CodigoEdificio");

        }
        if(validacion){
            resp.put("Parametros faltantes",check);
            resp.put("code", 400);
            resp.put("message", "Validaciones");
            resp.put("data", new ArrayList());
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        }
        empleado.setUsuarioRegistro(this.currentUser());

        int codigo = empleadoServices.createEmpleado(empleado);
        try {
            if (!Objects.isNull(codigo)) {
                resp.put("code", 200);
                resp.put("succes", true);
                resp.put("message", "Se creo el empleado");
                data.put("codigoEmpleado", codigo);
                resp.put("data", data);
                return new ResponseEntity<>(resp, HttpStatus.OK);
            } else {
                resp.put("code", 400);
                resp.put("succes", false);
                resp.put("message", "No se creo el empleado, por favor contactese");
                resp.put("data", new ArrayList());
                return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("succes",false);
            resp.put("message", "Ha ocurrido un error inesperado");
            resp.put("errorData", new ArrayList());
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SuppressWarnings("unchecked")
	@GetMapping("")
    public ResponseEntity<?> getEmpleados(@RequestParam(name = "esActivo", required = false) String estado,
                                          @RequestParam(name = "codigoCiudad", required = false) String codigoCiudad,
                                          @RequestParam(name = "tipoF", required = false) String tipoF,
                                          @RequestParam(name = "valorF", required = false) String valorF) {
        Map<String, Object> resp = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT  c.nombre_ciudad as ciudad, ed.nombre_edificio as edi, e.*, e.codigo_empleado as cod FROM EMPLEADO e INNER JOIN EDIFICIO ed ON e.codigo_edificio =ed.codigo_edificio");
        sb.append(" INNER JOIN CIUDAD c ON ed.codigo_ciudad = c.codigo_ciudad ");
        try {
            if(Objects.isNull(estado)) {
            	resp.put("code", 400);
                resp.put("succes",false);
                resp.put("message", "El estado del empleado es obligatorio.");
                resp.put("data", new ArrayList());
                return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
            }
            sb.append("WHERE e.estado = '"+estado+"'");
            if(!Objects.isNull(codigoCiudad)) {
            	sb.append(" AND c.codigo_ciudad = "+codigoCiudad);
            }
            if(!Objects.isNull(tipoF)  && !Objects.isNull(valorF)){
            	if(tipoF.equalsIgnoreCase("numeroIdentificacion")) {
            		sb.append(" AND e.numero_identificacion = '" + valorF + "'");
            	}
            	if(tipoF.equalsIgnoreCase("nombreEmpleado")) {
            		sb.append(" AND e.nombre_completo LIKE '%" + valorF+"%'");
            	}
            }
            TypedQuery<Tuple> query = (TypedQuery<Tuple>) em.createNativeQuery(sb.toString(), Tuple.class);
            List<Tuple> lsResult = query.getResultList();
            List<ResponseDto> empleados = new ArrayList<>();
            
            for(Tuple tuple: lsResult){
            	ResponseDto empleado = new ResponseDto();
            	System.out.println(tuple.toString());
            	empleado.ciudad = tuple.get("ciudad",String.class).toString();
            	empleado.edificio = tuple.get("edi",String.class).toString();
            	empleado.nombre = tuple.get("PRIMER_NOMBRE",String.class).toString();
            	empleado.apellido = tuple.get("PRIMER_APELLIDO",String.class).toString();
            	empleado.email = tuple.get("MAIL",String.class).toString();
            	empleado.identificacion = tuple.get("NUMERO_IDENTIFICACION",String.class).toString();
            	empleado.sexo = tuple.get("SEXO",String.class).toString();
            	empleado.codigoEmpleado = tuple.get("cod",Number.class).toString();
            	empleados.add(empleado);
            }
            
            resp.put("code", 200);
            resp.put("succes",true);
            resp.put("message", "OK");
            resp.put("data",empleados);
            return new ResponseEntity<>(resp, HttpStatus.OK);
            
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("message", "Ha ocurrido un error inesperado");
            resp.put("errorData", e );
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @SuppressWarnings("unchecked")
	public String currentUser() {
    	String usuario = "";
    	StringBuilder sb = new StringBuilder();
        sb.append("select user as usuario from dual");
        TypedQuery<Tuple> query = (TypedQuery<Tuple>) em.createNativeQuery(sb.toString(), Tuple.class);
        List<Tuple> lsResult = query.getResultList();
        for(Tuple tuple: lsResult) {
        	usuario = tuple.get("usuario",String.class).toString();
        }
        System.out.println(usuario);
        return usuario;
    }
    
}
