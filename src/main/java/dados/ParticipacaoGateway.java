package dados;

import java.util.*;
import java.sql.*;
import java.util.Date;

public class ParticipacaoGateway {
    Connection conn = ConnectionFactory.getConnection();

    public List<Participacao> getAll() throws SQLException {
        List<Participacao> participacoes = new ArrayList<>();

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM participacoes");

        while (rs.next()) {
            Participacao participacao = new Participacao(
                    rs.getInt("codigo"),
                    new Projeto(rs.getInt("codigo_projeto")),
                    new Funcionario(rs.getString("cpf_funcionario")),
                    rs.getDate("data_entrada"),
                    rs.getDate("data_saida")
            );
            participacoes.add(participacao);
        }
        rs.close();

        return participacoes;
    }

    public void create(Integer codigo_projeto, String cpf_funcionario, Date data_entrada, Date data_saida) throws SQLException {
        String SQL_INSERT = "INSERT INTO participacoes (codigo_projeto, cpf_funcionario, data_entrada, data_saida)" +
                "VALUES (?, ?, ?, ?)";

        PreparedStatement pstm = conn.prepareStatement(SQL_INSERT);

        pstm.setInt(1, codigo_projeto);
        pstm.setString(2, cpf_funcionario);
        pstm.setDate(3, (java.sql.Date) data_entrada);
        pstm.setDate(4, (java.sql.Date) data_saida);

        pstm.execute();
        pstm.close();
    }

    public void update(Integer codigo_projeto, Integer codigo) throws SQLException {
        String SQL_UPDATE = "UPDATE participacoes SET codigo_projeto = ? WHERE codigo = ?";

        PreparedStatement pstm = conn.prepareStatement(SQL_UPDATE);

        pstm.setInt(1, codigo_projeto);
        pstm.setInt(2, codigo);

        pstm.executeUpdate();
        pstm.close();
    }

    public void delete(Integer codigo) throws SQLException {
        String SQL_DELETE = "DELETE FROM participacoes WHERE codigo = ?";

        PreparedStatement pstm = conn.prepareStatement(SQL_DELETE);

        pstm.setInt(1, codigo);

        pstm.executeUpdate();
        pstm.close();
    }
}
