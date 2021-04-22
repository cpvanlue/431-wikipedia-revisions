package edu.bsu.cs.view;

import edu.bsu.cs.model.Revision;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class RevisionFormatter implements RevisionInterface {

    @Override
    public String format(Revision revision) throws ParseException {
        return String.format("At %s, a change by %s",
                date.parse(revision.timestamp.toString()),
                revision.name);
    }
}
