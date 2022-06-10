package com.groundgurus.portfolio;

import com.groundgurus.portfolio.dao.PortfolioDao;
import com.groundgurus.portfolio.model.Portfolio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyPortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPortfolioApplication.class, args);
	}

	@Bean
	@Transactional
	public CommandLineRunner runner(PortfolioDao portfolioDao) {
		return (args) -> {
			var id = "portfolio-053021";

			var searchedPortfolio = portfolioDao.findById(id);

			if (searchedPortfolio.isEmpty()) {
				var portfolio = Portfolio.builder()
						.id(id)
						.firstName("Jayson")
						.lastName("Olaguera")
						.age(27)
						.address("Metro Manila")
						.email("jaysonolaguera@gmail.com")
						.jobTitle("Software Engineer ")
						.skype("jaysonolaguera@skype.com")
						.phone("09153596868")
						.build();
				portfolioDao.save(portfolio);
			}
		};
	}
}
