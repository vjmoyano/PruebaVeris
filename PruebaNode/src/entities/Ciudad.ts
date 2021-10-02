import {
    BeforeInsert,
    Column,
    Entity,
    PrimaryGeneratedColumn,
} from "typeorm";

@Entity("Ciudad")
export class Ciudad{

    @PrimaryGeneratedColumn({ name: "CODIGO_CIUDAD" })
    codigoCiudad: number;

    @Column({ name: "NOMBRE_CIUDAD" })
    nombreCiudad: string;

    @Column({ name: "USUARIO_REGISTRO" })
    usuarioRegistro: string;

    @Column({ name: "FECHA_REGISTRO" })
    fechaRegistro: Date;

    @BeforeInsert()
    beforeInsertActions() {
        this.nombreCiudad = this.nombreCiudad.toUpperCase();
        this.usuarioRegistro = "VECSUS";
        this.fechaRegistro = new Date();
    }
}