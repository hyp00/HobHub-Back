package MoneyCatcher.HobHub.Board;

import MoneyCatcher.HobHub.File.FileEntity;
import MoneyCatcher.HobHub.File.FileRepository;
import MoneyCatcher.HobHub.File.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

//게시판
@Controller
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    private final FileService fileService;

    @Autowired
    private final FileRepository fileRepository;
    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/board")
    public String home()
    {

        return "board";
    }
    //취미 서랍장
    @GetMapping("board/generic")
    public String index(Model model){
        Iterable<BoardEntity> ones = boardRepository.findAll(); //BoardEntity에 있는 모든 값 차례로 꺼내서 ones에 담기
        System.out.println(ones);

        model.addAttribute("ones", ones);//보여줨
        model.addAttribute("newOne", new BoardEntity());//새로운애 보여줭

        Iterable<FileEntity> files = fileRepository.findAll();
        model.addAttribute("files",files);
        return "generic";
    }
    //새 게시물 업로드
    @PostMapping("board/generic/upload")
    public String uploadFile(@ModelAttribute BoardEntity one, @RequestParam("file") MultipartFile file, @RequestParam("files") List<MultipartFile> files) throws IOException, IOException {

        boardRepository.save(one);
        fileService.saveFile(file);

        for (MultipartFile multipartFile : files) {
            fileService.saveFile(multipartFile);
        }

        return "redirect:/board/generic";
    }
    //이미지 출력
    @GetMapping("board/generic/images/{fileId}")
    @ResponseBody
    public Resource downloadImage(@PathVariable("fileId") Long id, Model model) throws  IOException{
        FileEntity file = fileRepository.findById(id).orElse(null);
        return new UrlResource("file:" + file.getSavedPath());
    }


    @PostMapping("board/generic/new")
    public String onecreate(@ModelAttribute BoardEntity one)
    {
        boardRepository.save(one);
        return "redirect:/";
    }

}
