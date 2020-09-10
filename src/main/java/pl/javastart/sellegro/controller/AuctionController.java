package pl.javastart.sellegro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.sellegro.auction.Auction;
import pl.javastart.sellegro.auction.AuctionService;
import pl.javastart.sellegro.auction.Sorting;
import pl.javastart.sellegro.repository.AuctionRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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
    public String auctions(Model model,
                           @RequestParam(required = false, defaultValue = "ALL") Sorting sort) {
        List<Auction> auctions = switch (sort) {
            case ID_UP -> auctionRepository.findByOrderByIdAsc();
            case ID_DOWN -> auctionRepository.findByOrderByIdDesc();
            case TITLE_UP -> auctionRepository.findByOrderByTitleAsc();
            case TITLE_DOWN -> auctionRepository.findByOrderByTitleDesc();
            case CAR_MAKE_UP -> auctionRepository.findByOrderByCarMakeAsc();
            case CAR_MAKE_DOWN -> auctionRepository.findByOrderByCarMakeDesc();
            case CAR_MODEL_UP -> auctionRepository.findByOrderByCarModelAsc();
            case CAR_MODEL_DOWN -> auctionRepository.findByOrderByCarModelDesc();
            case COLOR_UP -> auctionRepository.findByOrderByColorAsc();
            case COLOR_DOWN -> auctionRepository.findByOrderByColorDesc();
            case PRICE_UP -> auctionRepository.findByOrderByPriceAsc();
            case PRICE_DOWN -> auctionRepository.findByOrderByPriceDesc();
            case END_DATE_UP -> auctionRepository.findByOrderByEndDateAsc();
            case END_DATE_DOWN -> auctionRepository.findByOrderByEndDateDesc();
            default -> auctionRepository.findAll();
        };
        model.addAttribute("auctions", auctions);
        return "auctions";
    }

    @GetMapping("/filters")
    public String filters(Model model,
                          @RequestParam(required = false, defaultValue = "ALL") Sorting sort,
                          @RequestParam(required = false) Long id,
                          @RequestParam(required = false) String carPropriety,
                          @RequestParam(required = false) BigDecimal price,
                          @RequestParam(required = false) LocalDate endDate) {
        List<Auction> filters = switch (sort) {
            case ID -> auctionRepository.findByIdStartingWith(id);
            case TITLE -> auctionRepository.findByTitleStartingWith(carPropriety);
            case CAR_MAKE -> auctionRepository.findByCarMakeStartingWith(carPropriety);
            case CAR_MODEL -> auctionRepository.findByCarModelStartingWith(carPropriety);
            case COLOR -> auctionRepository.findByColorStartingWith(carPropriety);
            case PRICE -> auctionRepository.findByPriceContaining(price);
            case END_DATE -> auctionRepository.findByEndDateContaining(endDate);
            default -> auctionRepository.findAll();
        };
        model.addAttribute("filters", filters);
        return "auctions";
    }
}
