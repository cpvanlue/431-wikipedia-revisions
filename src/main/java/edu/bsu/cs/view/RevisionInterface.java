package edu.bsu.cs.view;

import edu.bsu.cs.model.Revision;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public interface RevisionInterface {
    DateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    String format(Revision revision) throws ParseException;
}
