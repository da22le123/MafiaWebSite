package com.web.mafia.rest;

import com.web.mafia.module.Room;
import com.web.mafia.module.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.nio.file.Files;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/")
    public ResponseEntity<byte[]> start() throws IOException {
        // Load the HTML file from the static resources directory
        Resource resource = (Resource) new ClassPathResource("static/startpage.html");
        byte[] htmlBytes = Files.readAllBytes(resource.getFile().toPath());

        // Set the content type to text/html
        MediaType mediaType = MediaType.TEXT_HTML;

        // Create a ResponseEntity with the HTML content and OK status
        return ResponseEntity.ok()
                .contentType(mediaType)
                .body(htmlBytes);
    }

    @GetMapping("/webrtc")
    public ResponseEntity<byte[]> webRTC() throws IOException {
        // Load the HTML file from the static resources directory
        Resource resource = (Resource) new ClassPathResource("static/webRTCtest.html");
        byte[] htmlBytes = Files.readAllBytes(resource.getFile().toPath());

        // Set the content type to text/html
        MediaType mediaType = MediaType.TEXT_HTML;

        // Create a ResponseEntity with the HTML content and OK status
        return ResponseEntity.ok()
                .contentType(mediaType)
                .body(htmlBytes);
    }

    @GetMapping("/create-room")
    public ResponseEntity<byte[]> createRoomGet() throws IOException {
        // Load the HTML file from the static resources directory
        Resource resource = (Resource) new ClassPathResource("static/create-room.html");
        byte[] htmlBytes = Files.readAllBytes(resource.getFile().toPath());

        // Set the content type to text/html
        MediaType mediaType = MediaType.TEXT_HTML;
        System.out.println("test");
        // Create a ResponseEntity with the HTML content and OK status
        return ResponseEntity.ok()
                .contentType(mediaType)
                .body(htmlBytes);

    }

    @PostMapping("/create-room")
    public ResponseEntity<Long> createRoom() {
        Room room = new Room();
        roomRepository.save(room);
        Long roomId = room.getId();
        // Log the creation of the new room
        System.out.println("New room created with ID: " + roomId);
        return ResponseEntity.ok().body(roomId);
    }


}
