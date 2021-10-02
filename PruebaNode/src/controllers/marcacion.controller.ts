import { Request, Response } from "express";
import { getRepository } from "typeorm";

import { Marcacion } from "../entities/Marcacion";

export const getAll = async (
    req: Request,
    res: Response
): Promise<Response> => {
    try {
        const lsMarcaciones = await getRepository(Marcacion).find();
        return res.status(200).json({
            code: 200,
            success: true,
            message: "OK",
            data: lsMarcaciones,
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

export const postMarcacion = async (
    req: Request,
    res: Response
): Promise<Response> => {
    try {
        const Marcacion = new Marcacion();
        getRepository(Marcacion).merge(Marcacion, req.body);
        const Marcacion = await getRepository(Marcacion).create(Marcacion);
        const newMarcacion = await getRepository(Marcacion).save(Marcacion);
        return res.status(200).json({
            code: 200,
            success: true,
            message: "OK",
            data: {
                secuenciaMarcacion: newMarcacion.secuencia,
            },
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

