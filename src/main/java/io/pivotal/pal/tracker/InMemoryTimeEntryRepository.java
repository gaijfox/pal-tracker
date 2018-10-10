package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    HashMap<Long, TimeEntry> timeEntries = new HashMap<Long, TimeEntry>();
    long timeEntryCount = 0;

    public TimeEntry create(TimeEntry timeEntryToCreate) {
        timeEntryCount++;

       TimeEntry te =  new TimeEntry(timeEntryCount, timeEntryToCreate.getProjectId(), timeEntryToCreate.getUserId(), timeEntryToCreate.getDate(), timeEntryToCreate.getHours());

        timeEntries.put(te.getId(), te);
        return te;
    }

    public TimeEntry update(long l, TimeEntry expected) {
        if (find(l) == null) {
            return null;
        } else {
            expected.setId(l);
            timeEntries.put(l, expected);
        }
        return expected;
    }

    public TimeEntry delete(long l) {
        return timeEntries.remove(l);
    }

    public List<TimeEntry> list() {
        return new ArrayList(timeEntries.values());
    }

    public TimeEntry find(long l) {
        return timeEntries.get(l);
    }
}
