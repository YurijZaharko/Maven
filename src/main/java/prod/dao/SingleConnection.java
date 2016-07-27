package prod.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by SCIP on 24.07.2016.
 */
public class SingleConnection {

    public static final SingleConnection INSTANCE = new SingleConnection();
    private Connection connection;

    private SingleConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/sys",
                    "root", "4820087");
        } catch (SQLException e) {
            System.out.println("Connection not established");
        }
 /**
        createAllTable();
        createRelationshipProductCategory();
        createRelationshipProductBrand();
        createRelationshipProductCountry();
*/
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
/**
    private void createTableProduct() throws SQLException {
        if (connection != null){
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS Product("
                + "id INT PRIMARY KEY auto_increment,"
                + "category_id INT, "
                + "price DOUBLE(7,2),"
                + "name_product VARCHAR(255),"
                + "part_number VARCHAR(255),"
                + "brand_id VARCHAR(255), "
                + "country_id VARCHAR(255))"
            );
            statement.close();
        }
    }

    private void createTableCategory() throws SQLException {
        if (connection != null){
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS Category("
               +"id INT PRIMARY KEY AUTO_INCREMENT,"
               +"category VARCHAR(255))"
            );
            statement.close();
        }
    }

    private void createTableBrand() throws SQLException {
        if (connection != null){
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS Brand("
                +"id INT PRIMARY KEY AUTO_INCREMENT,"
                +"brand VARCHAR(255))"
            );
            statement.close();
        }
    }

    private void createTableCountry() throws SQLException {
        if (connection != null){
            Statement statement = connection.createStatement();
            statement.execute("");
            statement.close();
        }
    }

    private void createAllTable(){
        try {
            createTableProduct();
            createTableCategory();
            createTableBrand();
            createTableCountry();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createRelationshipProductCategory(){
        if (connection != null){
            try {
                Statement statement = connection.createStatement();
                statement.execute("ALTER TABLE Product ADD CONSTRAINT" +
                        " fk_category_product FOREIGN KEY (idCategory) " +
                        "REFERENCES Country(id)");
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void createRelationshipProductBrand(){
        if (connection != null){
            try {
                Statement statement = connection.createStatement();
                statement.execute("ALTER TABLE Product ADD CONSTRAINT" +
                        " fk_brand_product FOREIGN KEY (idBrand) " +
                        "REFERENCES Brand(id)");
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void createRelationshipProductCountry(){
        if (connection != null){
            try {
                Statement statement = connection.createStatement();
                statement.execute("ALTER TABLE Product ADD CONSTRAINT " +
                        "fk_country_product FOREIGN KEY (idCountry) " +
                        "REFERENCES Country(id)");
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
 */
}
