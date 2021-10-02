import { Empleado } from './Empleado';
import {
    BeforeInsert,
    Column,
    Entity,
    JoinColumn,
    ManyToOne,
    OneToOne,
    PrimaryGeneratedColumn,
} from "typeorm";
import { Edificio } from './Edificio';

@Entity("MARCACION")
export class Marcacion{

    @PrimaryGeneratedColumn({name:"SECUENCIA"})
    secuencia: number;

    @Column({ name: "CODIGO_EMPLEADO" })
    codigoEmpleado: number;

    @Column({ name: "CODIGO_EDIFICIO" })
    codigoEdificio: number;

    @Column({ name: "FECHA_MARCACION" })
    fechaMarcacion: Date;

    @Column({ name: "HORA_MARCACION" })
    horaMarcacion: string;

    @Column({ name: "TIPO_MARCACION" })
    tipoMarcacion: string;

    @Column({ name: "USUARIO_REGISTRO" })
    usuarioRegistro: string;

    @Column({ name: "FECHA_REGISTRO" })
    fechaRegistro: Date;

    // @ManyToOne(
    //     () => Empleado,
    //     empleado => empleado.marcaciones,
    //     {onDelete: "CASCADE", 
    //     eager: true}
    // )
    // @JoinColumn({
    //     name: "CODIGO_EMPLEADO"
    // })
    // empleado: Empleado;

    // @ManyToOne(
    //     () => Edificio,
    //     edificio => edificio.marcaciones,
    //     {onDelete: "CASCADE", 
    //     eager: true}
    // )
    // @JoinColumn({
    //     name: "CODIGO_EDIFICIO"
    // })
    // edificio: Edificio;
    //fechaGmt = new Date(Date.UTC(96, 11, 1, 0, 0, 0));

    @BeforeInsert()
    beforeInsertActions() {
        
        this.usuarioRegistro = "VECSUS";
        this.fechaRegistro = new Date();
    }
}