package com.fastcampuspay.membership.application.port.in;

import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.membership.domain.Membership;

public interface RegisterMembershipUseCase {

    Membership registerMembership(RegisterMembershipCommand command);
}
