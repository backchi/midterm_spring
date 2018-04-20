package kr.ac.jejunu;public class JdbcContext{private final javax.sql.DataSource dataSource;	public JdbcContext()	{	}private kr.ac.jejunu.Product JdbcContextForGet(kr.ac.jejunu.StatementStrategy statementStrategy) throws java.sql.SQLException {
        java.sql.Connection connection = null;
        java.sql.PreparedStatement preparedStatement = null;
        java.sql.ResultSet resultSet = null;
        kr.ac.jejunu.Product product = null;
        try {
            connection = dataSource.getConnection();

            preparedStatement = statementStrategy.makePreparedStatement(connection);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = new kr.ac.jejunu.Product();
                product.setId(resultSet.getLong("id"));
                product.setTitle(resultSet.getString("title"));
                product.setPrice(resultSet.getInt("price"));
            }
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (java.sql.SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (java.sql.SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (java.sql.SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return product;
    }private java.lang.Long JdbcContextForInsert(kr.ac.jejunu.StatementStrategy statementStrategy) throws java.sql.SQLException {
        java.sql.Connection connection = null;
        java.sql.PreparedStatement preparedStatement = null;
        java.sql.ResultSet resultSet = null;
        java.lang.Long id;
        try {
            connection = dataSource.getConnection();

            preparedStatement = statementStrategy.makePreparedStatement(connection);

            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            id = resultSet.getLong(1);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (java.sql.SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (java.sql.SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (java.sql.SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return id;
    }private void JdbcContextForUpdate(kr.ac.jejunu.StatementStrategy statementStrategy) throws java.sql.SQLException {
        java.sql.Connection connection = null;
        java.sql.PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();

            preparedStatement = statementStrategy.makePreparedStatement(connection);

            preparedStatement.executeUpdate();

        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (java.sql.SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (java.sql.SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }}