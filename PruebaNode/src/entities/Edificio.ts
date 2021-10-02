import {
    BeforeInsert,
    Column,
    Entity,
    JoinColumn,
    OneToOne,
    PrimaryGeneratedColumn,
} from "typeorm";

@Entity("Edificio")
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

    @BeforeInsert()
    beforeInsertActions() {
        this.nombreEdificio = this.nombreEdificio.toUpperCase();
        this.usuarioRegistro = "VECSUS";
        this.fechaRegistro = new Date();
    }
}