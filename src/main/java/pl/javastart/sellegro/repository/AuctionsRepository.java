package pl.javastart.sellegro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.sellegro.auction.Auctions;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface AuctionsRepository extends JpaRepository<Auctions, Long> {

    List<Auctions> findByOrderByIdAsc();

    List<Auctions> findByOrderByIdDesc();

    List<Auctions> findByOrderByCarMakeAsc();

    List<Auctions> findByOrderByCarMakeDesc();

    List<Auctions> findByOrderByCarModelAsc();

    List<Auctions> findByOrderByCarModelDesc();

    List<Auctions> findByOrderByColorAsc();

    List<Auctions> findByOrderByColorDesc();

    List<Auctions> findByOrderByPriceAsc();

    List<Auctions> findByOrderByPriceDesc();

    List<Auctions> findByOrderByEndDateAsc();

    List<Auctions> findByOrderByEndDateDesc();

    List<Auctions> findByIdStartingWith(Long id);

    List<Auctions> findByCarMakeStartingWith(String propriety);

    List<Auctions> findByCarModelStartingWith(String propriety);

    List<Auctions> findByColorStartingWith(String propriety);

    List<Auctions> findByPriceStartingWith(BigDecimal price);

    List<Auctions> findByEndDateContaining(LocalDate endDate);
}
