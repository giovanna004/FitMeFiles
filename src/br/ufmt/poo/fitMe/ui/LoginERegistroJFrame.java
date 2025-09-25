package br.ufmt.poo.fitMe.ui;

import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class LoginERegistroJFrame extends javax.swing.JFrame {
    
    private MigLayout layout;
    private CoverJPanel cover;
    private LoginERegistroJPanel loginERegistro;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;
    private final DecimalFormat df = new DecimalFormat("##0.###");

    public LoginERegistroJFrame() {
        initComponents();
        init();
    }
    
    private void init(){
            layout = new MigLayout("fill, insets 0");
            cover = new CoverJPanel();
            loginERegistro = new LoginERegistroJPanel();
            TimingTarget target = new TimingTargetAdapter(){
                @Override
                public void timingEvent(float fraction) {
                    double fractionCover;
                    double fractionLogin;
                    double size = coverSize;
                    if (fraction <= 0.5f){
                        size += fraction * addSize;
                    } else {
                        size += addSize - fraction * addSize;
                    }                                     
                    if (isLogin){
                        fractionCover = 1f - fraction;
                        fractionLogin = fraction;
                        if (fraction >= 0.5f) {
                            cover.registroDireita(fractionCover * 100);
                        } else {
                            cover.loginDireita(fractionLogin * 100);
                        }
                    } else {
                        fractionCover = fraction;
                        fractionLogin = 1f - fraction;
                        if (fraction <= 0.5f) {
                            cover.registroEsquerda(fraction * 100);
                        } else {
                            cover.loginEsquerda((1f - fraction) * 100);
                        }
                    }
                    if (fraction >= 0.5 ) {
                        loginERegistro.showRegistro(isLogin);
                    }
                    fractionCover = Double.valueOf(df.format(fractionCover).replace(',', '.'));
                    fractionLogin = Double.valueOf(df.format(fractionLogin).replace(',', '.'));
                    layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                    layout.setComponentConstraints(loginERegistro, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
                    bg.revalidate();
                }

                @Override
                public void end() {
                    isLogin = !isLogin; 
                }
                
            };
            
            Animator animator = new Animator(800, target);
            animator.setAcceleration(0.5f);
            animator.setDeceleration(0.5f);
            animator.setResolution(0);
            bg.setLayout(layout);
            bg.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
            bg.add(loginERegistro, "width " + loginSize + "%, pos 1al 0 n 100%");
            cover.addEvent((ActionEvent e) -> {
                if (!animator.isRunning()) {
                    animator.start();
                }
            });
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new LoginERegistroJFrame().setVisible(true);
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
