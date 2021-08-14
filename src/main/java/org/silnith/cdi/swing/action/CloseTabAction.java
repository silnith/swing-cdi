package org.silnith.cdi.swing.action;

import java.awt.event.ActionEvent;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import org.silnith.cdi.swing.Menus;
import org.silnith.cdi.swing.annotation.Menu;


@Dependent
@Default
@Menu(Menus.TAB)
public class CloseTabAction extends AbstractAction implements Action {

    @Inject
    public CloseTabAction() {
        super("Close Tab");
        this.putValue(SHORT_DESCRIPTION, "Close the current tab.");
        this.putValue(LONG_DESCRIPTION, "Close the current tab in the currently active window.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        assert SwingUtilities.isEventDispatchThread();
        
        System.out.println("Close tab.");
    }

}
