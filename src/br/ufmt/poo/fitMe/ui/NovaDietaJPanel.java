package br.ufmt.poo.fitMe.ui;

import br.ufmt.poo.fitMe.persistencia.entidade.Alimento;
import br.ufmt.poo.fitMe.service.AlimentoService;
import br.ufmt.poo.fitMe.service.DietaService;
import br.ufmt.poo.fitMe.service.ItemDietaService;
import br.ufmt.poo.fitMe.service.impl.AlimentoServiceImpl;
import br.ufmt.poo.fitMe.service.impl.DietaServiceImpl;
import br.ufmt.poo.fitMe.service.impl.ItemDietaServiceImpl;
import br.ufmt.poo.fitMe.ui.dto.DietaDTO;
import br.ufmt.poo.fitMe.ui.dto.ItemDietaDTO;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.table.DefaultTableModel;


public class NovaDietaJPanel extends javax.swing.JPanel {
    ItemDietaService serviceItem = new ItemDietaServiceImpl();
    DietaService serviceDieta = new DietaServiceImpl();
    List<ItemDietaDTO> listaAtualizada = new ArrayList<>();
    AlimentoService serviceAli = new AlimentoServiceImpl();
    


    public NovaDietaJPanel() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
        }
        
        initComponents();
        initTreino();
        configurarBusca();
        atualizarTabela(serviceAli.buscarTodos(), tabelaAlimentos, al -> new Object[] {
            al.getNome(),
            al.getUnidadeMedida(),
            al.getCalorias(),
            al.getPorcao_padrao(),
            al.getId()
        });
        
        
    }
    
    private void configurarBusca() {
        BuscaJTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                buscar();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                buscar();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                buscar();
            }

            private void buscar() {
                String termo = BuscaJTextField.getText().trim();
                String filtro = filtroBox.getSelectedItem().toString();
              
                List<Alimento> lista;

                if (termo.isEmpty()) {
                    lista = serviceAli.buscarTodos();
                } else {
                    lista = serviceAli.buscarPorNomeEFiltro(termo, filtro);
                }

                atualizarTabela(lista, tabelaAlimentos, al -> new Object[] {
                    al.getNome(),
                    al.getCalorias(),
                    al.getPorcao_padrao(),
                    al.getUnidadeMedida(),
                    al.getId()
                });
            }
        });
    }
    
    public static <T> void atualizarTabela(List<T> lista, JTable tabela, Function<T, Object[]> mapeador) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);

        for (T item : lista) {
            modelo.addRow(mapeador.apply(item));
        }
    }
    
    private void atualizarTotalCalorias(List<ItemDietaDTO> lista) {
        double totalCalorias = 0;
        for (ItemDietaDTO it : lista) {
            totalCalorias += it.getPorcao() * it.getCalorias();
        }
        total.setText(String.format("%.2f", totalCalorias));
    }
    
    
     private void initTreino() {
         
         NomeDieta.setUI(new BasicTextFieldUI() {
            @Override
            protected void paintSafely(Graphics g) {
                super.paintSafely(g);
                if (NomeDieta.getText().isEmpty() && !NomeDieta.hasFocus()) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setColor(Color.GRAY);
                    g2.drawString("Nome da Dieta", 5, NomeDieta.getHeight() / 2 + 5);
                    g2.dispose();
                }
            }
         });
         
         
     }
    

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        pesquisaJPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BuscaJTextField = new javax.swing.JTextField();
        filtroBox = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaAlimentos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        NomeDieta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaDieta = new javax.swing.JTable();
        Salvar = new javax.swing.JButton();
        total = new javax.swing.JLabel();
        Remover = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboPorcao = new javax.swing.JComboBox<>();
        Adicionar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(110, 186, 217));
        setMinimumSize(new java.awt.Dimension(736, 500));

        jSplitPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jSplitPane1.setMinimumSize(new java.awt.Dimension(495, 450));
        jSplitPane1.setPreferredSize(new java.awt.Dimension(495, 450));

        pesquisaJPanel.setBackground(new java.awt.Color(255, 255, 255));
        pesquisaJPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pesquisaJPanel.setAlignmentY(0.8F);
        pesquisaJPanel.setMinimumSize(new java.awt.Dimension(195, 450));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel1.setText("Alimentos");

        BuscaJTextField.setBackground(new java.awt.Color(249, 246, 246));
        BuscaJTextField.setToolTipText("");
        BuscaJTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 167, 217)));
        BuscaJTextField.setMinimumSize(new java.awt.Dimension(143, 28));
        BuscaJTextField.setPreferredSize(new java.awt.Dimension(143, 28));
        BuscaJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaJTextFieldActionPerformed(evt);
            }
        });

        filtroBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Proteína", "Carboidrato", "Vegetal", "Laticício" }));
        filtroBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 167, 217), 1, true));

        tabelaAlimentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alimento", "u.m.", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaAlimentos.setColumnSelectionAllowed(true);
        tabelaAlimentos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabelaAlimentos);
        tabelaAlimentos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabelaAlimentos.getColumnModel().getColumnCount() > 0) {
            tabelaAlimentos.getColumnModel().getColumn(0).setMinWidth(120);
            tabelaAlimentos.getColumnModel().getColumn(0).setPreferredWidth(120);
            tabelaAlimentos.getColumnModel().getColumn(0).setMaxWidth(120);
            tabelaAlimentos.getColumnModel().getColumn(1).setMinWidth(15);
            tabelaAlimentos.getColumnModel().getColumn(1).setPreferredWidth(30);
            tabelaAlimentos.getColumnModel().getColumn(2).setMinWidth(0);
            tabelaAlimentos.getColumnModel().getColumn(2).setPreferredWidth(0);
            tabelaAlimentos.getColumnModel().getColumn(2).setMaxWidth(0);
            tabelaAlimentos.getColumnModel().getColumn(3).setMinWidth(0);
            tabelaAlimentos.getColumnModel().getColumn(3).setPreferredWidth(0);
            tabelaAlimentos.getColumnModel().getColumn(3).setMaxWidth(0);
            tabelaAlimentos.getColumnModel().getColumn(4).setMinWidth(0);
            tabelaAlimentos.getColumnModel().getColumn(4).setPreferredWidth(0);
            tabelaAlimentos.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        javax.swing.GroupLayout pesquisaJPanelLayout = new javax.swing.GroupLayout(pesquisaJPanel);
        pesquisaJPanel.setLayout(pesquisaJPanelLayout);
        pesquisaJPanelLayout.setHorizontalGroup(
            pesquisaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pesquisaJPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pesquisaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(BuscaJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filtroBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(pesquisaJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pesquisaJPanelLayout.setVerticalGroup(
            pesquisaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pesquisaJPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(BuscaJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filtroBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(pesquisaJPanel);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel2.setMinimumSize(new java.awt.Dimension(300, 450));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel2.setText("Plano de Alimentação");

        NomeDieta.setBackground(new java.awt.Color(249, 246, 246));
        NomeDieta.setToolTipText("Hello");
        NomeDieta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 167, 217)));
        NomeDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeDietaActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Calorias Totais");

        TabelaDieta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alimentos", "Calorias"
            }
        ));
        TabelaDieta.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(TabelaDieta);
        TabelaDieta.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (TabelaDieta.getColumnModel().getColumnCount() > 0) {
            TabelaDieta.getColumnModel().getColumn(0).setMinWidth(180);
            TabelaDieta.getColumnModel().getColumn(0).setPreferredWidth(180);
            TabelaDieta.getColumnModel().getColumn(0).setMaxWidth(180);
            TabelaDieta.getColumnModel().getColumn(1).setMinWidth(60);
            TabelaDieta.getColumnModel().getColumn(1).setPreferredWidth(60);
            TabelaDieta.getColumnModel().getColumn(1).setMaxWidth(60);
        }

        Salvar.setBackground(new java.awt.Color(41, 167, 217));
        Salvar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Salvar.setForeground(new java.awt.Color(255, 255, 255));
        Salvar.setText("Salvar Dieta");
        Salvar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 167, 217), 1, true));
        Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarActionPerformed(evt);
            }
        });

        total.setBackground(new java.awt.Color(255, 255, 255));
        total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        total.setForeground(new java.awt.Color(41, 167, 217));
        total.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 167, 217), 1, true));

        Remover.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Remover.setForeground(new java.awt.Color(41, 167, 217));
        Remover.setText("Remover");
        Remover.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 167, 217), 1, true));
        Remover.setMaximumSize(new java.awt.Dimension(25, 25));
        Remover.setMinimumSize(new java.awt.Dimension(25, 25));
        Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setText("Porção (g)");

        comboPorcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100", "110", "120", "130", "140", "150", "160", "170", "180", "190", "200", "210", "220", "230", "240", "250", "260", "270", "280", "290", "300", "310", "320", "330", "340", "350", "360", "370", "380", "390", "400", "410", "420", "430", "440", "450", "460", "470", "480", "490", "500", "510", "520", "530", "540", "550", "560", "570", "580", "590", "600", "610", "620", "630", "640", "650", "660", "670", "680", "690", "700", "710", "720", "730", "740", "750", "760", "770", "780", "790", "800", "810", "820", "830", "840", "850", "860", "870", "880", "890", "900", "910", "920", "930", "940", "950", "960", "970", "980", "990", "1000" }));
        comboPorcao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 167, 217), 1, true));
        comboPorcao.setMinimumSize(new java.awt.Dimension(48, 25));
        comboPorcao.setPreferredSize(new java.awt.Dimension(48, 25));

        Adicionar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Adicionar.setForeground(new java.awt.Color(41, 167, 217));
        Adicionar.setText("Adicionar");
        Adicionar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 167, 217), 1, true));
        Adicionar.setMaximumSize(new java.awt.Dimension(25, 25));
        Adicionar.setMinimumSize(new java.awt.Dimension(25, 25));
        Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboPorcao, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Remover, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NomeDieta, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(NomeDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPorcao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Salvar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(Remover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );

        jSplitPane1.setRightComponent(jPanel2);

        jLabel7.setBackground(new java.awt.Color(67, 161, 217));
        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Dieta");

        jLabel8.setBackground(new java.awt.Color(67, 161, 217));
        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Nova");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel7))
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BuscaJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscaJTextFieldActionPerformed

    private void NomeDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeDietaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeDietaActionPerformed

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
        if (NomeDieta.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Insira um nome para o sua Dieta.");
            return;
        } else if (TabelaDieta.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Insira alimentos na sua Dieta.");
            return;
        }
        
        DietaDTO dieta = new DietaDTO();
        dieta.setNome(NomeDieta.getText());
        dieta.setUsuarioId(Sessao.usuarioLogado.getId());
        dieta.setItens(listaAtualizada);
        
        
        serviceDieta.cadastrar(dieta);
        JOptionPane.showMessageDialog(null, "Dieta salva com sucesso!");
    }//GEN-LAST:event_SalvarActionPerformed

    private void RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverActionPerformed
        int linhaSelecionada = TabelaDieta.getSelectedRow();
        
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada.");
            return;
        }
        
        listaAtualizada = serviceItem.removerItem(linhaSelecionada);
        
        atualizarTabela(listaAtualizada, TabelaDieta, it -> new Object[] {
            it.getAlimento(),
            it.getCalorias(),
            it.getPorcao(),
            it.getAlimentoId()
                
        });
       atualizarTotalCalorias(listaAtualizada);

    }//GEN-LAST:event_RemoverActionPerformed

    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed
        int linhaSelecionada = tabelaAlimentos.getSelectedRow();
        
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada.");
            return;
        } 
        
        String nomeAlimento = (String) tabelaAlimentos.getValueAt(linhaSelecionada, 0);
        int porcao = Integer.parseInt(comboPorcao.getSelectedItem().toString());
        String unidadeMedida = String.valueOf(tabelaAlimentos.getValueAt(linhaSelecionada, 1));
        double calorias = (double) tabelaAlimentos.getValueAt(linhaSelecionada, 2);
        int alimentoId = (int) tabelaAlimentos.getValueAt(linhaSelecionada, 4);

        ItemDietaDTO item = new ItemDietaDTO(alimentoId, porcao, calorias, unidadeMedida, nomeAlimento);
        
        listaAtualizada = serviceItem.adicionarItem(item);
        
        
        atualizarTabela(listaAtualizada, TabelaDieta, it -> new Object[] {
            it.getAlimento(),
            it.getCalorias(),
            it.getPorcao(),
            it.getUnidadeMedida(),
            it.getAlimentoId()
            
        });
        atualizarTotalCalorias(listaAtualizada);
        

    }//GEN-LAST:event_AdicionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adicionar;
    private javax.swing.JTextField BuscaJTextField;
    private javax.swing.JTextField NomeDieta;
    private javax.swing.JButton Remover;
    private javax.swing.JButton Salvar;
    private javax.swing.JTable TabelaDieta;
    private javax.swing.JComboBox<String> comboPorcao;
    private javax.swing.JComboBox<String> filtroBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel pesquisaJPanel;
    private javax.swing.JTable tabelaAlimentos;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
