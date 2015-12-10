package com.trivadis.jee.security.wildfly.preauth;

import io.undertow.servlet.ServletExtension;
import io.undertow.servlet.api.DeploymentInfo;

import javax.servlet.ServletContext;

public class PreAuthServletExtension implements ServletExtension {
    @Override
    public void handleDeployment(DeploymentInfo deploymentInfo, ServletContext servletContext) {

    	System.out.println("PREAUTHENTICATED mechanism");
        deploymentInfo.addAuthenticationMechanism("PREAUTHENTICATED", new PreAuthFactory());
    }
}
