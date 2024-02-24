package com.nhnacademy.minidooray.accountapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.minidooray.accountapi.entity.Member;
import com.nhnacademy.minidooray.accountapi.entity.MemberState;
import com.nhnacademy.minidooray.accountapi.repository.MemberRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberRepository memberRepository;

    @Test
    @Order(1)
    void testGetMembers() throws Exception {
        given(memberRepository.findAll()).willReturn(List.of(new Member("naver", "naver@naver.con", "12345", "naver",MemberState.JOIN)));

        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", equalTo("naver")));
    }

    @Test
    @Order(2)
    void testGetMember() throws Exception {
        given(memberRepository.findById("naver")).willReturn(Optional.of(new Member("naver", "naver@naver.con", "12345", "naver",MemberState.JOIN)));

        mockMvc.perform(get("/accounts/{id}", "naver"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", equalTo("naver")));
    }

    @Test
    @Order(3)
    void testCreateMember() throws Exception {
        Member member = new Member("daum", "daum@naver.con", "12345", "daum",MemberState.JOIN);
        given(memberRepository.existsById("daum")).willReturn(false);

        given(memberRepository.save(any())).willReturn(member);

        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/accounts")
                        .content(objectMapper.writeValueAsString(member))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", equalTo("daum")));
    }

    @Test
    @Order(4)
    void testDeleteMember() throws Exception {
        mockMvc.perform(delete("/accounts/{id}", "daum"))
                .andExpect(status().isOk());
    }
}