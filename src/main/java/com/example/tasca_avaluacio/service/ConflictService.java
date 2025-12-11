package com.example.tasca_avaluacio.service;

import com.example.tasca_avaluacio.dto.ConflictDTO;
import com.example.tasca_avaluacio.dto.CreateConflictDTO;
import com.example.tasca_avaluacio.model.Conflict;
import com.example.tasca_avaluacio.model.Country;
import com.example.tasca_avaluacio.repository.ConflictRepository;
import com.example.tasca_avaluacio.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConflictService {

    private final ConflictRepository conflictRepository;
    private final CountryRepository countryRepository;

    public ConflictService(ConflictRepository conflictRepository, CountryRepository countryRepository) {
        this.conflictRepository = conflictRepository;
        this.countryRepository = countryRepository;
    }
    public List<ConflictDTO> getAllConflicts() {
        return conflictRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ConflictDTO getConflictById(Long id) {
        return conflictRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Conflict not found"));
    }

    @Transactional
    public ConflictDTO createConflict(CreateConflictDTO dto) {
        Conflict conflict = new Conflict();
        conflict.setName(dto.getName());
        conflict.setDescription(dto.getDescription());
        conflict.setStatus(Conflict.Status.valueOf(dto.getStatus()));
        conflict.setStartDate(dto.getStartDate());

        List<Country> countries = countryRepository.findAllById(dto.getCountryIds());
        conflict.setCountries(countries);

        Conflict saved = conflictRepository.save(conflict);
        return convertToDTO(saved);
    }

    @Transactional
    public ConflictDTO updateConflict(Long id, CreateConflictDTO dto) {
        Conflict conflict = conflictRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conflict not found"));

        conflict.setName(dto.getName());
        conflict.setDescription(dto.getDescription());
        conflict.setStatus(Conflict.Status.valueOf(dto.getStatus()));
        conflict.setStartDate(dto.getStartDate());

        List<Country> countries = countryRepository.findAllById(dto.getCountryIds());
        conflict.setCountries(countries);

        return convertToDTO(conflict);
    }

    @Transactional
    public void deleteConflict(Long id) {
        conflictRepository.deleteById(id);
    }

    private ConflictDTO convertToDTO(Conflict conflict) {
        List<String> countryNames = conflict.getCountries()
                .stream()
                .map(Country::getName)
                .collect(Collectors.toList());

        return new ConflictDTO(
                conflict.getId(),
                conflict.getName(),
                conflict.getStartDate().atStartOfDay(),
                conflict.getStatus().name(),
                conflict.getDescription(),
                countryNames
        );
    }
}
