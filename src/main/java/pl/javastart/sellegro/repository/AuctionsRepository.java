package pl.javastart.sellegro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.sellegro.auction.Auctions;

public interface AuctionsRepository extends JpaRepository<Auctions, Long> {
}
