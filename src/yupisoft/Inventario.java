
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
public class Inventario extends javax.swing.JFrame {



    public Inventario() {
        initComponents();
        lbfecha.setText(fecha());
        
        numeros();
        //mostrardatos("");
        //mostrarInventario("");
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
   
    void mostrardatos(String valor){//METODO PARA MOSTRAR LOS DATOS REGISTRADOS EN LA TABLA DE LOTE
        
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("FECHA");
        modelo.addColumn("ID LOTE");
        modelo.addColumn("ID PROUCTO");
        modelo.addColumn("PRECIO");
        modelo.addColumn("CANTIDAD");
        JtableLote.setModel(modelo);
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
                        JtableLote.setModel(modelo);
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
        JtableProduc.setModel(modelo);
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
                        JtableProduc.setModel(modelo);
                      
                        
                } catch (SQLException ex) {
                    Logger.getLogger( Inventario.class.getName()).log(Level.SEVERE, null, ex);
                }
                
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TNombreP = new javax.swing.JTextField();
        TPrecioC = new javax.swing.JTextField();
        Tcant = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lbfecha = new javax.swing.JLabel();
        lb_IdLote = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TId_Prod = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtableLote = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        texIdProducto = new javax.swing.JTextField();
        texNomProducto = new javax.swing.JTextField();
        texCantidad = new javax.swing.JTextField();
        texdescripcion = new javax.swing.JTextField();
        texPrecioVenta = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JtableProduc = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 550, 80, -1));

        jButton2.setText("regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 110, -1));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(700, 500));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setPreferredSize(new java.awt.Dimension(450, 350));

        jLabel1.setText("Id Producto");

        jLabel2.setText("Nombre");

        jLabel3.setText("Cantidad");

        jLabel4.setText("Precio de compra");

        TNombreP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNombrePActionPerformed(evt);
            }
        });

        TPrecioC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TPrecioCActionPerformed(evt);
            }
        });

        Tcant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TcantActionPerformed(evt);
            }
        });

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha");

        lbfecha.setText("DD/MM/YYYY");

        jLabel5.setText("Id Lote");

        TId_Prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TId_ProdActionPerformed(evt);
            }
        });
        TId_Prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TId_ProdKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TId_ProdKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TPrecioC, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addGap(86, 86, 86)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbfecha)
                                    .addComponent(lb_IdLote, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TId_Prod, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(23, 23, 23)
                                        .addComponent(Tcant, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(139, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbfecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_IdLote, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButton4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(TId_Prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TPrecioC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(Tcant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jButton3)
                .addGap(118, 118, 118))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        JtableLote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(JtableLote);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );

        jTabbedPane1.addTab("Lote", jPanel1);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setText("Nombre");

        jLabel10.setText("Codigo");

        jLabel11.setText("Cantidad");

        jLabel12.setText("Precio");

        jLabel13.setText("Descripción");

        jButton8.setText("Agregar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        texIdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texIdProductoActionPerformed(evt);
            }
        });
        texIdProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                texIdProductoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                texIdProductoKeyReleased(evt);
            }
        });

        texdescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texdescripcionActionPerformed(evt);
            }
        });

        jButton9.setText("Modificar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(texIdProducto)
                            .addComponent(texNomProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel12))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jButton9)))
                        .addGap(194, 194, 194))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(texCantidad)
                                .addGap(52, 52, 52)
                                .addComponent(texPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(texdescripcion))
                        .addGap(126, 126, 126))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(texIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(texNomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton9)
                        .addGap(15, 15, 15)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(texPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(texCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(27, 27, 27))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        JtableProduc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(JtableProduc);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Producto", jPanel3);

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton7.setText("Finalizar");

        jButton6.setText("Entregar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addGap(124, 124, 124))
        );

        jTabbedPane1.addTab("Dev Averia", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 780, 510));
        jTabbedPane1.getAccessibleContext().setAccessibleName("Lote");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        System.exit(0);//SALIR


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

            this.setVisible(false);
            Inicio I = new Inicio();
            I.setVisible(true);
           I.setLocationRelativeTo(null);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void TPrecioCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TPrecioCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TPrecioCActionPerformed

    private void TcantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TcantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TcantActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {

            PreparedStatement s = cn.prepareStatement("INSERT INTO lote(fecha,idLote,idProducto,precioCompra,cantidad) VALUES(?,?,?,?,?)");

// GUARDAR LOS DATOS INGRESADOS, SE REGISTRAN LOS DATOS EN LA BASE DE DATOS EN LA TABLA LOTE
            s.setString(1, fecha());
            s.setString(2, lb_IdLote.getText());
            s.setString(3, TId_Prod.getText());
            s.setString(4, TPrecioC.getText());
            s.setString(5, Tcant.getText());
            s.executeUpdate();
            //   mostrarInventario("");

            JOptionPane.showMessageDialog(this, "Informacion Almacenada");
            numeros();// LLAMAR AL METODO PARA GENERAR EL CONSECUTIVO DE LOTE

            //LIMPIAR LOS CAMPOS
            TId_Prod.setText("");

            TPrecioC.setText("");
            Tcant.setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       
     
        
        try{
          PreparedStatement s=cn.prepareStatement("INSERT INTO producto(idProducto,nombreProducto,precioVenta, descripcion) VALUES(?,?,?,?)")  ;
          PreparedStatement sn=cn.prepareStatement("INSERT INTO inventario(idProducto,cantidad) VALUES(?,?)")  ;
//GUARDAR LOS DATOS REGISTRADOS EN LA PESTAÑA DE PRODUCTOS.. GUARDA LOS DATOS EN LA BASE DE DATOS EN LA TABLA INVENTARIO
    
            //producto
          s.setString(1,texIdProducto.getText());
          s.setString(2,texNomProducto.getText());
          s.setString(3,texPrecioVenta.getText());
          s.setString(4,texdescripcion.getText());
          s.executeUpdate();
          
          //inventario
          sn.setString(1,texIdProducto.getText());
          sn.setString(2,texCantidad.getText());
          
          sn.executeUpdate();
          
          
          
            //mostrarInventario("");// LLAMAR AL METODO PARA MOSTRAR LOS DATOS ANTERIORMENTE REGISTRADOS
          JOptionPane.showMessageDialog(this, "Informacion Almacenada");
     
//LIMPIAR LOS CAMPOS AL MOMENTO DE CULMINAR EL REGISTRO
          texIdProducto.setText("");
          texNomProducto.setText("");
          texPrecioVenta.setText("");
          texCantidad.setText("");
          texdescripcion.setText("");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
         }
        
        
        
   
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void texdescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texdescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texdescripcionActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
        // METODO PARA BUSCAR PRODUCTO EN LOTE (NO ESTA TERMINADO)
    
        if(! "Producto FROM IdProducto".equals(TId_Prod.getText())){
            
            
            JOptionPane.showMessageDialog(null, "DEBE REGISTRAR EL PRODUCTO");
     
            
        }else{
            JOptionPane.showMessageDialog(null, "NAAAAA");
            
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void TNombrePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNombrePActionPerformed
       
    }//GEN-LAST:event_TNombrePActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

    }//GEN-LAST:event_jButton9ActionPerformed

    private void texIdProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texIdProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texIdProductoActionPerformed

    private void texIdProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texIdProductoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_texIdProductoKeyPressed

    private void TId_ProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TId_ProdKeyPressed
       
        String[] titulos = {"Id Producto","Producto"," Precio Venta","Descripción"};
        String[] registros = new String[50];
        
        String sql = "SELECT *FROM producto WHERE idProducto LIKE '%" +TId_Prod.getText() + "%'"
              +  "OR nombreProducto LIKE '%" +TId_Prod.getText()+"%'"
              +  "OR descripcion LIKE '%" +TId_Prod.getText()+"%'";
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
            
             JtableLote.setModel(modelo);
        
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        
    }//GEN-LAST:event_TId_ProdKeyPressed

    private void TId_ProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TId_ProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TId_ProdActionPerformed

    private void texIdProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texIdProductoKeyReleased

        
    }//GEN-LAST:event_texIdProductoKeyReleased

    private void TId_ProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TId_ProdKeyReleased
                
    }//GEN-LAST:event_TId_ProdKeyReleased

    
    //GENERAR FECHA AUTOMATICA.. SE MUESTRA LA FECHA ACTUAL Y SE GUARDA EN LA BASE DE DATOS
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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtableLote;
    private javax.swing.JTable JtableProduc;
    private javax.swing.JTextField TId_Prod;
    private javax.swing.JTextField TNombreP;
    private javax.swing.JTextField TPrecioC;
    private javax.swing.JTextField Tcant;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lb_IdLote;
    private javax.swing.JLabel lbfecha;
    private javax.swing.JTextField texCantidad;
    private javax.swing.JTextField texIdProducto;
    private javax.swing.JTextField texNomProducto;
    private javax.swing.JTextField texPrecioVenta;
    private javax.swing.JTextField texdescripcion;
    // End of variables declaration//GEN-END:variables

Conectar cc= new Conectar();
    Connection cn= cc.conexion();
}
