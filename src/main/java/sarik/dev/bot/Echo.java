package sarik.dev.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import sarik.dev.utils.BotUtils;

/**
 * Echo botining asosiy klassi.
 * Bu bot foydalanuvchilardan kelgan xabarlarni aks ettiradi.
 */
public class Echo extends TelegramLongPollingBot {

    /**
     * Bot konstruktori.
     *
     * @param botToken Botning tokeni
     */
    public Echo(String botToken) {
        super(botToken);
    }

    /**
     * Yangilanishlar olinganda chaqiriladi.
     *
     * @param update Yangilanish (Update) obyekti
     */
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage(); // Kelgan xabar
        Long chatId = message.getChatId(); // Foydalanuvchi chat IDsi
        String text = message.getText(); // Foydalanuvchi yuborgan matn

        // Xabarga javob yuborish
        SendMessage sendMessage = new SendMessage(chatId.toString(), text);

        try {
            execute(sendMessage); // Javobni yuborish
        } catch (TelegramApiException e) {
            throw new RuntimeException(e); // Xato yuz bersa, xatolikni tashlaydi
        }
    }

    /**
     * Botning foydalanuvchi nomini qaytaradi.
     *
     * @return Bot foydalanuvchi nomi
     */
    @Override
    public String getBotUsername() {
        return BotUtils.USERNAME; // Bot foydalanuvchi nomini qaytaradi
    }
}
