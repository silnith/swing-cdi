package org.silnith.cdi.swing.action;

import java.awt.event.ActionEvent;

import javax.enterprise.context.Dependent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import org.silnith.cdi.swing.annotation.Tab;


@Dependent
@Tab
public class CloseTabAction extends AbstractAction implements Action {

    public CloseTabAction() {
        super("Close Tab");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        assert SwingUtilities.isEventDispatchThread();
        
        System.out.println("Close tab.");
    }

}
