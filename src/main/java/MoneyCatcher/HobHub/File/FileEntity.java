package MoneyCatcher.HobHub.File;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name="file")
@Entity
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="file_id")
    private Long id;

    public Long getId(){
        return id;
    }

    public String getSavedPath() {
        return savedPath;
    }

    private String orgNm;
    private String savedNm;
    private String savedPath;
    @Builder
    public FileEntity(Long id, String orgNm, String savedNm, String savedPath) {
        this.id = id;
        this.orgNm = orgNm;
        this.savedNm = savedNm;
        this.savedPath = savedPath;
    }
}
