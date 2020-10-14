package br.com.romero.pizzaria.telas;

import java.awt.Dimension;
import br.com.romero.pizzaria.dal.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TelaFuncionario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaFuncionario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    private void consultar() {
        String query = "select f.idfuncionario,f.nomefun,f.cpf,f.cargo,f.salario,c.telefone,c.celular,e.tipo,e.logradouro,e.numero,e.complemento,e.bairro,l.usuario,l.perfil from tbfuncionario f inner join tbcontato c on f.idcontato=c.idcontato inner join tbendereco e on f.idendereco=e.idendereco inner join tblogin l on f.idlogin=l.idlogin where idfuncionario=?";

        try {
            pst = conexao.prepareStatement(query);
            pst.setString(1, txtFunId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtFunId.setText(rs.getString(1));
                txtFunNome.setText(rs.getString(2));
                txtFunCpf.setText(rs.getString(3));
                txtFunCar.setText(rs.getString(4));
                txtFunSal.setText(rs.getString(5));
                txtFunTel.setText(rs.getString(6));
                txtFunCel.setText(rs.getString(7));
                cboFunTip.setSelectedItem(rs.getString(8));
                txtFunLog.setText(rs.getString(9));
                txtFunNum.setText(rs.getString(10));
                txtFunCom.setText(rs.getString(11));
                txtFunBai.setText(rs.getString(12));
                txtFunUsu.setText(rs.getString(13));
                txtFunSen.setText(null);
                cboFunPer.setSelectedItem(rs.getString(14));

            } else {
                JOptionPane.showMessageDialog(null, "Funcionário não cadastrado");
                txtFunNome.setText(null);
                txtFunCpf.setText(null);
                txtFunCar.setText(null);
                txtFunSal.setText("R$ 0,00");
                txtFunTel.setText(null);
                txtFunCel.setText(null);
                cboFunTip.setSelectedItem("Rua");
                txtFunLog.setText(null);
                txtFunNum.setText(null);
                txtFunCom.setText(null);
                txtFunBai.setText(null);
                txtFunUsu.setText(null);
                txtFunSen.setText(null);
                cboFunPer.setSelectedItem("user");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFunId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFunNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFunCpf = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFunCar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFunSal = new javax.swing.JFormattedTextField();
        txtFunTel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFunCel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cboFunTip = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtFunLog = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFunNum = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtFunCom = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtFunBai = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtFunUsu = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cboFunPer = new javax.swing.JComboBox<>();
        txtFunSen = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnUpd = new javax.swing.JButton();
        btnRea = new javax.swing.JButton();
        btnCre = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();

        setClosable(true);
        setForeground(java.awt.Color.black);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Funcionários");
        setMaximumSize(new java.awt.Dimension(890, 600));
        setMinimumSize(new java.awt.Dimension(890, 600));
        setPreferredSize(new java.awt.Dimension(890, 600));

        painel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("id");

        txtFunId.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Nome");

        txtFunNome.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("CPF");

        try {
            txtFunCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFunCpf.setToolTipText("");
        txtFunCpf.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Telefone");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("Cargo");

        txtFunCar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setText("Salário");

        txtFunSal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtFunSal.setText("R$ 0,00");
        txtFunSal.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        txtFunTel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setText("Celular");

        txtFunCel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setText("Tipo");

        cboFunTip.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cboFunTip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rua", "Av", "Condomínio", "Alameda", "Praça" }));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setText("Logradouro");

        txtFunLog.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setText("Nº");

        txtFunNum.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Complemento");

        txtFunCom.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel13.setText("Bairro");

        txtFunBai.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel14.setText("Usuário");

        txtFunUsu.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel15.setText("Senha");

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setText("Perfil");

        cboFunPer.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cboFunPer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "user", "admin" }));

        txtFunSen.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/romero/pizzaria/imagens/alert.png"))); // NOI18N
        jLabel16.setText("Campo não obrigátorio");

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel14))
                                .addGap(29, 29, 29)
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFunUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboFunTip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFunNum, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelLayout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFunTel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtFunCar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(69, 69, 69)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFunSal, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFunCel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFunLog, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFunCom, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(txtFunSen))
                                .addGap(18, 18, 18)
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboFunPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFunBai, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel2)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(36, 36, 36)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(txtFunId, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16))
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(txtFunNome, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFunCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFunId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFunNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtFunCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFunCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtFunSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 19, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFunTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtFunCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cboFunTip, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtFunLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtFunNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtFunCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFunBai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtFunUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel11)
                    .addComponent(cboFunPer, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFunSen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        btnUpd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/romero/pizzaria/imagens/update.png"))); // NOI18N
        btnUpd.setToolTipText("Alterar");
        btnUpd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnRea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/romero/pizzaria/imagens/read.png"))); // NOI18N
        btnRea.setToolTipText("Consultar");
        btnRea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReaActionPerformed(evt);
            }
        });

        btnCre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/romero/pizzaria/imagens/create.png"))); // NOI18N
        btnCre.setToolTipText("Adicionar");
        btnCre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/romero/pizzaria/imagens/delete.png"))); // NOI18N
        btnDel.setToolTipText("Deletar");
        btnDel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(btnCre)
                .addGap(18, 18, 18)
                .addComponent(btnRea)
                .addGap(18, 18, 18)
                .addComponent(btnUpd)
                .addGap(18, 18, 18)
                .addComponent(btnDel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDel)
                    .addComponent(btnCre)
                    .addComponent(btnRea)
                    .addComponent(btnUpd))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        setBounds(0, 0, 949, 612);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReaActionPerformed
        // Chamando o método para consultar
        consultar();
    }//GEN-LAST:event_btnReaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCre;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnRea;
    private javax.swing.JButton btnUpd;
    private javax.swing.JComboBox<String> cboFunPer;
    private javax.swing.JComboBox<String> cboFunTip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painel;
    private javax.swing.JTextField txtFunBai;
    private javax.swing.JTextField txtFunCar;
    private javax.swing.JTextField txtFunCel;
    private javax.swing.JTextField txtFunCom;
    private javax.swing.JFormattedTextField txtFunCpf;
    private javax.swing.JTextField txtFunId;
    private javax.swing.JTextField txtFunLog;
    private javax.swing.JTextField txtFunNome;
    private javax.swing.JTextField txtFunNum;
    private javax.swing.JFormattedTextField txtFunSal;
    private javax.swing.JPasswordField txtFunSen;
    private javax.swing.JTextField txtFunTel;
    private javax.swing.JTextField txtFunUsu;
    // End of variables declaration//GEN-END:variables
}
