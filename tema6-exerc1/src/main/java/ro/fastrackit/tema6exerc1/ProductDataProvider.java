package ro.fastrackit.tema6exerc1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductDataProvider
{
	@Bean
	CommandLineRunner initDataBase(ProductRepository repository)
	{
		return args -> {
			repository.save(new Product("HP Pavilion", 3500.0, "AMD Ryzen 7 4700G, 16GB DDR4", ProductCategory.COMPUTERS));
			repository.save(new Product("Daikin Sensira", 2549.0, "Aparat aer conditionat, 12000 BTU", ProductCategory.HOESEHOLD_APPLIANCES));
			repository.save(new Product("Mitsubishi Electric", 4209.0, "Aparat aer conditionat, 9000 BTU", ProductCategory.HOESEHOLD_APPLIANCES));
			repository.save(new Product("Philips TAM6805/10", 1299.0, "Microsistem audio Philips", ProductCategory.ELECTRONICS));
			repository.save(new Product("Makita DDF453SYX5", 469.99, "Masina de gaurit si insurubat", ProductCategory.HOUSE_DIY));
			
			repository.save(new Product("Dell Inspiron", 3000.99, "Intel Core i5-10400, 8GB DDR4", ProductCategory.COMPUTERS));
			repository.save(new Product("SONY CMT-X3CDB", 1033.99, "Microsistem CD, Bluetooth, NFC4", ProductCategory.ELECTRONICS));
			repository.save(new Product("Bosch ALB18 LI", 649.0, "Suflanta de frunze cu acumulator", ProductCategory.HOUSE_DIY));
			repository.save(new Product("Braun HC5030", 208.25, "Aparat de tuns electric ", ProductCategory.PERSONAL_CARE));
			repository.save(new Product("Remington AC8002", 3500.0, "Uscator de par", ProductCategory.PERSONAL_CARE));
		};
	}
}
