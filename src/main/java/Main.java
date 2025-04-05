import Entity.ProjectEntity;
import Entity.ProjectRepository;
import com.google.protobuf.TextFormat;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;



public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        Configuration configure = configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration
                .buildSessionFactory();
        ProjectRepository pr = new ProjectRepository();
        ProjectEntity project = new ProjectEntity();
        project.setName("Ana");
        project.setDiscription("Makajsjhjgyguy");
        final SimpleDateFormat dateFormater = new SimpleDateFormat("dd.MM.yyyy");
        try {

            Date startDate = parse("2020-02-04");
            Date endDate = parse("2021-02-04");
            project.setDateOfStart(startDate);
            project.setDateOfEnd(endDate);
            pr.save(project);

        } catch (Exception e) {
            e.printStackTrace();
        }
        pr.save(project);
    }

    private static Date parse(String date) {
        return null;
    }

}
