package com.fastcampuspay.membership.adapter.in.web;

import com.fastcampuspay.membership.domain.Membership;
import com.fasterxml.jackson.databind.ObjectMapper;
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
class RegisterMembershipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;


    @Test
    public void testRegisterMembership() throws Exception {
        RegisterMembershipRequest request = new RegisterMembershipRequest("name", "email", "address", true);

        Membership membership = Membership.generateMember(
                new Membership.MembershipId("1"),
                new Membership.MembershipName("name"),
                new Membership.MembershipEmail("email"),
                new Membership.MembershipAddress("address"),
                new Membership.MembershipIsValid(true),
                new Membership.MembershipIsCorp(true)
        );

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/membership/register")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(request))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(membership)));

    }

}
