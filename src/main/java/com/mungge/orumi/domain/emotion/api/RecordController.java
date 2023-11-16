package com.mungge.orumi.domain.emotion.api;

import com.mungge.orumi.domain.emotion.application.EmotionCountService;
import com.mungge.orumi.domain.diary.domain.Emotion;
import com.mungge.orumi.domain.emotion.dto.SkyDto;
import com.mungge.orumi.domain.emotion.dto.WeatherDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class RecordController {

    private final EmotionCountService diaryEmotionService;

    @Operation(summary = "감정 날씨", tags = "Record Controller")
    @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = WeatherDto.class)))
    @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    @GetMapping("/record/weather")
    public ResponseEntity<?> getEmotionWeather(String id) {
        List<Emotion> list = diaryEmotionService.getEmotionsOfMonth(id);
        WeatherDto weatherDto = new WeatherDto(id, list);
        return ResponseEntity.ok(weatherDto);
    }

    @Operation(summary = "감정 하늘", tags = "Record Controller")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = SkyDto.class)))
    @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    @GetMapping("/record/sky")
    public ResponseEntity<?> getEmotionSky(String id) {
        List<Integer> list = diaryEmotionService.getAllCountByEmotion(id);
        SkyDto skyDto = new SkyDto(id, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
        return ResponseEntity.ok(skyDto);
    }
}
