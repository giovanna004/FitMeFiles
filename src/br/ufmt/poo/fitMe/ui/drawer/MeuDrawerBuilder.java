
package br.ufmt.poo.fitMe.ui.drawer;
import br.ufmt.poo.fitMe.ui.DashboardJPanel;
import br.ufmt.poo.fitMe.ui.Sessao;
import br.ufmt.poo.fitMe.ui.DietasJPanel;
import br.ufmt.poo.fitMe.ui.HomeJFrame;
import br.ufmt.poo.fitMe.ui.LoginERegistroJFrame;
import br.ufmt.poo.fitMe.ui.NovaDietaJPanel;
import br.ufmt.poo.fitMe.ui.NovoTreinoJPanel;
import br.ufmt.poo.fitMe.ui.TreinosJPanel;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Window;
import javax.swing.Icon;
import javax.swing.SwingUtilities;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuValidation;
import raven.drawer.component.menu.SimpleMenuOption;
import raven.swing.AvatarIcon;


public class MeuDrawerBuilder extends SimpleDrawerBuilder {

    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        String nome = Sessao.usuarioLogado != null ? Sessao.usuarioLogado.getNome() : "Usuário";
        String email = Sessao.usuarioLogado != null ? Sessao.usuarioLogado.getEmail() : "email@exemplo.com";
        
        return new SimpleHeaderData()
                .setIcon(new AvatarIcon(getClass().getResource("/Imagens/Icon1.png"), 60, 60, 999))
                .setTitle(nome)
                .setDescription(email);
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {

        String items[][] = {
            {"~MAIN~"},
            {"Dashboard"},
            {"Treinos", "Novo Treino", "Treinos Cadastrados"},
            {"Dietas", "Nova Dieta", "Dietas Cadastradas"},
            {"Logout"}
                
        };
        
        String icons[] = {
            "icons/dashboard.svg",
            "icons/fitness-watch.svg",
            "icons/diet.svg",
            "icons/logout.svg"
        };

        SimpleMenuOption simpleMenuOption = new SimpleMenuOption() {
            @Override
            public Icon buildMenuIcon(String path, float scale) {
                FlatSVGIcon icon = new FlatSVGIcon(path, 0.8f);
                FlatSVGIcon.ColorFilter colorFilter = new FlatSVGIcon.ColorFilter();
                colorFilter.add(Color.decode("#969696"), Color.decode("#FAFAFA"), Color.decode("#969696"));
                icon.setColorFilter(colorFilter);
                return icon;
            }
        };

        return simpleMenuOption
                .setMenus(items)
                .setIcons(icons)
                .addMenuEvent((MenuAction action, int index, int subIndex) -> {
                    if (index == 0) {
                        HomeJFrame.getInstance().trocarTela(new DashboardJPanel());
                    }
                    if (index == 1 && subIndex == 1) {
                        HomeJFrame.getInstance().trocarTela(new NovoTreinoJPanel());
                    }
                    if (index == 1 && subIndex == 2) {
                        HomeJFrame.getInstance().trocarTela(new TreinosJPanel());
                    }
                    if (index == 2 && subIndex == 1) {
                        HomeJFrame.getInstance().trocarTela(new NovaDietaJPanel());
                    }
                    if (index == 2 && subIndex == 2) {
                        HomeJFrame.getInstance().trocarTela(new DietasJPanel());
                    }
                    if (index == 3) {
                        Sessao.usuarioLogado = null;

                        LoginERegistroJFrame login = new LoginERegistroJFrame();
                        login.setVisible(true);
                        
                        Window window = HomeJFrame.getInstance();
                        if (window != null) {
                            window.dispose();
                        }
                        
                    }
        })
                .setMenuValidation(new MenuValidation() {
                    @Override
                    public boolean menuValidation(int index, int subIndex) {
                        if (index == -1) {
                            return false;
                        } else if (index == 5) {
                            return false;
                        }
                        return true;
                    }
                });
                
}

    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData()
                .setTitle("FitMe - Treino e Dieta")
                .setDescription("Version 1.0.0");
    }
    
}
