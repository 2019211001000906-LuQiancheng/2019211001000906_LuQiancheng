package com.luqiancheng.dao;


import com.luqiancheng.model.Product;
import com.luqiancheng.model.User;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into userdb.product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        int n = 0;
        String sql = "delete from userdb.product where ProductId = ?;";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,productId);
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }

    @Override
    public int update(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "update userdb.product set ProductName = ?,ProductDescription = ?,Picture = ?,price = ?,CategoryID = ? where ProductId = ?;";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            //pt.setBinaryStream(3, product.getPicture());
            //for mysql
            pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        pt.setInt(6,product.getProductId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        Product product = null;
        String sql = "select * from userdb.product where ProductId = ?;";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet resultSet = pt.executeQuery();
        if (resultSet.next()){
            product = new Product(resultSet.getInt("ProductId"),resultSet.getInt("CategoryId"),resultSet.getString("ProductName"),resultSet.getString("ProductDescription"),resultSet.getBinaryStream("picture"),resultSet.getDouble("price"));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<>();
        Product product = null;
        String sql = "select * from userdb.product where CategoryId = ?;";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,categoryId);
        ResultSet resultSet = pt.executeQuery();
        if (resultSet.next()){
            product = new Product(resultSet.getInt("ProductId"),resultSet.getInt("CategoryId"),resultSet.getString("ProductName"),resultSet.getString("ProductDescription"),resultSet.getBinaryStream("picture"),resultSet.getDouble("price"));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<>();
        Product product = null;
        String sql = "select * from userdb.product where price >= ? and price <= ?;";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setDouble(1,minPrice);
        pt.setDouble(2,maxPrice);
        ResultSet resultSet = pt.executeQuery();
        if (resultSet.next()){
            product = new Product(resultSet.getInt("ProductId"),resultSet.getInt("CategoryId"),resultSet.getString("ProductName"),resultSet.getString("ProductDescription"),resultSet.getBinaryStream("picture"),resultSet.getDouble("price"));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> productList = new ArrayList<>();
        Product product = null;
        String sql = "select * from userdb.product;";
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet resultSet = pt.executeQuery();
        if (resultSet.next()){
            product = new Product(resultSet.getInt("ProductId"),resultSet.getInt("CategoryId"),resultSet.getString("ProductName"),resultSet.getString("ProductDescription"),resultSet.getBinaryStream("picture"),resultSet.getDouble("price"));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<>();
        Product product = null;
        String sql = "select * from userdb.product where ProductName = ?;";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1,productName);
        ResultSet resultSet = pt.executeQuery();
        if (resultSet.next()){
            product = new Product(resultSet.getInt("ProductId"),resultSet.getInt("CategoryId"),resultSet.getString("ProductName"),resultSet.getString("ProductDescription"),resultSet.getBinaryStream("picture"),resultSet.getDouble("price"));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<>();
        Product product = null;
        String sql = "select * from userdb.product where ProductId = ?;";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet resultSet = pt.executeQuery();
        if (resultSet.next()){
            product = new Product(resultSet.getInt("ProductId"),resultSet.getInt("CategoryId"),resultSet.getString("ProductName"),resultSet.getString("ProductDescription"),resultSet.getBinaryStream("picture"),resultSet.getDouble("price"));
            productList.add(product);
        }
        return productList;
    }
}
