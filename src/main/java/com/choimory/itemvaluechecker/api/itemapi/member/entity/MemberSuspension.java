package com.choimory.itemvaluechecker.api.itemapi.member.entity;

import com.choimory.itemvaluechecker.api.itemapi.common.entity.CommonDateTimeEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberSuspension extends CommonDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    private String reason;
    private LocalDateTime suspendedAt;
    private LocalDateTime suspendedTo;
}
