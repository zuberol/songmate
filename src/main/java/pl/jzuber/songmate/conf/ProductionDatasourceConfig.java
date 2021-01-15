package pl.jzuber.songmate.conf;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("production")
public class ProductionDatasourceConfig {
    public void setup() {
        System.out.println("Setting up datasource for PRODUCTION environment. ");
    }
}