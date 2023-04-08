/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppermarket;

import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JFrame;

/**
 *
 * @author OYEBANJI
 */
public class Suppermarket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   
    Login login=new Login();
    login.setVisible(true);
    login.setResizable(false);
    
   
   /* 
    DateFormat dForm =new SimpleDateFormat("dd/MM/yy HH:mm:ss");   
   Calendar date =Calendar.getInstance(); 

    System.out.println(dForm.format(date.getTime()));
    

   Double  num=5000000.206777;
    NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
   String pattern=((DecimalFormat)nf).toPattern();
   String newPattern = pattern.replace("\u00A4","").trim();
   NumberFormat newFormat=new DecimalFormat(newPattern);
   
 */
  
    
    
    
    }

}
    
