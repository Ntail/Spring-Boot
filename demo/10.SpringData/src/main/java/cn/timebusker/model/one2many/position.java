package cn.timebusker.model.one2many;

import javax.persistence.*;
import java.util.List;

/**
 * 职级表
 */
@Entity
@Table(name = "t_position")
public class position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long posId;

    @Column(nullable = false,length = 32)
    private String posName;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "position")
    private List<employee> employee;
}
