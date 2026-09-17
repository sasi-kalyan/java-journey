package ioc.spring;

import org.springframework.context.annotation.Bean;

public class JavaConfig {

    @Bean(name = "Hydrogen")
    public Atom createHydrogenAtom(){
        return new Atom(1, 1.008d, 31, 0.08988);
    }
}
