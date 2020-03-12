import com.pluralsight.service.SpeakerService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("./resources/applicationContext.xml");
        // SpeakerService service = new SpeakerServiceImpl();

        SpeakerService service = appContext.getBean("speakerService", SpeakerService.class);
        System.out.println(service.findAll().get(0).getFirsName());
    }
}