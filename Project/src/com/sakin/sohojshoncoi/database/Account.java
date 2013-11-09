package com.sakin.sohojshoncoi.database;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "accounts")
public class Account {
    
    @DatabaseField(generatedId = true)
    private int account_id;
    @DatabaseField
    private String name;
    @DatabaseField
    private double balance;
    @DatabaseField
    private double space_used;
    @DatabaseField(dataType = DataType.DATE_LONG)
    private Date expiry_date;
    
    public Account() {
        // ORMLite needs a no-arg constructor 
    }
    public Account(String name, double balance, double space_used) {
        this.name = name;
        this.balance = balance;
        this.space_used = space_used;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public double getSpaceUsed() {
        return space_used;
    }
    public void setSpaceUsed(double space_used) {
        this.space_used = space_used;
    }
    
    public Date getExpiryDate() {
        return expiry_date;
    }
    public void setExpiryDate(Date date) {
        this.expiry_date = date;
    }
}