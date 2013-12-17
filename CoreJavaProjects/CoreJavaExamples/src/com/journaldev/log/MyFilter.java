package com.journaldev.log;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class MyFilter implements Filter {

    @Override
    public boolean isLoggable(LogRecord record) {
        return record.getLevel() == Level.CONFIG ? false : true;
    }

}
