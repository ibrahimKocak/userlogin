package com.userlogin.userlogin.service.user;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateDataConverterService {

    String getString(Date date, String format) {

        String stringDate = null;
        if(!ObjectUtils.isEmpty(date)) {
            stringDate = new SimpleDateFormat(format).format(date);
        }
        return stringDate;
    }

    Date getDate(String stringDate, String format) throws ParseException {

        Date date = null;
        if(StringUtils.hasText(stringDate)) {
            date = new SimpleDateFormat(format).parse(stringDate);
        }
        return date;
    }

}
