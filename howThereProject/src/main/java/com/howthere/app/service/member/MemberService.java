package com.howthere.app.service.member;

import com.howthere.app.entity.member.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {
    Page<Member> getMembers(Pageable pageable, String keyword);
}
