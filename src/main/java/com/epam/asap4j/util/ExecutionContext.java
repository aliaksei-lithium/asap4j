package com.epam.asap4j.util;

import java.util.Locale;

/**
 * Provides some context information about current request.
 *
 * @author Ivan_Zauharodneu
 * @version 1.0
 */
public interface ExecutionContext {
    /**
     * @return locale that is used by the current user.
     */
    Locale getLocale();

}
