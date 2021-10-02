import { Router } from "express";
import { validatorPutEdificio } from "../middlewares/validatorEdificio";
import {putEdificio, getAll} from "../controllers/edificio.controller"

const router = Router();

router.put("/:codigoEdificio",validatorPutEdificio,putEdificio);
router.get("/",getAll);

export default router;