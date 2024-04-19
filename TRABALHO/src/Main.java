import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {

        CARROSDAO carrosdao = new CARROSDAO();

        CARROS carros = new CARROS("CIVIC", "HONDA", 1998, "VERDE", "15000");
        carrosdao.adicionarCarro(carros);
        carrosdao.atualizarCarro(carros);
        List<CARROS> carros1 = CARROSDAO.listarCarro();
        carros1.forEach(System.out::println);

        CARROS carros2 = new CARROS("MUSTANG", "FORD", 2020, "PRETO", "1500000");
        carrosdao.adicionarCarro(carros2);
        carrosdao.atualizarCarro(carros2);
        List<CARROS> carros3 = CARROSDAO.listarCarro();
        carros3.forEach(System.out::println);

        CARROS carros4 = new CARROS("UNO", "FIAT", 2000, "BRANCO", "3000");
        carrosdao.adicionarCarro(carros4);
        carrosdao.atualizarCarro(carros4);
        List<CARROS> carros5 = CARROSDAO.listarCarro();
        carros5.forEach(System.out::println);

        CARROS carros6 = new CARROS("SANDERO", "RENAULT", 2015, "VERMELHO", "30000");
        carrosdao.adicionarCarro(carros6);
        carrosdao.atualizarCarro(carros6);
        List<CARROS> carros7 = CARROSDAO.listarCarro();
        carros7.forEach(System.out::println);
    }
}