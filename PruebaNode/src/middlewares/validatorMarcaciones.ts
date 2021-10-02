import { body, param, query } from "express-validator";

import { validatorMap } from "../helpers/validatorMap";

export const validatorPostBodySucursal: any = [
    body("codigoEmpleado", "El codigo Empresa es obligatorio").not().isEmpty(),
    body("codigoEdificio", "El codigo Edificio es obligatorio").not().isEmpty(),
    body("fechaMarcacion", "La fecha Marcacio es obligatoria").not().isEmpty(),
    body("tipoMarcacion", "El tipo Marcacion es obligatorio").not().isEmpty(),
    body("horaMarcacion", "La hora Marcacion es obligatoria").not().isEmpty(),
    validatorMap,
];

