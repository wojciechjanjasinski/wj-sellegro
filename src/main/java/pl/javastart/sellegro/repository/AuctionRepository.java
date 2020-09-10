package pl.javastart.sellegro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.sellegro.auction.Auction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long> {

    List<Auction> findByOrderByIdAsc();

    List<Auction> findByOrderByIdDesc();

    List<Auction> findByOrderByTitleAsc();

    List<Auction> findByOrderByTitleDesc();

    List<Auction> findByOrderByCarMakeAsc();

    List<Auction> findByOrderByCarMakeDesc();

    List<Auction> findByOrderByCarModelAsc();

    List<Auction> findByOrderByCarModelDesc();

    List<Auction> findByOrderByColorAsc();

    List<Auction> findByOrderByColorDesc();

    List<Auction> findByOrderByPriceAsc();

    List<Auction> findByOrderByPriceDesc();

    List<Auction> findByOrderByEndDateAsc();

    List<Auction> findByOrderByEndDateDesc();

    List<Auction> findByIdStartingWith(Long id);

    List<Auction> findByTitleStartingWith(String title);

    List<Auction> findByCarMakeStartingWith(String carMake);

    List<Auction> findByCarModelStartingWith(String carMake);

    List<Auction> findByColorStartingWith(String color);

    List<Auction> findByPriceContaining(BigDecimal price);

    List<Auction> findByEndDateContaining(LocalDate endDate);
}
