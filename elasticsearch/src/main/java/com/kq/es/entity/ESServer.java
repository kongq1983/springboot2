package com.kq.es.entity;

public class ESServer {

    protected String hostname;
    protected int port;
    protected String scheme;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @Override
    public String toString() {
        return "ESServer{" +
                "hostname='" + hostname + '\'' +
                ", port=" + port +
                ", scheme='" + scheme + '\'' +
                '}';
    }
}
