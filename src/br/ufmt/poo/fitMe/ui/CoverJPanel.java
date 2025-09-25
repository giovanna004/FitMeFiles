package br.ufmt.poo.fitMe.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;


public class CoverJPanel extends javax.swing.JPanel {
        
        private final DecimalFormat df = new DecimalFormat("##0.###");
        private ActionListener event;
        private MigLayout layout;
        private JLabel titulo;
        private JLabel descricao;
        private JLabel descricao1;
        private ButtonOutLine button;
        private boolean isLogin;
        
        public CoverJPanel() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]25[]10[]25[]push");
        setLayout(layout);
        init();
    }
    
    private void init() {
        titulo = new JLabel("Bem-Vindo!");
        titulo.setFont(new Font("sansserif", 1, 30));
        titulo.setForeground(new Color(245, 245, 245));
        add(titulo);
        descricao = new JLabel("Para continuar conectado por favor");
        descricao.setForeground(new Color(245, 245, 245));
        add(descricao);
        descricao1 = new JLabel("preencha suas informações");
        descricao1.setForeground(new Color(245, 245, 245));
        add(descricao1);
        button = new ButtonOutLine();
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(new Color(255, 255, 255));
        button.setText("ENTRAR");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event.actionPerformed(e);
            }
            
        });
        add(button, "w 60%, h 40");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        GradientPaint gra = new GradientPaint(0, 0, new Color(187, 232, 155), 0, getHeight(), new Color(157, 191, 132));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g); 
    }
    
    public void addEvent(ActionListener event) {
        this.event = event;
    }
    
    public void registroEsquerda(double v) {
        v = Double.valueOf(df.format(v).replace(',', '.'));
        login(false);
        layout.setComponentConstraints(titulo, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(descricao, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(descricao1, "pad 0 -" + v + "% 0 0");
    }
    
    public void registroDireita(double v) {
        v = Double.valueOf(df.format(v).replace(',', '.'));
        login(false);
        layout.setComponentConstraints(titulo, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(descricao, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(descricao1, "pad 0 -" + v + "% 0 0");
    }
    
    public void loginEsquerda(double v){
        v = Double.valueOf(df.format(v).replace(',', '.'));
        login(true);
        layout.setComponentConstraints(titulo, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(descricao, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(descricao1, "pad 0 " + v + "% 0 " + v + "%");
    }
    
    public void loginDireita(double v){
        v = Double.valueOf(df.format(v).replace(',', '.'));
        login(true);
        layout.setComponentConstraints(titulo, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(descricao, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(descricao1, "pad 0 " + v + "% 0 " + v + "%");
    }
    
    private void login(boolean login) {
        if (this.isLogin != login) {
            if (login) {
                titulo.setText("Olá!");
                descricao.setText("Insira seus dados e comece");
                descricao1.setText("seu progresso conosco");
                button.setText("CADASTRO");
            } else {
                titulo.setText("Bem-Vindo!");
                descricao.setText("Para continuar conectado por favor");
                descricao1.setText("preencha seus dados pessoais");
                button.setText("ENTRAR");
            }
            this.isLogin = login;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
