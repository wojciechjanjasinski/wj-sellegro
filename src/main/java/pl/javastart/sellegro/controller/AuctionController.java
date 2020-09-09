package pl.javastart.sellegro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.sellegro.auction.Auction;
import pl.javastart.sellegro.auction.AuctionService;
import pl.javastart.sellegro.repository.AuctionRepository;

import java.util.List;

@Controller
public class AuctionController {

    private final AuctionRepository auctionRepository;

    @Autowired
    public AuctionController(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @GetMapping("/")
    public String home(Model model) {

        return "home";
    }

    @GetMapping("/auctions")
    public String auctions (){
        List<Auction> all = auctionRepository.findAll();
        return "auctions";
    }
}
