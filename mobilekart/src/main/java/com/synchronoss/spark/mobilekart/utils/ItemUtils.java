package com.synchronoss.spark.mobilekart.utils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.synchronoss.spark.mobilekart.model.Item;
import com.synchronoss.spark.mobilekart.service.DatabaseService;

public class ItemUtils {

  public ItemUtils() {}
  Connection con = null;
  List<Item> items =null;
  
  private Statement getStatement(){
    Statement stmt=null;
    try {
      con = DatabaseService.getconnection();
      if(con !=null){
          stmt =con.createStatement();
         } 
      return stmt;
    }catch (SQLException e) {
          e.printStackTrace();
        }
    return stmt;
    
  }

  public List<Item> getAllProducts(){
    try {
      items = new ArrayList<Item>();
      Item item;
      ResultSet rs =null;
          Statement stmt =getStatement();
          if(stmt!=null){ rs=stmt.executeQuery("select * from ITEMS"); }
          
          if(rs!=null){
            while (rs.next()) {
              item = new Item();
              item.setBarcodeId(rs.getLong("barcode_Id"));
              item.setName(rs.getString("product_name"));
              item.setPrice(rs.getDouble("price"));
              item.setDiscountedPrice(rs.getDouble("discounted_price"));
              item.setQuantity(rs.getInt("quantity"));
              items.add(item);
              
          }
            rs.close();
          }       
         
       
      
    }catch (SQLException e) {
          e.printStackTrace();
        }finally{
          if(con!=null)
          {
            try {
              con.close();
            } catch (SQLException e) {
              
              e.printStackTrace();
            }
          }
          
        }
    return items;
}
  
  public Item getProduct(long barcodeId){
    Item item = new Item();
    ResultSet rs =null;
    try {
    Statement stmt= getStatement();
    rs = stmt!=null ? stmt.executeQuery("select * from ITEMS where barcode_id='"+barcodeId+"'"):null;
    if (rs!=null){
      while (rs.next()) {
      
        item.setBarcodeId(rs.getLong("barcode_Id"));
        item.setName(rs.getString("product_name"));
        item.setPrice(rs.getDouble("price"));
        item.setDiscountedPrice(rs.getDouble("discounted_price"));
        item.setQuantity(rs.getInt("quantity"));
      } }
    }catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }finally{
        if(con!=null)
        {
          try {
            con.close();
            rs.close();
          } catch (SQLException e) {
            
            e.printStackTrace();
          }
        }
        
      }
    
    return item ;
    
  }

   public boolean addProduct(Item item){
     int count=0;
     try {
       con = DatabaseService.getconnection();
       if(con !=null){
         Statement  stmt =con.createStatement();
    
      if(stmt!=null){
         count =stmt.executeUpdate("INSERT INTO ITEMS (barcode_Id,product_name,price,discounted_price,quantity) VALUES ('"+item.getBarcodeId()+"','"+item.getName()+"',"+item.getPrice()+","+item.getDiscountedPrice()+","+item.getQuantity()+")");  
      }
       }
       }catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
         }finally{
           if(con!=null)
           {
             try {
               con.close();
             } catch (SQLException e) {
               
               e.printStackTrace();
             }
           }
           
         }
     if (count>0){
       return true;
     }
     else 
      return false;
   }
   
   
   public boolean updateProduct(Item item){
     int count=0;
     try {
       con = DatabaseService.getconnection();
       if(con !=null){
         Statement  stmt =con.createStatement();
    
      if(stmt!=null){
         stmt.executeUpdate("DELETE from ITEMS where barcode_id='"+item.getBarcodeId()+"'");
         count =stmt.executeUpdate("INSERT INTO ITEMS (barcode_Id,product_name,price,discounted_price,quantity) VALUES ('"+item.getBarcodeId()+"','"+item.getName()+"',"+item.getPrice()+","+item.getDiscountedPrice()+","+item.getQuantity()+")");  
      }
       }
       }catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
         }finally{
           if(con!=null)
           {
             try {
               con.close();
             } catch (SQLException e) {
               
               e.printStackTrace();
             }
           }
           
         }
     if (count>0){
       return true;
     }
     else 
      return false;
   }
   
   public String removeProduct(long barcodeId){
     int count=0;
     Item item= new Item();
     ResultSet rs =null;
     try {
       con = DatabaseService.getconnection();
       if(con !=null){
         Statement  stmt =con.createStatement();
         rs = stmt!=null ? stmt.executeQuery("select * from ITEMS where barcode_id='"+barcodeId+"'"):null;
         if (rs!=null){
           while (rs.next()) {
           
             item.setBarcodeId(rs.getLong("barcode_Id"));
             item.setName(rs.getString("product_name"));
             item.setPrice(rs.getDouble("price"));
             item.setDiscountedPrice(rs.getDouble("discounted_price"));
             item.setQuantity(rs.getInt("quantity"));
           } }
    
      if(stmt!=null){
           
         count =  stmt.executeUpdate("DELETE from ITEMS where barcode_id='"+barcodeId+"'");
      }
       }
       }catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
         }finally{
           if(con!=null)
           {
             try {
               con.close();
               rs.close();
             } catch (SQLException e) {
               
               e.printStackTrace();
             }
           }
           
         }
     if (count>0){
       return "Product is removed :"+item.getBarcodeId()+" :"+item.getName();
     }
     else 
     return "Product is  not removed";
   }
   
   
  }


