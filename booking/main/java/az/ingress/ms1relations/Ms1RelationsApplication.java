package az.ingress.ms1relations;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Ms1RelationsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Ms1RelationsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
