package com.choimory.itemvaluechecker.api.itemapi.member.entity;

import com.choimory.itemvaluechecker.api.itemapi.common.entity.CommonDateTimeEntity;
import com.choimory.itemvaluechecker.api.itemapi.member.code.SocialType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberSocial extends CommonDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @Enumerated(EnumType.STRING)
    private SocialType socialType;
    private String socialId;
}