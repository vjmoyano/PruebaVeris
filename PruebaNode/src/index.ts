import express from "express";
import cors from "cors";
import { createConnection } from "typeorm";
import "reflect-metadata";

import MarcacionR from "./routes/marcacion.routes";
import EdificiosR from "./routes/edificio.routes";

const PORT = 3000;

const app = express();
createConnection();

app.use(cors());
app.use(express.json());
app.use("/marcaciones", MarcacionR );
app.use("/edificios", EdificiosR);

app.listen(PORT);
console.log(`Servidor escuchando en el puerto ${PORT}`);