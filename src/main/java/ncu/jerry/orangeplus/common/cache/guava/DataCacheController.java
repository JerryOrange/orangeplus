package ncu.jerry.orangeplus.common.cache.guava;

import ncu.jerry.orangeplus.common.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Guava cache 测试controller
 *
 * Created by Jiacheng on 2018/1/19.
 */
@RestController
// 开启缓存
@EnableCaching
public class DataCacheController {

    @Autowired
    private DataCache dataCache;

    @RequestMapping("/putGuavaCache")
    public Result put(Long id, String value) {
        return new Result("Putting Guava cache success  : id=" + id + "&value=" + dataCache.put(id, value));
    }

    @RequestMapping("/getGuavaCache")
    public Result query(Long id) {
        return new Result("Value is " + dataCache.query(id));
    }

    @RequestMapping("/removeGuavaCache")
    public Result remove(Long id) {
        dataCache.remove(id);
        return new Result("Removing Guava cache success");
    }
}
