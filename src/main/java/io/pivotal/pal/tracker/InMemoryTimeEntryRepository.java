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

    public TimeEntry update(Long id, TimeEntry expected) {
        if (find(id) == null) {
            return null;
        } else {
            expected.setId(id);
            timeEntries.put(id, expected);
        }
        return expected;
    }

    public TimeEntry delete(Long id) {
        return timeEntries.remove(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList(timeEntries.values());
    }

    public TimeEntry find(Long id) {
        return timeEntries.get(id);
    }
}
