package br.ufmt.poo.fitMe.ui;

import br.ufmt.poo.fitMe.persistencia.entidade.Dieta;
import br.ufmt.poo.fitMe.persistencia.entidade.ItemDieta;
import br.ufmt.poo.fitMe.service.DietaService;
import br.ufmt.poo.fitMe.service.ItemDietaService;
import br.ufmt.poo.fitMe.service.impl.DietaServiceImpl;
import br.ufmt.poo.fitMe.service.impl.ItemDietaServiceImpl;
import static br.ufmt.poo.fitMe.ui.Sessao.usuarioLogado;
import java.util.List;
import java.util.function.Function;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DietasJPanel extends javax.swing.JPanel {
    DietaService serviceDieta = new DietaServiceImpl();
    ItemDietaService serviceItem = new ItemDietaServiceImpl();
    List<Dieta> dietas = serviceDieta.buscarTodosPorUsuario(usuarioLogado.getId());
    
    
    public DietasJPanel() {
        initComponents();
        
        comboDietas.removeAllItems();
        
        for (Dieta d : dietas) {
            comboDietas.addItem(d.getNome());
        }
        
        comboDietas.addActionListener(e -> {
            String nomeSelecionado = (String) comboDietas.getSelectedItem();

            if (nomeSelecionado != null) {
                Dieta dieta = serviceDieta.buscarPeloNome(nomeSelecionado, usuarioLogado.getId());

                if (dieta != null) {
                    List<ItemDieta> itens = serviceItem.buscarItensPorDieta(dieta.getId());

                    atualizarTabela(itens, tabelaItensDieta, item -> new Object[]{
                        item.getNomeAlimento(),
                        item.getPorcao(),
                        item.getCalorias(),
                        item.isConsumido(),
                        item.getId()
                    });
                }
            }
        });
        
        salvar.addActionListener(e -> {
            try {
                for (int i = 0; i < tabelaItensDieta.getRowCount(); i++) {
                    int itemId = Integer.parseInt(tabelaItensDieta.getValueAt(i, 4).toString());
                    boolean consumido = (boolean) tabelaItensDieta.getValueAt(i, 3);

                    ItemDieta item = new ItemDieta();
                    item.setId(itemId);
                    item.setConsumido(consumido);

                    serviceItem.atualizarConsumido(item);
                }

                JOptionPane.showMessageDialog(null, "Consumos atualizados com sucesso!");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
            }
        });
    }
    
    private <T> void atualizarTabela(List<T> lista, JTable tabela, Function<T, Object[]> transformador) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);
        for (T item : lista) {
            modelo.addRow(transformador.apply(item));
        }
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboDietas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaItensDieta = new javax.swing.JTable();
        salvar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(736, 520));

        jPanel1.setBackground(new java.awt.Color(175, 217, 145));
        jPanel1.setMinimumSize(new java.awt.Dimension(736, 520));
        jPanel1.setPreferredSize(new java.awt.Dimension(736, 520));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(500, 450));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 450));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(155, 207, 118));
        jLabel1.setText("Dietas Cadastradas");

        comboDietas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboDietas.setSelectedItem(getToolTipText());
        comboDietas.setToolTipText("Selecione o Treino");
        comboDietas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        comboDietas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDietasActionPerformed(evt);
            }
        });

        tabelaItensDieta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alimento", "Porção", "Calorias", "Consumido", "null"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaItensDieta);
        if (tabelaItensDieta.getColumnModel().getColumnCount() > 0) {
            tabelaItensDieta.getColumnModel().getColumn(4).setMinWidth(0);
            tabelaItensDieta.getColumnModel().getColumn(4).setPreferredWidth(0);
            tabelaItensDieta.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        salvar.setBackground(new java.awt.Color(159, 204, 127));
        salvar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        salvar.setForeground(new java.awt.Color(255, 255, 255));
        salvar.setText("Salvar Progresso");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboDietas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salvar)
                .addGap(190, 190, 190))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboDietas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboDietasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDietasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDietasActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        
    }//GEN-LAST:event_salvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboDietas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salvar;
    private javax.swing.JTable tabelaItensDieta;
    // End of variables declaration//GEN-END:variables
}
