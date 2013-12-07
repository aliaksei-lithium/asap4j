package com.epam.asap4j.conf;

import com.epam.asap4j.util.ContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service("messageStorage")
public class MessageStorage {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String key) {
        return messageSource.getMessage(key, null, getLocale());
    }

    public String getMessage(String key, Object... args) {
        return messageSource.getMessage(key, args, getLocale());
    }

    /**
     * @return locale that should be used when localizing messages.
     */
    public final Locale getLocale() {
        return ContextHolder.getContext().getLocale();
    }
}
