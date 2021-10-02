import { body, param, query } from "express-validator";

import { NextFunction, Request, Response } from "express";
import { validationResult } from "express-validator";

const dataError = (
    req: Request,
    res: Response,
    next: NextFunction
) => {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
        return res.status(400).json({
            code: 400,
            message: "Validación del Request",
            errorData: errors.mapped(),
        });
    }
    next();
};

export const validatorPostBodySucursal: any = [
    body("codigoEmpleado", "El codigo Empresa es obligatorio").not().isEmpty(),
    body("codigoEdificio", "El codigo Edificio es obligatorio").not().isEmpty(),
    body("fechaMarcacion", "La fecha Marcacio es obligatoria").not().isEmpty(),
    body("tipoMarcacion", "El tipo Marcacion es obligatorio").not().isEmpty(),
    body("horaMarcacion", "La hora Marcacion es obligatoria").not().isEmpty(),
    dataError,
];

