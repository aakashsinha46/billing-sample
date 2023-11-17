package in.aakashsinha.billingsimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:.env")
public class BillingSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingSimpleApplication.class, args);
	}

}
