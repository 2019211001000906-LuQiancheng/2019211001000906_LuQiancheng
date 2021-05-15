package com.luqiancheng.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private int categoryId;
    private String categoryName;
    private String description;
    private boolean active;

    public Category() {
    }

    public Category(int categoryId, String categoryName, String description, boolean active) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.active = active;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                '}';
    }

    public static List<Category> findAllCategory(Connection con) throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        Category category = null;
        String sql = "select * from userdb.category;";
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet resultSet = pt.executeQuery();
        if (resultSet.next()){
            category = new Category();
            category.setCategoryId(resultSet.getInt("CategoryId"));
            category.setCategoryName(resultSet.getString("CategoryName"));
            category.setDescription(resultSet.getString("Description"));
            categoryList.add(category);
        }
        return categoryList;
    }

    public static String findByCategoryId(int categoryId , Connection con) throws SQLException {
        String sql = "select * from userdb.category where CategoryId = ?;";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,categoryId);
        ResultSet resultSet = pt.executeQuery();
        String categoryName = null;
        if (resultSet.next()){
            categoryName = resultSet.getString("CategoryName");

        }
        return categoryName;
    }
}
