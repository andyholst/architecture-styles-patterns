package com.design.component;

public class ComponentImpl implements Component {

    private final Port port;
    private final Connector connector;

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
