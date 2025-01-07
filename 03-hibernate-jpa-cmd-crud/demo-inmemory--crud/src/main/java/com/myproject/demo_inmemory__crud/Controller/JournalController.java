package com.myproject.demo_inmemory__crud.Controller;

import com.myproject.demo_inmemory__crud.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalController {
    // specific endpoints
    private Map<Long, JournalEntry> jornalEntries = new HashMap<>();

    @GetMapping
    public  List<JournalEntry> getAll() {
        return new ArrayList<>(jornalEntries.values());
    }

    @PostMapping
    public boolean create(@RequestBody JournalEntry body) {
        jornalEntries.put(body.getId(), body);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntry(@PathVariable Long myId) {
        return jornalEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public  JournalEntry deleteEntryById(@PathVariable Long myId) {
        return jornalEntries.remove(myId);
    }

    @PutMapping("id/{myId}")
    public boolean updateJournalEntry(@PathVariable Long myId, @RequestBody JournalEntry body) {
        jornalEntries.put(myId, body);
        return true;
    }
}
