package com.designpatterns.adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/23
 * Description: com.designpatterns.adapter
 * Version: V1.0
 */

// BufferedReader 构造需要传入reader
// InputStreamReader 需要传入String
// 因此InputStreamReader FileInputStream 都是Adapter

public class Adapter {
    public static void main(String[] args) throws Exception {
        try (
                FileInputStream fis = new FileInputStream("c:/test.text");
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
            ) {
            String line = br.readLine();
            while (line != null && !line.equals("")) {
                System.out.println(line);
            }
            br.close();
            isr.close();
            fis.close();
        }
    }

}
