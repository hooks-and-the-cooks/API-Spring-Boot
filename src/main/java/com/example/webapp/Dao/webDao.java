package com.example.webapp.Dao;
import com.example.webapp.Model.webModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class webDao {
    String url = "jdbc:postgresql://localhost:5432/springproj";
    String username = "postgres";
    String password = "anshuman123";
    @Autowired
    public webModel web;
    List<webModel> webList = new ArrayList<>();
    public void addToDatabase(webModel WebModel) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            int id = WebModel.getId();
            String name = WebModel.getName();
            String email = WebModel.getEmail();
            PreparedStatement st = conn.prepareStatement("INSERT INTO dao values(?,?,?)");
            st.setInt(1, id);
            st.setString(2, name);
            st.setString(3, email);
            st.executeUpdate();
            System.out.println("##Added new entry##");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Not Found!");
        }
    }
    public webModel fetchFromDatabaseOnId(int id){
        boolean flag = false;
        try{
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement st = conn.prepareStatement("Select * from dao where id = ?");
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                this.web.setId(rs.getInt(1));
                this.web.setName(rs.getString(2));
                this.web.setEmail(rs.getString(3));
                flag = true;
            }
            System.out.println("##Fetch with id returned##");
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Not Found!");
        }
        if (flag == true)
            return web;
        else
            return null;
    }
    public List<webModel> fetchAll(){
        try{
            webList.removeAll(webList);
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement st = conn.prepareStatement("Select * from dao");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                web = new webModel();
                web.setId(rs.getInt(1));
                web.setName(rs.getString(2));
                web.setEmail(rs.getString(3));
                webList.add(web);
            }
            System.out.println("##All returned##");
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Not Found!");
        }
        return webList;
    }
    public void deleteFromDatabase(int id){
        try{
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement st = conn.prepareStatement("Delete from dao where id = ?");
            st.setInt(1,id);
            st.executeUpdate();
            System.out.println("##Deleted!##");
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Not Found!");
        }
    }
    public void updateExistingInDatabase(webModel WebModel){
        try{
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement st = conn.prepareStatement("UPDATE dao SET id = ? , name = ? , email = ? where id = ?");
            st.setInt(1,WebModel.getId());
            st.setString(2,WebModel.getName());
            st.setString(3,WebModel.getEmail());
            st.setInt(4,WebModel.getId());
            st.executeUpdate();
            System.out.println("##Updated!##");
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Not Found!");
        }
    }
}
