package io.system.heeseong.common.repository;

import io.system.heeseong.common.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
    List<FileEntity> findByIndexNumberAndTableName(long indexNumber, String tableName);
}
