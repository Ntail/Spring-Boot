package cn.timebusker.model.one2many;

import javax.persistence.*;
import java.util.List;

/**
 * 员工表
 */

@Entity
@Table(name="t_employee")
public class employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;

    @Column(nullable = false,length = 32)
    private String empName;

    /**
     * mappedBy = "employee" 指定了，这个实体是被关系维护端端那个属性所维护
     * 当我们设置了，mappedBy后，使关系成为双向的时候，本实例中，datailInfo实体
     * 使被employee实体中的外键“detailInfo”所维护
     */
    @OneToOne(cascade = CascadeType.ALL, optional = false,mappedBy = "employee")
    private datailInfo datailInfo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="depId")
    private department department;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="t_em_pos", inverseJoinColumns = @JoinColumn(name = "em_id" ),
            joinColumns = @JoinColumn(name = "pos_id"))
    private List<position> position;
}
