package com.bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DatabaseConnection {
	/*public static MysqlDataSource getDataSource() throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        
        Properties properties = loadProperties();
        
        ds.setServerName(properties.getProperty("db.serverName"));
        ds.setPort(Integer.parseInt(properties.getProperty("db.port")));
        ds.setDatabaseName(properties.getProperty("db.databaseName"));
        ds.setUser(properties.getProperty("db.user"));
        ds.setPassword(properties.getProperty("db.password"));
        ds.setUseSSL(Boolean.parseBoolean(properties.getProperty("db.useSSL")));
        ds.setAllowPublicKeyRetrieval(Boolean.parseBoolean(properties.getProperty("db.allowPublicKeyRetrieval")));
        
        return ds;
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find db.properties");
                return null;
            }
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    } */
	
	
    /*private static Connection connection = null;

    public static Connection getConnection() {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");//static block of driver is called and register
			//System.out.println("type 4 driver of mysql is loaded into memory");
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/BankApplication?useSSL=false&allowPublicKeyRetrieval=true"
,"root","root");
			System.out.println("connection is "+connection);
			Statement stat=connection.createStatement();
    	}catch(ClassNotFoundException e){
    		e.printStackTrace();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }*/
	private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            Properties props = new Properties();
            try {
                props.load(new FileInputStream("src\\com\\bank\\db.properties"));
                String url = props.getProperty("url");
                String user = props.getProperty("user");
                String password = props.getProperty("password");
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connection is established: " + connection);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return connection;
        }
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static int getNextCustomerId() {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT MAX(CustomerId) FROM Customer";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int lastCustomerId = resultSet.getInt(1);
                return lastCustomerId + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Default to starting customer ID if there are no existing customers
        return 100;
    }
        public static void insertCustomer(Customer customer) {
            String sql = "INSERT INTO Customer (CustomerId,CustomerName, age, MobileNumber,PassportNumber, DOB) VALUES (?, ?, ?, ?, ?,?)";
            try (Connection connection = DatabaseConnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            	
            	 preparedStatement.setInt(1, customer.getCustomid());
                preparedStatement.setString(2, customer.getName());
                preparedStatement.setInt(3, customer.getAge());
                preparedStatement.setInt(4, customer.getMob_no());
                preparedStatement.setString(5, customer.getPassport_no());
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date dobUtil = dateFormat.parse(customer.getDob());

                // Convert java.util.Date to java.sql.Date
                java.sql.Date dobSql = new java.sql.Date(dobUtil.getTime());
                preparedStatement.setDate(6, dobSql);
               
                preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            	System.err.println("Error executing SQL query:");
                System.err.println("SQL Query: " + sql); // Print the SQL query
                e.printStackTrace();
            } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        public static void insertAccount(Account account, int customerId) {
            String sql = "INSERT INTO Account (CustomerId, account_number, bsb_code, bank_name, balance, opening_date, deposit_amount, tenure, account_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (Connection connection = DatabaseConnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, customerId);
                preparedStatement.setLong(2, account.getAccountNumber());
                preparedStatement.setLong(3, account.getBsbCode());
                preparedStatement.setString(4, account.getBankName());
                preparedStatement.setDouble(5, account.getBalance());
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date dobUtil = dateFormat.parse(account.getOpeningDate());

                // Convert java.util.Date to java.sql.Date
                java.sql.Date dobSql = new java.sql.Date(dobUtil.getTime());
                
                preparedStatement.setDate(6, dobSql);
                preparedStatement.setDouble(7, account instanceof FixedDepositAccount ? ((FixedDepositAccount) account).getDepositAmount() : 0);
                preparedStatement.setInt(8, account instanceof FixedDepositAccount ? ((FixedDepositAccount) account).getTenure() : 0);
                preparedStatement.setString(9, account instanceof SavingsAccount ? "Savings" : "Fixed Deposit");
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    
public static void displayCustomerDetails() {
    String sql = "SELECT * FROM Customer";
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sql);
         ResultSet resultSet = preparedStatement.executeQuery()) {

        System.out.println("Customer Details:");
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String mobileNumber = resultSet.getString(4);
            String passportNumber = resultSet.getString(5);
            String dob = resultSet.getString(6);

            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Mobile Number: " + mobileNumber);
            System.out.println("Passport Number: " + passportNumber);
            System.out.println("DOB: " + dob);
            System.out.println();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
