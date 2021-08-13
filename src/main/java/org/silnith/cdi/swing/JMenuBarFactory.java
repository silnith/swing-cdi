package org.silnith.cdi.swing;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.swing.JMenu;
import javax.swing.JMenuBar;


@ApplicationScoped
public class JMenuBarFactory {
    
    @Produces
    @Dependent
    public JMenuBar getJMenuBar(final @Any Instance<JMenu> jMenuInstance) {
        final JMenuBar jMenuBar = new JMenuBar();
        for (final JMenu jMenu : jMenuInstance) {
            jMenuBar.add(jMenu);
        }
        return jMenuBar;
    }

}
