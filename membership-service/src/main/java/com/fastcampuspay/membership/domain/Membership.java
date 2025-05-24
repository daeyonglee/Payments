package com.fastcampuspay.membership.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;


@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {

    private final String membershipId;
    private final String name;
    private final String email;
    private final String address;
    private final boolean isValid;
    private final boolean isCorp;

    public static Membership generateMember(MembershipId membershipId, MembershipName membershipName, MembershipEmail membershipEmail, MembershipAddress membershipAddress, MembershipIsValid membershipIsValid, MembershipIsCorp membershipIsCorp) {
        return new Membership(
                membershipId.membershipId,
                membershipName.membershipName,
                membershipEmail.email,
                membershipAddress.address,
                membershipIsValid.isValid,
                membershipIsCorp.isCorp
        );
    }

    @Value
    public static class MembershipId {

        String membershipId;

        public MembershipId(String membershipId) {
            this.membershipId = membershipId;
        }
    }

    @Value
    public static class MembershipName {
        String membershipName;

        public MembershipName(String membershipName) {
            this.membershipName = membershipName;
        }
    }

    @Value
    public static class MembershipEmail {
        String email;

        public MembershipEmail(String email) {
            this.email = email;
        }
    }

    @Value
    public static class MembershipAddress {
        String address;

        public MembershipAddress(String address) {
            this.address = address;
        }
    }

    @Value
    public static class MembershipIsValid {
        boolean isValid;

        public MembershipIsValid(boolean isValid) {
            this.isValid = isValid;
        }
    }


    @Value
    public static class MembershipIsCorp {
        boolean isCorp;

        public MembershipIsCorp(boolean isCorp) {
            this.isCorp = isCorp;
        }
    }
}
