package org.silnith.cdi.swing.weld;

import java.lang.reflect.InvocationTargetException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jboss.weld.environment.se.events.ContainerInitialized;


@ApplicationScoped
public class Launcher {
    
    public void openInitialWindow(@Observes final ContainerInitialized foo, final JFrame jFrame) throws InvocationTargetException, InterruptedException {
        System.out.println("Opening initial window.");
        SwingUtilities.invokeAndWait(new Runnable() {
            
            @Override
            public void run() {
                assert SwingUtilities.isEventDispatchThread();
                
                jFrame.setVisible(true);
            }
            
        });
    }

}
