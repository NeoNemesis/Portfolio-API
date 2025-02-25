package com.victor.vilches.portfolio_api;

import org.springframework.data.jpa.repository.JpaRepository;

    public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    }

