package com.example.tasca_avaluacio.controller;

import com.example.tasca_avaluacio.dto.ConflictDTO;
import com.example.tasca_avaluacio.dto.CreateConflictDTO;
import com.example.tasca_avaluacio.service.ConflictService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/conflicts")
public class ConflictController {

    private final ConflictService conflictService;

    public ConflictController(ConflictService conflictService) {
        this.conflictService = conflictService;
    }

    @GetMapping
    public List<ConflictDTO> getAll(@RequestParam(required = false) String status) {
        if (status != null) {
            return conflictService.getAllConflicts().stream()
                    .filter(c -> c.getStatus().equalsIgnoreCase(status))
                    .toList();
        }
        return conflictService.getAllConflicts();
    }

    @GetMapping("/{id}")
    public ConflictDTO getById(@PathVariable Long id) {
        return conflictService.getConflictById(id);
    }

    @PostMapping
    public ConflictDTO create(@RequestBody CreateConflictDTO dto) {
        return conflictService.createConflict(dto);
    }

    @PutMapping("/{id}")
    public ConflictDTO update(@PathVariable Long id, @RequestBody CreateConflictDTO dto) {
        return conflictService.updateConflict(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        conflictService.deleteConflict(id);
    }
}
