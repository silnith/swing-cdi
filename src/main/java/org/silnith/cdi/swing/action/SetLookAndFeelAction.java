package org.silnith.cdi.swing.action;

import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class SetLookAndFeelAction extends AbstractAction implements Action {
    
    private final UIManager.LookAndFeelInfo lookAndFeelInfo;

    public SetLookAndFeelAction(final UIManager.LookAndFeelInfo lookAndFeelInfo) {
        super(lookAndFeelInfo.getName());
        this.lookAndFeelInfo = lookAndFeelInfo;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        assert SwingUtilities.isEventDispatchThread();
        
        try {
            UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
            
            for (final Window window : Window.getWindows()) {
                SwingUtilities.updateComponentTreeUI(window);
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
    }

}
