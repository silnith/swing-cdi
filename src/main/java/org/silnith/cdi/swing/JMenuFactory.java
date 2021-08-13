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
import org.silnith.cdi.swing.annotation.Application;
import org.silnith.cdi.swing.annotation.Frame;
import org.silnith.cdi.swing.annotation.Tab;


@ApplicationScoped
public class JMenuFactory {
    
    @Produces
    @Dependent
    @Application
    public JMenu getApplicationMenu(final @Application Instance<Action> frameActions) {
        final JMenu jMenu = new JMenu("Application");
        for (final Action frameAction : frameActions) {
            jMenu.add(frameAction);
        }
        return jMenu;
    }
    
    @Produces
    @Dependent
    @Frame
    public JMenu getFrameMenu(final @Frame Instance<Action> frameActions) {
        final JMenu jMenu = new JMenu("Frame");
        for (final Action frameAction : frameActions) {
            jMenu.add(frameAction);
        }
        return jMenu;
    }
    
    @Produces
    @Dependent
    @Tab
    public JMenu getTabMenu(final @Tab Instance<Action> tabActions) {
        final JMenu jMenu = new JMenu("Tab");
        for (final Action tabAction : tabActions) {
            jMenu.add(tabAction);
        }
        return jMenu;
    }
    
    @Produces
    @Dependent
//    @LookAndFeel
    public JMenu getLookAndFeelMenu(final Collection<UIManager.LookAndFeelInfo> lookAndFeelInfos) {
        final JMenu jMenu = new JMenu("Look and Feel");
        for (final UIManager.LookAndFeelInfo info : lookAndFeelInfos) {
            jMenu.add(new SetLookAndFeelAction(info));
        }
        return jMenu;
    }

}
