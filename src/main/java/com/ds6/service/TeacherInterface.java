package com.ds6.service;

import com.ds6.dto.SaveTeacherDTO;
import com.ds6.dto.TeacherDTO;

import java.util.List;
import java.util.UUID;

public interface TeacherInterface {
    public TeacherDTO createTeacher(SaveTeacherDTO saveTeacherDTO);
    public TeacherDTO getTeacherById(UUID id);
    public List<TeacherDTO> getAllTeachers();
    public TeacherDTO updateTeacher(UUID id, SaveTeacherDTO saveTeacherDTO);
    public void deleteTeacher(UUID id);
}
