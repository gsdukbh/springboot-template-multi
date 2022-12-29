package top.werls.springboottemplate.common.utils;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MessageUtils {
  @Resource
  private MessageSource messageSource;

  public String getMessage(String msgKey) {
    try {
      return messageSource.getMessage(msgKey, null, LocaleContextHolder.getLocale());
    } catch (Exception e) {
      return msgKey;
    }
  }

  /**
   * @param msgKey key
   * @param args an array of arguments that will be filled in for params within the message (params
   *     look like "{0}", "{1,date}", "{2,time}" within a message), or {@code null} if none
   * @return
   */
  public String getMessage(String msgKey, Objects... args) {
    try {
      return messageSource.getMessage(msgKey, args, LocaleContextHolder.getLocale());
    } catch (Exception e) {
      return msgKey;
    }
  }
}
