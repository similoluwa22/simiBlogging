package com.simiblogging.Blogging.repository;
import com.simiblogging.Blogging.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;



    public interface Blogrepository extends JpaRepository<Blog, Long> {
    }

