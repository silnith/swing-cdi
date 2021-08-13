package org.silnith.cdi.swing.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.swing.UIManager;


@ApplicationScoped
public class LookAndFeelFactory {
    
    private Collection<UIManager.LookAndFeelInfo> installedLookAndFeels;
    
    @Inject
    public LookAndFeelFactory() {
        super();
    }

    @PostConstruct
    public void init() {
        this.installedLookAndFeels = new ArrayList<>(Arrays.asList(UIManager.getInstalledLookAndFeels()));
    }

    @Produces
    @Dependent
    public Collection<UIManager.LookAndFeelInfo> getInstalledLookAndFeels() {
        return installedLookAndFeels;
    }

}
