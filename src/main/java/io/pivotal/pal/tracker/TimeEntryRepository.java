package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry update(long l, TimeEntry expected);

    public TimeEntry delete(long l);

    public List<TimeEntry> list();

    public TimeEntry find(long l);

    public TimeEntry create(TimeEntry timeEntryToCreate);
}
