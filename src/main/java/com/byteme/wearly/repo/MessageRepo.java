package com.byteme.wearly.repo;

import com.byteme.wearly.model.Message;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 18, 2022 12:19 AM
 */

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {

    List<Message> findAllByConvoCode(String code, Sort sort);

}
