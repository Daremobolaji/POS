/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppermarket;

/**
 *
 * @author OYEBANJI
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JLabel;

import javax.swing.JOptionPane;

public class Receipt implements Printable {
    
    
    
    
    private PrinterJob printerJob;
	private PageFormat pageFormat; 
	private Paper paper;
	
	private final int MARGIN = 1;
	
	public void PrintReceipt() {
		
		printerJob = PrinterJob.getPrinterJob();
		pageFormat = printerJob.defaultPage(); // Getting the page format.

		paper = new Paper(); // Create a new paper..
		
		// If you are working on printer rather than Thermal printers
		// then change the width and height accordingly.
		
		// I set them to 1000 value because that was for 
		// receipt which will not be larger than 1000 points
		// actually this height does not mean the height of 
		// paper get out from the printer, this is the height
		// of the printable area which you can use.
		int width = 216;
		int height = 1000;
		
		// width = totalWidthOfPage - (MARGIN * 2);
		// height = numberOfLines * 10 - (MARGIN * 2);
		
		paper.setImageableArea(MARGIN, MARGIN, width, height);
		pageFormat.setPaper(paper);
		
		pageFormat.setOrientation(PageFormat.PORTRAIT);
		printerJob.setPrintable(this, pageFormat);
		
		try {
                    
			
			printerJob.print();
                    
                  
                   String $sql="DELETE FROM receipt";
                  Connection con=Connect.connected();
                  Statement stmt=con.createStatement();
                  
                  stmt.executeUpdate($sql);
                   
                   
              
                  
                  con.close();
		
		} catch (PrinterException ex) {
                    
			
			JOptionPane.showMessageDialog(null, "Printing Failed, Error: "+ex.toString());
		
		}catch(SQLException e){
                
                } 
		
	}
	
        
        

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
          int   y=10;
    	if(pageIndex > 0) {
			return NO_SUCH_PAGE;
		}
		
		Graphics2D g2d = (Graphics2D) graphics;
		g2d.setColor(Color.black);
		
		
                
                
            
                
                
                
                
                
            int yShift = 10;
            int headerRectHeight=15;
            int headerRectHeighta=40;
            
            ///////////////// Product names Get ///////////
                            ///////////////// Product names Get ///////////
                
            
            ///////////////// Product price Get ///////////
                int pp1a=400;
                int pp2a=500;
                int pp3a=600;
                int pp4a=700;
                int sum=800;
            ///////////////// Product price Get ///////////
                
            g2d.setFont(new Font("Monospaced",Font.BOLD,15));
            g2d.drawString("*************************************",12,y);y+=yShift;
            g2d.drawString("OluwaSeun Super Store    ",12,y);y+=yShift;
            
             g2d.setFont(new Font("Monospaced",Font.BOLD,10));
            g2d.drawString("*************************************",12,y);y+=headerRectHeight;
      
            
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Items                  Price   ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;
            
            double total=0.0;
            String ftotal="";
            
              try{  
                String query = "SELECT * FROM receipt";
                
                
                
                
                Connection con=Connect.connected();
                
                 Statement stmt=con.createStatement();
        
         
         ResultSet rs = stmt.executeQuery(query);
         
         
         
          //update transaction table
          
          
          
          
          
                    
    NumberFormat nf1 = NumberFormat.getCurrencyInstance(Locale.CANADA);
   String pattern1=((DecimalFormat)nf1).toPattern();
   String newPattern1 = pattern1.replace("\u00A4","").trim();
   NumberFormat newFormat1=new DecimalFormat(newPattern1);
   ftotal=newFormat1.format(total);
          
          
         
          while(rs.next()){
              
               
             double price=rs.getInt("Price");
            
            
             total = total+price;
    
                
            // g2d.drawString(" "+rs.getString("Product_Name")+"     "+rs.getString("Price")+" ",10,y);y+=yShift;  
           g2d.drawString(" "+String.format("%-15s %14s",rs.getString("Product_Name"),newFormat1.format(price))+" ",10,y);y+=yShift;
            
             
   // NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
   //String pattern=((DecimalFormat)nf).toPattern();
 //  String newPattern = pattern.replace("\u00A4","").trim();
//   NumberFormat newFormat=new DecimalFormat(newPattern);
   ftotal=newFormat1.format(total);
          
          
          }
            con.close();    
              }catch(Exception e){
              
              
              }     
                
                
            
             Pos p = new Pos();
             //int total = p.getSum();
            
             DateFormat dForm =new SimpleDateFormat("dd/MM/yy HH:mm:ss");   
             Calendar date =Calendar.getInstance();    
          
             g2d.drawString("-------------------------------------",10,y);y+=yShift;
           //g2d.drawString(" Total amount:            N"+total+"   ",10,y);y+=yShift;
            g2d.drawString(String.format("%-15s %14s","Total amount:","N"+ftotal )+" ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
         g2d.drawString("Purchased Date:"+dForm.format(date.getTime())+"",10,y);y+=yShift;
             
            g2d.drawString("*************************************",10,y);y+=yShift;
            g2d.drawString("    Thanks for your  Patronage   ",10,y);y+=yShift;
            g2d.drawString("*************************************",10,y);y+=yShift;
             g2d.drawString("      Please Call again !!!     ",10,y);y+=yShift;
            
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                
                
              
		return PAGE_EXISTS;
               
	
	}


	
	public String spaces(int num) {
		
		String sp = "";
		for(int i = 0; i < num; i++)
			sp += " ";
		
		return sp;
                
                
                
	

}
    
    
  //delete receipt
        
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    

