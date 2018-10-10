package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public @ResponseBody ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        return new ResponseEntity(timeEntryRepository.create(timeEntryToCreate), HttpStatus.CREATED);
    }

    @PutMapping("/time-entries/{id}")
    public @ResponseBody ResponseEntity update(@PathVariable("id") long l, @RequestBody TimeEntry expected) {
        TimeEntry timeEntry = timeEntryRepository.update(l, expected);
        return timeEntry == null ?
                new ResponseEntity(timeEntry, HttpStatus.NOT_FOUND):
                new ResponseEntity(timeEntry, HttpStatus.OK);
    }

    @DeleteMapping("/time-entries/{id}")
    public @ResponseBody ResponseEntity<TimeEntry> delete(@PathVariable("id") long l) {
        return new ResponseEntity(timeEntryRepository.delete(l), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/time-entries/{id}")
    public @ResponseBody ResponseEntity<TimeEntry> read(@PathVariable("id") long l) {
        TimeEntry timeEntry = timeEntryRepository.find(l);
        return timeEntry == null ?
                new ResponseEntity(timeEntry, HttpStatus.NOT_FOUND) :
                new ResponseEntity(timeEntry, HttpStatus.OK);

    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<>(timeEntryRepository.list(),HttpStatus.OK);
    }


}
