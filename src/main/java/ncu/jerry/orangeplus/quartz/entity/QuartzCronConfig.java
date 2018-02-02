package ncu.jerry.orangeplus.quartz.entity;

import javax.persistence.*;

/**
 * Created by Jiacheng on 2018/1/29.
 */
@Entity
public class QuartzCronConfig {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String cron;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}
