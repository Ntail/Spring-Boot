package cn.timebusker.model.one2many;

import javax.persistence.*;
import java.util.List;

/**
 *公司表
 * @author
 */
@Entity
@Table(name="t_company")
public class company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long comId;

    @Column(nullable = false,length = 32)
    private String comName;

    @OneToMany(mappedBy = "company")
    private List<department> department;
}
