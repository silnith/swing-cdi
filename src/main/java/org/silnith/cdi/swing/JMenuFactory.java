package org.silnith.cdi.swing;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.UIManager;

import org.silnith.cdi.swing.action.SetLookAndFeelAction;
import org.silnith.cdi.swing.annotation.Menu;


@ApplicationScoped
public class JMenuFactory {
    
    @Produces
    @Dependent
    @Menu(Menus.APPLICATION)
    public JMenu getApplicationMenu(final @Menu(Menus.APPLICATION) Instance<Action> applicationMenuActions) {
        final JMenu jMenu = new JMenu("Application");
        for (final Action frameAction : applicationMenuActions) {
            jMenu.add(frameAction);
        }
        return jMenu;
    }
    
    @Produces
    @Dependent
    @Menu(Menus.FRAME)
    public JMenu getFrameMenu(final @Menu(Menus.FRAME) Instance<Action> frameMenuActions) {
        final JMenu jMenu = new JMenu("Frame");
        for (final Action frameAction : frameMenuActions) {
            jMenu.add(frameAction);
        }
        return jMenu;
    }
    
    @Produces
    @Dependent
    @Menu(Menus.TAB)
    public JMenu getTabMenu(final @Menu(Menus.TAB) Instance<Action> tabMenuActions) {
        final JMenu jMenu = new JMenu("Tab");
        for (final Action tabAction : tabMenuActions) {
            jMenu.add(tabAction);
        }
        return jMenu;
    }
    
    @Produces
    @Dependent
    @Menu(Menus.LOOK_AND_FEEL)
    public JMenu getLookAndFeelMenu(final Collection<UIManager.LookAndFeelInfo> lookAndFeelInfos) {
        final JMenu jMenu = new JMenu("Look and Feel");
        for (final UIManager.LookAndFeelInfo info : lookAndFeelInfos) {
            jMenu.add(new SetLookAndFeelAction(info));
        }
        return jMenu;
    }

}
