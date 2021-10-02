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

export const validatorPutEdificio: any = [
    body("codigoEdificio", "El codigo Edificio es obligatorio").not().isEmpty(),
    body("nombreEdificio", "El codigo Edificio es obligatorio").not().isEmpty(),
    body("codigoCiudad", "El codigo Edificio es obligatorio").not().isEmpty(),
    dataError,
];

