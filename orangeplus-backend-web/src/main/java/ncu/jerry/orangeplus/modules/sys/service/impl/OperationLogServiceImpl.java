package ncu.jerry.orangeplus.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import ncu.jerry.orangeplus.modules.sys.entity.OperationLog;
import ncu.jerry.orangeplus.modules.sys.mapper.OperationLogMapper;
import ncu.jerry.orangeplus.modules.sys.service.IOperationLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志 服务实现类
 * </p>
 *
 * @author Jiacheng
 * @since 2017-08-23
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements IOperationLogService {
	
}
