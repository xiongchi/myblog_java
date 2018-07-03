package xiaoxiong.blog.web.controller.NBA;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController("nba")
public class PlayersController {
    
    private final String PLAYERS_MATCH_DATA = "http://nba.stats.qq.com/stats/";

    @GetMapping(value = "playersData")
    public void getPlayersMsg() {
        Document doc = null;
        try {
            doc = Jsoup.connect(PLAYERS_MATCH_DATA).get();
            Elements tb = doc.getElementsByClass("ng-scope").
                    first().select("table");
            System.out.println(tb);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
