import { Request, Response } from "express";
import { getRepository } from "typeorm";

import { Edificio } from "../entities/Edificio";

export const getAll = async (
    req: Request,
    res: Response
): Promise<Response> => {
    try {
        const lsEdificio = await getRepository(Edificio).find();
        return res.status(200).json({
            code: 200,
            success: true,
            message: "OK",
            data: lsEdificio,
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

export const putEdificio = async (
    req: Request,
    res: Response
): Promise<Response> => {
    try {
        const obEdificio = await getRepository(Edificio).findOne({
            where: {codigoEdificio: req.params.codigoEdificio},
        });
        if (!obEdificio) {
            return res.status(400).json({
                code: 400,
                success: false,
                message: "El edificio con aquel codigo no existe!",
                data: obEdificio,
            });
        }
        
        getRepository(Edificio).merge(obEdificio, req.body);
        console.log(obEdificio);
        const resp = await getRepository(Edificio).save(obEdificio);
        console.log(resp);
        return res.status(200).json({
            code: 200,
            success: true,
            message: "OK",
            data: resp.codigoEdificio,
        });
    } catch (err) {
        return res.status(500).json({
            code: 500,
            success: false,
            message: "Ha ocurrido un error inesperado.",
            errorData: err,
        });
    }
}