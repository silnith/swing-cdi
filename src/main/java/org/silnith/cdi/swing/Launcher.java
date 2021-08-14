package org.silnith.cdi.swing;

import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Default;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import org.silnith.cdi.swing.action.NewFrameAction;


@ApplicationScoped
public class Launcher {
    
    public static class NewFrameTask implements Runnable {
        
        private final Action action;

        public NewFrameTask(final Action action) {
            super();
            this.action = action;
        }

        @Override
        public void run() {
            assert SwingUtilities.isEventDispatchThread();
            
            final ActionEvent e = new ActionEvent(NewFrameTask.this, 1, "new window");
            action.actionPerformed(e);
        }
        
    }
    
    public void foo(
            @Observes @Initialized(ApplicationScoped.class) Object foo,
            @Default final NewFrameAction newFrameAction) throws InvocationTargetException, InterruptedException {
        System.out.println("Opening initial window.");
        SwingUtilities.invokeAndWait(new NewFrameTask(newFrameAction));
    }
    
}
