package com.groundgurus.portfolio.dao;

import com.groundgurus.portfolio.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioDao extends JpaRepository<Portfolio, String> {

}
