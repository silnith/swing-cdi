package org.silnith.cdi.swing.action;

import java.awt.event.ActionEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import org.silnith.cdi.swing.Menus;
import org.silnith.cdi.swing.annotation.Menu;


@ApplicationScoped
@Default
@Menu(Menus.FRAME)
public class NewTabAction extends AbstractAction implements Action {

    @Inject
    public NewTabAction() {
        super("New Tab");
        this.putValue(SHORT_DESCRIPTION, "Open a new tab.");
        this.putValue(LONG_DESCRIPTION, "Open a new tab in the currently active window.");
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        assert SwingUtilities.isEventDispatchThread();
        
        System.out.println("Add a new tab.");
    }

}
