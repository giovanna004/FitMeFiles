package br.ufmt.poo.fitMe.ui;

import br.ufmt.poo.fitMe.persistencia.entidade.ItemTreino;
import br.ufmt.poo.fitMe.persistencia.entidade.Treino;
import br.ufmt.poo.fitMe.service.ItemTreinoService;
import br.ufmt.poo.fitMe.service.TreinoService;
import br.ufmt.poo.fitMe.service.impl.ItemTreinoServiceImpl;
import br.ufmt.poo.fitMe.service.impl.TreinoServiceImpl;
import static br.ufmt.poo.fitMe.ui.Sessao.usuarioLogado;
import java.util.List;
import java.util.function.Function;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TreinosJPanel extends javax.swing.JPanel {
    
    TreinoService serviceTreino = new TreinoServiceImpl();
    ItemTreinoService serviceItem = new ItemTreinoServiceImpl();
    List<Treino> treinos = serviceTreino.buscarTodosPorUsuario(usuarioLogado.getId());
    

    
    public TreinosJPanel() {
        initComponents();
        comboTreinos.removeAllItems();
        
        for (Treino t : treinos) {
            comboTreinos.addItem(t.getNome());
        }
        
        comboTreinos.addActionListener(e -> {
            String nomeSelecionado = (String) comboTreinos.getSelectedItem();

            if (nomeSelecionado != null) {
                Treino treino = serviceTreino.buscarPeloNome(nomeSelecionado, usuarioLogado.getId());

                if (treino != null) {
                    List<ItemTreino> itens = serviceItem.buscarItensPorTreino(treino.getId());

                    atualizarTabela(itens, tabelaItensTreino, item -> new Object[]{
                        item.getNomeExercicio(),
                        item.getSeries(),
                        item.getRepeticoes(),
                        item.getDescanso(),
                        item.isConcluido(),
                        item.getId()
                    });
                }
            }
        });
        
        salvar.addActionListener(e -> {
            try {
                for (int i = 0; i < tabelaItensTreino.getRowCount(); i++) {
                    int itemId = Integer.parseInt(tabelaItensTreino.getValueAt(i, 5).toString());
                    boolean concluido = (boolean) tabelaItensTreino.getValueAt(i, 4);

                    ItemTreino item = new ItemTreino();
                    item.setId(itemId);
                    item.setConcluido(concluido);

                    serviceItem.atualizarConcluido(item);
                }

                JOptionPane.showMessageDialog(null, "Progresso atualizado com sucesso!");
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
        comboTreinos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaItensTreino = new javax.swing.JTable();
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
        jLabel1.setText("Treinos Cadastrados");

        comboTreinos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTreinos.setSelectedItem(getToolTipText());
        comboTreinos.setToolTipText("Selecione o Treino");
        comboTreinos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        comboTreinos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTreinosActionPerformed(evt);
            }
        });

        tabelaItensTreino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Exercício", "Séries", "Repetições", "Descanso", "Concluído", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaItensTreino);
        if (tabelaItensTreino.getColumnModel().getColumnCount() > 0) {
            tabelaItensTreino.getColumnModel().getColumn(5).setMinWidth(0);
            tabelaItensTreino.getColumnModel().getColumn(5).setPreferredWidth(0);
            tabelaItensTreino.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        salvar.setBackground(new java.awt.Color(159, 204, 127));
        salvar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        salvar.setForeground(new java.awt.Color(255, 255, 255));
        salvar.setText("Salvar Progresso");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboTreinos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(comboTreinos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void comboTreinosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTreinosActionPerformed
        
    }//GEN-LAST:event_comboTreinosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> comboTreinos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salvar;
    private javax.swing.JTable tabelaItensTreino;
    // End of variables declaration//GEN-END:variables
}
