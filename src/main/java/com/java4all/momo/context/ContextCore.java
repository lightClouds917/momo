package com.java4all.momo.context;

import java.util.Map;

/**
 * context core interface
 * @author IT云清
 */
public interface ContextCore {

    String put(String key,String value);

    String get(String key);

    String remove(String key);

    Map<String,String> entries();

}
