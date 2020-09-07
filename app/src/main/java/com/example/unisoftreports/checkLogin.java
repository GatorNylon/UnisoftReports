package com.example.unisoftreports;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.*;

import android.view.View;
import android.widget.*;
import java.sql.*;

public class checkLogin
{
    String z = "";
    Boolean isSuccess = false;
    Connection con;

    public String loginMessage(String username , String password)
    {
        if(username.trim().equals("") || password.trim().equals(""))
        {
            z = "Please enter Username and Password";
        }
        else
        {
            try
            {
                con = connection.sqlConnection();        // Connect to database
                if (con == null)
                {
                    z = "Check Your Internet Access!";
                }
                else
                {
                    String query = "select * from USUARIOS where USUARIO= '" + username.toString() + "' and CLAVE = '"+ password.toString() +"' ";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    if(rs.next())
                    {
                        z = "Login successful";
                        isSuccess=true;
                        System.out.println(z);
                        con.close();
                    }
                    else
                    {
                        z = "Invalid Credentials!";
                        System.out.println(z);
                        isSuccess = false;
                    }
                }
            }
            catch (Exception ex)
            {
                isSuccess = false;
                z = ex.getMessage();
            }
        }
        return z;
    }
}
