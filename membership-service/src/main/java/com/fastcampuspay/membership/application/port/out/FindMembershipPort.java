package com.fastcampuspay.membership.application.port.out;

import com.fastcampuspay.membership.adapter.out.persistence.MembershipJapEntity;
import com.fastcampuspay.membership.domain.Membership;

public interface FindMembershipPort {

    MembershipJapEntity findMembership(Membership.MembershipId membershipId);
}
