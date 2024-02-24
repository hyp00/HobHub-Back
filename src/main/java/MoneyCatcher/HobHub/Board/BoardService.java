package MoneyCatcher.HobHub.Board;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

    @Autowired
    private final BoardRepository boardRepository;
    public void deleteById(Long id)
    {
        //게시물 id로 게시물 삭제하기
        boardRepository.deleteById(id);//글면 보드아이디를 입력해야되나?
    }
    public void create(String content){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setContent(content);
        this.boardRepository.save(boardEntity);
    }
}
