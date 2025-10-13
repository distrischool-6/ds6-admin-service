package com.ds6.service;

import java.util.List;
import java.util.UUID;

import com.ds6.dto.SaveTeacherDTO;
import com.ds6.dto.TeacherDTO;

public interface TeacherService {
    public TeacherDTO createTeacher(SaveTeacherDTO saveTeacherDTO);
    public TeacherDTO getTeacherById(UUID id);
    public List<TeacherDTO> getAllTeachers();
    public TeacherDTO updateTeacher(UUID id, SaveTeacherDTO saveTeacherDTO);
    public void deleteTeacher(UUID id);
}
