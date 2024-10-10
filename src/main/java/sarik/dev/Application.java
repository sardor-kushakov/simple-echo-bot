package sarik.dev;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import sarik.dev.bot.Echo;
import sarik.dev.utils.BotUtils;

/**
 * Bot ilovasining asosiy klassi.
 *
 * @author SARDOR KUSHAKOV
 * @version 1.0.0
 * * @see <a href="https://github.com/sardor-kushakov/simple-echo-bot">GitHub repository</a>
 */
public class Application {
    public static void main(String[] args) {
        try {
            // Telegram botlarini ro'yxatdan o'tkazish uchun API
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            // Echo botini ro'yxatdan o'tkazish
            botsApi.registerBot(new Echo(BotUtils.TOKEN));
            System.out.println("Bot started!"); // Bot ishga tushganligini bildiruvchi xabar
        } catch (TelegramApiException e) {
            throw new RuntimeException(e); // Xato yuz bersa, xatolikni tashlaydi
        }
    }
}
