package com.java4all.momo.session;

/**
 * @author ITyunqing
 * @date 2019年12月19日 20:20:26
 */
public interface SessionStorable {

    byte[] encode();

    void decode(byte[] src);
}
