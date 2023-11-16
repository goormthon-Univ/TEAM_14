package com.mungge.orumi.domain.user.api;

import com.mungge.orumi.domain.diary.application.DiaryService;
import com.mungge.orumi.domain.user.application.UserService;
import com.mungge.orumi.domain.user.domain.User;
import com.mungge.orumi.domain.user.dto.MainDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/main")
public class MainController {

    private final UserService userService;
    private final DiaryService diaryService;
    private static String id = "orumi";

    @Operation(summary = "메인 화면", tags = "Main Controller")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = MainDto.class)))
    @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    @GetMapping
    public ResponseEntity<?> getMain() {
        User user = new User();
        MainDto mainDto = new MainDto("nickname", 0, false);
        return ResponseEntity.ok(mainDto);
    }
}
