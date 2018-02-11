package ncu.jerry.orangeplus.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import ncu.jerry.orangeplus.modules.sys.entity.Menu;
import ncu.jerry.orangeplus.modules.sys.mapper.MenuMapper;
import ncu.jerry.orangeplus.modules.sys.service.IMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author Jiacheng
 * @since 2017-08-23
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
	
}
