package org.example;

import java.sql.*;
import java.util.HashMap;

public class PersonDAO implements AutoCloseable{

    private final Connection connection;

    public PersonDAO(){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        connection = databaseConnection.getConnection();
    }

    public void addPerson(Person person) {
        String sql = "INSERT INTO person (name, age) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Person getPersonById(int id){
        String sql = "select id, name, age from person where id = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Person person = new Person();
                        person.setId(resultSet.getInt("id"));
                        person.setName(resultSet.getString("name"));
                        person.setAge(resultSet.getInt("age"));
                        return person;
                    }
                }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteById(int id){
        String sql = "delete from person where id = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Person person, int id){
        String sql = "update person set name = ?, age = ? where id = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Integer, Person> getAll() throws SQLException {
        String sql = "select * from person";
        PreparedStatement statement = connection.prepareStatement(sql);
        try (ResultSet resultSet = statement.executeQuery()) {
            HashMap<Integer, Person> hashMap = new HashMap<>();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                hashMap.put(resultSet.getInt("id"), person);
            }
            return hashMap;
        }catch (SQLException e){
            throw new SQLException("Error");
        }
    }

    @Override
    public void close() throws Exception {
        if(connection != null){
            connection.close();
        }
    }
}
