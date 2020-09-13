package pl.javastart.sellegro.auction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.sellegro.repository.AuctionsRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuctionController {

    private AuctionsRepository auctionsRepository;


    public AuctionController(AuctionsRepository auctionsRepository) {
        this.auctionsRepository = auctionsRepository;
    }

    @GetMapping("/auctions_sorted")
    public String auctions (Model model,
                            @RequestParam(required = false, defaultValue = "ALL") Sorting sort){

        List<Auctions> auctionsList;
        switch (sort) {
            case ID_UP:
                auctionsList = auctionsRepository.findByOrderByIdAsc();
                break;
            case ID_DOWN:
                auctionsList = auctionsRepository.findByOrderByIdDesc();
                break;
            case CAR_MAKE_UP:
                auctionsList = auctionsRepository.findByOrderByCarMakeAsc();
                break;
            case CAR_MAKE_DOWN:
                auctionsList = auctionsRepository.findByOrderByCarMakeDesc();
                break;
            case CAR_MODEL_UP:
                auctionsList = auctionsRepository.findByOrderByCarModelAsc();
                break;
            case CAR_MODEL_DOWN:
                auctionsList = auctionsRepository.findByOrderByCarModelDesc();
                break;
            case COLOR_UP:
                auctionsList = auctionsRepository.findByOrderByColorAsc();
                break;
            case COLOR_DOWN:
                auctionsList = auctionsRepository.findByOrderByColorDesc();
                break;
            case PRICE_UP:
                auctionsList = auctionsRepository.findByOrderByPriceAsc();
                break;
            case PRICE_DOWN:
                auctionsList = auctionsRepository.findByOrderByPriceDesc();
                break;
            case END_DATE_UP:
                auctionsList = auctionsRepository.findByOrderByEndDateAsc();
                break;
            case END_DATE_DOWN:
                auctionsList = auctionsRepository.findByOrderByEndDateDesc();
                break;
            default:
                auctionsList = auctionsRepository.findAll();
                break;
        }
        model.addAttribute("auctions", auctionsList);
        return "auctions";
    }
}
