package com.hase.huatuo.admin.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p> </p>
 * Created by shenpeng on  2020/2/8 18:46
 */
@Data
@Entity
@Table(name = "health_info_hacn")
public class HealthInfoHACN {

    @Id
    @Column(name = "serail_number")
    private String serialNo;

    @Column(name = "open_id")
    private String openId;

    @Column(name = "staff_id")
    private String staffId;

    @Column(name = "staff_name")
    private String staffName;

    @Column(name = "mobile_number")
    private String mobileNum;

    @Column(name = "is_report_other")
    private String isReportOther;

    @Column(name = "report_staff_id")
    private String reportStaffId;

    @Column(name = "city_short_name")
    private String cityName;

    @Column(name = "department")
    private String department;

    @Column(name = "workplace")
    private String workPlace;

    @Column(name = "health_status")
    private String healthStatus;

    @Column(name = "is_isolation")
    private String isIsolation;

    @Column(name = "isolation_type")
    private String isoType;

    @Column(name = "isolation_start_date")
    private String startDate;

    @Column(name = "isolation_end_date")
    private String endDate;

    @Column(name = "report_date")
    private String reportDate;

    @Column(name = "is_statistic")
    private String isStatistic;
}
