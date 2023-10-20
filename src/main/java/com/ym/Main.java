package com.ym;

import com.ym.dao.IStudentDAO;
import com.ym.models.Departement;
import com.ym.models.Student;
import com.ym.services.StudentService;
import jakarta.xml.ws.Endpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(Config.class);
        IStudentDAO studentDAO = applicationContext.getBean(IStudentDAO.class);
        studentDAO.save(new Student(null, "yassirmerfouk1@gmail.com", "Yassir", "Merfouk", new Date(), Departement.WEB_MOBILE_DEV));
        studentDAO.save(new Student(null, "yassirmerfouk2@gmail.com", "Yassir", "Merfouk", new Date(), Departement.BIG_DATA_AI));
        studentDAO.save(new Student(null, "yassirmerfouk3@gmail.com", "Yassir", "Merfouk", new Date(), Departement.NETWORK));

        Endpoint.publish("http://0.0.0.0:1234/service", applicationContext.getBean(StudentService.class));
    }
}