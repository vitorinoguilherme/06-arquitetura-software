package dados;

import java.util.Date;

public class Participacao {
    private Integer codigo;
    private Projeto projeto;
    private Funcionario funcionario;
    private Date data_entrada;
    private Date data_saida;

    public Participacao(Integer codigo, Projeto projeto, Funcionario funcionario,
                        Date data_entrada, Date data_saida) {
        this.setCodigo(codigo);
        this.projeto = projeto;
        this.funcionario = funcionario;

        this.setData_entrada(data_entrada);
        this.data_saida = data_saida;
    }

    public void setCodigo(Integer codigo) {
        if (codigo == null) {
            throw new IllegalArgumentException("Codigo invalido.");
        }
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }


    public void setData_entrada(Date data_entrada) {
        if (data_entrada == null) {
            throw new IllegalArgumentException("Data Entrada invalida.");
        }
        this.data_entrada = data_entrada;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_saida(Date data_saida) {
        if (data_saida == null) {
            throw new IllegalArgumentException("Data Saída invalida.");
        }
        this.data_saida = data_saida;
    }

    public Date getData_saida() {
        return data_saida;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + ", Codigo_Projeto: " + projeto.getCodigo() + ",\n" +
                "CPF_funcionario: " + funcionario.getCPF() + ", \n" +
                "Data_Entrada: " + data_entrada + ", Data_Saida: " + data_saida + "\n";
    }
}
