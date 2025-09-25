package br.ufmt.poo.fitMe.ui;

import br.ufmt.poo.fitMe.persistencia.entidade.Exercicio;
import br.ufmt.poo.fitMe.service.ExercicioService;
import br.ufmt.poo.fitMe.service.ItemTreinoService;
import br.ufmt.poo.fitMe.service.TreinoService;
import br.ufmt.poo.fitMe.service.impl.ExercicioServiceImpl;
import br.ufmt.poo.fitMe.service.impl.ItemTreinoServiceImpl;
import br.ufmt.poo.fitMe.service.impl.TreinoServiceImpl;
import br.ufmt.poo.fitMe.ui.dto.ItemTreinoDTO;
import br.ufmt.poo.fitMe.ui.dto.TreinoDTO;
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


public class NovoTreinoJPanel extends javax.swing.JPanel {
    ItemTreinoService serviceItem = new ItemTreinoServiceImpl();
    ExercicioService serviceExerc = new ExercicioServiceImpl();
    TreinoService serviceTreino = new TreinoServiceImpl();
    List<ItemTreinoDTO> listaAtualizada = new ArrayList<>();

    public NovoTreinoJPanel() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
        }
        
        initComponents();
        initTreino();
        configurarBusca();
        atualizarTabela(serviceExerc.buscarTodos(), tabelaExercicios, ex -> new Object[] {
            ex.getNome(),
            ex.getGrupoMuscular(),
            ex.getEquipamento(),
            ex.getId()
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
              
                List<Exercicio> lista;

                if (termo.isEmpty()) {
                    lista = serviceExerc.buscarTodos();
                } else {
                    lista = serviceExerc.buscarPorNomeEFiltro(termo, filtro);
                }

                atualizarTabela(lista, tabelaExercicios, ex -> new Object[] {
                    ex.getNome(),
                    ex.getGrupoMuscular(),
                    ex.getEquipamento(),
                    ex.getId()
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
    
    
    private void initTreino() {
         
         NomeTreino.setUI(new BasicTextFieldUI() {
            @Override
            protected void paintSafely(Graphics g) {
                super.paintSafely(g);
                if (NomeTreino.getText().isEmpty() && !NomeTreino.hasFocus()) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setColor(Color.GRAY);
                    g2.drawString("Nome do Treino", 5, NomeTreino.getHeight() / 2 + 5);
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
        tabelaExercicios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        NomeTreino = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboSeries = new javax.swing.JComboBox<>();
        comboRepeticoes = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboDescanso = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaTreino = new javax.swing.JTable();
        remover = new javax.swing.JButton();
        SalvarButton = new javax.swing.JButton();
        adicionarExercicio = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(110, 186, 217));
        setMinimumSize(new java.awt.Dimension(736, 500));

        jSplitPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jSplitPane1.setMinimumSize(new java.awt.Dimension(500, 450));
        jSplitPane1.setPreferredSize(new java.awt.Dimension(500, 450));

        pesquisaJPanel.setBackground(new java.awt.Color(255, 255, 255));
        pesquisaJPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pesquisaJPanel.setAlignmentY(0.8F);
        pesquisaJPanel.setMinimumSize(new java.awt.Dimension(195, 450));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel1.setText("Exercícios");

        BuscaJTextField.setBackground(new java.awt.Color(249, 246, 246));
        BuscaJTextField.setToolTipText("");
        BuscaJTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 167, 217)));
        BuscaJTextField.setMinimumSize(new java.awt.Dimension(143, 18));
        BuscaJTextField.setPreferredSize(new java.awt.Dimension(143, 18));
        BuscaJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaJTextFieldActionPerformed(evt);
            }
        });

        filtroBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Peito", "Costas", "Ombros", "Bíceps", "Tríceps", "Quadríceps", "Isquiotibiais ", "Panrurrílha", "Pernas", "Cardio" }));
        filtroBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 167, 217), 1, true));

        tabelaExercicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Exercício", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaExercicios.setColumnSelectionAllowed(true);
        tabelaExercicios.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabelaExercicios);
        tabelaExercicios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabelaExercicios.getColumnModel().getColumnCount() > 0) {
            tabelaExercicios.getColumnModel().getColumn(0).setMinWidth(180);
            tabelaExercicios.getColumnModel().getColumn(0).setPreferredWidth(180);
            tabelaExercicios.getColumnModel().getColumn(0).setMaxWidth(200);
            tabelaExercicios.getColumnModel().getColumn(1).setResizable(false);
            tabelaExercicios.getColumnModel().getColumn(1).setPreferredWidth(0);
            tabelaExercicios.getColumnModel().getColumn(2).setResizable(false);
            tabelaExercicios.getColumnModel().getColumn(2).setPreferredWidth(0);
            tabelaExercicios.getColumnModel().getColumn(3).setResizable(false);
            tabelaExercicios.getColumnModel().getColumn(3).setPreferredWidth(0);
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(pesquisaJPanel);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel2.setMinimumSize(new java.awt.Dimension(300, 450));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 450));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel2.setText("Plano de Treino");

        NomeTreino.setBackground(new java.awt.Color(249, 246, 246));
        NomeTreino.setToolTipText("Hello");
        NomeTreino.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 167, 217)));
        NomeTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeTreinoActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setText("Séries");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setText("Repetições");
        jLabel4.setMaximumSize(new java.awt.Dimension(80, 22));
        jLabel4.setMinimumSize(new java.awt.Dimension(80, 22));
        jLabel4.setPreferredSize(new java.awt.Dimension(80, 22));

        comboSeries.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        comboSeries.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 167, 217), 1, true));
        comboSeries.setMinimumSize(new java.awt.Dimension(48, 25));
        comboSeries.setPreferredSize(new java.awt.Dimension(48, 25));

        comboRepeticoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50" }));
        comboRepeticoes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 167, 217), 1, true));
        comboRepeticoes.setMinimumSize(new java.awt.Dimension(48, 25));
        comboRepeticoes.setPreferredSize(new java.awt.Dimension(48, 25));
        comboRepeticoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRepeticoesActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setText("Descanso (min)");

        comboDescanso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        comboDescanso.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 167, 217), 1, true));
        comboDescanso.setMinimumSize(new java.awt.Dimension(48, 25));
        comboDescanso.setPreferredSize(new java.awt.Dimension(48, 25));
        comboDescanso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDescansoActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Treino");

        tabelaTreino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Exercício", "Séries", "Repet.", "Desc.", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaTreino.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tabelaTreino);
        tabelaTreino.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tabelaTreino.getColumnModel().getColumnCount() > 0) {
            tabelaTreino.getColumnModel().getColumn(0).setMinWidth(120);
            tabelaTreino.getColumnModel().getColumn(0).setPreferredWidth(120);
            tabelaTreino.getColumnModel().getColumn(1).setMinWidth(10);
            tabelaTreino.getColumnModel().getColumn(1).setPreferredWidth(7);
            tabelaTreino.getColumnModel().getColumn(2).setMinWidth(10);
            tabelaTreino.getColumnModel().getColumn(2).setPreferredWidth(7);
            tabelaTreino.getColumnModel().getColumn(3).setMinWidth(10);
            tabelaTreino.getColumnModel().getColumn(3).setPreferredWidth(7);
            tabelaTreino.getColumnModel().getColumn(4).setMinWidth(0);
            tabelaTreino.getColumnModel().getColumn(4).setPreferredWidth(0);
            tabelaTreino.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        remover.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        remover.setForeground(new java.awt.Color(41, 167, 217));
        remover.setText("Remover");
        remover.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 167, 217), 1, true));
        remover.setMaximumSize(new java.awt.Dimension(25, 25));
        remover.setMinimumSize(new java.awt.Dimension(25, 25));
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        SalvarButton.setBackground(new java.awt.Color(41, 167, 217));
        SalvarButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SalvarButton.setForeground(new java.awt.Color(255, 255, 255));
        SalvarButton.setText("Salvar Treino");
        SalvarButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 167, 217), 1, true));
        SalvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarButtonActionPerformed(evt);
            }
        });

        adicionarExercicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adicionarExercicio.setForeground(new java.awt.Color(41, 167, 217));
        adicionarExercicio.setText("Adicionar");
        adicionarExercicio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 167, 217), 1, true));
        adicionarExercicio.setMaximumSize(new java.awt.Dimension(25, 25));
        adicionarExercicio.setMinimumSize(new java.awt.Dimension(25, 25));
        adicionarExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarExercicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SalvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboSeries, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboRepeticoes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboDescanso, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(adicionarExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                                .addComponent(NomeTreino, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(NomeTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboSeries, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboRepeticoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboDescanso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adicionarExercicio, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SalvarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(remover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );

        jSplitPane1.setRightComponent(jPanel2);

        jLabel7.setBackground(new java.awt.Color(67, 161, 217));
        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Treino");

        jLabel8.setBackground(new java.awt.Color(67, 161, 217));
        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Novo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
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
 
    }//GEN-LAST:event_BuscaJTextFieldActionPerformed

    private void NomeTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeTreinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeTreinoActionPerformed

    private void comboDescansoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDescansoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDescansoActionPerformed

    private void SalvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarButtonActionPerformed
        if (NomeTreino.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Insira um nome para o seu treino");
            return;
        } else if (tabelaTreino.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Insira exercícios no seu treino");
            return;
        }
        
        TreinoDTO treino = new TreinoDTO();
        treino.setNome(NomeTreino.getText());
        treino.setUsuarioId(Sessao.usuarioLogado.getId());
        treino.setItens(listaAtualizada);
        
        
        serviceTreino.cadastrar(treino);
        JOptionPane.showMessageDialog(null, "Treino salvo com sucesso!");
    }//GEN-LAST:event_SalvarButtonActionPerformed

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        int linhaSelecionada = tabelaTreino.getSelectedRow();
        
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada.");
            return;
        }
        
        listaAtualizada = serviceItem.removerItem(linhaSelecionada);
        
        atualizarTabela(listaAtualizada, tabelaTreino, it -> new Object[] {
            it.getExercicio(),
            it.getSeries(),
            it.getRepeticoes(),
            it.getDescanso()
        });
    }//GEN-LAST:event_removerActionPerformed

    private void comboRepeticoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRepeticoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboRepeticoesActionPerformed

    private void adicionarExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarExercicioActionPerformed
        int linhaSelecionada = tabelaExercicios.getSelectedRow();
        
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada.");
            return;
        } 
        
        String nomeExercicio = (String) tabelaExercicios.getValueAt(linhaSelecionada, 0);
        int series = Integer.parseInt(comboSeries.getSelectedItem().toString());
        int repeticoes = Integer.parseInt(comboRepeticoes.getSelectedItem().toString());
        int descanso = Integer.parseInt(comboDescanso.getSelectedItem().toString());
        int exercicioId = (int) tabelaExercicios.getValueAt(linhaSelecionada, 3);

        ItemTreinoDTO item = new ItemTreinoDTO(exercicioId, series, repeticoes, descanso, nomeExercicio);
        
        listaAtualizada = serviceItem.adicionarItem(item);
        
        
        atualizarTabela(listaAtualizada, tabelaTreino, it -> new Object[] {
            it.getExercicio(),
            it.getSeries(),
            it.getRepeticoes(),
            it.getDescanso(),
            it.getExercicioId()
        });
    }//GEN-LAST:event_adicionarExercicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BuscaJTextField;
    private javax.swing.JTextField NomeTreino;
    private javax.swing.JButton SalvarButton;
    private javax.swing.JButton adicionarExercicio;
    private javax.swing.JComboBox<String> comboDescanso;
    private javax.swing.JComboBox<String> comboRepeticoes;
    private javax.swing.JComboBox<String> comboSeries;
    private javax.swing.JComboBox<String> filtroBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel pesquisaJPanel;
    private javax.swing.JButton remover;
    private javax.swing.JTable tabelaExercicios;
    private javax.swing.JTable tabelaTreino;
    // End of variables declaration//GEN-END:variables
}
