package stc.anycomp_marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("stc.anycomp_marketplace.model")
public class AnycompMarketplaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnycompMarketplaceApplication.class, args);
	}

}
