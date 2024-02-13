package Personal.project.QEats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.modelmapper.ModelMapper;
import lombok.extern.log4j.Log4j2;

@SpringBootApplication
public class QEatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(QEatsApplication.class, args);
		System.out.println("Application started");
	}

	 /**
   * Fetches a ModelMapper instance.
   *
   * @return ModelMapper
   */

  @Bean // Want a new obj every time
  @Scope("prototype")
  public ModelMapper modelMapper() {
    return new ModelMapper();
//   }
}
}
