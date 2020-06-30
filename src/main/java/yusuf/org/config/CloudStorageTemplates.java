package yusuf.org.config;

import io.quarkus.qute.EngineBuilder;

import javax.enterprise.event.Observes;

public class CloudStorageTemplates {

    void addLocator(@Observes EngineBuilder engineBuilder){
        engineBuilder.addLocator(new CloudStorageLocator());

    }
}
