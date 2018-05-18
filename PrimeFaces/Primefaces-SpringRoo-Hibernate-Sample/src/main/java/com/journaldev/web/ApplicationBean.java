package com.journaldev.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.roo.addon.jsf.application.RooJsfApplicationBean;

@RooJsfApplicationBean
public class ApplicationBean {

    public String getColumnName(String column) {
        if (column == null || column.length() == 0) {
            return column;
        }
        final Pattern p = Pattern.compile("[A-Z][^A-Z]*");
        final Matcher m = p.matcher(Character.toUpperCase(column.charAt(0)) + column.substring(1));
        final StringBuilder builder = new StringBuilder();
        while (m.find()) {
            builder.append(m.group()).append(" ");
        }
        return builder.toString().trim();
    }
}