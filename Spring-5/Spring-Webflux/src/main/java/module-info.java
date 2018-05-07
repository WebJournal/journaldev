module com.journaldev.spring {
    requires reactor.core;
    requires spring.web;
    requires spring.beans;
    requires spring.context;
    requires spring.webflux;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    exports com.journaldev.spring;
}