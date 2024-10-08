package sarik.dev;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import sarik.dev.bot.Echo;
import sarik.dev.utils.BotUtils;

public class Application {
    // GitHub - https://github.com/sardor-kushakov
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Echo(BotUtils.TOKEN));
            System.out.println("Bot started!");
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}