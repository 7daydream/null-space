package com.nullspace.domain.video;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    // 여기에 나중에 필요한 쿼리 메서드를 추가할 수 있습니다.
}