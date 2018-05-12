/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yupisoft;

import clases.Conectar;
import clases.GenerarNum;
import clases.Lote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static javax.swing.text.html.HTML.Tag.SELECT;


/**
 *
 * @author kimberly
 */
public class Producto extends javax.swing.JFrame {

    /**
     * Creates new form Producto
     */
    public Producto() {
        initComponents();
        lbfecha.setText(fecha());
        
        numeros();
        Deshabilitar();
        //mostrardatos("");
        mostrarInventario("");
    }
    
    
    
   public void Deshabilitar(){
        
    Tvent_producto.setEnabled(false);
    Tdescrip_prod.setEnabled(false);
    Tnom_producto.setEnabled(false); 
    Tdescrip_prod.setEnabled(false);
    Tnom_producto.setEnabled(false);
    Tcom_producto.setEnabled(false);
    Tcant_producto.setEnabled(false);
            
    
}
   public void Habilitar(){
    Tid_Producto.setEnabled(false);
    Tnom_producto.setEnabled(false);
    Tvent_producto.setEnabled(true);
    Tdescrip_prod.setEnabled(true);
    Tcom_producto.setEnabled(true);
    Tcant_producto.setEnabled(true);
   }
   
   public void Limpiar(){
    Tid_Producto.setText("");
    Tnom_producto.setText("");
    Tvent_producto.setText("");
    Tdescrip_prod.setText("");
    Tcom_producto.setText("");
    Tcant_producto.setText("");
   }
   
   
   void mostrardatos(String valor){//METODO PARA MOSTRAR LOS DATOS REGISTRADOS EN LA TABLA DE LOTE
        
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("FECHA");
        modelo.addColumn("ID LOTE");
        modelo.addColumn("ID PROUCTO");
        modelo.addColumn("PRECIO");
        modelo.addColumn("CANTIDAD");
        Jtable.setModel(modelo);
        String sql ="";
        if(valor.equals(""))
        {
            sql="SELECT * FROM lote";
        }
        else{
            sql="SELECT * FROM Lote WHERE idLote='"+valor+"'";
        }
 
            String []datos = new String [5];
                try {
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    while(rs.next()){
                        datos[0]=rs.getString(1);
                        datos[1]=rs.getString(2);
                        datos[2]=rs.getString(3);
                        datos[3]=rs.getString(4);
                        datos[4]=rs.getString(5);
                      
                        modelo.addRow(datos);
                    }
                        Jtable.setModel(modelo);
                } catch (SQLException ex) {
                    Logger.getLogger( Inventario.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
   
   
     void mostrarInventario(String valor){ //METODO PARA MOSTRAR LOS DATOS EN LA TABLA DE INVENTARIO.. MUESTRA LOS DATOS REGISTRADOS EN LA BASE DE DATOS
        DefaultTableModel modelo= new DefaultTableModel();
       
        modelo.addColumn("ID PROUCTO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO");
        modelo.addColumn("DESCRIPCION");
        Jtable.setModel(modelo);
        String sql ="";
        if(valor.equals(""))
        {
            sql="SELECT * FROM producto";
        }
        else{
            sql="SELECT * FROM producto WHERE idProducto='"+valor+"'";
        }
 
            String []datos = new String [4];
                try {
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    while(rs.next()){
                        datos[0]=rs.getString(1);
                        datos[1]=rs.getString(2);
                        datos[2]=rs.getString(3);
                        datos[3]=rs.getString(4);
                       
                       
                        modelo.addRow(datos);
                    }
                        Jtable.setModel(modelo);
                      
                        
                } catch (SQLException ex) {
                    Logger.getLogger( Inventario.class.getName()).log(Level.SEVERE, null, ex);
                }
                
    }
    
    void numeros(){// metodo para generar el numero concecutivo en el registro del lote
         
         
        int j;
        String num="";
        String c="";
        String SQL="SELECT MAX(idLote) AS idLote FROM lote";
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs.next())
            {
                c=rs.getString(1); 
            }
            
            if(c==null){
                
                lb_IdLote.setText("CD0001");
            }
            else{
            
            char r1 =c.charAt(2);
            char r2 =c.charAt(3);
            char r3 =c.charAt(4);
            char r4 =c.charAt(5);
           
            String r = "";
                   r= ""+r1+r2+r3+r4;
            
            j=Integer.parseInt(r);
            
            GenerarNum g = new GenerarNum();
            g.generar(j);
            
            lb_IdLote.setText("CD"+g.serie());
            }
            
        }     
        catch (SQLException ex)
        {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator3 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbfecha = new javax.swing.JLabel();
        lb_IdLote = new javax.swing.JLabel();
        Tid_Producto = new javax.swing.JTextField();
        Tnom_producto = new javax.swing.JTextField();
        Tcant_producto = new javax.swing.JTextField();
        Tvent_producto = new javax.swing.JTextField();
        Tcom_producto = new javax.swing.JTextField();
        Tdescrip_prod = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Jtable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Codigo Producto");

        jLabel2.setText("Producto");

        jLabel3.setText("Cantidad");

        jLabel4.setText("Precio Venta");

        jLabel5.setText("Precio Compra");

        jLabel6.setText("Descripción ");

        jLabel8.setText("Fecha");

        lbfecha.setText("DD/MM/YYYY");

        Tid_Producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Tid_ProductoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(87, 87, 87)
                        .addComponent(lbfecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_IdLote, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Tid_Producto, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(Tvent_producto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Tcom_producto))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(49, 49, 49)
                                        .addComponent(Tnom_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(28, 28, 28)
                                .addComponent(Tcant_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(Tdescrip_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_IdLote, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(lbfecha)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Tid_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(Tnom_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Tvent_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(Tcom_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Tcant_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(Tdescrip_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122))
        );

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Jtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Jtable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
        );

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.red, null));

        jButton3.setText("LISTAR LOTE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("LISTAR PRODUCTOS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setText("Registrar Lote");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Lote");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(java.awt.Color.red);

        jButton2.setText("Registrar Producto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setText("Producto");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jButton6)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator4))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(70, 70, 70)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        try{
   
          PreparedStatement s=cn.prepareStatement("INSERT INTO lote(fecha,idLote,idProducto,precioCompra,cantidad) VALUES(?,?,?,?,?)")  ;
          
// GUARDAR LOS DATOS INGRESADOS, SE REGISTRAN LOS DATOS EN LA BASE DE DATOS EN LA TABLA LOTE
          s.setString(1,fecha());
          s.setString(2, lb_IdLote.getText());
          s.setString(3,Tid_Producto.getText());
          s.setString(4,Tcom_producto.getText());
          s.setString(5,Tcant_producto.getText());
          s.executeUpdate();
         //   mostrarInventario("");
            
          JOptionPane.showMessageDialog(this, "Informacion Almacenada");
          numeros();// LLAMAR AL METODO PARA GENERAR EL CONSECUTIVO DE LOTE
            
          //LIMPIAR LOS CAMPOS
          Tid_Producto.setText("");
          Tnom_producto.setText("");
          Tcom_producto.setText("");
          Tvent_producto.setText("");
          Tcant_producto.setText("");
          Tdescrip_prod.setText("");
          

        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
         }
   
           
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
          
        try{
          PreparedStatement s=cn.prepareStatement("INSERT INTO producto(idProducto,nombreProducto,precioVenta, descripcion) VALUES(?,?,?,?)")  ;
          PreparedStatement sn=cn.prepareStatement("INSERT INTO inventario(idProducto,cantidad) VALUES(?,?)")  ;
//GUARDAR LOS DATOS REGISTRADOS EN LA PESTAÑA DE PRODUCTOS.. GUARDA LOS DATOS EN LA BASE DE DATOS EN LA TABLA INVENTARIO
    
            //producto
          
          s.setString(1,Tid_Producto.getText());
          s.setString(2,Tnom_producto.getText());
          s.setString(3,Tvent_producto.getText());
          s.setString(4,Tdescrip_prod.getText());
          s.executeUpdate();
          
          //inventario
          sn.setString(1,Tid_Producto.getText());
          sn.setString(2,Tcant_producto.getText());
          
          sn.executeUpdate();
          
          
          
            //mostrarInventario("");// LLAMAR AL METODO PARA MOSTRAR LOS DATOS ANTERIORMENTE REGISTRADOS
          JOptionPane.showMessageDialog(this, "Informacion Almacenada");
     
//LIMPIAR LOS CAMPOS AL MOMENTO DE CULMINAR EL REGISTRO
          Tid_Producto.setText("");
          Tnom_producto.setText("");
          Tvent_producto.setText("");
          Tcant_producto.setText("");
          Tdescrip_prod.setText("");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
         }
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        mostrardatos("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        mostrarInventario("");
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void JtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtableMouseClicked
      
       Habilitar();
       int col = Jtable.getSelectedRow();
       Tid_Producto.setText(Jtable.getModel().getValueAt(col,0).toString());
       Tnom_producto.setText(Jtable.getModel().getValueAt(col,1).toString());
       Tvent_producto.setText(Jtable.getModel().getValueAt(col,2).toString());
       Tdescrip_prod.setText(Jtable.getModel().getValueAt(col,3).toString());

    }//GEN-LAST:event_JtableMouseClicked

    private void Tid_ProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tid_ProductoKeyPressed
        
         String[] titulos = {"Id Producto","Producto"," Precio Venta","Descripción"};
        String[] registros = new String[50];
        
        String sql = "SELECT *FROM producto WHERE idProducto LIKE '%" +Tid_Producto.getText() + "%'"
              +  "OR nombreProducto LIKE '%" +Tid_Producto.getText()+"%'"
              +  "OR descripcion LIKE '%" +Tid_Producto.getText()+"%'";
         DefaultTableModel modelo= new DefaultTableModel(null, titulos);
         
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            registros[0] = rs.getString("idProducto");
            registros[1] = rs.getString("nombreProducto");
            registros[2] = rs.getString("PrecioVenta");
            registros[3] = rs.getString("descripcion");
            
            modelo.addRow(registros);
            }
            
             Jtable.setModel(modelo);
        
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        
        
        
    }//GEN-LAST:event_Tid_ProductoKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
   Tid_Producto.setEnabled(true);
   Tnom_producto.setEnabled(true);
        Limpiar();
   Deshabilitar();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    
    Tid_Producto.setEnabled(true); 
    Tnom_producto.setEnabled(true);    
    Tvent_producto.setEnabled(true);
    Tdescrip_prod.setEnabled(true);
        
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static String fecha(){
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
        
    }
    
    
    
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
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jtable;
    private javax.swing.JTextField Tcant_producto;
    private javax.swing.JTextField Tcom_producto;
    private javax.swing.JTextField Tdescrip_prod;
    private javax.swing.JTextField Tid_Producto;
    private javax.swing.JTextField Tnom_producto;
    private javax.swing.JTextField Tvent_producto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lb_IdLote;
    private javax.swing.JLabel lbfecha;
    // End of variables declaration//GEN-END:variables

Conectar cc= new Conectar();
    Connection cn= cc.conexion();
}
