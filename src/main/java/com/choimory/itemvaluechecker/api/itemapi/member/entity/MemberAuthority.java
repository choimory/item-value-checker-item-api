package com.choimory.itemvaluechecker.api.itemapi.member.entity;

import com.choimory.itemvaluechecker.api.itemapi.common.entity.CommonDateTimeEntity;
import com.choimory.itemvaluechecker.api.itemapi.member.code.AuthLevel;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberAuthority extends CommonDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @Enumerated(EnumType.STRING)
    private AuthLevel authLevel;
}