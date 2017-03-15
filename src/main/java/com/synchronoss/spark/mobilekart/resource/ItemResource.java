package com.synchronoss.spark.mobilekart.resource;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.synchronoss.spark.mobilekart.model.Item;
import com.synchronoss.spark.mobilekart.utils.ItemUtils;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemResource {
  
  ItemUtils itemUtils =new ItemUtils();
	
	@GET
	public List<Item> getItems()
	{
		return itemUtils.getAllProducts();
	}
	
	@GET
	@Path("/{barcodeId}")
	public Item getItem(@PathParam("barcodeId") long barcodeId){
	  
		return itemUtils.getProduct(barcodeId);
	}
	
	@POST
	public String addItem(Item item){
	  
	  boolean added = itemUtils.addProduct(item);
	  
	  if(added)
	  return "Product is added";
	  else 
	    return "Not able to added ";
	}
	
	@PUT
   public String updateItem(Item item){
    
    boolean added = itemUtils.updateProduct(item);
    
    if(added)
    return "Product is Updated";
    else 
      return "Not able to update";
  }
	 
	@DELETE
	@Path("/{barcodeId}")
   public String deleteItem(@PathParam("barcodeId") long barcodeId){
    
    return itemUtils.removeProduct(barcodeId);
    
  
  }
	
   
	
 
}
