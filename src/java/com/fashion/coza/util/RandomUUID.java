/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.util;

import java.util.UUID;

/**
 *
 * @author tuan anh
 */
public class RandomUUID {

    public static String getRandomID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
