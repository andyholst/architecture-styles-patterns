package com.design.component;

public class ComponentImpl implements Component {

    private Port port;
    private Connector connector;

    public ComponentImpl() {
        port = new PortImpl();
        connector = new ConnectorImpl();
    }

    @Override
    public Connector getConnector() {
        return connector;
    }

    @Override
    public Port getPort() {
        return port;
    }
}
