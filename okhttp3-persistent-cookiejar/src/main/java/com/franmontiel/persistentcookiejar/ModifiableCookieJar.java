package com.franmontiel.persistentcookiejar;

import com.franmontiel.persistentcookiejar.cache.CookieCache;


public interface ModifiableCookieJar extends ClearableCookieJar {

    CookieCache getCookieCache();

    void persistCookieCache();
}
