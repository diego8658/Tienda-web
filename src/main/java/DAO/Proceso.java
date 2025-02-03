package DAO;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import modelo.Cambio;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

public class Proceso {
  public Cambio obtener(){
  Cambio cb=null;
  try{
      URL url=new URL("https://api.apis.net.pe/v1/tipo-cambio-sunat");
      HttpURLConnection con=(HttpURLConnection)url.openConnection();
      con.setRequestMethod("GET");
      con.connect();
      int code=con.getResponseCode();
      if(code!=200){
          throw new RuntimeException("error  "+code);
      }else{//esta correcto
        StringBuilder sg=new StringBuilder();
          Scanner sc=new Scanner(url.openStream());
          sg.append("[");
          while(sc.hasNext()){
              sg.append(sc.nextLine());
          }
          sg.append("]");
          sc.close();
          cb=new Cambio();
          JSONArray   jsa=new JSONArray(sg.toString());
          //leer la fila
          JSONObject obj= jsa.getJSONObject(0);
          cb.setCompra(obj.getDouble("compra"));
          cb.setVenta(obj.getDouble("venta"));
          cb.setOrigen(obj.getString("origen"));
          cb.setMoneda(obj.getString("moneda"));
          cb.setFecha(obj.getString("fecha"));
          System.out.println(""+cb.getCompra()+" "+cb.getVenta());
      }
  
  }catch(Exception ex){
      ex.printStackTrace();
  } 
  return cb;    
  }
    
}