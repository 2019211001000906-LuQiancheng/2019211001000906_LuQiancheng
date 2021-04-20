package com.luqiancheng.dao;

import com.luqiancheng.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql = "insert into userdb.usertable(username,password,email,gender,birthdate) values(?,?,?,?,?);";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setString(3,user.getEmail());
        preparedStatement.setString(4,user.getGender());
        preparedStatement.setString(5,user.getBirthdate());
        int result = preparedStatement.executeUpdate();
        if (result > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql = "delete from userdb.usertable where id = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,user.getId());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql = "update userdb.usertable set username = ? and password = ? and email = ? and gender =? and birthdate = ? where id = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setString(3,user.getEmail());
        preparedStatement.setString(4,user.getGender());
        preparedStatement.setString(5,user.getBirthdate());
        preparedStatement.setInt(6,user.getId());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql ="select * from userdb.usertable where id = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultset = preparedStatement.executeQuery();
        User user = null;
        if (resultset.next()){
            user = new User();
            user.setId(resultset.getInt("id"));
            user.setUsername(resultset.getString("username"));
            user.setPassword(resultset.getString("password"));
            user.setEmail(resultset.getString("email"));
            user.setGender(resultset.getString("gender"));
            user.setBirthdate(resultset.getString("birthdate"));
        }

        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql ="select * from userdb.usertable where username = ? and password = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet resultset = preparedStatement.executeQuery();

        User user = null;
        if (resultset.next()){
            user = new User();
            user.setId(resultset.getInt("id"));
            user.setUsername(resultset.getString("username"));
            user.setPassword(resultset.getString("password"));
            user.setEmail(resultset.getString("email"));
            user.setGender(resultset.getString("gender"));
            user.setBirthdate(resultset.getString("birthdate"));

        }

        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql = "select * from userdb.usertable where username = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,username);
        ResultSet resultset = preparedStatement.executeQuery();
        List<User> userList = new ArrayList<>();
        User user = null;
        while (resultset.next()) {
            user = new User();
            user.setId(resultset.getInt("id"));
            user.setUsername(resultset.getString("username"));
            user.setPassword(resultset.getString("password"));
            user.setEmail(resultset.getString("email"));
            user.setGender(resultset.getString("gender"));
            user.setBirthdate(resultset.getString("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql = "select * from userdb.usertable where password = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,password);
        ResultSet resultset = preparedStatement.executeQuery();
        List<User> userList = new ArrayList<>();
        User user = null;
        while (resultset.next()) {
            user = new User();
            user.setId(resultset.getInt("id"));
            user.setUsername(resultset.getString("username"));
            user.setPassword(resultset.getString("password"));
            user.setEmail(resultset.getString("email"));
            user.setGender(resultset.getString("gender"));
            user.setBirthdate(resultset.getString("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql = "select * from userdb.usertable where email = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,email);
        ResultSet resultset = preparedStatement.executeQuery();
        List<User> userList = new ArrayList<>();
        User user = null;
        while (resultset.next()) {
            user = new User();
            user.setId(resultset.getInt("id"));
            user.setUsername(resultset.getString("username"));
            user.setPassword(resultset.getString("password"));
            user.setEmail(resultset.getString("email"));
            user.setGender(resultset.getString("gender"));
            user.setBirthdate(resultset.getString("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql = "select * from userdb.usertable where gender = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,gender);
        ResultSet resultset = preparedStatement.executeQuery();
        List<User> userList = new ArrayList<>();
        User user = null;
        while (resultset.next()) {
            user = new User();
            user.setId(resultset.getInt("id"));
            user.setUsername(resultset.getString("username"));
            user.setPassword(resultset.getString("password"));
            user.setEmail(resultset.getString("email"));
            user.setGender(resultset.getString("gender"));
            user.setBirthdate(resultset.getString("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByBirthdate(Connection con, String birthDate) throws SQLException {
        String sql = "select * from userdb.usertable where birthdate = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,birthDate);
        ResultSet resultset = preparedStatement.executeQuery();
        List<User> userList = new ArrayList<>();
        User user = null;
        while (resultset.next()) {
            user = new User();
            user.setId(resultset.getInt("id"));
            user.setUsername(resultset.getString("username"));
            user.setPassword(resultset.getString("password"));
            user.setEmail(resultset.getString("email"));
            user.setGender(resultset.getString("gender"));
            user.setBirthdate(resultset.getString("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "select * from userdb.usertable;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet resultset = preparedStatement.executeQuery();
        List<User> userList = new ArrayList<>();
        User user = null;
        while (resultset.next()) {
            user = new User();
            user.setId(resultset.getInt("id"));
            user.setUsername(resultset.getString("username"));
            user.setPassword(resultset.getString("password"));
            user.setEmail(resultset.getString("email"));
            user.setGender(resultset.getString("gender"));
            user.setBirthdate(resultset.getString("birthdate"));
            userList.add(user);
        }
        return userList;
    }
}
