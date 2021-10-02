import { Marcacion } from './Marcacion';
import {
    BeforeInsert,
    Column,
    Entity,
    OneToMany,
    PrimaryGeneratedColumn,
} from "typeorm";

@Entity("EMPLEADO")
export class Empleado{

    @PrimaryGeneratedColumn({name:"CODIGO_EMPLEADO"})
    codigoEmpleado: number;

    @Column({ name: "TIPO_IDENTIFICACION" })
    tipoIdentificacion: string;

    @Column({ name: "NUMERO_IDENTIFICACION"})
    numeroIdentificacion: string;

    @Column({ name: "PRIMER_NOMBRE" })
    primerNombre: string;

    @Column({ name: "SEGUNDO_NOMBRE" })
    segundoNombre: string;

    @Column({ name: "PRIMER_APELLIDO" })
    primerApellido: string;

    @Column({ name: "SEGUNDO_APELLIDO" })
    segundoApellido: string;

    @Column({ name: "NOMBRE_COMPLETO" })
    nombreCompleto: string;

    @Column({ name: "MAIL" })
    mail: string;

    @Column({ name: "SEXO" })
    sexo: string;

    @Column({ name: "FECHA_NACIMIENTO" })
    fechaNacimiento: Date;

    @Column({ name: "CODIGO_EDIFICIO" })
    codigoEdificio: number;

    @Column({ name: "ESTADO" })
    estado: string;

    @Column({ name: "USUARIO_REGISTRO" })
    usuarioRegistro: string;

    @Column({ name: "FECHA_REGISTRO" })
    fechaRegistro: Date;

    // @OneToMany( 
    //     () => Marcacion,
    //     marcacion => marcacion.empleado
    // )
    // marcaciones: Marcacion[];

    @BeforeInsert()
    beforeInsertActions() {
        this.usuarioRegistro = "VECSUS";
        this.fechaRegistro = new Date();
        this.toUpper();
    }

    toUpper() {
        this.tipoIdentificacion = this.tipoIdentificacion.toUpperCase();
        this.primerNombre = this.primerNombre.toUpperCase();
        if (this.segundoNombre) this.segundoNombre = this.segundoNombre.toUpperCase();
        this.primerApellido = this.primerApellido.toUpperCase();
        if (this.segundoApellido) this.segundoApellido = this.segundoApellido.toUpperCase();
        this.primerApellido = this.primerApellido.toUpperCase();

        this.nombreCompleto = this.primerNombre + " ";
        if (this.segundoNombre) this.nombreCompleto += this.segundoNombre + " ";
        this.nombreCompleto += this.primerApellido + " ";
        this.nombreCompleto += this.segundoApellido;

        this.mail = this.mail.toUpperCase();
        this.sexo = this.sexo.toUpperCase();
    }
}