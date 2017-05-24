package vkaretko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Class vkaretko.Application.
 * Description TODO.
 * Created by vitoss.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 14.05.17 13:34.
 */
@SpringBootApplication
@EnableJpaRepositories("vkaretko.repository")
@EntityScan("vkaretko.domain")
@ComponentScan("vkaretko.web")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}