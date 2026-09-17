import ioc.spring.Atom;
import ioc.spring.Element;
import ioc.spring.JavaConfig;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/*
        Notes:

        Spring Framework: is the lightweight, open-source framework that is provides infrastructure development support
        to build the enterprise java applications. Using spring we can build robust software systems which promotes
        the loose-coupling, testability and maintainability.

        IoC (Inversion of Control): is a design principle where the construction of objects, assembling and
        managing of objects process is transffered from application code to external continer which is
        spring framework.

        Dependency Injection: is a design pattern where the dependencies are injected in the form of beans
        so that we do not need to construct or manage it.

        Inversion of Control: is a design principle where it deals with controlling the flow and object
        creation process by using external containers ("IOC Containers"), it will provide handle all the beans
        inside the application.

        Types of IOC Containers:
        -> BeanFactory: Light-weight container
        -> ApplicationContext: which is an extension to the BeanFactory
        -> BeanDefinitionRegistry: Another form of IOC just like BeanFactory

        Autowiring Concept:

        1. Field injection
        2. Constructor Injection
        3. Setter injection

        Point1: When we are autowiring byName, spring looks for the bean id matches exactly
                with the property name of the property, if it matches it injects bean via
                setter.
        Point2: When we are autowiring byType, spring looks for the bean class matches exactly
                with the property datatype/ObjectType of the property, if it matches it injects bean via
                setter.
        Point3: javax-annotation-based-api is used to use annotation based java features like
                @Autowired, @PreDestroy, @PostConstruct etc...

 */

public class Main {
    public static void main(String[] args) {

        /*

        //Normal Object Creation
        System.out.println("*********General Object Creation*********");

        Atom atom = new Atom(1, 1.008d, 31, 0.08988);
        System.out.println("Normal Object Atom Created: "+ atom.toString());

        //BeanFactory: Usage
        System.out.println("*********Usage: BeanFactory*********");
        Resource resource = new ClassPathResource("app-context.xml");

        BeanFactory beanFactory = new XmlBeanFactory(resource);

        Atom hydrogen = (Atom) beanFactory.getBean("Hydrogen");
        System.out.println("Bean (Hydrogen): "+ hydrogen);

        //BeanDefinitionReader: Usage
        System.out.println("*********Usage: BeanDefinitionRegistry*********");
        Resource resource1 = new ClassPathResource("app-context.xml");
        BeanDefinitionRegistry beanRegistry = new DefaultListableBeanFactory();
        BeanDefinitionReader bdr = new XmlBeanDefinitionReader(beanRegistry);

        //loads the bean definitions
        bdr.loadBeanDefinitions(resource1);

        Atom carbon = (Atom) ((DefaultListableBeanFactory) beanRegistry).getBean("Carbon");
        System.out.println("BeanDefinitionRegistry (Carbon) Bean: "+ carbon);

        //ApplicationContext: Usage
        System.out.println("*********Usage: ApplicationContext*********");
        ApplicationContext appContext = new ClassPathXmlApplicationContext("new-app-context.xml");

        Atom atom1 = (Atom) appContext.getBean("atom");
        System.out.println("ApplicatinContext (Atom) Bean: "+ atom1);


        System.out.println("*********Usage: JavaConfig + ApplicationContext*********");

        //ApplicationContext + JavaConfig : Usage
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);

        Atom hyd = (Atom) applicationContext.getBean("Hydrogen");
        System.out.println("JavaConfig + AppContext: "+ hyd);

        //Autowiring : Usage - XmlConfiguration
        ClassPathXmlApplicationContext appcontext = new ClassPathXmlApplicationContext("new-app-context.xml");

        Element element = (Element) appcontext.getBean("Element");
        System.out.println("Element Bean: "+ element);

        appcontext.close();

         */

        //Annotation Based Autowiring with XMLBeanConfig
        ClassPathXmlApplicationContext appcontext = new ClassPathXmlApplicationContext("new-app-context.xml");
        Element element = (Element) appcontext.getBean("Element");
        System.out.println("Element Bean Created(Field Based Autowiring): " + element);
    }
}

