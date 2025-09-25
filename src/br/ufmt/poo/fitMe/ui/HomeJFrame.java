package br.ufmt.poo.fitMe.ui;

import br.ufmt.poo.fitMe.ui.drawer.MeuDrawerBuilder;
import javax.swing.*;
import java.awt.*;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;

public class HomeJFrame extends javax.swing.JFrame {
    
    private static HomeJFrame instance;

    
    public HomeJFrame() {
        GlassPanePopup.install(this);
        MeuDrawerBuilder meuDrawerBuilder = new MeuDrawerBuilder();
        Drawer.getInstance().setDrawerBuilder(meuDrawerBuilder);
        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 520));
        setLocationRelativeTo(null);
        
        initComponents();
        instance = this;
        HomeJFrame.getInstance().trocarTela(new DashboardJPanel());
        
        botaoMenu.setBorderPainted(false);
        botaoMenu.setContentAreaFilled(false);
        botaoMenu.setFocusPainted(false);
        botaoMenu.setOpaque(false);
        
        
        
        
        addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowOpened(java.awt.event.WindowEvent evt) {
            
        }
    });
    }
    
    public static HomeJFrame getInstance() {
        return instance;
    }

    
    public void trocarTela(JPanel novoPainel) {
        TelajPanel.removeAll();
        TelajPanel.add(novoPainel);
        TelajPanel.revalidate();
        TelajPanel.repaint();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LateraljPanel = new javax.swing.JPanel();
        botaoMenu = new javax.swing.JButton();
        TelajPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 520));
        setPreferredSize(new java.awt.Dimension(800, 520));

        LateraljPanel.setBackground(new java.awt.Color(255, 255, 255));
        LateraljPanel.setMinimumSize(new java.awt.Dimension(58, 500));
        LateraljPanel.setPreferredSize(new java.awt.Dimension(58, 520));
        LateraljPanel.setRequestFocusEnabled(false);

        botaoMenu.setBackground(new java.awt.Color(204, 204, 204));
        botaoMenu.setForeground(new java.awt.Color(255, 255, 255));
        botaoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/menu_normal.png"))); // NOI18N
        botaoMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoMenu.setBorderPainted(false);
        botaoMenu.setContentAreaFilled(false);
        botaoMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botaoMenu.setFocusPainted(false);
        botaoMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/menu_hover.png"))); // NOI18N
        botaoMenu.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/menu_pressed.png"))); // NOI18N
        botaoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LateraljPanelLayout = new javax.swing.GroupLayout(LateraljPanel);
        LateraljPanel.setLayout(LateraljPanelLayout);
        LateraljPanelLayout.setHorizontalGroup(
            LateraljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LateraljPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(botaoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        LateraljPanelLayout.setVerticalGroup(
            LateraljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LateraljPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TelajPanel.setMinimumSize(new java.awt.Dimension(736, 520));
        TelajPanel.setPreferredSize(new java.awt.Dimension(736, 520));
        TelajPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LateraljPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TelajPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LateraljPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TelajPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMenuActionPerformed
        Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_botaoMenuActionPerformed


        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LateraljPanel;
    private javax.swing.JPanel TelajPanel;
    private javax.swing.JButton botaoMenu;
    // End of variables declaration//GEN-END:variables
}
