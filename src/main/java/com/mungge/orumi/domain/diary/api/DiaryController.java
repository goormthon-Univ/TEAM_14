package com.mungge.orumi.domain.diary.api;

import com.mungge.orumi.domain.diary.application.DiaryService;
import com.mungge.orumi.domain.diary.domain.Diary;
import com.mungge.orumi.domain.diary.domain.DiaryForm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    // 구름 선택
    @PostMapping(value = "/diary/new")
    public String createForm(Model model) {
        model.addAttribute("form", new DiaryForm());

        Diary diary = new Diary();
        DiaryForm diaryForm = new DiaryForm();
        diary.setEmotion(diaryForm.getEmotion());
        diaryService.saveDiary(diary);
        return "redirect:/diary";
    }

    //저장
    @GetMapping("diary/{diaryId}/edit")
    public String updateForm(@PathVariable("diaryId") Long Id, Model model){
        Diary diary = (Diary) diaryService.findOne(Id);

        DiaryForm form = new DiaryForm();
        form.setDairyId(diary.getDairyId());
        form.setEmotion(diary.getEmotion());
        form.setText(diary.getText());
        form.setDate(diary.getDate());

        model.addAttribute("form", form);
        return "redirect:/diary";
    }
    @PostMapping("diary/{diaryId}/edit")
    public String updateDiaryForm(@PathVariable Long diaryId, @ModelAttribute("from") DiaryForm form) {

        diaryService.updateDiary(diaryId, form.getUserId(), form.getEmotion(),
                form.getText(), form.getImage(), form.getDate());
        return "redirect:/diary";
    }
}
