package com.franmontiel.persistentcookiejar;

import com.franmontiel.persistentcookiejar.cache.CookieCache;
import com.franmontiel.persistentcookiejar.persistence.CookiePersistor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import okhttp3.Cookie;


public class ModifiablePersistentCookieJar extends PersistentCookieJar implements ModifiableCookieJar {

    public ModifiablePersistentCookieJar(CookieCache cache, CookiePersistor persistor) {
        super(cache, persistor);
    }

    @Override
    public CookieCache getCookieCache() {
        return cache;
    }

    @Override
    synchronized public void persistCookieCache() {
        Iterator<Cookie> iterator = cache.iterator();
        List<Cookie> cookies = new LinkedList<>();
        while (iterator.hasNext())
            cookies.add(iterator.next());

        persistor.clear();
        persistor.saveAll(cookies);
    }
}
