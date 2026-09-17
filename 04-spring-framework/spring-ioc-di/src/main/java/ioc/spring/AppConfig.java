package ioc.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class AppConfig {

    @Bean(name = "process-2")
    public Process makeProcess(){

        Process process = new Process();
        process.setId(2);
        process.setDesc("PROCESS-2");
        return process;
    }
}
