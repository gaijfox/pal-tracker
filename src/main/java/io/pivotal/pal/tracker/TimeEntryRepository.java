package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry update(Long id, TimeEntry expected);

    public TimeEntry delete(Long id);

    public List<TimeEntry> list();

    public TimeEntry find(Long id);

    public TimeEntry create(TimeEntry timeEntryToCreate);
}
