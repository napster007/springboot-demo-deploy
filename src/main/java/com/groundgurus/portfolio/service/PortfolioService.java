package com.groundgurus.portfolio.service;

import com.groundgurus.portfolio.dao.PortfolioDao;
import com.groundgurus.portfolio.model.Portfolio;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PortfolioService {
  private final PortfolioDao portfolioDao;

  public Portfolio getPortfolio() {
    return portfolioDao.findById("portfolio-053021").get();
  }

  @Transactional
  public void save(Portfolio portfolio) {
    var searchedPortfolio = portfolioDao.findById("portfolio-053021");

    if (searchedPortfolio.isPresent()) {
      var myPortfolio = searchedPortfolio.get();

      myPortfolio.setFirstName(portfolio.getFirstName());
      myPortfolio.setLastName(portfolio.getLastName());

      portfolioDao.save(myPortfolio);
    }
  }
}
