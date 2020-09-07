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

public class connection {

    public static Connection sqlConnection()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        //String ConnectionURL = null;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            Data datum = new Data();
            //ConnectionURL = "jdbc:jtds:sqlserver://SQL5026.site4now.net;database=DB_A0C996_unisoft;user=DB_A0C996_unisoft_admin;password=Pa55word";

            connection = DriverManager.getConnection(connectionBuilder(datum.getDataSource()
                            , datum.getDBName(), datum.getUsername(), datum.getPassword()));
        }
        catch (SQLException se)
        {
            Log.e("error here 1 : ", se.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            Log.e("error here 2 : ", e.getMessage());
        }
        catch (Exception e)
        {
            Log.e("error here 3 : ", e.getMessage());
        }
        return connection;
    }

    private static String connectionBuilder(String dataSource , String DBName , String username, String password)
    {
        String cnxnString = "jdbc:jtds:sqlserver://" + dataSource + ";database=" + DBName + ";user=" + username
                + ";password=" + password;
        return cnxnString;
    }
}
