package com.ds6.controller;

import com.ds6.dto.SaveTeacherDTO;
import com.ds6.dto.TeacherDTO;
import com.ds6.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {
    
    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherDTO> createTeacher(@Valid @RequestBody SaveTeacherDTO saveTeacherDTO) {
        TeacherDTO createdTeacher = teacherService.createTeacher(saveTeacherDTO);
        return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
        List<TeacherDTO> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable UUID id) {
        TeacherDTO teacher = teacherService.getTeacherById(id);
        return ResponseEntity.ok(teacher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable UUID id, @Valid @RequestBody SaveTeacherDTO saveTeacherDTO) {
        TeacherDTO updatedTeacher = teacherService.updateTeacher(id, saveTeacherDTO);
        return ResponseEntity.ok(updatedTeacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable UUID id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}
