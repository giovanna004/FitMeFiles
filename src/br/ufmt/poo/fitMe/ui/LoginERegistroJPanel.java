package br.ufmt.poo.fitMe.ui;

import br.ufmt.poo.fitMe.persistencia.entidade.Usuario;
import br.ufmt.poo.fitMe.service.UsuarioService;
import br.ufmt.poo.fitMe.service.impl.UsuarioServiceImpl;
import br.ufmt.poo.fitMe.ui.dto.UsuarioDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;

public class LoginERegistroJPanel extends javax.swing.JLayeredPane {
    
    UsuarioService service = new UsuarioServiceImpl();
    
        
    public LoginERegistroJPanel() {
        initComponents();
        initLogin();
        initRegistro();
        login.setVisible(false);
        registro.setVisible(true);
    }
    
    private void initRegistro(){
        registro.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Criar Conta");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(157, 191, 132));
        registro.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/Imagens/user.png")));
        txtUser.setHint("Nome");
        registro.add(txtUser, "w 60%");
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/Imagens/mail.png")));
        txtEmail.setHint("Email");
        registro.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/Imagens/pass.png")));
        txtPass.setHint("Senha");
        registro.add(txtPass, "w 60%");
        Button cmd = new Button();
        cmd.setBackground(new Color(157, 191, 132));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("INSCREVER-SE");
        registro.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = txtUser.getText();
                    String email = txtEmail.getText();
                    String senha = new String(txtPass.getPassword());

                    UsuarioDTO dto = new UsuarioDTO();
                    dto.setNome(nome);
                    dto.setEmail(email);
                    dto.setSenha(senha);
                    
                    txtUser.setText("");
                    txtEmail.setText("");
                    txtPass.setText("");

                    service.registrar(dto);
                    
                 
                    JOptionPane.showMessageDialog(null, "Registro efetuado com sucesso!");
                    
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            
        });
    }
    
    private void initLogin(){
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Entrar");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(157, 191, 132));
        login.add(label);
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/Imagens/mail.png")));
        txtEmail.setHint("Email");
        login.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/Imagens/pass.png")));
        txtPass.setHint("Senha");
        login.add(txtPass, "w 60%");
        JButton cmdForget = new JButton("Esqueceu sua senha ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);
        Button cmd = new Button();
        cmd.setBackground(new Color(157, 191, 132));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("ENTRAR");
        login.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String email = txtEmail.getText();
                    String senha = new String(txtPass.getPassword());

                    UsuarioService service = new UsuarioServiceImpl();
                    Usuario usuario = service.entrar(email, senha);

                    Sessao.usuarioLogado = usuario;

                    new HomeJFrame().setVisible(true);

                    Window window = SwingUtilities.getWindowAncestor(LoginERegistroJPanel.this);
                    if (window instanceof LoginERegistroJFrame) {
                        window.dispose();
                    }

                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }
    
    public void showRegistro(boolean show) {
        if (show) {
            registro.setVisible(true);
            login.setVisible(false);
        } else {
            registro.setVisible(false);
            login.setVisible(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        registro = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        registro.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registroLayout = new javax.swing.GroupLayout(registro);
        registro.setLayout(registroLayout);
        registroLayout.setHorizontalGroup(
            registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registroLayout.setVerticalGroup(
            registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(registro, "card2");
    }// </editor-fold>//GEN-END:initComponents
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel registro;
    // End of variables declaration//GEN-END:variables

    
}
