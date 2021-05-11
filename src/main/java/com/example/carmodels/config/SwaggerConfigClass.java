package com.example.carmodels.config;

import com.example.carmodels.car.Car;
import com.example.carmodels.car.CarDTO;
import com.example.carmodels.car.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfigClass {

    // insert dummy data to the database
    @Bean
    CommandLineRunner commandLineRunner(CarRepository carRepository) {
        return args -> {
            Car audi = new Car("Audi", "BASS", "XSE5241",2011, 160, 4000L);
            Car mercedes = new Car("Mercedes",  "SIXT","VSE0211",2021, 330, 30000L);
            Car vw = new Car("VW", "BASS", "NSE2412",2015, 150, 15000L);
            Car bmw = new Car("BMW", "Hertz", "LNE547",2018, 220, 20000L);
            Car audi6 = new Car("Audi", "FiveStarCar", "OPN123",2017, 200, 18500L);

            carRepository.saveAll(List.of(audi, mercedes, vw, bmw, audi6));

        };
    }

    @Bean
    public Docket swaggerConfig() {
//		return a prepared Docket instance
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                .build()
                .ignoredParameterTypes(CarDTO.class)
                .apiInfo(apiDetail());
    }

    private ApiInfo apiDetail() {
        return new ApiInfo (
                "Cars Info API",
                "API's for my Demo Car-Dealers project",
                "v1.0",
                "Project for the trainees",
                new Contact("Wakar", "www.learning-by-doing.de", "waqar.afzal@adesso.de"),
                "Demo Project of adesso",
                "API ITCM",
                Collections.emptyList()
        );
    }
}
