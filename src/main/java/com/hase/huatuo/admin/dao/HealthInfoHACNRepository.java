package com.hase.huatuo.admin.dao;

import com.hase.huatuo.admin.dao.entity.HealthInfoHACN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HealthInfoHACNRepository extends JpaRepository<HealthInfoHACN,String> {


    @Query(value = "select \n" +
            "h.serail_number,\n" +
            "h.open_id,\n" +
            "h.staff_id,\n" +
            "h.staff_name,\n" +
            "h.mobile_number,\n" +
            "h.is_report_other,\n" +
            "h.report_staff_id,\n" +
            "(select c.city_name from cities c where c.city_short_name = h.city_short_name) as city_short_name,\n" +
            "h.is_isolation,\n" +
            "(select iso.isolation_name from isolation_type_hacn iso where iso.isolation_type = h.isolation_type) as isolation_type,\n" +
            "h.isolation_start_date,\n" +
            "h.isolation_end_Date,\n" +
            "h.report_date,\n" +
            "h.is_statistic,\n" +
            "h.department,\n" +
            "h.workplace,\n" +
            "h.health_status\n" +
            "from health_info_hacn h  \n" +
            "where (?1 is null or h.staff_Id = ?1) and h.staff_Id is not null \n" +
            "            and (?2 is null or h.staff_name like ?2) and h.staff_name is not null ",
        nativeQuery = true)
    List<HealthInfoHACN> findAll(String staffId,
                                 String staffName);
}
