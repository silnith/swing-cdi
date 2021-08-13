package org.silnith.cdi.swing;

import java.lang.reflect.InvocationTargetException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


@ApplicationScoped
public class Launcher {
    
    public void foo(@Observes @Initialized(ApplicationScoped.class) Object foo, final JFrame jFrame) throws InvocationTargetException, InterruptedException {
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
