package io.system.heeseong.common.domain.repository;

import io.system.heeseong.common.domain.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
    List<FileEntity> findByBoardIdxAndTableName(long boardIdx, String tableName);
}
