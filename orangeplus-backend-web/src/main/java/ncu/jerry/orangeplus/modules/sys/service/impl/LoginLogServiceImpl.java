package ncu.jerry.orangeplus.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import ncu.jerry.orangeplus.modules.sys.entity.LoginLog;
import ncu.jerry.orangeplus.modules.sys.mapper.LoginLogMapper;
import ncu.jerry.orangeplus.modules.sys.service.ILoginLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录记录 服务实现类
 * </p>
 *
 * @author Jiacheng
 * @since 2017-08-23
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogService {
	
}
