/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huellero;

/**
* @librerias importadas
* @author: Napster2011
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBD {
/**
*    @atributos
*    @author: Napster2011
*  @access: public
public  String puerto="8080";
public  String nomservidor="localhost";
public  String db="huellas";
public  String user="root";
public  String pass="";
Connection conn=null;
*/
public  String puerto="8080";
public  String nomservidor="10.25.30.60";
public  String db="dbsalud_as";
public  String user="apperp";
public  String pass="sql123";
Connection conn=null;

/**
*    @function: conectar
*    @author: Napster2011
*  @description: esta funcion se encarga de conectar la base de datos con el servidor
*  @access: public
*  @return
*/
public Connection conectar(){
try{
    String ruta="jdbc:mysql://";
    String servidor=nomservidor+"/";
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection(ruta+servidor+db,user,pass);
    if (conn!=null)
    {
        System.out.println("Conección a base de datos listo…");
    }
    else {
        throw new SQLException();
    }
}
catch(SQLException e){
    JOptionPane.showMessageDialog(null, e.getMessage());
}
catch (ClassNotFoundException e) {
JOptionPane.showMessageDialog(null, "Se produjo el siguiente error: "+e.getMessage());
}
catch (NullPointerException e){
JOptionPane.showMessageDialog(null, "Se produjo el siguiente error: "+e.getMessage());
}
finally{
return conn;
}
}

/**
*    @function: desconectar
*    @author: Napster2011
*  @description: esta funcion se encarga de realizar la desconexion de la base de datos con el servidor
*  @access: public
*  @return
*/
public void desconectar(){
conn = null;
System.out.println("Desconexion a base de datos listo…");
}
}