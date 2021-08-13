package org.silnith.cdi.swing.action;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


@ApplicationScoped
public class WindowTracker implements ActionListener, WindowListener {
    
    private final Collection<JFrame> frames = new ArrayList<>();

    @Override
    public void actionPerformed(final ActionEvent e) {
        assert SwingUtilities.isEventDispatchThread();
        System.out.println("Action performed.");
    }

    @Override
    public void windowOpened(WindowEvent e) {
        assert SwingUtilities.isEventDispatchThread();
        System.out.println("Window opened.");
        final Component component = e.getComponent();
        if (component instanceof JFrame) {
            final JFrame jFrame = (JFrame) component;
            frames.add(jFrame);
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        assert SwingUtilities.isEventDispatchThread();
        System.out.println("Window closing.");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        assert SwingUtilities.isEventDispatchThread();
        System.out.println("Window closed.");
        final Component component = e.getComponent();
        frames.remove(component);
        if (component instanceof Window) {
            final Window window = (Window) component;
//            window.dispose();
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {
        assert SwingUtilities.isEventDispatchThread();
        System.out.println("Window iconified.");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        assert SwingUtilities.isEventDispatchThread();
        System.out.println("Window deiconified.");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        assert SwingUtilities.isEventDispatchThread();
        System.out.println("Window activated.");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        assert SwingUtilities.isEventDispatchThread();
        System.out.println("Window deactivated.");
    }

}
