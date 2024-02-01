package flow.team.domain.file.repository;


import flow.team.domain.file.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<File,Long> {
    File findByValue(String value);
    Boolean existsByValue(String value);
    List<File> findAllByCategory(String category);

}
