package com.wakil.spring_multi_vendor.respository.files;

import com.wakil.spring_multi_vendor.model.CustomFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomFileRepository extends JpaRepository<CustomFile, UUID> {
}
