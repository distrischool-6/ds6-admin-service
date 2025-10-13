package com.ds6.serviceimpl;

import java.util.stream.Collectors;

import com.ds6.dto.SaveTeacherDTO;
import com.ds6.dto.TeacherDTO;
import com.ds6.exception.ResourceNotFoundException;
import com.ds6.model.Teacher;
import com.ds6.repository.TeacherRepository;
import com.ds6.service.TeacherService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{
    
    private final TeacherRepository teacherRepository;

    @Override
    @Transactional
    public TeacherDTO createTeacher(SaveTeacherDTO dto) {
        Teacher teacher = new Teacher();
        teacher.setId(UUID.randomUUID());
        teacher.setName(dto.name());
        teacher.setDiscipline(dto.discipline());
        teacher.setPhone(dto.phone());

        Teacher savedTeacher = teacherRepository.save(teacher);
        return toDTO(savedTeacher);
    }

    @Override
    @Transactional(readOnly = true)
    public TeacherDTO getTeacherById(UUID id) {
        Teacher teacher = findTeacherById(id);
        return toDTO(teacher);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TeacherDTO> getAllTeachers() {
        return teacherRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TeacherDTO updateTeacher(UUID id, SaveTeacherDTO dto) {
        Teacher teacher = findTeacherById(id);
        teacher.setName(dto.name());
        teacher.setDiscipline(dto.discipline());
        teacher.setPhone(dto.phone());

        Teacher updatedTeacher = teacherRepository.save(teacher);
        return toDTO(updatedTeacher);
    }

    @Override
    @Transactional
    public void deleteTeacher(UUID id) {
        if (!teacherRepository.existsById(id)) {
            throw new ResourceNotFoundException("Teacher not found with id: " + id);
        }
        teacherRepository.deleteById(id);
    }

    // --- Métodos utilitários ---
    private Teacher findTeacherById(UUID id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));
    }
    
    private TeacherDTO toDTO(Teacher teacher) {
        return new TeacherDTO(
            teacher.getId(),
            teacher.getName(),
            teacher.getDiscipline(),
            teacher.getPhone()
        );
    }
}
