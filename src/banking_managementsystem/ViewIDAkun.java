/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking_managementsystem;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class ViewIDAkun extends javax.swing.JFrame {

   Connection connection;
   ResultSet resultset;
   PreparedStatement prepared;
    public ViewIDAkun() {
        initComponents();
        Koneksi();
        TampilData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbllihat = new javax.swing.JTable();
        txtcari = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblidakun = new javax.swing.JLabel();
        lblnama = new javax.swing.JLabel();
        lblidcustomer = new javax.swing.JLabel();
        lblnamaakhir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbllihat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbllihat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbllihatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbllihat);

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblidakun.setText("jLabel1");

        lblnama.setText("jLabel2");

        lblidcustomer.setText("jLabel1");

        lblnamaakhir.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblidcustomer)
                    .addComponent(lblnamaakhir)
                    .addComponent(lblnama)
                    .addComponent(lblidakun)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(lblidakun)
                .addGap(27, 27, 27)
                .addComponent(lblnama)
                .addGap(26, 26, 26)
                .addComponent(lblnamaakhir)
                .addGap(28, 28, 28)
                .addComponent(lblidcustomer)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbllihatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbllihatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbllihatMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String carinama=txtcari.getText();
        
        try{
            prepared=connection.prepareStatement("select customer.idcustomer,customer.namapertama, customer.namaakhir, akun.idakun from customer,akun where customer.idcustomer=akun.idcustomer and namapertama=?");
            prepared.setString(1, carinama);
            resultset=prepared.executeQuery();
            
            if(resultset.next()){
                String idakun=resultset.getString("idakun");
                String nama=resultset.getString("namapertama");
                String namaakhir=resultset.getString("namaakhir");
                String idcustomer=resultset.getString("idcustomer");
                
                lblidakun.setText(idakun.trim());
                lblnama.setText(nama.trim());
                lblnamaakhir.setText(namaakhir.trim());
                lblidcustomer.setText(idcustomer.trim());
            }
            else{
                JOptionPane.showMessageDialog(null,"Nama Tidak Ditemukan");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erorr "+e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewIDAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewIDAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewIDAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewIDAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewIDAkun().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblidakun;
    private javax.swing.JLabel lblidcustomer;
    private javax.swing.JLabel lblnama;
    private javax.swing.JLabel lblnamaakhir;
    private javax.swing.JTable tbllihat;
    private javax.swing.JTextField txtcari;
    // End of variables declaration//GEN-END:variables

    private void TampilData() {
        DefaultTableModel datalist = new DefaultTableModel();
        
        datalist.addColumn("No");
        datalist.addColumn("ID Akun");
        datalist.addColumn("ID Customer");
        
        try{
            int i=1;
            
            prepared=connection.prepareStatement("select * from akun");
            resultset=prepared.executeQuery();
            while(resultset.next())
                datalist.addRow(new Object[]{
                    (""+i++),
                    resultset.getString(2), resultset.getString(3)
                });
            tbllihat.setModel(datalist);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
        }
    }

    private void Koneksi() {
       try{
           Class.forName("com.mysql.jdbc.Driver");
           connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingmanagement","root","");
           System.out.println("Koneksi Berhasil");
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
       }
    }
}
