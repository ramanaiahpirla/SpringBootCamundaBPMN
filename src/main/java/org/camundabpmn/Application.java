package org.camundabpmn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Loan API", version = "1.0.0-SNAPSHOT",description = "Loan Processing Application By Camunda Process Engine"))
public class Application {

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

}