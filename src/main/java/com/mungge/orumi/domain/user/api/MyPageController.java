package com.mungge.orumi.domain.user.api;

import com.mungge.orumi.domain.emotion.application.EmotionCountService;
import com.mungge.orumi.domain.emotion.domain.EmotionCount;
import com.mungge.orumi.domain.emotion.dto.SkyDto;
import com.mungge.orumi.domain.user.application.MyPageService;
import com.mungge.orumi.domain.user.application.UserService;
import com.mungge.orumi.domain.user.domain.User;
import com.mungge.orumi.domain.user.dto.MyPageDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mypage")
public class MyPageController {

    private final UserService userService;
    private final MyPageService myPageService;
    private static String id = "orumi";

    @Operation(summary = "마이페이지", tags = "MyPage Controller")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = MyPageDto.class)))
    @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    @GetMapping()
    public ResponseEntity<?> getMyPage() {
        User user = userService.findUser(id);
        int total = myPageService.getTotalCount(id);
        Period period = Period.between(user.getJoinDate(), LocalDate.now());
        MyPageDto myPageDto = new MyPageDto(id, user.getNickname(), 0, total, period.getDays());
        return ResponseEntity.ok(myPageDto);
    }
}
