package com.fastcampuspay.membership.adapter.in.web;

import com.fastcampuspay.membership.adapter.out.persistence.MembershipPersistenceAdapter;
import com.fastcampuspay.membership.domain.Membership;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@SpringBootTest
@AutoConfigureMockMvc
class FindMembershipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MembershipPersistenceAdapter membershipPersistenceAdapter;

    @Autowired
    private ObjectMapper mapper;

    @BeforeEach
    void setup() {
        // DB 데이터 셋팅
        membershipPersistenceAdapter.createMemberShip(
                new Membership.MembershipName("name"),
                new Membership.MembershipEmail("email"),
                new Membership.MembershipAddress("address"),
                new Membership.MembershipIsValid(true),
                new Membership.MembershipIsCorp(true)
        );
    }


    @Test
    void testFindMembership() throws Exception {
        // given
        Membership membership = Membership.generateMember(
                new Membership.MembershipId("1"),
                new Membership.MembershipName("name"),
                new Membership.MembershipEmail("email"),
                new Membership.MembershipAddress("address"),
                new Membership.MembershipIsValid(true),
                new Membership.MembershipIsCorp(true)
        );

        // when & then
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/membership/1")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(membership)));
    }
}
