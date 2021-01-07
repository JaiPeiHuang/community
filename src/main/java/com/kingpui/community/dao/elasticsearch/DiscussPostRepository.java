package com.kingpui.community.dao.elasticsearch;

import com.kingpui.community.entity.DiscussPost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 * DiscussPost 返回的类型
 * Integer 主键的类型
 */
public interface DiscussPostRepository extends ElasticsearchRepository<DiscussPost,Integer> {

}
