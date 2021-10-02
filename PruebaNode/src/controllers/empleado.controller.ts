import { Request, Response } from "express";
import { getRepository } from "typeorm";

import { Empleado } from "../entities/Empleado";

export const getAll = async (
    req: Request,
    res: Response
): Promise<Response> => {
    try {
        const lsEmpleado = await getRepository(Empleado).find();
        return res.status(200).json({
            code: 200,
            success: true,
            message: "OK",
            data: lsEmpleado,
        });
    } catch (err) {
        return res.status(500).json({
            code: 500,
            success: false,
            message: "Ha ocurrido un error inesperado.",
            errorData: err,
        });
    }
};
