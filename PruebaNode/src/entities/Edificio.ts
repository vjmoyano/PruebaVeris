import {
    BeforeInsert,
    Column,
    Entity,
    JoinColumn,
    ManyToOne,
    OneToMany,
    OneToOne,
    PrimaryGeneratedColumn,
} from "typeorm";
import { Ciudad } from "./Ciudad";
import { Marcacion } from "./Marcacion";

@Entity("EDIFICIO")
export class Edificio{

    @PrimaryGeneratedColumn({ name: "CODIGO_EDIFICIO" })
    codigoEdificio: number;

    @Column({ name: "NOMBRE_EDIFICIO" })
    nombreEdificio: string;

    @Column({ name: "CODIGO_CIUDAD" })
    codigoCiudad: number;

    @Column({ name: "USUARIO_REGISTRO" })
    usuarioRegistro: string;

    @Column({ name: "FECHA_REGISTRO" })
    fechaRegistro: Date;

    // @OneToOne(
    //     () => Ciudad,
    //     ciudad => ciudad.edificios,
    //     {onDelete: "CASCADE", 
    //     eager: true
    // }
    // )
    // @JoinColumn({
    //     name: "CODIGO_CIUDAD"
    // })
    // ciudad: Ciudad;

    // @OneToMany( 
    //     () => Marcacion,
    //     marcacion => marcacion.edificio
    // )
    // marcaciones: Marcacion[];

    @BeforeInsert()
    beforeInsertActions() {
        this.nombreEdificio = this.nombreEdificio.toUpperCase();
        this.usuarioRegistro = "VECSUS";
        this.fechaRegistro = new Date();
    }
}