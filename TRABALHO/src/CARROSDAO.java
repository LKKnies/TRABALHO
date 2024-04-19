import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
public class CARROSDAO {

    private String url="jdbc:sql.lite:TRABALHO.sql";

    private Connection conectar() throws SQLException{
        return DriverManager.getConnection(url);
    }

    public void adicionarCarro(CARROS CARROS) throws SQLException {
        String sql= "INSERT INTO CARROS (NOME, MARCA, ANO, COR) VALUES (?, ?, ?, ?)";
        try (Connection connection = conectar();
            PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setString(1, CARROS.getNOME());
            ps.setString(2, CARROS.getMARCA());
            ps.setInt(3, CARROS.getANO());
            ps.setString(4, CARROS.getCOR());
            ps.setString(5, CARROS.getVALOR());
            ps.executeUpdate();
        }
        catch (SQLException l){
            l.printStackTrace();
        }
    }

    public void atualizarCarro(CARROS CARROS) throws SQLException {
        String sql= "UPDATE CARROS SET VALOR = ?, NOME = ?, MARCA = ?, ANO = ?, COR = ?";
        try (Connection connection = conectar();
             PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setString(1, CARROS.getNOME());
            ps.setString(2, CARROS.getMARCA());
            ps.setInt(3, CARROS.getANO());
            ps.setString(4, CARROS.getCOR());
            ps.setString(5, CARROS.getVALOR());
            ps.executeUpdate();
        }
        catch (SQLException l){
            l.printStackTrace();
        }
    }

    public void excluirCarro(String NOME) throws SQLException {
        String sql= "DELETE FROM CARROS WHERE NOME = ?";
        try (Connection connection = conectar();
             PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setString(1, NOME);
            ps.executeUpdate();
        }
        catch (SQLException l){
            l.printStackTrace();
        }
    }

    public static List<CARROS> listarCarro() throws SQLException {
        List<CARROS> Carro = new ArrayList<>();
        String sql= "SELECT * FROM CARROS";
        try (Connection connection = conectar();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
                 while (resultSet.next()){
                     CARROS carro = new CARROS(
                             resultSet.getString("NOME"),
                             resultSet.getString("MARCA"),
                             resultSet.getInt("ANO"),
                             resultSet.getString("COR"),
                             resultSet.getString("VALOR")
                     );
                     Carro.add(carro);
                 }

        }
        catch (SQLException l){
            l.printStackTrace();
        }
        return Carro;
    }
}
