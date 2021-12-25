package com.example.springboot.repository;

import com.example.springboot.model.Data;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Repository
public class DataRepository implements IDataRepository{
    private Statement statement;

    public DataRepository(){
        try {
            Properties properties = new Properties();
            properties.load(DataRepository.class.getClassLoader().getResourceAsStream("application.properties"));

            String connectionString = properties.getProperty("spring.datasource.url");
            String username = properties.getProperty("spring.datasource.username");
            String password = properties.getProperty("spring.datasource.password");

            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(connectionString, username, password);
            statement = connection.createStatement();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public List<Data> getall (){
        List<Data> resultl = new ArrayList<>();
        try {
<<<<<<< Updated upstream
            String query = "SELECT * " +
=======
            String query = "SELECT u.id,u.first_name,u.last_name,u.email, p.privilagename,p.discount" +
>>>>>>> Stashed changes
                    " from users as u join privilages as p on u.privilageid = p.id";
            var result = statement.executeQuery(query);

            while (result.next()) {

                Data dataObj = new Data();
                dataObj.id = Integer.parseInt(result.getString("id"));
                dataObj.first_name = result.getString("first_name");
                dataObj.last_name = result.getString("last_name");
                dataObj.email = result.getString("email");
<<<<<<< Updated upstream
                dataObj.privilageid = result.getString("privilageid");
=======
>>>>>>> Stashed changes
                dataObj.privilagename = result.getString("privilagename");
                dataObj.discount = Integer.parseInt(result.getString("discount"));

                resultl.add(dataObj);
            }
            return resultl;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return resultl;
    }

    public Data get(int id) {
        try {
            String query = "SELECT u.id,u.first_name,u.last_name,u.email, p.privilagename,p.discount" +
                    " from users as u join privilages as p on u.privilageid = p.id where u.id = '" + id + "'";
            var result = statement.executeQuery(query);
            result.next();

            Data dataObj = new Data();
            dataObj.id = Integer.parseInt(result.getString("id"));
            dataObj.first_name = result.getString("first_name");
            dataObj.last_name = result.getString("last_name");
            dataObj.email = result.getString("email");
            dataObj.privilagename = result.getString("privilagename");
            dataObj.discount = Integer.parseInt(result.getString("discount"));

            return dataObj;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public String insert(Data data){
        try{
            String query = "INSERT INTO users(first_name, last_name,email,privilageid) " +
                    "VALUES('" + data.first_name + "', '" + data.last_name + "','"+ data.email +"','"
                    + data.privilageid +"')";
            statement.executeUpdate(query);
            return "Пользователь создан!"   ;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return "Пользователь не создан!";
    }

    public Data update(Data data){
        try{
            String query = "UPDATE users SET " +
                    "first_name = '" + data.first_name + "'," +
                    "last_name = '" + data.last_name + "'," +
                    "email = '" + data.email + "'," +
                    "privilageid = '" + data.privilageid +
                    "' WHERE id = '" + data.id + "'";
            statement.executeUpdate(query);
            return data;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public int delete(int id){
        try{
            String query = "DELETE FROM users WHERE id = '" + id + "'";
            statement.executeUpdate(query);
            return id;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return 0;
    }
}
