import com.hyouka.school.config.StudentConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    @org.junit.Test
    public void testLifeCycle() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
        System.out.println("IOC容器创建了...");
        context.close();
    }
}
