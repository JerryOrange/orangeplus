package ncu.jerry.orangeplus.quartz.repository;

import ncu.jerry.orangeplus.quartz.entity.QuartzCronConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jiacheng on 2018/1/29.
 */
public interface QuartzCronConfigRepository extends JpaRepository<QuartzCronConfig, Long> {
}
