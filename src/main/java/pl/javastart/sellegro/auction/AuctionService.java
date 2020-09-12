package pl.javastart.sellegro.auction;

import org.springframework.stereotype.Service;

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

    private List<Auctions> auctions;

    private static final String[] ADJECTIVES = {"Niesamowity", "Jedyny taki", "IGŁA", "HIT", "Jak nowy",
            "Perełka", "OKAZJA", "Wyjątkowy"};

    public AuctionService() {
        try {
            loadData();
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void loadData() throws IOException {
        auctions = new ArrayList<>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("dane.csv");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

        Random random = new Random();

        String line = bufferedReader.readLine(); // skip first line
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            long id = Long.parseLong(data[0]);
            String randomAdjective = ADJECTIVES[random.nextInt(ADJECTIVES.length)];
            String title = randomAdjective + " " + data[1] + " " + data[2];
            BigDecimal price = new BigDecimal(data[4].replace("\\.", ","));
            LocalDate endDate = LocalDate.parse(data[5]);
            Auctions auctions = new Auctions(id, title, data[1], data[2], data[3], price, endDate);
            this.auctions.add(auctions);
        }
    }

    public List<Auctions> find4MostExpensive() {
        return auctions.stream()
                .sorted(Comparator.comparing(Auctions::getPrice).reversed())
                .limit(4)
                .collect(Collectors.toList());
    }

    public List<Auctions> findAllForFilters(AuctionFilters auctionFilters) {
        return auctions.stream()
                .filter(auctions -> auctionFilters.getTitle() == null || auctions.getTitle().toUpperCase().contains(auctionFilters.getTitle().toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Auctions> findAllSorted(String sort) {
        Comparator<Auctions> comparator = Comparator.comparing(Auctions::getTitle);
        if(sort.equals("title")) {
            comparator = Comparator.comparing(Auctions::getTitle);
        } else if(sort.equals("price")) {
            comparator = Comparator.comparing(Auctions::getPrice);
        }

        return auctions.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
