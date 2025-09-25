
package br.ufmt.poo.fitMe.ui;

import br.ufmt.poo.fitMe.persistencia.entidade.Usuario;
import br.ufmt.poo.fitMe.service.UsuarioService;
import br.ufmt.poo.fitMe.service.impl.UsuarioServiceImpl;
import javax.swing.JOptionPane;


public class DashboardJPanel extends javax.swing.JPanel {

    
    public DashboardJPanel() {
        initComponents();
        editarJPanel.setVisible(false);
        principalJPanel.setVisible(true);
        preencherCamposComDadosDoUsuario();
    }

    private void preencherCamposComDadosDoUsuario() {
        Usuario u = Sessao.usuarioLogado;

        
        pesoTxt.setText(String.format("%.2f", u.getPesoAtual()));
        alturaTxt.setText(String.format("%.2f", u.getAltura()));
        objetivoJComboBox.setSelectedItem(u.getObjetivo());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        editarJPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        editarPesoTxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        editarAlturaTxt = new javax.swing.JTextField();
        salvarJButton = new javax.swing.JButton();
        editarObjetivoJComboBox = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        principalJPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pesoTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        alturaTxt = new javax.swing.JTextField();
        editarJButton = new javax.swing.JButton();
        objetivoJComboBox = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();

        setMinimumSize(new java.awt.Dimension(736, 520));
        setPreferredSize(new java.awt.Dimension(736, 520));

        jLayeredPane1.setMinimumSize(new java.awt.Dimension(195, 520));
        jLayeredPane1.setLayout(new javax.swing.OverlayLayout(jLayeredPane1));

        editarJPanel.setBackground(new java.awt.Color(157, 191, 132));
        editarJPanel.setMinimumSize(new java.awt.Dimension(195, 520));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Meu Objetivo:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Peso (Kg):");

        editarPesoTxt.setText(getName());
        editarPesoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarPesoTxtActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Altura (m):");

        editarAlturaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarAlturaTxtActionPerformed(evt);
            }
        });

        salvarJButton.setBackground(new java.awt.Color(159, 204, 127));
        salvarJButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        salvarJButton.setForeground(new java.awt.Color(255, 255, 255));
        salvarJButton.setText("Salvar");
        salvarJButton.setBorder(null);
        salvarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarJButtonActionPerformed(evt);
            }
        });

        editarObjetivoJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Emagrecimento", "Hipertrofia", "Saúde cardiovascular", "Mais energia", "Controle de doenças", "Performance esportiva", "Redução de estresse", "Alimentação saudável", "Manutenção de peso", "Força e resistência", "Reeducação alimentar", "Melhor sono", "Prevenção de lesões" }));
        editarObjetivoJComboBox.setMinimumSize(new java.awt.Dimension(154, 26));
        editarObjetivoJComboBox.setPreferredSize(new java.awt.Dimension(154, 26));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo2.png"))); // NOI18N

        javax.swing.GroupLayout editarJPanelLayout = new javax.swing.GroupLayout(editarJPanel);
        editarJPanel.setLayout(editarJPanelLayout);
        editarJPanelLayout.setHorizontalGroup(
            editarJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarJPanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(editarJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarJPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editarJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(editarObjetivoJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(editarJPanelLayout.createSequentialGroup()
                            .addGroup(editarJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel18)
                                .addComponent(jLabel17))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(editarJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(editarPesoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(editarAlturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(editarJPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(salvarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(43, 43, 43))
        );
        editarJPanelLayout.setVerticalGroup(
            editarJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarJPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel19)
                .addGap(40, 40, 40)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editarObjetivoJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(editarJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(editarPesoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(editarJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(editarAlturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99)
                .addComponent(salvarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jLayeredPane1.add(editarJPanel);

        principalJPanel.setBackground(new java.awt.Color(157, 191, 132));
        principalJPanel.setMinimumSize(new java.awt.Dimension(195, 520));
        principalJPanel.setPreferredSize(new java.awt.Dimension(195, 520));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Meu Objetivo:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Peso (Kg):");

        pesoTxt.setEnabled(false);
        pesoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesoTxtActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Altura (m):");

        alturaTxt.setEnabled(false);

        editarJButton.setBackground(new java.awt.Color(159, 204, 127));
        editarJButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        editarJButton.setForeground(new java.awt.Color(255, 255, 255));
        editarJButton.setText("Editar");
        editarJButton.setBorder(null);
        editarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarJButtonActionPerformed(evt);
            }
        });

        objetivoJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Emagrecimento", "Hipertrofia", "Saúde cardiovascular", "Mais energia", "Controle de doenças", "Performance esportiva", "Redução de estresse", "Alimentação saudável", "Manutenção de peso", "Força e resistência", "Reeducação alimentar", "Melhor sono", "Prevenção de lesões" }));
        objetivoJComboBox.setSelectedItem(editarObjetivoJComboBox);
        objetivoJComboBox.setEnabled(false);
        objetivoJComboBox.setMinimumSize(new java.awt.Dimension(154, 26));
        objetivoJComboBox.setPreferredSize(new java.awt.Dimension(154, 26));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo2.png"))); // NOI18N

        javax.swing.GroupLayout principalJPanelLayout = new javax.swing.GroupLayout(principalJPanel);
        principalJPanel.setLayout(principalJPanelLayout);
        principalJPanelLayout.setHorizontalGroup(
            principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalJPanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(principalJPanelLayout.createSequentialGroup()
                            .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pesoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(alturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                        .addComponent(objetivoJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(principalJPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(principalJPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(editarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(43, 43, 43))
        );
        principalJPanelLayout.setVerticalGroup(
            principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalJPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel11)
                .addGap(40, 40, 40)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(objetivoJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(pesoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(alturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99)
                .addComponent(editarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jLayeredPane1.add(principalJPanel);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Olá! Como vai hoje ?");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Sua determinação é sua maior força!");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(8, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane3)
                .addGap(85, 85, 85))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarJButtonActionPerformed
        editarJPanel.setVisible(true);
        principalJPanel.setVisible(false);
        
    }//GEN-LAST:event_editarJButtonActionPerformed

    private void pesoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesoTxtActionPerformed

    private void editarPesoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarPesoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editarPesoTxtActionPerformed

    private void salvarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarJButtonActionPerformed
        try {
            double peso = Double.parseDouble(editarPesoTxt.getText());
            double altura = Double.parseDouble(editarAlturaTxt.getText());
            String objetivo = editarObjetivoJComboBox.getSelectedItem().toString();
            
            UsuarioService service = new UsuarioServiceImpl();
            service.atualizarDadosUsuario(peso, altura, objetivo);

            JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!");

            pesoTxt.setText(String.format("%.2f", peso));
            alturaTxt.setText(String.format("%.2f", altura));
            /*lblIMC.setText(String.format("%.2f", peso / Math.pow((altura), 2)));*/
            objetivoJComboBox.setSelectedItem(objetivo);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Preencha os campos corretamente!");
        }
        editarJPanel.setVisible(false);
        principalJPanel.setVisible(true);
    }//GEN-LAST:event_salvarJButtonActionPerformed

    private void editarAlturaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarAlturaTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editarAlturaTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alturaTxt;
    private javax.swing.JTextField editarAlturaTxt;
    private javax.swing.JButton editarJButton;
    private javax.swing.JPanel editarJPanel;
    private javax.swing.JComboBox<String> editarObjetivoJComboBox;
    private javax.swing.JTextField editarPesoTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JComboBox<String> objetivoJComboBox;
    private javax.swing.JTextField pesoTxt;
    private javax.swing.JPanel principalJPanel;
    private javax.swing.JButton salvarJButton;
    // End of variables declaration//GEN-END:variables
}
