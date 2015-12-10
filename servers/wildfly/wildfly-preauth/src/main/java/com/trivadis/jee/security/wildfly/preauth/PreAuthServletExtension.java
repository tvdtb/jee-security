package com.trivadis.jee.security.wildfly.preauth;

import io.undertow.servlet.ServletExtension;
import io.undertow.servlet.api.DeploymentInfo;

import java.util.logging.Logger;

import javax.servlet.ServletContext;

public class PreAuthServletExtension implements ServletExtension {
	private static Logger LOG = Logger.getLogger(PreAuthServletExtension.class.getName());
	
    @Override
    public void handleDeployment(DeploymentInfo deploymentInfo, ServletContext servletContext) {

    	LOG.fine("PREAUTHENTICATED servlet extensio created");
        deploymentInfo.addAuthenticationMechanism("PREAUTHENTICATED", new PreAuthFactory());
    }
}
