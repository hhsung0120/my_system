package io.system.heeseong.user.domain.reposiroty;

import io.system.heeseong.user.domain.entity.AccountUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountUserRepository extends JpaRepository<AccountUserEntity, Long> {
    AccountUserEntity findByEmail(String email);
}
