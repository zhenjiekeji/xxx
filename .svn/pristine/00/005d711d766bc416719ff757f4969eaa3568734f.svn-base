package com.uk.sec.framework.example.mailer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.uk.sec.framework.mail.MailModel;


public class ExampleMailModel implements MailModel {
    
    @Override
    public Map<String, String> freemarkMode() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "孙大爷");
        map.put("date", String.format("%tF", new Date()));
        return map;
    }
    
}
