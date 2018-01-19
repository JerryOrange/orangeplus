package ncu.jerry.orangeplus.common.cache.guava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Google Guava cache
 *
 * Created by Jiacheng on 2018/1/19.
 */
@Component
public class DataCache {

    private final static Logger logger = LoggerFactory.getLogger(DataCache.class);
    private Map<Long, String> dataMap = new HashMap<>();

    /**
     * 初始化
     */
    @PostConstruct
    public void init() {
        dataMap.put(1L, "Guava cache_1");
        dataMap.put(2L, "Guava cache_2");
        dataMap.put(3L, "Guava cache_3");
    }

    /**
     * query
     * 如果数据没有缓存,那么从dataMap里面获取,并且将缓存的数据存入到guava
     * 如果缓存了,那么从guava里面获取
     * 其中key 为 #id_guava
     *
     * @param id
     * @return
     */
    @Cacheable(value = "guava", key = "#id + '_guava'")
    public String query(Long id) {
        logger.debug("query id = " + id);
        return dataMap.get(id);
    }

    /**
     * put or update
     * 插入或更新数据到dataMap中,并且缓存到guava
     * 如果存在了那么更新缓存中的值
     * 其中key 为 #id_guava
     *
     * @param id
     * @param value
     * @return
     */
    @CachePut(value = "guava", key = "#id + '_guava'")
    public String put(Long id, String value) {
        logger.debug("add data, id=" + id + "&value=" + value);
        // data persistence
        dataMap.put(id, value);
        return value;
    }

    /**
     * remove
     * 删除dataMap里面的数据,并且删除缓存guava中的数据
     * 其中key 为 #id_guava
     *
     * @param id
     */
    @CacheEvict(value = "guava", key = "#id + '_guava'")
    public void remove(Long id) {
        logger.debug("remove id = " + id + " data");
        // data remove
        dataMap.remove(id);
    }

}
