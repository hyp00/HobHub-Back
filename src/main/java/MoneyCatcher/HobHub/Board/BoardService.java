package MoneyCatcher.HobHub.Board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public void create(String content){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setContent(content);
        this.boardRepository.save(boardEntity);
    }
}
