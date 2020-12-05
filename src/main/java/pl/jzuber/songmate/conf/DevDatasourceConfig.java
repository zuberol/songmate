package pl.jzuber.songmate.conf;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevDatasourceConfig {
    public void setup() {
        System.out.println("Setting up datasource for DEV environment. ");
    }
}