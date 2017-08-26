package ncu.jerry.orangeplus.modules.sys.service.impl;

import ncu.jerry.orangeplus.modules.sys.entity.OperationLog;
import ncu.jerry.orangeplus.modules.sys.mapper.OperationLogMapper;
import ncu.jerry.orangeplus.modules.sys.service.IOperationLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
