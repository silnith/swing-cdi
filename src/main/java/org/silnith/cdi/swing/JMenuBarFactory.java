package org.silnith.cdi.swing;

import java.lang.annotation.Annotation;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.util.AnnotationLiteral;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import org.silnith.cdi.swing.annotation.Menu;


@ApplicationScoped
public class JMenuBarFactory {
    
    public static class MenuQualifier extends AnnotationLiteral<Menu> implements Menu {
        
        private final Menus menuType;

        public MenuQualifier(final Menus menuType) {
            super();
            this.menuType = menuType;
        }

        @Override
        public Menus value() {
            return menuType;
        }
        
    }
    
    @Produces
    @Dependent
    public JMenuBar getJMenuBar(final @Any Instance<JMenu> jMenuInstance) {
        final JMenuBar jMenuBar = new JMenuBar();
        for (final Menus menuType : Menus.values()) {
            final Annotation annotation = new MenuQualifier(menuType);
            final Instance<JMenu> selector = jMenuInstance.select(annotation);
            if (!selector.isResolvable()) {
                continue;
            }
            final JMenu jMenu = selector.get();
            jMenuBar.add(jMenu);
        }
        return jMenuBar;
    }

}
