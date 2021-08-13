package org.silnith.cdi.swing;

import java.awt.event.WindowListener;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;


@ApplicationScoped
public class JFrameFactory {
    
    @Produces
    @Dependent
    public JFrame getJFrame(final JMenuBar jMenuBar, final @Any Instance<WindowListener> windowListeners) {
        final JFrame jFrame = new JFrame();
        jFrame.setJMenuBar(jMenuBar);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for (final WindowListener windowListener : windowListeners) {
            jFrame.addWindowListener(windowListener);
        }
        final JTabbedPane jTabbedPane = new JTabbedPane();
        jFrame.getContentPane().add(jTabbedPane);
        return jFrame;
    }

}
