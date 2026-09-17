import io.beans.App;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class AppLauncher {
    public static void main(String[] args) {

        /*
                Spring Bean: is the reusable object, that is instantiated, configured
                initialized and managed by the spring ico container.

                There are multiple bean creation sources we have interms of annotations
                @Component
                @Controller
                @Service
                @Repository
                @Configuration + @Bean

                Bean Scope: determines how many bean instances, spring should create in application and how
                instances need to be shared.

                Scopes:
                    Singleton - creates a single instance per application
                    Prototype - creates multiple instances of a bean
                    Request - single bean instance per HTTP request
                    Session
                    Application
                    Websocket
         */

        //Resource resource = new ClassPathResource("app-context.xml");

        ApplicationContext appContext = new ClassPathXmlApplicationContext("app-context.xml");
        App app1 = appContext.getBean("app1", App.class);
        App app2 = appContext.getBean("app1", App.class);

        /*
            The both instances are same, so by default SCOPE is SINGLETON
         */
        System.out.println("is two objects are equal:? app1 == app2 ? " + (app1 == app2));

        App app3 = appContext.getBean("app2", App.class);
        App app4 = appContext.getBean("app2", App.class);

        /*
            since we have configured scop = PROTOTYPE , the object instances are not equal;
         */
        System.out.println("is two objects are equal:? app3 == app4 ? " + (app3 == app4));
    }
}
