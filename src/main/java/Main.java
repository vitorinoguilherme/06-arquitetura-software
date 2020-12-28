import dados.*;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        /*------------------- DEPARTAMENTOS -------------------*/
        DepartamentoGateway dg = new DepartamentoGateway();

        for (Departamento departamento : dg.getAll()) {
            System.out.println(departamento);
        }

        System.out.println("----------------------");
        dg.update(4, "Recursos Humanos", "RH");
        dg.delete(6);
        System.out.println("----------------------");

        for (Departamento departamento : dg.getAll()) {
            System.out.println(departamento);
        }
        System.out.println("----------------------");

        /*-------------------- FUNCIONARIOS --------------------*/
        FuncionarioGateway fg = new FuncionarioGateway();

        for (Funcionario funcionario : fg.getAll()) {
            System.out.println(funcionario);
        }

        System.out.println("----------------------");
        //gifg.create("65384986064", "Bruce Wayne", "bruce@gmail.com", 2);
        fg.update("65384986064", "Batman", "batman@gmail.com");
        System.out.println("----------------------");

        for (Funcionario funcionario : fg.getAll()) {
            System.out.println(funcionario);
        }

        System.out.println("----------------------");

        /*--------------------   PROJETOS   --------------------*/
        ProjetoGateway pg = new ProjetoGateway();

        for (Projeto projeto: pg.getAll()) {
            System.out.println(projeto);
        }
        System.out.println("----------------------");

        /*-------------------- PARTICIPACOES -------------------*/
        ParticipacaoGateway ptg = new ParticipacaoGateway();

        for (Participacao participacao: ptg.getAll()) {
            System.out.println(participacao);
        }

    }
}
