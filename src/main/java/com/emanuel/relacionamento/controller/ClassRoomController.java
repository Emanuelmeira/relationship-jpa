package com.emanuel.relacionamento.controller;


import com.emanuel.relacionamento.domain.ClassRoom;
import com.emanuel.relacionamento.domain.dto.ClassRoomDTO;
import com.emanuel.relacionamento.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/entity/class")
public class ClassRoomController {

    @Autowired
    private ClassService classService;

    @PostMapping
    public ResponseEntity<ClassRoom> create(@RequestBody ClassRoomDTO classRoomDTO){
        return ResponseEntity.ok(classService.create(classRoomDTO));
    }
}
