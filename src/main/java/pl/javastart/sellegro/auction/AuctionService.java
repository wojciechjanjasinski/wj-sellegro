package pl.javastart.sellegro.auction;

import org.springframework.stereotype.Service;
import org.springframework.util.comparator.Comparators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AuctionService {

    private List<Auction> auctions;

    private static final String[] ADJECTIVES = {"Niesamowity", "Jedyny taki", "IGŁA", "HIT", "Jak nowy",
            "Perełka", "OKAZJA", "Wyjątkowy"};


//    public List<Auction> find4MostExpensive() {
//    }
//
//    public List<Auction> findAllForFilters(AuctionFilters auctionFilters) {
//    }
//
//    public List<Auction> findAllSorted(String sort) {
//    }
}
