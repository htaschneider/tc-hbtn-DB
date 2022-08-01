import java.sql.*;

public class ClienteDAOImpl implements ClienteDAO {
    private Statement createStatement(Connection connection) {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Connection connect(String urlConexao) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(urlConexao);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    @Override
    public void createTable(String urlConexao) {
        String sql = "CREATE TABLE IF NOT EXISTS cliente (id INTEGER PRIMARY KEY, nome TEXT, idade INTEGER, cpf TEXT, rg TEXT)";
        try (Connection connection = connect(urlConexao)) {
            try (Statement statement = createStatement(connection)) {
                if (statement != null) {

                    statement.execute(sql);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectAll(String urlConexao) {
        try (Connection connection = connect(urlConexao)) {
            String sql = "SELECT * FROM CLIENTE";

            try (Statement statement = createStatement(connection)) {
                if (statement != null) {
                    statement.executeQuery(sql);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String urlConexao, int id) {
        try (Connection connection = connect(urlConexao)) {
            String sql = "DELETE FROM CLIENTE WHERE ID = (?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(String urlConexao, Cliente cliente) {
        try (Connection connection = connect(urlConexao)) {
            String sql = "INSERT INTO CLIENTE (nome, idade, cpf, rg) VALUES (?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, cliente.getNome());
                preparedStatement.setInt(2, cliente.getIdade());
                preparedStatement.setString(3, cliente.getCpf());
                preparedStatement.setString(4, cliente.getRg());

                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String urlConexao, int id, String name, Integer idade) {
        try (Connection connection = connect(urlConexao)) {
            String sql = "UPDATE CLIENTE SET nome = (?), idade = (?) WHERE id = (?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, idade);
                preparedStatement.setInt(3, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}