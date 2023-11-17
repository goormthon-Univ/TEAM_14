package com.mungge.orumi.domain.diary.api;

import com.mungge.orumi.domain.diary.application.DiaryService;
import com.mungge.orumi.domain.diary.domain.Diary;
import com.mungge.orumi.domain.diary.dto.DiaryRequestDto;
import com.mungge.orumi.domain.diary.dto.DiaryResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/diary")
public class DiaryController {

    private final DiaryService diaryService;
    private static String id = "orumi";

    @Operation(summary = "감정구름 고르기", tags = "Diary Controller")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = String.class)))
    @GetMapping("/cloud")
    public ResponseEntity<?> selectCloud() {
        return ResponseEntity.ok("nickname");
    }

    @Operation(summary = "구름일기 작성", tags = "Diary Controller")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = Diary.class)))
    @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    @PostMapping("/new")
    public ResponseEntity<?> createDiary(DiaryRequestDto diaryDto) {
        Diary diary = new Diary(id, diaryDto.getEmotion(), diaryDto.getText(), null);
        diaryService.createDiary(diary);
        return ResponseEntity.ok(diary);
    }

    @Operation(summary = "나의 구름", tags = "Diary Controller")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = DiaryResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    @GetMapping("/{date}")
    public ResponseEntity<?> getDiary(@PathVariable String date) {
        LocalDate formattedDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        Diary diary = diaryService.getDiary(id, formattedDate);
        DiaryResponseDto responseDto = new DiaryResponseDto(diary.getEmotion(), diary.getText(), diary.getImage(), diary.getDate());
        return ResponseEntity.ok(responseDto);
    }

    @Operation(summary = "나의 구름 수정", tags = "Diary Controller")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = Diary.class)))
    @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    @PutMapping("/{date}/update")
    public ResponseEntity<?> updateDiary(DiaryRequestDto diaryDto) {
        Diary diary = new Diary(id, diaryDto.getEmotion(), diaryDto.getText(), null);
        diaryService.createDiary(diary);
        return ResponseEntity.ok(diary);
    }
}
