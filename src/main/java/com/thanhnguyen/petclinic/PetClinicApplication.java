package com.thanhnguyen.petclinic;

import com.thanhnguyen.petclinic.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PetClinicApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PetClinicApplication.class, args);

        MyController myController = (MyController) context.getBean(MyController.class);

        System.out.println(myController.sayHello());
    }
}
