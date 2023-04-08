/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppermarket;

import javax.swing.JLabel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextListener;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author OYEBANJI
 */
public class Pos extends javax.swing.JFrame implements TextListener {

    /**
     * Creates new form
     */
    
    public  Pos() {
        initComponents();
        textField1.requestFocus();
      Double  t=total();
      
       NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
   String pattern=((DecimalFormat)nf).toPattern();
   String newPattern = pattern.replace("\u00A4","").trim();
   NumberFormat newFormat=new DecimalFormat(newPattern);
   String s=newFormat.format(t);
   sales.setText("NGN "+String.valueOf(s));
     
   
   transactionHistory();
   
   
   
   
  
    }
    
    
    
    public void transactionHistory(){
    
    trans.setText("**********************RECENT TRANSACTIONS***************\n");
    trans.append(String.format("%-15s %15s %25s %25s","Product Name","Product Code","Price","Purchase Date"+"\n"));
   //TEXTAREA
   DateFormat dForm =new SimpleDateFormat("dd/MM/yy");   
                    Calendar date =Calendar.getInstance();
                    String d = dForm.format(date.getTime()); 
   try{
     Connection con=Connect.connected();   
     String qry="SELECT * FROM transaction WHERE date='"+d+"'";    
     Statement stmt1=con.createStatement();
     ResultSet rs = stmt1.executeQuery(qry);
     
  
   while(rs.next()){
   
    String pid = rs.getString("product_code");
    String pd = rs.getString("Product_Name");
     String dat = rs.getString("date");
      String price = rs.getString("price");
      
      trans.append(String.format("%-15s %20s %30s %35s",pd,pid,price,dat+"\n"));
   
   }   
   
   }catch(Exception e){
   
   
   
   
            }
    
    
    
    }
    
    public void getSum(){
    
    double sum = 0;

      
  
for(int i = 0; i<purchaseTable.getRowCount();i++){
    
    String f =purchaseTable.getValueAt(i,3).toString();
    String rf =f.replace(",","");
    sum=sum + Double.parseDouble(rf);  
     
    
}

 NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
   String pattern=((DecimalFormat)nf).toPattern();
   String newPattern = pattern.replace("\u00A4","").trim();
   NumberFormat newFormat=new DecimalFormat(newPattern);
  String fsum= newFormat.format(sum);
    
//totalBuy.setText(Double.toString(fsum));
totalBuy.setText("NGN"+String.valueOf(fsum));

}
    
    
    
    
    

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        trans = new javax.swing.JTextArea();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        sales = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        purchaseTable = new javax.swing.JTable();
        t = new java.awt.Label();
        totalBuy = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        textField1 = new java.awt.TextField();
        delete = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar2.setRollover(true);

        trans.setEditable(false);
        trans.setColumns(20);
        trans.setRows(5);
        jScrollPane2.setViewportView(trans);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );

        jToggleButton1.setBackground(new java.awt.Color(0, 204, 51));
        jToggleButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("Sales History");

        jToggleButton2.setBackground(new java.awt.Color(255, 0, 0));
        jToggleButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setText("Total Sales");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        sales.setBackground(new java.awt.Color(255, 255, 255));
        sales.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        sales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sales.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        purchaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S/N", "Product Code", "Product Name", "Price", ""
            }
        ));
        jScrollPane3.setViewportView(purchaseTable);
        if (purchaseTable.getColumnModel().getColumnCount() > 0) {
            purchaseTable.getColumnModel().getColumn(0).setMinWidth(100);
            purchaseTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            purchaseTable.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        t.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        t.setText("Total :");

        totalBuy.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 153, 52));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Purchase");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(689, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalBuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 448, Short.MAX_VALUE))
        );

        t.getAccessibleContext().setAccessibleName("Total");

        textField1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        textField1.addTextListener(this);

        delete.setBackground(new java.awt.Color(204, 0, 0));
        delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Dashboard");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(sales, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sales, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(delete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(820, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void reset(){
    
        totalBuy.setText("");
        DefaultTableModel model =(DefaultTableModel) purchaseTable.getModel();
        model.setRowCount(0);
    
    }
    
    
    
    
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
           
        DefaultTableModel model =(DefaultTableModel) purchaseTable.getModel();

