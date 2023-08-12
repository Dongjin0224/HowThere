package com.howthere.app.repository.member;

import com.howthere.app.entity.member.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.howthere.app.entity.member.QMember.member;

@RequiredArgsConstructor
public class MemberQueryDSLImpl implements MemberQueryDSL {
    private final JPAQueryFactory query;

    @Override
    public Page<Member> getMembers(Pageable pageable, String keyword) {
        List<Member> members = query.select(member).from(member).offset(pageable.getOffset()).limit(pageable.getPageSize()).fetch();
        Long count = query.select(member.count()).from(member).fetchOne();
        return new PageImpl<>(members, pageable, count != null ? count : 0);
    }
}
