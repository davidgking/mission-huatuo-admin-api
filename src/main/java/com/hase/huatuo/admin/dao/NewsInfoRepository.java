package com.hase.huatuo.admin.dao;


import com.hase.huatuo.admin.dao.entity.NewsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsInfoRepository extends JpaRepository<NewsInfo, String> {
    NewsInfo getNewsInfoByIdEquals(Long  newsId);
    @Query(nativeQuery = true,value = "SELECT ni.* FROM news_info ni WHERE ni.enable='Y' AND ni.priority=1 ORDER BY ni.date DESC LIMIT 0,5")
    List<NewsInfo> getImportantNewsList();
}
