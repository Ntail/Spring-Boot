package cn.timebusker.model.one2many;

import javax.persistence.*;
import java.util.List;

/**
 * 部门表
 */
@Entity
@Table(name="t_department")
public class department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long depId;

    @Column(nullable = false,length = 32)
    private String depName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="comId")
    private company company;

    @OneToMany(mappedBy = "department")
    private List<employee> employee;
}