try{
   int SelectedRowIndex = purchaseTable.getSelectedRow();
   int value = Integer.parseInt(model.getValueAt(SelectedRowIndex,0).toString());
   model.removeRow(SelectedRowIndex);
   getSum();
   
   



String query="DELETE FROM receipt WHERE prodID='"+value+"' ";
String query2="DELETE FROM transaction WHERE prodID='"+value+"' ";

        Connection con=Connect.connected();
        
        // PreparedStatement stmt = con.prepareStatement(query);
        // stmt.setString(1,textField1.getText());
        
        Statement stmt=con.createStatement();
        Statement stmt2=con.createStatement();
        
         
        
        stmt.executeUpdate(query);
        stmt2.executeUpdate(query2);
         
          double t =total();
          
           NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
   String pattern=((DecimalFormat)nf).toPattern();
   String newPattern = pattern.replace("\u00A4","").trim();
   NumberFormat newFormat=new DecimalFormat(newPattern);
   String ft= newFormat.format(t);
    
          
         sales.setText("NGN"+String.valueOf(ft));
          
        con.close();


   }catch(Exception ex){
      
     JOptionPane.showMessageDialog(null,ex);

  }





    }//GEN-LAST:event_deleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        Receipt print = new Receipt();
        print.PrintReceipt();
                this.reset();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Landing L =new Landing();
        L.setVisible(true);
        L.setResizable(false);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 Pos p = new Pos();
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 
                 p.setVisible(true); 
                
            }
        });
        
        
     
    }
    
    
     public double total(){
           double sum=0;
      DateFormat dForm =new SimpleDateFormat("dd/MM/yy");   
                    Calendar date =Calendar.getInstance();
                    String d = dForm.format(date.getTime());
        try{
                       Connection con=Connect.connected();   
                   String qry="SELECT price FROM transaction WHERE date='"+d+"'";    
                    Statement stmt1=con.createStatement();
                   ResultSet rs = stmt1.executeQuery(qry);
  
                 
                  
                  
                 
                  while(rs.next()){
                  
                  sum = sum+rs.getDouble("price");
                  
                  }
                  // int t =total();
           NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
   String pattern=((DecimalFormat)nf).toPattern();
   String newPattern = pattern.replace("\u00A4","").trim();
   NumberFormat newFormat=new DecimalFormat(newPattern);
   newFormat.format(sum);
    
        sales.setText("N"+String.valueOf(sum));  
        }catch(SQLException e){
                       
     
     }
      return sum;  
   }
    
    public void textValueChanged(TextEvent te)
{
   // String codecontroll = textField1.getText();
    transactionHistory();
    
     try{
         
           DateFormat dForm =new SimpleDateFormat("dd/MM/yy");   
           Calendar date =Calendar.getInstance();
          String d = dForm.format(date.getTime());
    
        String codecontroll=textField1.getText();
         Connection con=Connect.connected();
         String query = "SELECT * FROM products WHERE product_code = '"+codecontroll+"'";
        // PreparedStatement stmt = con.prepareStatement(query);
        // stmt.setString(1,textField1.getText());
         String query2 ="INSERT INTO receipt(prodID,product_code,Product_Name,price)VALUES(?,?,?,?) ";
         String query3 ="INSERT INTO transaction(prodID,product_code,Product_Name,date,price)VALUES(?,?,?,?,?) ";
         
         //format price
         
       
        Statement stmt=con.createStatement();
        
         ResultSet rs = stmt.executeQuery(query);
         
    NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
   String pattern=((DecimalFormat)nf).toPattern();
   String newPattern = pattern.replace("\u00A4","").trim();
   NumberFormat newFormatt=new DecimalFormat(newPattern);
  
    
      
         
      
          while(rs.next()){
            //Display values
          
            DefaultTableModel model =(DefaultTableModel)purchaseTable.getModel();
            model.addRow(new Object[]{rs.getString("id"),rs.getString("product_code"),rs.getString("Product_Name"), newFormatt.format(rs.getDouble("price"))});
            getSum();
          
          
           PreparedStatement pst=null;
            PreparedStatement pst2=null;
            
            
          pst = con.prepareStatement(query2);
          pst2 = con.prepareStatement(query3);
         pst.setInt(1,Integer.parseInt(rs.getString("id")));
          pst.setString(2,rs.getString("product_code"));
           pst.setString(3,rs.getString("Product_Name"));
             
               pst.setDouble(4,Double.parseDouble(rs.getString("price")));
               
               
        
               
        
         pst2.setInt(1,Integer.parseInt(rs.getString("id")));
         pst2.setString(2,rs.getString("product_code"));
         pst2.setString(3,rs.getString("Product_Name"));
         pst2.setString(4,d);
         pst2.setDouble(5,Double.parseDouble(rs.getString("price")));
         pst2.execute();
          pst.execute();
          
        Double t =total();
          
    NumberFormat nfp = NumberFormat.getCurrencyInstance(Locale.CANADA);
   String patternt=((DecimalFormat)nfp).toPattern();
   String newPatternt = patternt.replace("\u00A4","").trim();
   NumberFormat newFormat=new DecimalFormat(newPatternt);
   String ft =newFormat.format(t);
    
         sales.setText("NGN "+String.valueOf(ft));
        textField1.setText("");  
          
        }
          
         
        
          con.close();
          
     }catch(SQLException e){
        // JOptionPane.showMessageDialog(null, "Pos Could Not update table ");
     //e.printStackTrace();
    // System.out.println("your error"+e);
    
     }
    
    
     
    
    
    
    
}
    
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTable purchaseTable;
    private javax.swing.JLabel sales;
    private java.awt.Label t;
    private java.awt.TextField textField1;
    private java.awt.Label totalBuy;
    private javax.swing.JTextArea trans;
    // End of variables declaration//GEN-END:variables

   

}