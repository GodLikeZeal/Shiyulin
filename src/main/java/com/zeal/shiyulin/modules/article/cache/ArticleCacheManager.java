package com.zeal.shiyulin.modules.article.cache;/**
 * Created by Zeal on 2017/12/13.
 */

import com.zeal.shiyulin.modules.article.dao.ArticleDao;
import com.zeal.shiyulin.modules.article.entity.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 文章类缓存管理类
 *
 * @auther Zeal
 * @create 2017/12/13
 **/
public class ArticleCacheManager {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    //取数据
    public ArticleEntity getArticle(Long id){
        if(id == null){
            return null;
        }
        ValueOperations<String, Object> valueOper = redisTemplate.opsForValue();
        Object value = valueOper.get("article:"+id);
        if(value == null||!(value instanceof ArticleEntity)){
            return null;
        }
        return (ArticleEntity) value;
    }
    //存数据
    public void setArticle(Long id,ArticleEntity value){
        if(id == null||value == null){
            return ;
        }
        ValueOperations< String, Object> valueOper = redisTemplate.opsForValue();
        valueOper.set( "article:"+String.valueOf(id) , value , 48 , TimeUnit.HOURS);//48小时失效
    }
    //删除数据
    public void delArticle(Long id){
        redisTemplate.delete("article:"+String.valueOf(id));
    }
    //保存待删除id，定时同步至数据库
    public void addDelKey(Long id){
        ListOperations<String, Object> listOper = redisTemplate.opsForList();
        listOper.rightPush("to_delete_keys", "article:"+String.valueOf(id));
    }
    //判断是否当前key是否已被删除
    public boolean isDeletedKey(Long id) {
        ListOperations<String, Object> listOper = redisTemplate.opsForList();
        List keys = listOper.range("to_delete_keys", 0, -1);
        if(keys.contains("article:"+String.valueOf(id))){
            return true;
        }
        return false;
    }
    //保存待更新id,定时同步至数据库
    public void addUpdateKey(Long id){
        ListOperations<String, Object> listOper = redisTemplate.opsForList();
        listOper.rightPush("to_update_keys", "article:"+String.valueOf(id));
    }

    //定时任务：同步缓存至数据库
    public void redisSync(){
        ValueOperations<String, Object> valueOper = redisTemplate.opsForValue();
        ListOperations<String, Object> listOper = redisTemplate.opsForList();
        //同步更新
        List keys = listOper.range("to_update_keys", 0, -1);
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = (String)iterator.next();
            ArticleEntity article =(ArticleEntity) valueOper.get(key);
            articleDao.update(article);
        }
        redisTemplate.delete("to_update_keys");
        //同步删除
        keys = listOper.range("to_delete_keys", 0, -1);
        iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = (String)iterator.next();
            articleDao.deleteById(key.split(":")[1]);
        }
        redisTemplate.delete("to_delete_keys");
        System.out.println("-----redis同步完成------");
    }
}
