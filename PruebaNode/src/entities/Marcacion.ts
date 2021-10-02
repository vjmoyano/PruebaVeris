import {
    BeforeInsert,
    Column,
    Entity,
    JoinColumn,
    OneToOne,
    PrimaryGeneratedColumn,
} from "typeorm";

@Entity("Marcacion")
export class Marcacion{

    @PrimaryGeneratedColumn({name:"SECUENCIA"})
    secuencia: number;

    @Column({ name: "CODIGO_EMPLEADO" })
    codigoEmpleado: number;

    @Column({ name: "CODIGO_EDIFICIO" })
    codigoEdificio: number;

    @Column({ name: "FECHA_MARCACION" })
    codigoMarcacion: Date;

    @Column({ name: "HORA_MARCACION" })
    horaMarcacion: string;

    @Column({ name: "USUARIO_REGISTRO" })
    usuarioRegistro: string;

    @Column({ name: "FECHA_REGISTRO" })
    fechaRegistro: Date;

    @BeforeInsert()
    beforeInsertActions() {
        this.usuarioRegistro = "VECSUS";
        this.fechaRegistro = new Date();
    }
}