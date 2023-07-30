package is.musix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "is.musix") // Include other package names if needed
public class MusiXApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusiXApplication.class, args);
	}

}
