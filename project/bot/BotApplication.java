import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.tinkoff.edu.java.bot.configuration.ApplicationConfig;
import com.project.link-parser.LinkParserApplication;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class BotApplication {
    public static void main(String[] args) {
        var ctx = SpringApplication.run(BotApplication.class, args);
        ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
        System.out.println(config);
    }
}


@Service
public class TelegramService {
    private static final String TELEGRAM_BASE_URL = "https://api.telegram.org/bot";

    private final String botToken;

    public TelegramService(@Value("${telegram.bot-token}") String botToken) {
        this.botToken = botToken;
    }

    public void sendMessage(Long chatId, String message) throws IOException {
        URL url = new URL(TELEGRAM_BASE_URL + botToken + "/sendMessage?chat_id=" + chatId + "&text=" + message);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
    }
}


@Component
public class Bot {
    private static final String COMMAND = "/start";

    private final TelegramService telegramService;
    private final RabbitTemplate rabbitTemplate;

    private LinkParser linkParserService = new LinkParserApplication();

    public Bot(TelegramService telegramService, RabbitTemplate rabbitTemplate) {
        this.telegramService = telegramService;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void handleMessage(String message, Long chatId) throws IOException {
        if (message.startsWith(COMMAND)) {
            String response = "Hello, Your links is sended to the quote and will added to the parce!";

            telegramService.sendMessage(chatId, response);
        } else {
            List<String> urls = extractUrls(message);

            if (!urls.isEmpty()) {
                sendUrlsToRabbitMQ(urls);
            }
        }
    }

    private List<String> extractUrls(String message) {
        String result = linkParserService.parseLink(message);
        return result;
    }

    private void sendUrlsToRabbitMQ(List<String> urls) {
        rabbitTemplate.convertAndSend("urls-queue", urls);
    }
}