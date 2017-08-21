package ncu.jerry.orangeplus.modules.sys.service.impl;

import ncu.jerry.orangeplus.modules.sys.entity.User;
import ncu.jerry.orangeplus.modules.sys.mapper.UserMapper;
import ncu.jerry.orangeplus.modules.sys.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author Jiacheng
 * @since 2017-08-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
}
