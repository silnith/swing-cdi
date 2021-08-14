package org.silnith.cdi.swing;

import java.awt.Dimension;
import java.awt.event.WindowListener;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


@ApplicationScoped
public class JFrameFactory {
    
    @Produces
    @Dependent
    public JFrame getJFrame(final JMenuBar jMenuBar, final @Any Instance<WindowListener> windowListeners) {
        final JPanel jPanel = new JPanel();
        jPanel.setPreferredSize(new Dimension(800, 600));
        final JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.addTab("title", jPanel);
        final JFrame jFrame = new JFrame();
        jFrame.setJMenuBar(jMenuBar);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for (final WindowListener windowListener : windowListeners) {
            jFrame.addWindowListener(windowListener);
        }
        jFrame.getContentPane().add(jTabbedPane);
        return jFrame;
    }
    
    public void dispose(@Disposes final JFrame jFrame) {
        System.out.println("dispose frame");
    }

}
