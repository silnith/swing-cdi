package org.silnith.cdi.swing.action;

import java.awt.event.ActionEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.silnith.cdi.swing.annotation.Frame;


/**
 * An action that creates a new {@link javax.swing.JFrame}.
 */
@ApplicationScoped
@Frame
public class NewWindowAction extends AbstractAction implements Action {
    
    @Inject
    private Provider<JFrame> jFrameProvider;
    
    @Inject
    public NewWindowAction() {
        super("New Window");
        this.putValue(Action.SHORT_DESCRIPTION, "Open a new window.");
        this.putValue(Action.LONG_DESCRIPTION, "Open a new window, dude.");
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        assert SwingUtilities.isEventDispatchThread();
        
        final JFrame jFrame = jFrameProvider.get();
        jFrame.pack();
        jFrame.setVisible(true);
    }

}
