import {
    BeforeInsert,
    Column,
    Entity,
    OneToMany,
    PrimaryGeneratedColumn,
} from "typeorm";
import { Edificio } from "./Edificio";

@Entity("CIUDAD")
export class Ciudad{

    @PrimaryGeneratedColumn({ name: "CODIGO_CIUDAD" })
    codigoCiudad: number;

    @Column({ name: "NOMBRE_CIUDAD" })
    nombreCiudad: string;

    @Column({ name: "USUARIO_REGISTRO" })
    usuarioRegistro: string;

    @Column({ name: "FECHA_REGISTRO" })
    fechaRegistro: Date;

    // @OneToMany( 
    //     () => Edificio,
    //     edificio => edificio.ciudad
    // )
    // edificios: Edificio[];

    @BeforeInsert()
    beforeInsertActions() {
        this.nombreCiudad = this.nombreCiudad.toUpperCase();
        this.usuarioRegistro = "VECSUS";
        this.fechaRegistro = new Date();
    }
}