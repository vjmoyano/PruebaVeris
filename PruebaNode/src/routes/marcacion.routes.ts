import { Router } from "express";
import { validatorPostMarcacion } from "../middlewares/validatorMarcaciones";

import {postMarcacion} from "../controllers/marcacion.controller";

const router = Router();

router.post('/',validatorPostMarcacion,postMarcacion);

export default router;