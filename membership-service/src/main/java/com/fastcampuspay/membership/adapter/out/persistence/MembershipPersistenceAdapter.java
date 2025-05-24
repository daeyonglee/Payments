package com.fastcampuspay.membership.adapter.out.persistence;

import com.fastcampuspay.common.PersistenceAdapter;
import com.fastcampuspay.membership.application.port.out.FindMembershipPort;
import com.fastcampuspay.membership.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter  implements RegisterMembershipPort, FindMembershipPort {

    public final SpringMembershipRepository membershipRepository;
    @Override
    public MembershipJapEntity createMemberShip(Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {
        return membershipRepository.save(
                new MembershipJapEntity(
                        membershipName.getMembershipName(),
                        membershipEmail.getEmail(),
                        membershipAddress.getAddress(),
                        membershipIsValid.isValid(),
                        membershipIsCorp.isCorp()
                )
        );
    }

    @Override
    public MembershipJapEntity findMembership(Membership.MembershipId membershipId) {
        Optional<MembershipJapEntity> membershipJapEntity = membershipRepository.findById(Long.parseLong(membershipId.getMembershipId()));

        return membershipJapEntity.orElse(null);
    }
}
