import { body, param, query } from "express-validator";

import { validatorMap } from "../helpers/validatorMap";

export const validatorPutEdificio: any = [
    body("codigoEdificio", "El codigo Edificio es obligatorio").not().isEmpty(),
    body("nombreEdificio", "El codigo Edificio es obligatorio").not().isEmpty(),
    body("codigoCiudad", "El codigo Edificio es obligatorio").not().isEmpty(),
    validatorMap,
];

