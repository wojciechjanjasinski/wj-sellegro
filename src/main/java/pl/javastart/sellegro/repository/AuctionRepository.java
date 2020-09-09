package pl.javastart.sellegro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.sellegro.auction.Auction;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long> {

    List<Auction> findByOrderById();
    List<Auction> findByOrderByIdDesc();
}
