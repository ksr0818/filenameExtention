package flow.team.domain.file.controller;

import flow.team.domain.file.entity.File;
import flow.team.domain.file.repository.FileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
@Slf4j
public class MyController {
    private final FileRepository repository;

    public MyController(FileRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/my-page")
    public String myPage(Model model) {
        // 체크박스 목록을 만듭니다.
        List<String> checkboxOptions = Arrays.asList("bat", "cmd", "com","cpl","exe","scr","js");
        List<File> checkedFile = repository.findAll();
        List<String> checkedOptions = new ArrayList<>();

        for (int i =0; i < checkedFile.size(); i++) {
            checkedOptions.add(checkedFile.get(i).getValue());
        }
        //text
        List<File> textFile = repository.findAllByCategory("text");
        List<String> textOptions = new ArrayList<>();

        for (int i =0; i < textFile.size(); i++) {
            textOptions.add(textFile.get(i).getValue());
        }




        // 각 체크박스의 상태를 저장하는 맵을 생성합니다.
        Map<String, Boolean> checkboxStates = new LinkedHashMap<>();
        log.error("checkedOptions :" + checkedOptions);
        // 체크박스 목록을 순회하면서 선택 여부를 확인합니다.
        for (String option : checkboxOptions) {
            if (checkedOptions.contains(option)) {
                checkboxStates.put(option, true); // 선택된 경우 true로 설정합니다.
            } else {
                checkboxStates.put(option, false); // 선택되지 않은 경우 false로 설정합니다.
            }
        }

        log.error("checkboxStates : " + checkboxStates);

        // 입력창 목록을 만듭니다.
        String inputFields = "";

        // 모델에 데이터를 추가합니다.
        model.addAttribute("checkboxOptions", checkboxOptions);
        model.addAttribute("checkboxStates", checkboxStates);
        model.addAttribute("inputFields", inputFields);
        model.addAttribute("textOptions", textOptions);

        return "my-page";
    }
}