package io.system.heeseong.common.domain.repository;

import io.system.heeseong.common.domain.entity.ValidationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationRepository extends JpaRepository<ValidationEntity, Long> {

}
