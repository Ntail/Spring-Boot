package cn.timebusker.model.one2many;

import javax.persistence.*;

/**
 *员工详细信息表(一个员工一条详细)
 */
@Entity
@Table(name = "t_datailInfo")
public class datailInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long datId;

    @Column(nullable = false,length = 32)
    private String datName;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "empId")
    private employee employee;
}
