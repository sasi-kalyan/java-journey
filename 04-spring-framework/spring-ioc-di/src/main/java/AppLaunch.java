import ioc.spring.App;
import ioc.spring.AppConfig;
import ioc.spring.Process;
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

public class AppLaunch {

    public static void main(String[] args) {

        /*
        //Old way of creating the objects in Java
        Process process1 = new Process();
        process1.setId(1);
        process1.setDesc("Process-1");

        //Using BeanFactory, we are giving the control of our application to spring ioc-container

        Resource resource = new ClassPathResource("process-app-context.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);

        Process process2 = (Process) beanFactory.getBean("process-1");
        System.out.println("Id of the process : " + process2.getId());
        System.out.println("Desc of the process: "+ process2.getDesc());

        //Using BeanDefinitionRegistry

        BeanDefinitionRegistry bdReg = new DefaultListableBeanFactory();
        BeanDefinitionReader bdr = new XmlBeanDefinitionReader(bdReg);
        bdr.loadBeanDefinitions(resource);

        Process process3 = ((DefaultListableBeanFactory) bdReg).getBean("process-1", Process.class);
        System.out.println("Id of the process : " + process3.getId());
        System.out.println("Desc of the process: "+ process3.getDesc());


        //Application Context
        ApplicationContext appContext1 = new ClassPathXmlApplicationContext("process-app-context.xml");
        Process process4 = appContext1.getBean("process-1", Process.class);

        System.out.println("Id of the process : " + process4.getId());
        System.out.println("Desc of the process: "+ process4.getDesc());

        ApplicationContext appContext2 = new AnnotationConfigApplicationContext(AppConfig.class);
        Process process5 = appContext2.getBean("process-2", Process.class);

        System.out.println("Id of the process : " + process5.getId());
        System.out.println("Desc of the process: "+ process5.getDesc());

         */

        ApplicationContext appContext01 = new ClassPathXmlApplicationContext("process-app-context.xml");

        App app01 = appContext01.getBean("app-1", App.class);
        System.out.println(app01);

    }
}
